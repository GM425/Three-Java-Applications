package com.service.recordservice.controller;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Controller;

import com.service.recordservice.entity.ExerciseRecord;
import com.service.recordservice.service.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/record")
public class RecordController {
    
    private RecordService recordService;

    public RecordController(RecordService recordService){
        this.recordService = recordService;
    }

    @GetMapping("/health")
    public String getHealth() {
        System.out.println("health get ran ////////////////////////////////////////////////////////////////////");
        return "Healthy";
    }
    
    @PostMapping("/create")
    public String addRecord(@RequestBody ExerciseRecord exerciseRecord) {
        recordService.createRecord(exerciseRecord);     
        return "Record Created Successfully";   
    }

    @GetMapping("/all")
    public ArrayList<ExerciseRecord> getAllExercisdRecords(){
        
        Optional<ArrayList<ExerciseRecord>> expenses = recordService.getAllRecords();
        try {
            expenses.orElseThrow(() -> new RuntimeException("There are no records yet."));
        } catch(NoSuchElementException notFound){
            System.err.println("There are no records currently in the database. Please add a record to get started.");
        }

        return expenses.get();  
    }

    
}
