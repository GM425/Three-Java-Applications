package com.expensetracker.expensetracker.entity;

import lombok.Data;

@Data
public class MonthExpenses {
    private float total;
    private float groceries;
    private float transportation;
    private float dining;
    private float utilities;
    private float entertainment;
    private float housing;
    private float other;

    public MonthExpenses() {
        this.total = 0.0f;
        this.groceries = 0.0f;
        this.transportation = 0.0f;
        this.dining = 0.0f;
        this.entertainment = 0.0f;
        this.housing = 0.0f;
        this.other = 0.0f;
    }
 
}
