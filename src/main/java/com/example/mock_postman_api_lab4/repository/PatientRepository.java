package com.example.mock_postman_api_lab4.repository;

import com.example.mock_postman_api_lab4.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
