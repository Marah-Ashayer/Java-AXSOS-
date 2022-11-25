package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Category;
import com.codingdojo.relationships.models.Product;
import com.codingdojo.relationships.repositories.CategoryRepository;
@Service
public class CategoryService {
 // adding the Category repository as a dependency
	private final CategoryRepository categoryRepository;
 
 public CategoryService(CategoryRepository categoryRepository) {
     this.categoryRepository = categoryRepository;
 }
 // returns all Categories
 public List<Category> allCategories() {
     return categoryRepository.findAll();
 }
 // creates a Category
 public Category createCategory(Category c) {
     return categoryRepository.save(c);
 }
 // retrieves a Category
 public Category findCategory(Long id) {
     Optional<Category> optionalCategory = categoryRepository.findById(id);
     if(optionalCategory.isPresent()) {
         return optionalCategory.get();
     } else {
         return null;
     }
 }
 
 public void updateCategory(Category c) {
     categoryRepository.save(c);
}
public List<Category> CategoriesNotInProduct(Product product) {
	return categoryRepository.findByProductsNotContains(product);
	}

}