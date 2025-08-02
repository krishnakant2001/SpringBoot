package com.codingshuttle.jpaTutorial.JpaTuts.services;

import com.codingshuttle.jpaTutorial.JpaTuts.entities.Insurance;
import com.codingshuttle.jpaTutorial.JpaTuts.entities.Patient;
import com.codingshuttle.jpaTutorial.JpaTuts.repositories.InsuranceRepository;
import com.codingshuttle.jpaTutorial.JpaTuts.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToParent(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);

        insurance.setPatient(patient); //optional

        return insurance;

    }
}
