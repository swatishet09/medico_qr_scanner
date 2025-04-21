package com.example.medical_scanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medical_scanner.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    // No custom code needed — Spring Boot auto-generates it!
}
