package com.codingshuttle.jpaTutorial.JpaTuts.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    //this is owning side because Patient can exists
    //without appointment but appointment cannot

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Patient patient;
    //many appointment to one patient


    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;

}
