package com.codingshuttle.jpaTutorial.JpaTuts;

import com.codingshuttle.jpaTutorial.JpaTuts.dto.BloodGroupStats;
import com.codingshuttle.jpaTutorial.JpaTuts.dto.CPatientInfo;
import com.codingshuttle.jpaTutorial.JpaTuts.dto.IPatientInfo;
import com.codingshuttle.jpaTutorial.JpaTuts.entities.Patient;
import com.codingshuttle.jpaTutorial.JpaTuts.repositories.PatientRepository;
import com.codingshuttle.jpaTutorial.JpaTuts.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

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

    @Test
    public void testPatientClass(){
        List<CPatientInfo> patientInfoList = patientRepository.getAllPatientInfoConcrete();

        for(CPatientInfo p : patientInfoList){
            System.out.println(p);
        }
    }

    @Test
    public void testPatientClassBloodGroup(){
        int rowsAffected = patientRepository.updatePatientNameWithId("Krishnakant", 1L);
        List<BloodGroupStats> bloodGroupStats = patientRepository.getBloodGroupStats();

        for(BloodGroupStats p : bloodGroupStats){
            System.out.println(p);
        }

        System.out.println(rowsAffected);
    }

    @Test
    public void testPatientTransaction(){
        patientService.testPatientTransaction();
    }
}
