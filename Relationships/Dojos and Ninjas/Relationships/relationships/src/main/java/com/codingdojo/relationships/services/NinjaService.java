package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Ninja;
import com.codingdojo.relationships.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	 
 public NinjaService(NinjaRepository ninjaRepository) {
     this.ninjaRepository = ninjaRepository;
 }
 // returns all ninjas
 public List<Ninja> allNinjas() {
     return ninjaRepository.findAll();
 }
 // creates a ninja
 public Ninja createNinja(Ninja n) {
     return ninjaRepository.save(n);
 }
 // retrieves a ninja
 public Ninja findNinja(Long id) {
     Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
     if(optionalNinja.isPresent()) {
         return optionalNinja.get();
     } else {
         return null;
     }
 }
}
