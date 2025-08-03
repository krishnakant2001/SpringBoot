package com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private LocalDateTime timeStamp;

    private T data;

    private ApiError error;

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this(); // default constructor called
        this.error = error;
    }
}
