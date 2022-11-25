package com.codingdojo.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.codingdojo.travels.models.Expense;
import com.codingdojo.travels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
 // adding the Expense repository as a dependency
	private final ExpenseRepository expenseRepository;
 
 public ExpenseService(ExpenseRepository expenseRepository) {
     this.expenseRepository = expenseRepository;
 }
 // returns all expenses
 public List<Expense> allExpenses() {
     return expenseRepository.findAll();
 }
 // creates a expense
 public Expense createExpense(Expense e) {
     return expenseRepository.save(e);
 }
 // retrieves a expense
 public Expense findExpense(Long id) {
     Optional<Expense> optionalExpense = expenseRepository.findById(id);
     if(optionalExpense.isPresent()) {
         return optionalExpense.get();
     } else {
         return null;
     }
 }
 
 public Expense updateExpense(Expense expense){
	 return expenseRepository.save(expense);
 }
 public void deleteExpense(Long id ) {
     Optional<Expense> optionalExpense = expenseRepository.findById(id);
     if(optionalExpense.isPresent()) {
    	 expenseRepository.deleteById(id);
     }
 }
}

