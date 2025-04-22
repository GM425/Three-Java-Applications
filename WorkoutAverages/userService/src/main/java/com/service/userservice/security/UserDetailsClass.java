package com.service.userservice.security;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.service.userservice.entity.Authority;
import com.service.userservice.entity.User;
import java.util.Collection;
import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.Lombok;
// @Configuration
@Data
public class UserDetailsClass implements UserDetails{

    private String username;
    private String password;
    private String email;
    private Set<GrantedAuthority> authorities;
    // private User user;

    // public UserDetailsClass(String username, String password){
        public UserDetailsClass(String username, String password, String email, Set<GrantedAuthority> authorities){
        // this.user = user;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }

    @Override
    public Set<? extends GrantedAuthority> getAuthorities(){
        return authorities;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

}


// package com.service.loginService.config;
// import org.springframework.security.core.userdetails.UserDetails;



// // import lombok.Data;







    

// }
