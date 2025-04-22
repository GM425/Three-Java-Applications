package com.service.userservice.dtos;

import java.util.Set;

import com.service.userservice.entity.Authority;
import com.service.userservice.entity.User;

import lombok.Data;

@Data
public class UserDTO{
    
    // private User user;
    private String username;
    private String email;
    private Set<Authority> authorities;

    public UserDTO(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.authorities = user.getAuthorities();
    }
}
