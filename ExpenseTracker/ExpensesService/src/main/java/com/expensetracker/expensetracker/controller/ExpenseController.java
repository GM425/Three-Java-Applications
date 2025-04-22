package com.expensetracker.expensetracker.controller;

import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.expensetracker.expensetracker.entity.Expense;
import com.expensetracker.expensetracker.entity.MonthExpenses;
import com.expensetracker.expensetracker.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private ExpenseService expenseService;  

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping("/create")
    public String createExpense(@RequestBody Expense expense){
        expenseService.createExpense(expense);
        return "Successfully Created Expense";
    }

    @GetMapping("/all/{m}")
    public MonthExpenses getMonth(@PathVariable String m){
            MonthExpenses expenses = expenseService.getSummary(m);
        return expenses;
    }


    @GetMapping("/all")
    public ArrayList<Expense> getAllExpenses(){
        
        Optional<ArrayList<Expense>> expenses = expenseService.getAllExpenses();
        try {
            expenses.orElseThrow(() -> new RuntimeException("There are no expenses yet."));
        } catch(NoSuchElementException notFound){
            System.err.println("There are no expenses currently in the database. Please add an expense to get started.");
        }

        return expenses.get();  
    }


    @GetMapping("health")
    public String getHealth(){
        return "Healthy";
    }
    
}
