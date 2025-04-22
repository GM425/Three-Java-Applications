package com.service.recordservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestSummary {
    
    private String activity;
    private int duration;
    
}


