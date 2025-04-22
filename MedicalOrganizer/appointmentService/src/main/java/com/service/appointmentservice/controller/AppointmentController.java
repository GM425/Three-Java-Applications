package com.service.appointmentservice.controller;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Controller;

import com.service.appointmentservice.entity.Appointment;
import com.service.appointmentservice.service.AppointmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @PostMapping("/create")
    public String addAppointment(@RequestBody Appointment appointment) {
        appointmentService.createAppointment(appointment);
        return "Created Appointment Successfully";
    }

    @GetMapping("/all")
    public ArrayList<Appointment> getAllAppointments() {
          Optional<ArrayList<Appointment>> appointments = appointmentService.getAllAppointments();
        // try {
            return appointments.orElseThrow(() -> new RuntimeException("There are no appointments yet."));
        // } catch(NoSuchElementException notFound){
        //     System.err.println("There are no appointments yet. Please add a record to get started.");
        // }

        // return appointments.get();
    }
    
    
}
