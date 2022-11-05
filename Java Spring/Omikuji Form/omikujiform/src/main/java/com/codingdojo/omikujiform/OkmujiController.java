package com.codingdojo.omikujiform;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

  
@Controller
public class OkmujiController {
	
		@RequestMapping("/")
		public String index() {
			return "index.jsp";
		}
		
		
		@PostMapping(value="/login" )
		public String login(@RequestParam(value="num") Integer num,
							@RequestParam(value="city") String city,
							@RequestParam(value="person") String person,
							@RequestParam(value="hoppy") String hoppy,
							@RequestParam(value="living") String living,
							@RequestParam(value="say") String say,
							HttpSession session){
			session.setAttribute("num",num);
			session.setAttribute("city",city);
			session.setAttribute("person",person);
			session.setAttribute("hoppy",hoppy);
			session.setAttribute("living",living);
			session.setAttribute("say",say);
			return "redirect:/show";
		}
		
		
		
		@RequestMapping("/show")
		public String show() {
			return "show.jsp";
		}
	}