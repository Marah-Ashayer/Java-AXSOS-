package com.codingdojo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.relationships.models.Dojo;
import com.codingdojo.relationships.models.Ninja;
import com.codingdojo.relationships.services.DojoService;
import com.codingdojo.relationships.services.NinjaService;

@Controller
public class MainController {
	
    private final DojoService dojoService;
    private final NinjaService ninjaService;
    
    public MainController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
    @GetMapping("/dojos")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
        return "NewDojo.jsp";
    }
    @PostMapping("/dojos/new")
    public String createdojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result,Model model) {
        if (result.hasErrors()) {
	        List<Dojo> dojos = dojoService.allDojos();
	        model.addAttribute("dojos", dojos);
            return "NewDojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/dojos";
        }
    }
    
    @GetMapping("/ninjas")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
          List<Dojo> dojos = dojoService.allDojos();
          model.addAttribute("dojos", dojos);
          return "NewNinja.jsp";
    }
    
    @PostMapping("/ninjas/new")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,Model model) {
        if (result.hasErrors()) {
	        List<Ninja> ninjas = ninjaService.allNinjas();
	        model.addAttribute("ninjas", ninjas);
            return "NewNinja.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/ninjas";
        }
    }
    
    @GetMapping("/dojos/{id}")
    public String showDojo(Model model , @PathVariable("id") Long id){
    	Dojo dojo = dojoService.findDojo(id);
        List<Ninja> ninjas = ninjaService.allNinjas();
        model.addAttribute("ninjas", ninjas);
        model.addAttribute("dojo", dojo);
    	return "DojoPage.jsp";
    }
}
