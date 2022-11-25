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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.relationships.models.Category;
import com.codingdojo.relationships.models.Product;
import com.codingdojo.relationships.services.CategoryService;
import com.codingdojo.relationships.services.ProductService;

@Controller
public class HomeControlleer {
	
  private final ProductService productService;
  private final CategoryService categoryService;
  
  public HomeControlleer(ProductService productService, CategoryService categoryService) {
      this.productService = productService;
      this.categoryService = categoryService;
  }
@GetMapping("")
public String main(Model model) {
	
  List<Category> categories = categoryService.allCategories();
  model.addAttribute("categories", categories);
  
  List<Product> products = productService.allProducts();
  model.addAttribute("products", products);
  
    return "HomePage.jsp";
}

@RequestMapping("/products")
public String newProduct(@ModelAttribute("product") Product product, Model model) {
  return "NewProduct.jsp";
}
@PostMapping("/products/new")
public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,Model model) {
  if (result.hasErrors()) {
      List<Product> products = productService.allProducts();
      model.addAttribute("products", products);
      return "NewProduct.jsp";
  } else {
      productService.createProduct(product);
      return "redirect:/";
  }
}

@RequestMapping("/categories")
public String newCategory(@ModelAttribute("category") Category category, Model model) {
  return "NewCategory.jsp";
}
@PostMapping("/categories/new")
public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result,Model model) {
  if (result.hasErrors()) {
      List<Category> categories = categoryService.allCategories();
      model.addAttribute("categories", categories);
      return "NewCategory.jsp";
  } else {
      categoryService.createCategory(category);
      return "redirect:/";
  }
}

@GetMapping("/products/{id}")
public String showProduct(Model model , @PathVariable("id") Long id){
  Product product = productService.findProduct(id);
  model.addAttribute("product", product);
  
  List<Category> outc = categoryService.CategoriesNotInProduct(product);
  model.addAttribute("outc", outc);
  return "ViewProduct.jsp";
}

@PostMapping("/products/add")
public String addproduct(Model model,@RequestParam("product") Long idproduct,@RequestParam("category") Long idcategory) {
	Product product1 = productService.findProduct(idproduct);
	Category category1 = categoryService.findCategory(idcategory);
	
	List<Category> product1categories = product1.getCategories();
	product1categories.add(category1);
	product1.setCategories(product1categories);
	productService.updateProduct(product1);
	
	return "redirect:/";
}

@GetMapping("/categories/{id}")
public String showCategory(Model model , @PathVariable("id") Long id){
  Category category = categoryService.findCategory(id);
  model.addAttribute("category", category);
  
  List<Product> outp = productService.ProductsNotInCategory(category);
  model.addAttribute("outp", outp);
  return "ViewCategory.jsp";
}
@PostMapping("/categories/add")
public String addcategory(Model model,@RequestParam("category") Long categoryId,@RequestParam("product") Long productId) {
	Category category2 = categoryService.findCategory(categoryId);
	Product product2 = productService.findProduct(productId);
	
	List<Product> category2Products = category2.getProducts();
	category2Products.add(product2);
	category2.setProducts(category2Products);
	categoryService.updateCategory(category2);
	return "redirect:/";
}
}
