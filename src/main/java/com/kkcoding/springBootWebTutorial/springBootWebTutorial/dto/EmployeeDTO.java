package com.kkcoding.springBootWebTutorial.springBootWebTutorial.dto;

import com.kkcoding.springBootWebTutorial.springBootWebTutorial.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    //DTO -> data transfer object

    private Long id;

    @NotNull
    @NotBlank(message = "Name of the employee cannot be Blank")
    @Size(min = 3, message = "Minimum number of characters in the name should be greater or equal 3")
    private String name;

    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Minimum age of employee should be 18")
    @Max(value = 80, message = "Maximum age of employee can be 80")
    private Integer age;

    @NotBlank(message = "Role of the employee cannot be Blank")
    // @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of the employee can be USER or ADMIN")
    @EmployeeRoleValidation  //custom annotation
    private String role; //ADMIN, USER


    private LocalDate dateOfJoining;
    private Boolean isActive;
}
