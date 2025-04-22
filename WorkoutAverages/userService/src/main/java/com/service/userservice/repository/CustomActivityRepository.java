package com.service.userservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.userservice.entity.CustomActivity;
import com.service.userservice.entity.User;

@Repository
public interface CustomActivityRepository extends JpaRepository<CustomActivity, Long> {
       ArrayList<CustomActivity> findAll();
}