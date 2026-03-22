package com.misaelpereiradev.rest_playground.persons.domain.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String message) {
        super(message);
    }
}
