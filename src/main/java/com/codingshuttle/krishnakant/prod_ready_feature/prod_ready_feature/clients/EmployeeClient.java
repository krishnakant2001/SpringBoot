package com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.clients;

import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long employeeId);
    EmployeeDTO createNewEmployee(EmployeeDTO inputEmployeeDto);

}
