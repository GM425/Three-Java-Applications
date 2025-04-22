package com.service.userservice.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    ArrayList<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
}
