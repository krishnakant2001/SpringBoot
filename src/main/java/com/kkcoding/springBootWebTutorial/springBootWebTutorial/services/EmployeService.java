package com.kkcoding.springBootWebTutorial.springBootWebTutorial.services;

import com.kkcoding.springBootWebTutorial.springBootWebTutorial.dto.EmployeeDTO;
import com.kkcoding.springBootWebTutorial.springBootWebTutorial.entities.EmployeeEntity;
import com.kkcoding.springBootWebTutorial.springBootWebTutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }



    public EmployeeEntity createNewEmployee(EmployeeEntity employeeInput) {
        return employeeRepository.save(employeeInput);
    }


    public EmployeeDTO createNewEmployee(EmployeeDTO employeeInput) {
        EmployeeEntity toSaveEntity = modelMapper.map(employeeInput, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }
}
