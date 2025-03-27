package com.example.mock_postman_api_lab4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @Column(name = "appointment_id")
    private int appointmentId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "appointment_reason")
    private String appointmentReason;
}
