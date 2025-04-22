package com.service.appointmentservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="appointment")
public class Appointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String doctor;

    @Column(nullable = false)
    private String specialty;

    @Column(nullable = false)
    private boolean preventative;

    @Column(nullable = false)
    private Float duration;

    @Column(nullable = false)
    private String description;

}
