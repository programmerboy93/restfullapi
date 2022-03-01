package com.example.restfullapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ActorExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Requested Actor Not Found")
    @ExceptionHandler(ActorNotFoundException.class)
    public void actorNotFoundHandler(ActorNotFoundException ex){
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Received Invalid Input Parameters")
    @ExceptionHandler(ActorNotCreatedException.class)
    public void actorNotCreatedHandler(ActorNotCreatedException ex){
    }


}
