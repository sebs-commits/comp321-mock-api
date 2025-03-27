package com.example.mock_postman_api_lab4.repository;

import com.example.mock_postman_api_lab4.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByPatientPatientId(int patientId);
}
