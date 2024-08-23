package com.iuri.delivery.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.webjars.NotFoundException;

import java.sql.SQLException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<String> notFoundExceptionHandler(NotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<String> constraintViolationExceptionHandler(ConstraintViolationException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    private ResponseEntity<String> nullPointerExceptionHandler(NullPointerException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Null pointer exception occurred: " + exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid argument: " + exception.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    private ResponseEntity<String> sqlExceptionHandler(SQLException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database error: " + exception.getMessage());
    }

    @ExceptionHandler(DataAccessException.class)
    private ResponseEntity<String> dataAccessExceptionHandler(DataAccessException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data access error: " + exception.getMessage());
    }
}
