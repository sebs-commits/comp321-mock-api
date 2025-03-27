package com.example.mock_postman_api_lab4.controller;

import com.example.mock_postman_api_lab4.model.Patient;
import com.example.mock_postman_api_lab4.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public ResponseEntity<?> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
    @GetMapping("/patients/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable int id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
}
