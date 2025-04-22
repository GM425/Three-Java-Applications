package com.service.appointmentservice.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.appointmentservice.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    ArrayList<Appointment> findAll();
}
