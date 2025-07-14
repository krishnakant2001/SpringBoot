package com.kkcoding.springBootWebTutorial.springBootWebTutorial.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
public class ApiError {

    private HttpStatus status;
    private String message;


}
