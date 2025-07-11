package com.kkcoding.springBootWebTutorial.springBootWebTutorial.repositories;

import com.kkcoding.springBootWebTutorial.springBootWebTutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    //All the CRUD operation is handled by Spring-data-jpa
    //and some more complex queries for us with the help of JPQL


}
