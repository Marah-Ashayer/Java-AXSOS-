package com.codingdojo.authentication.controllers;
    
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.authentication.models.BookClub;
import com.codingdojo.authentication.models.LoginUser;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.servicies.BookClubService;
import com.codingdojo.authentication.servicies.UserService;



@Controller
public class HomeController {
    
    @Autowired
    private UserService userServ;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "LoginPage.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "LoginPage.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/books";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "LoginPage.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/books";
    }
    
    @GetMapping("/books")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
        Long user_id = (Long) session.getAttribute("user_id");
        User thisUser = userServ.findUserById(user_id);
        model.addAttribute("thisUser", thisUser);
        
		List<BookClub> books = bookService.allBooks();
		model.addAttribute("books", books);
        return "Home.jsp";
    }
        else {
            return "redirect:/";
        }
    }
    
    //------------------------------ Log Out --------------------------------//
    
    @GetMapping("/logout")
    public String logout(HttpSession session) { 
            session.invalidate();
            return "redirect:/";
    }
    
    //---------------------------------- Add Books ----------------------------//
    
    private final BookClubService bookService;
    public HomeController(BookClubService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/books/new")
    public String addBook(@ModelAttribute("book") BookClub newBook,HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/";
		}
        return "NewBook.jsp";
    }
    
    @PostMapping("/books/add")
    public String create(@Valid @ModelAttribute("book") BookClub book, BindingResult result,Model model,HttpSession session) {
        if (result.hasErrors()) {
            return "NewBook.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    //-------------------------- Show Book -----------------------------------// 
    
    @GetMapping("/books/{id}")
    public String showBook(Model model , @PathVariable("id") Long id){
        BookClub book = bookService.findBook(id);
        model.addAttribute("book", book);
    	return "ViewBook.jsp";
    }
    //-------------------------- Delete Book -------------------------------------//
    @DeleteMapping("/books/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    //----------------------------Edit Book ----------------------------------//
    
    @GetMapping("/books/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model,HttpSession session) {
    	BookClub book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "EditBook.jsp";
    }
    
    @PutMapping("/books/edit/{id}")
    public String update(@Valid @ModelAttribute("book") BookClub book, BindingResult result,HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		if(!book.getUser().getId().equals(userId)) {
			return "redirect:/books";
		}
    	if (result.hasErrors()) {
            return "EditBook.jsp";
        } else {
        	bookService.updateBook(book);
            return "redirect:/books";
        }
    }
}
