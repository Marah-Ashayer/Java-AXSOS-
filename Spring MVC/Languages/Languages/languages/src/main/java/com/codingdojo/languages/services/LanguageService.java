package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
 // adding the Language repository as a dependency
	private final LanguageRepository languageRepository;
 
 public LanguageService(LanguageRepository languageRepository) {
     this.languageRepository = languageRepository;
 }
 // returns all Languages
 public List<Language> allLanguages() {
     return languageRepository.findAll();
 }
 // creates a language
 public Language createLanguage(Language l) {
     return languageRepository.save(l);
 }
 // retrieves a language
 public Language findLanguage(Long id) {
     Optional<Language> optionalLanguage = languageRepository.findById(id);
     if(optionalLanguage.isPresent()) {
         return optionalLanguage.get();
     } else {
         return null;
     }
 }
 
 public Language updateLanguage(Language language){
	 return languageRepository.save(language);
 }
 public void deleteLanguage(Long id ) {
     Optional<Language> optionalLanguage = languageRepository.findById(id);
     if(optionalLanguage.isPresent()) {
    	 languageRepository.deleteById(id);
     }
 }
}

