package com.ninjagoldgame;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaController {
	
	@RequestMapping("")
	public String index(HttpSession session) {
		if(session.getAttribute("total_gold")== null) {
			session.setAttribute("total_gold", 0);
			session.setAttribute("activities", " ");
			ArrayList<String> activities = new ArrayList<String>();
			session.setAttribute("activities", activities);
	}
		return "index.jsp";
	}
	
	@PostMapping("/money")
	public String process_money(HttpSession session,@RequestParam("test") String test) {
		Integer gold=0;
		
    	String timePattern = "hh:mm a";
    	SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);
    	
		String datePattern = "EEEEE, 'the' dd 'of' MMMMM, yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		
		Random rand = new Random(); 
		if(test.equals("farm")){
            Integer upperbound = 11;
            gold = rand.nextInt(upperbound)+10;
            String time = timeFormat.format(new Date());
            String date = dateFormat.format(new Date());
            String message = "You entered a farm and earned   " + gold +' '+ "gold" + ". " + date +" at "+ time;
			ArrayList <String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(message);
			session.setAttribute("activities", activities);
		}
		else if(test.equals("cave")){
			Integer upperbound =6 ;
			gold = rand.nextInt(upperbound) + 5;
            String time = timeFormat.format(new Date());
            String date = dateFormat.format(new Date());
            String message = "You entered a cave and earned  " + gold +' '+ "gold" + ". " + date+" at "+ time;
			ArrayList <String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(message);
			session.setAttribute("activities", activities);
		}
		else if(test.equals("house")){
			Integer upperbound = 4;
			gold = rand.nextInt(upperbound) + 2;
            String time = timeFormat.format(new Date());
            String date = dateFormat.format(new Date());
            String message = "You entered a house and earned  " + gold +' '+ "gold" + ". " + date+" at "+ time;
			ArrayList <String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(message);
			session.setAttribute("activities", activities);

		}
		else if(test.equals("quest")){
			Integer upperbound = 100;
			gold = rand.nextInt(upperbound)-50;
            String time = timeFormat.format(new Date());
            String date = dateFormat.format(new Date());
            if(gold > 0){
            	String message = "You entered a quest and earned  " + gold +' '+ "gold" + ". " + date+" at "+ time;     	
    			ArrayList <String> activities = (ArrayList<String>) session.getAttribute("activities");
    			activities.add(message);
    			session.setAttribute("activities", activities);
            }
         
            else {
            	String message = "You entered a quest and lost  " + gold +' '+ "gold" + ". " + date+" at "+ time;
            	ArrayList <String> activities = (ArrayList<String>) session.getAttribute("activities");
    			activities.add(message);
    			session.setAttribute("activities", activities);
            	
            }

		}
		
		Integer tot =(Integer)session.getAttribute("total_gold")+ gold ;
		System.out.println(tot);
		session.setAttribute("total_gold",tot);
		return "redirect:/";
	}
}
