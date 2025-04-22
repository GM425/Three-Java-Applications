package com.service.recordservice.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.service.recordservice.entity.ExerciseRecord;
import com.service.recordservice.entity.Summary;
import com.service.recordservice.repository.RecordRepository;

@Service
public class RecordService {
    
    private RecordRepository recordRepository;
    
    // Default Activities - My thought is when I include authentication, then I can include in the user entity a list of custom activities.
    // Then create a route for authenticated users to add custom activities, then if authenticated check the user profile so that custom activities can be include with the default ones.
    public String[] activities = {"Push-Ups Regular", "Push-Ups Clap", "Push-Ups One-Handed", "Sit-Ups", "Reverse Sit-Ups", "Crunches", "Burpies"};

    public RecordService(RecordRepository recordRepository){
        this.recordRepository = recordRepository;
    }

    public void createRecord(ExerciseRecord exerciseRecord){
        boolean found = false;
        for (String activity : activities){
            if (activity.equals(exerciseRecord.getActivity())){
                found = true;
            }
        }
        if(!found){
            throw(new RuntimeException("The available activities include Push-Ups Regular, Push-Ups Clap, Push-Ups One-Handed, Sit-Ups, Reverse Sit-Ups, Crunches and Burpies. Please re-enter."));
        }

        if(exerciseRecord.getDuration() >= 6){
            throw(new RuntimeException("You can only give duration as an integer from 0 to 5 as recorded in minutes."));
        }
        ArrayList<ExerciseRecord> recordsAll = recordRepository.findAll();
        for (ExerciseRecord record : recordsAll){
            if (record.getActivity().equals(exerciseRecord.getActivity()) && record.getDate().equals(exerciseRecord.getDate()) && record.getDuration() == exerciseRecord.getDuration()){
                throw(new RuntimeException("You cannot duplicate a daily record with the same date, activity, and duration."));
            }
        }
        recordRepository.save(exerciseRecord);
    }

    public Optional<ArrayList<ExerciseRecord>> getAllRecords(){
        ArrayList<ExerciseRecord> recordsAll = recordRepository.findAll();
        return recordsAll.isEmpty() ? Optional.empty() : Optional.of(recordsAll);
    }

    // public Summary getActivitySummary(RequestSummary requestSummary){
            //For right now create a summary of all the default activities that takes no account of users. 
            //Future Goal: To create an authentication layer that covers all services and allows access if JWT token presented.
            //Then can take custom activity functionality off User Service.
            //If the User is authenticated and has a token from the User Service, they can add an activity that isn't a default activity
                         //Can view an activity that isn't a default activity
    // }
    // So will have to either create a filter for each service or a gateway service that has a filter that then directs traffic to the correct service.
    // Ask Jaimie if I should just do gateway service now?
}
