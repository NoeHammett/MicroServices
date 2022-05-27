package com.devhammett.restweb.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
   
    public UserNotFoundException(String message) {
        super(message);
    }
}
