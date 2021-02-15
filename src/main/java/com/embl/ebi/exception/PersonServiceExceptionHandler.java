package com.embl.ebi.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class PersonServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EmptyResultDataAccessException.class})
    protected ResponseEntity<String> exception(EmptyResultDataAccessException exception, WebRequest request) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NoSuchElementException.class})
    protected ResponseEntity<String> exception(NoSuchElementException exception, WebRequest request) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
