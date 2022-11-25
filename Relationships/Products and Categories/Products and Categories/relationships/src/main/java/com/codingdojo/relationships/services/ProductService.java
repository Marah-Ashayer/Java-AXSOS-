package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Category;
import com.codingdojo.relationships.models.Product;
import com.codingdojo.relationships.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	 
 public ProductService(ProductRepository productRepository) {
     this.productRepository = productRepository;

}
 
 // returns all products
 public List<Product> allProducts() {
     return productRepository.findAll();
 }
 // creates a product
 public Product createProduct(Product p) {
     return productRepository.save(p);
 }
 
 public void updateProduct(Product p) {
      productRepository.save(p);
 }

 public Product findProduct(Long id) {
     Optional<Product> optionalProduct = productRepository.findById(id);
     if(optionalProduct.isPresent()) {
         return optionalProduct.get();
     } else {
         return null;
     }
 }
public List<Product> ProductsNotInCategory(Category category) {
	return productRepository.findByCategoriesNotContains(category);
	}
}


//-------------------------------------------------------------------------
//// retrieve an instance of a category using another method in the service.
//Category thisCategory = findCategoryById(categoryId);
//
//// retrieve an instance of a product using another method in the service.
//Product thisProduct = findProductById(productId);
//
//// add the product to this category's list of products
//thisCategory.getProducts().add(thisProduct);
//
//// Save thisCategory, since you made changes to its product list.
//categoryRepository.save(thisCategory);	
//
//
//
//    // This has the same affect as above:
//thisProduct.getCategories().add(thisCategory);	// add the category to this products's list of categories
//    productRepository.save(thisProduct);	// Save thisProduct, since you made changes to its category list.

