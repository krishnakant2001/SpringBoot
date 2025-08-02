package com.codingshuttle.jpaTutorial.JpaTuts.repositories;

import com.codingshuttle.jpaTutorial.JpaTuts.dto.BloodGroupStats;
import com.codingshuttle.jpaTutorial.JpaTuts.dto.CPatientInfo;
import com.codingshuttle.jpaTutorial.JpaTuts.dto.IPatientInfo;
import com.codingshuttle.jpaTutorial.JpaTuts.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p.id as id, p.name as name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientInfo();

    List<Patient> findByEmailContaining(String email);

    @Query("select new com.codingshuttle.jpaTutorial.JpaTuts.dto.CPatientInfo(p.id, p.name) from Patient p")
    List<CPatientInfo> getAllPatientInfoConcrete();

    @Query("select new com.codingshuttle.jpaTutorial.JpaTuts.dto.BloodGroupStats(p.bloodGroup, " +
    "COUNT(p)) from Patient p group by p.bloodGroup order by COUNT(p)")
    List<BloodGroupStats> getBloodGroupStats();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p set p.name = :name where p.id = :id")
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);


    @Query("select p from Patient p LEFT JOIN FETCH p.appointments")
    List<Patient> getAllPatientsWithAppointments();
}
