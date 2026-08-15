package com.CCS.Service.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.CCS.Service.ApiResponse.ApiResponse;

@RestControllerAdvice
public class globalExceptionHandler {

   
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(ResourceNotFoundException ex) {

        ApiResponse<Object> response =
                new ApiResponse<>(ex.getMessage(), null, false);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequest(BadRequestException ex) {

        ApiResponse<Object> response =
                new ApiResponse<>(ex.getMessage(), null, false);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    //ADD THIS METHOD
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .findFirst()
                .orElse("Validation failed");

        ApiResponse<Object> response =
                new ApiResponse<>(message, null, false);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGlobalException(Exception ex) {

        ApiResponse<Object> response =
                new ApiResponse<>("Something went wrong: " + ex.getMessage(), null, false);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}