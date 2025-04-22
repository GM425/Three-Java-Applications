package com.service.recordservice.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import com.service.recordservice.entity.ExerciseRecord;


public interface RecordRepository extends JpaRepository<ExerciseRecord, Long>{
        ArrayList<ExerciseRecord> findAll();
}
