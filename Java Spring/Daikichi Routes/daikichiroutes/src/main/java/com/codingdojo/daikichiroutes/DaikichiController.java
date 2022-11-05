package com.codingdojo.daikichiroutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	
    @RequestMapping("")
    public String index() {
            return "Welcome";
    }
    
    @RequestMapping( "/today" )
    public String today() {
            return "Today You Will Find Luck In All Your Endeavors";
    }
    @RequestMapping("/tomorrow")
    public String tomorrow() {
            return "Tomorrow, an Opportunity will arisde, so be sure to be open to new ideas";
    }


}


