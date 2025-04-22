package com.expensetracker.expensetracker.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensetracker.expensetracker.entity.Expense;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    ArrayList<Expense> findAll();
}
