package com.codingdojo.counter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class CounterController {
	@RequestMapping("")
	public String index(HttpSession session) {
    	// If the count is not already in session
		if (session.getAttribute("count") == null) {
		// Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
			Integer x = (Integer) session.getAttribute("count");
		    x++ ;
			session.setAttribute("count", x);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(){
		return "counter.jsp";	
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session,Model model,HttpServletRequest request){
		session.setAttribute("count", 0);
		return "redirect:/your_server/counter/";	
	}
	
		
	}


