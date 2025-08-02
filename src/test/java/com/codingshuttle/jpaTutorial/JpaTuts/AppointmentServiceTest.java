package com.codingshuttle.jpaTutorial.JpaTuts;

import com.codingshuttle.jpaTutorial.JpaTuts.entities.Appointment;
import com.codingshuttle.jpaTutorial.JpaTuts.services.AppointmentService;
import com.codingshuttle.jpaTutorial.JpaTuts.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
                .reason("fever")
                .build();

        Appointment updatedAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);

        System.out.println(updatedAppointment);

        patientService.deletePatient(2L);
    }
}
