package com.service.userservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Summary {
    
    private String activity;
    private int duration;
    private String date;
    private int amount;
    private int average;
}
