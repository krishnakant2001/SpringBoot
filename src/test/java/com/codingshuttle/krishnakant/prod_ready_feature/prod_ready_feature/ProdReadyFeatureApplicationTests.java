package com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature;

import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.clients.EmployeeClient;
import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.dto.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProdReadyFeatureApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	@Order(3)
	void getAllEmployeesTest(){
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

	@Test
	@Order(2)
	void getEmployeeByIdTest(){
		EmployeeDTO employeeDTO = employeeClient.getEmployeeById(1L);
		System.out.println(employeeDTO);
	}

	@Test
	@Order(1)
	void createNewEmployeeTest(){
		EmployeeDTO employeeDTO = new EmployeeDTO(null, "Krishnakant", "kk@gmail.com",
				24, "USER", LocalDate.of(2024, 9, 1), true);
		EmployeeDTO savedEmployeeDto = employeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployeeDto);
	}


}
