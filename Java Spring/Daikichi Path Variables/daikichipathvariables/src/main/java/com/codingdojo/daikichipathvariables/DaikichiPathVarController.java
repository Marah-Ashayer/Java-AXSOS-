package com.codingdojo.daikichipathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiPathVarController {
	
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
	
    @RequestMapping("travel/{place}")
    public String travelTo(@PathVariable("place")String place ) {
            return "Congratulations! You Will Soon travel to  " + place ;
    }
    
    @RequestMapping( "/lotto/{n}" )
    public String evenOrOdd(@PathVariable("n")int n) {
    	if(n%2 == 0){
            return "You Will Take a Grand Joourny In The Near Future, But Be Wary Of tempting Offers";
    }
    else {
            return "You Have Enjoyed The Fruits Of Your Labor But Now is A Great Time To Spend Time With Family And Friends ";}
    }

}







	

