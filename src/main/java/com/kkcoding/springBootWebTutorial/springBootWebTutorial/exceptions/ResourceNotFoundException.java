package com.kkcoding.springBootWebTutorial.springBootWebTutorial.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
