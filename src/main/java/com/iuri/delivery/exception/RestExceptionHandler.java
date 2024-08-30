package com.iuri.delivery.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.webjars.NotFoundException;

import java.sql.SQLException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex,
             HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return handleExceptionInternal(ex, "Bad request", headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundExceptionHandler(NotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolationExceptionHandler(ConstraintViolationException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullPointerExceptionHandler(NullPointerException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Null pointer exception occurred: " + exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid argument: " + exception.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> sqlExceptionHandler(SQLException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database error: " + exception.getMessage());
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> dataAccessExceptionHandler(DataAccessException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data access error: " + exception.getMessage());
    }
}
