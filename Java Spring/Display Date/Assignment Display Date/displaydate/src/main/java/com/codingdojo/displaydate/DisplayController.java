package com.codingdojo.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayController {
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    @RequestMapping("/time")
    public String time(Model model) {
    	String timePattern = "hh:mm a";
    	SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);
    	String time = timeFormat.format(new Date());	
    	model.addAttribute("time", time);
        return "time.jsp";
    }
    
    @RequestMapping("/date")
    public String date(Model model) {
		String datePattern = "EEEEE, 'the' dd 'of' MMMMM, yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		String date = dateFormat.format(new Date());	
		model.addAttribute("date", date);
        return "date.jsp";
    }

}


