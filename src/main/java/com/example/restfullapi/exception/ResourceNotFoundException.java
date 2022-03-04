package com.example.restfullapi.exception;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(long id) {
        super("Could not found resource of: " + id);
    }

    public ResourceNotFoundException(String message, long id) {
        super(message + " " + id);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
