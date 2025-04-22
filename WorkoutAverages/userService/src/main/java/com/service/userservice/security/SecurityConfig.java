package com.service.userservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.beans.BeanProperty;
import java.lang.Exception;

// import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.service.userservice.entity.User;
import com.service.userservice.repository.UserRepository;
import com.service.userservice.security.UserDetailsServiceImp;
import com.zaxxer.hikari.HikariDataSource;

// import jakarta.annotation.sql.DataSourceDefinition;
// import jakarta.sql.DataSource;
import javax.sql.DataSource; // Note: This is `javax.sql` even in Spring Boot 3

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
        .url("jdbc:mysql://user-db:3307/USER_DB")
        .username("user")
        .password("user")
        .driverClassName("com.mysql.cj.jdbc.Driver")
        .build();
    }

    // Use Spring Boot's auto-configured DataSource
    // @Bean
    // public UserDetailsService userDetailsService(DataSource dataSource) {
    //     // JDBC-based UserDetailsService using auto-configured DataSource
    //     JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
    //     userDetailsManager.setUsersByUsernameQuery(
    //             "SELECT username, password, enabled FROM users WHERE username = ?");
    //     userDetailsManager.setAuthoritiesByUsernameQuery(
    //             "SELECT username, authority FROM authorities WHERE username = ?");
    //     return userDetailsManager;
    // }

    // Password encoder for securing passwords
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // Define the security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing; enable for production
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/login", "/users/registration","/users/all").permitAll() // Public routes
                .anyRequest().authenticated()// All other routes require authentication
            )
            .httpBasic(Customizer.withDefaults()); // Enable basic authentication
        return http.build();
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker(){
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }
}


  






 