package com.codingshuttle.jpaTutorial.JpaTuts.repositories;

import com.codingshuttle.jpaTutorial.JpaTuts.dto.IPatientInfo;
import com.codingshuttle.jpaTutorial.JpaTuts.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p.id as id, p.name as name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientInfo();

    List<Patient> findByEmailContaining(String email);
}
