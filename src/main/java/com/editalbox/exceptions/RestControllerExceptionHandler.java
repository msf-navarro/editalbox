package com.editalbox.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.swing.*;

@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<String> resourceNotFoundHandler(
            ResourceNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                String.format(
                        "[NOT_FOUND: %s not found with id \"%d\"]",
                        exception.resourceName,
                        exception.resourceId
                )
        );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> typeMismatchHandler(
            MethodArgumentTypeMismatchException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                String.format(
                        "[BAD_REQUEST: \"%s\" is not a valid id]",
                        exception.getValue()
                )
        );
    }

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> emptyInputHandler(
            EmptyInputException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                String.format(
                        "[BAD_REQUEST: parameter \"%s\" can not be empty]",
                        exception.parameterName
                )
        );
    }
}
