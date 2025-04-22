package com.expensetracker.expensetracker.service;

import java.util.Optional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.expensetracker.expensetracker.entity.Expense;
import com.expensetracker.expensetracker.entity.MonthExpenses;
import com.expensetracker.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;
    public String[] categories = {"Groceries", "Transportation", "Dining", "Utilities", "Entertainment", "Housing", "Other"};

    public ExpenseService (ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public MonthExpenses getSummary(String month){
        ArrayList<Expense> expenses = expenseRepository.findAll();
        MonthExpenses thisMonth = new MonthExpenses();
        for (Expense e : expenses){
            LocalDate date = e.getDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dateString = date.format(formatter);
            String[] dateArray = dateString.split("-");
            if (dateArray[1].equals(month)){
                thisMonth.setTotal(thisMonth.getTotal() + e.getAmount());

                switch(e.getCategory()) {
                    case "Groceries":
                        thisMonth.setGroceries(thisMonth.getGroceries()+ e.getAmount());
                    case "Transportation":
                        thisMonth.setTransportation(thisMonth.getTransportation()+ e.getAmount());
                        // System.out.println("Hit transportation");
                        // System.out.println("Category //////////////////////Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"");
                        // System.out.println(e.getCategory());
                        break;
                    case "Dining":
                        thisMonth.setDining(thisMonth.getDining()+ e.getAmount());
                        break;
                    case "Entertainment":
                        thisMonth.setEntertainment(thisMonth.getEntertainment()+ e.getAmount());
                        // System.out.println("Hit entertainment");
                        // System.out.println("Category //////////////////////Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"");
                        // System.out.println(e.getCategory());
                        break;
                    case "Housing":
                        thisMonth.setHousing(thisMonth.getHousing()+ e.getAmount());
                        // System.out.println("Hit housing");
                        // System.out.println("Category //////////////////////Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"");
                        // System.out.println(e.getCategory());
                        break;  
                    case "Other":
                        thisMonth.setOther(thisMonth.getOther()+ e.getAmount());
                        // System.out.println("Hit other");
                        // System.out.println("Category //////////////////////Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"");
                        // System.out.println(e.getCategory());
                        break;  
                    default:
                        System.out.println("No Case Matches");
                        // System.out.println("Category //////////////////////Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"Category //////////////////////\"");
                        // System.out.println(e.getCategory());
                }
            }
        }
        return thisMonth;
    }

    public Optional<ArrayList<Expense>> getAllExpenses(){
        ArrayList<Expense> expenses = expenseRepository.findAll();
        return expenses.isEmpty() ? Optional.empty() : Optional.of(expenses);
    }

    public void createExpense(Expense expense){
        try {
            boolean found = false;
            for (String category : categories){
                if(category.equals(expense.getCategory())){
                    found = true;
                    break;
                }
            }

            if(found){
                expenseRepository.save(expense);
            } else {
                throw(new RuntimeException("The category you entered is not a valid category. Please re-try with any of the following categories: Groceries, Transportation, Dining, Utilities, Entertainment, Housing, Other"));
            }
        
         
        } catch(DateTimeParseException dtpexception){
            System.err.println("The date you entered is invalid. Please give the date in following format (YYY-MM-DD)");
        }
    }
}
