package com.codingdojo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;



@Controller
public class LanguagesController {
	
    private final LanguageService languageService;
    
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @GetMapping("/languages")
    public String newLanguage(@ModelAttribute("language") Language language, Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "index.jsp";
    }
    @PostMapping("/languages/new")
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result,Model model) {
        if (result.hasErrors()) {
	        List<Language> languages = languageService.allLanguages();
	        model.addAttribute("languages", languages);
            return "index.jsp";
        } else {
        	languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }

    // ---------------------Edit --------------------------//
    
    @GetMapping("/languages/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
    
    @PutMapping("/languages/edit/{id}")
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
        //-----------------------------Delete --------------------------------//
        
        @DeleteMapping("/languages/delete/{id}")
        public String destroy(@PathVariable("id") Long id) {
        	languageService.deleteLanguage(id);
            return "redirect:/languages";
        }
        
//       // --------------------Show Expense ---------------------//
   	 @GetMapping("/languages/{id}")
   	 public String show(@PathVariable("id") Long id, Model model) {
   		 Language language = languageService.findLanguage(id);
   		 model.addAttribute("language",language);
   	     return "show.jsp";
   	     }
    }
	    
	 
