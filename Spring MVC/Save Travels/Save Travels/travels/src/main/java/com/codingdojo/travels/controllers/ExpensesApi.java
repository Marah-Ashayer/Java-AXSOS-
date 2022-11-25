package com.codingdojo.travels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.travels.models.Expense;
import com.codingdojo.travels.services.ExpenseService;

@RestController
public class ExpensesApi {
 private final ExpenseService expenseService;
 public ExpensesApi(ExpenseService expenseService){
     this.expenseService = expenseService;
 }
 @RequestMapping("/api/expenses")
 public List<Expense> index() {
     return expenseService.allExpenses();
 }
 
 @RequestMapping(value="/api/expenses", method=RequestMethod.POST)
 public Expense create(@RequestParam(value="name") String name, @RequestParam(value="vendor") String vendor, @RequestParam(value="ammount") double ammount, @RequestParam(value="description") String description) {
	 Expense expense = new Expense(name, vendor, ammount, description);
     return expenseService.createExpense(expense);
 }
 
 @RequestMapping("/api/expenses/{id}")
 public Expense show(@PathVariable("id") Long id) {
	 Expense expense = expenseService.findExpense(id);
     return expense;
 }
 @RequestMapping(value="/api/expenses/{id}", method=RequestMethod.PUT)
 public Expense update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="vendor") String vendor, @RequestParam(value="ammount") double ammount, @RequestParam(value="description") String description) {
	 Expense expense = expenseService.updateExpense(new Expense(name, vendor, ammount, description));
	 expense.setId(id);
     return expense;
 }
 
 @RequestMapping(value="/api/expenses/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
	 expenseService.deleteExpense(id);
 }
}
