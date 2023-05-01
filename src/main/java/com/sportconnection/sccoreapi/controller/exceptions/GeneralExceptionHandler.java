package com.sportconnection.sccoreapi.controller.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler( { NoSuchElementException.class, EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(Exception ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity<Object> handleException(MissingServletRequestParameterException ex) {
        return ResponseEntity.unprocessableEntity().body(ex.getMessage());
    }
    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<Object> handleException(AuthenticationException ex) {
        return (ResponseEntity<Object>) ResponseEntity.status(HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<Object> handleException(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().build();
    }
}
