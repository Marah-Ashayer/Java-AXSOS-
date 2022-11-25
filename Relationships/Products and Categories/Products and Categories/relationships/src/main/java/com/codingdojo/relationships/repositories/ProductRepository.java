package com.codingdojo.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.relationships.models.Category;
import com.codingdojo.relationships.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	 // this method retrieves all the products from the database
	 List<Product> findAll();
	 
	 // Retrieves a list of all products for a particular category
	 List<Product> findAllByCategories(Category category);
	    
	  // Retrieves a list of any categories a particular product does not belong to.
	  List<Product> findByCategoriesNotContains(Category category);
}
