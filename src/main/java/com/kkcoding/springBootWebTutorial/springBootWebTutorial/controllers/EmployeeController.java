package com.kkcoding.springBootWebTutorial.springBootWebTutorial.dto;

import com.kkcoding.springBootWebTutorial.springBootWebTutorial.entities.EmployeeEntity;
import com.kkcoding.springBootWebTutorial.springBootWebTutorial.repositories.EmployeeRepository;
import com.kkcoding.springBootWebTutorial.springBootWebTutorial.services.EmployeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/india")
public class EmployeeController {

    private final EmployeService employeService;

    public EmployeeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping(path = "/getSecretMessage")
    public String getMySuperSecretMessage(){
        return "Secret Message: Khana Khalo guys";
    }

    @GetMapping(path = "/employees/{employeeId}")
    // @PathVariable long employeeId
    // path variable written like any one of the method
    //convert the json data into objects that thing is done by JACKSON

    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeService.getEmployeeById(id);

//        return new EmployeeDTO(id, "Krishnakant", "strikerKK@gmail.com", 23, LocalDate.of(2025, 3, 1), true);
    }

    //for the query in the url your have to use ? then write age=12
    //for the second param you have to use & then write your second param
    @GetMapping(path = "/employees")
    public List<EmployeeDTO> getAllEmployees(@RequestParam (required = false) Integer age, @RequestParam (required = false) Integer weight){
        return employeService.getAllEmployees();
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
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeInput){
            return employeService.createNewEmployee(employeeInput);
//        employeeDTOInput.setId(100L);
//        return employeeDTOInput;
    }

    @PutMapping(path = "/employees")
    public String updateEmployeeById(){
        return "Hello from the put req";
    }
}
