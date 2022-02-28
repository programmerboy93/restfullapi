package com.example.restfullapi.exception;

public class ActorNotFoundException extends RuntimeException {

    public ActorNotFoundException(long id) {
        super("Could not find book: " + id);
    }
}
