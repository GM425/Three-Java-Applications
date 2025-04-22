package com.service.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Login {
    private String username;
    private String password;
}
