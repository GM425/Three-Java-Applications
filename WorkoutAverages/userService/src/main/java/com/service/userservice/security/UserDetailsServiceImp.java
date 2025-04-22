package com.service.userservice.security;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.service.userservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
// import com.service.userservice.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import com.service.userservice.entity.User;

@Service
public class UserDetailsServiceImp implements UserDetailsService{
    
    private UserRepository userRepository;

    public UserDetailsServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Optional<User> user = 
        User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username not found for the user" + username));
        Set<GrantedAuthority> authorities = user.getAuthorities().stream()
        .map(auth -> new SimpleGrantedAuthority(auth.getAuthority()))
        .collect(Collectors.toSet());
        return new UserDetailsClass(user.getUsername(), user.getPassword(), user.getEmail(), authorities);
        // user.setAuthorities(authorities);
        // return user.map(UserDetailsClass::new);
    }
}
