package com.codingshuttle.jpaTutorial.JpaTuts.services;

import com.codingshuttle.jpaTutorial.JpaTuts.entities.Patient;
import com.codingshuttle.jpaTutorial.JpaTuts.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public void testPatientTransaction(){
        Patient p1 = patientRepository.findById(1L).orElseThrow();

        Patient p2 = patientRepository.findById(1L).orElseThrow();

        System.out.println(p1 + " " + p2);
        System.out.println(p1 == p2);

        p1.setName("Ram Kumar");
    }


}
