package com.codingshuttle.jpaTutorial.JpaTuts.services;

import com.codingshuttle.jpaTutorial.JpaTuts.entities.Appointment;
import com.codingshuttle.jpaTutorial.JpaTuts.entities.Doctor;
import com.codingshuttle.jpaTutorial.JpaTuts.entities.Patient;
import com.codingshuttle.jpaTutorial.JpaTuts.repositories.AppointmentRepository;
import com.codingshuttle.jpaTutorial.JpaTuts.repositories.DoctorRepository;
import com.codingshuttle.jpaTutorial.JpaTuts.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;
    }
}
