package com.codingshuttle.jpaTutorial.JpaTuts;

import com.codingshuttle.jpaTutorial.JpaTuts.entities.Insurance;
import com.codingshuttle.jpaTutorial.JpaTuts.services.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceServiceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testAssignInsuranceToPatient(){
        Insurance insurance = Insurance.builder()
                .provider("Hdfc Ergo")
                .policyNumber("Hdfc_236")
                .validUntil(LocalDate.of(2030, 1, 1))
                .build();

        Insurance updateInsurance = insuranceService.assignInsuranceToParent(insurance, 1L);

        System.out.println(updateInsurance);

        insuranceService.deletePatient(1L);

    }
}
