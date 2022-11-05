package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	
	    @RequestMapping("/")
	    public String index(@RequestParam(value="first", required=false) String firstName, @RequestParam(value="last", required=false)String lastName, @RequestParam(value="num", required= false) int num) {
	        if(firstName != null && lastName != null && num!=0 ) {
	        	return (("Hello " + firstName + "  " + lastName).repeat(num)) ;
	        }
	        else if(firstName != null && num!=0 ) {
	        	return (("Hello  " + firstName).repeat(num)) ;
	        }
	        return "Hello Human";
	    }
}