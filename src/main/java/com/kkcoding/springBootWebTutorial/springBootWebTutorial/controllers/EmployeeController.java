package com.kkcoding.springBootWebTutorial.springBootWebTutorial.controllers;

import com.kkcoding.springBootWebTutorial.springBootWebTutorial.dto.EmployeeDTO;
import com.kkcoding.springBootWebTutorial.springBootWebTutorial.exceptions.ResourceNotFoundException;
import com.kkcoding.springBootWebTutorial.springBootWebTutorial.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/india")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/getSecretMessage")
    public String getMySuperSecretMessage(){
        return "Secret Message: Khana Khalo guys";
    }

    @GetMapping(path = "/employees/{employeeId}")
    // @PathVariable long employeeId
    // path variable written like any one of the method
    //convert the json data into objects that thing is done by JACKSON

    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id : " + id));


//        return new EmployeeDTO(id, "Krishnakant", "strikerKK@gmail.com", 23, LocalDate.of(2025, 3, 1), true);
    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleEmployeeNotFount(NoSuchElementException exception){
//        return new ResponseEntity<>("Employee Not Found", HttpStatus.NOT_FOUND);
//    }

    //for the query in the url your have to use ? then write age=12
    //for the second param you have to use & then write your second param
    @GetMapping(path = "/employees")
    public List<EmployeeDTO> getAllEmployees(@RequestParam (required = false) Integer age, @RequestParam (required = false) Integer weight){
        return employeeService.getAllEmployees();
//        if(age == null && weight == null){
//            return "I don't know my age and weight";
//        }
//        else if(age == null){
//            return "My weight is " + weight;
//        }
//        else if(weight == null){
//            return "My age is " + age;
//        }
//        return "My age is " + age + " and weight is " + weight;
    }

    @PostMapping(path = "/employees")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO employeeInput){
            EmployeeDTO savedEmployee = employeeService.createNewEmployee(employeeInput);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
//        employeeDTOInput.setId(100L);
//        return employeeDTOInput;
    }

    @PutMapping(path = "/employees/{employeeId}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        System.out.println("Entering in the put");
        return employeeService.updateEmployeeById(employeeId, employeeDTO);
    }

    @DeleteMapping(path = "/employees/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping(path = "/employees/{employeeId}")
    public EmployeeDTO updatePartialEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId){
        return employeeService.updatePartialEmployeeById(employeeId, updates);

    }
}
