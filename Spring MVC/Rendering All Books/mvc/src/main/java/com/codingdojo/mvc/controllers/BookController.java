package com.codingdojo.mvc.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController {
	
    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
	
	 @RequestMapping("/books/{id}")
	 public String show(@PathVariable("id") Long id, Model model) {
//		 ArrayList<Book> books = bookService.getAllBooks();
		 Book book = bookService.findBook(id);
		 model.addAttribute("book",book);
	     return "show.jsp";
	     }
	 

	    
	    @RequestMapping("/books")
	    public String index(Model model) {
	        List<Book> books = bookService.allBooks();
	        model.addAttribute("books", books);
	        return "index.jsp";
	    }
	 
}
