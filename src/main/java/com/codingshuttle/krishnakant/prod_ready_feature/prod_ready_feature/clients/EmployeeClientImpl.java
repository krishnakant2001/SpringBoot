package com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.clients;

import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.advice.ApiResponse;
import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient{

    private final RestClient restClient;

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        try{
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDTOList.getData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        try {
            ApiResponse<EmployeeDTO> employeeResponse = restClient.get()
                    .uri("employees/{employeeId}", employeeId)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeResponse.getData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployeeDto) {
        try{
            ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient.post()
                    .uri("employees")
                    .body(inputEmployeeDto)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDTOApiResponse.getData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
