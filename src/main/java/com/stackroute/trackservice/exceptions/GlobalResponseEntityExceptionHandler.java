package com.stackroute.trackservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value= { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(Exception ex) {

        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
}
