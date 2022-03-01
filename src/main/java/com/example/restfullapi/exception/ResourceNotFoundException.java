package com.example.restfullapi.exception;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(long id) {
        super("Could not find resource: " + id);
    }
}
