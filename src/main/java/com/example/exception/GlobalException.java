package com.example.exception;

import com.example.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> getResourceNotFoundException(ResourceNotFoundException ex) {
        ApiResponse build = ApiResponse.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(build, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ResourceFoundException.class)
    public ResponseEntity<ApiResponse> getResourceFoundException(ResourceFoundException ex) {
        ApiResponse build = ApiResponse.builder().message(ex.getMessage()).success(true).status(HttpStatus.PARTIAL_CONTENT).build();
        return new ResponseEntity<>(build, HttpStatus.PARTIAL_CONTENT);
    }
}
