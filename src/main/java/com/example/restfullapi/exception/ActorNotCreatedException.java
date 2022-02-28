package com.example.restfullapi.exception;


public class ActorNotCreatedException extends RuntimeException {

    public ActorNotCreatedException() {
        super("Could not created new Actor");
    }
}
