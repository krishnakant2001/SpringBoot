package com.codingshuttle.jpaTutorial.JpaTuts;

import com.codingshuttle.jpaTutorial.JpaTuts.dto.IPatientInfo;
import com.codingshuttle.jpaTutorial.JpaTuts.entities.Patient;
import com.codingshuttle.jpaTutorial.JpaTuts.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient() {
        List<Patient> patientList = patientRepository.findAll();
        List<IPatientInfo> patientInfoList = patientRepository.getAllPatientInfo();

//        for(Patient p: patientList){
//            System.out.println(p);
//        }

        for(IPatientInfo p : patientInfoList){
            System.out.println(p);
        }
    }
}
