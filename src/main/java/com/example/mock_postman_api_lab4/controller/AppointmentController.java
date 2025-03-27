package com.example.mock_postman_api_lab4.controller;

import com.example.mock_postman_api_lab4.model.Appointment;
import com.example.mock_postman_api_lab4.model.Patient;
import com.example.mock_postman_api_lab4.repository.AppointmentRepository;
import com.example.mock_postman_api_lab4.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/patient/{id}/add-appointment")
    public ResponseEntity<?> addAppointment(@PathVariable int id, @RequestBody Appointment appointment) {
        Optional<Patient> patientOptional = patientRepository.findById(id);

        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            appointment.setPatient(patient);
            Appointment savedAppointment = appointmentRepository.save(appointment);
            return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/patient/{id}/appointments")
    public ResponseEntity<?> getAppointments(@PathVariable int id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            List<Appointment> appointments = appointmentRepository.findByPatientPatientId(id);
            return new ResponseEntity<>(appointments, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
