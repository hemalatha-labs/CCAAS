package com.CCS.Service.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.CCS.Service.ApiResponse.*;

import com.CCS.Service.ResponseDTO.*;

@RestControllerAdvice
public class globalExceptionHandler {

    // Resource Not Found - 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(
            ResourceNotFoundException ex) {

        ApiResponse<Object> response = new ApiResponse<>(
                ex.getMessage(),
                null,
                false
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }


    // Bad Request - 400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequest(
            BadRequestException ex) {

        ApiResponse<Object> response = new ApiResponse<>(
                ex.getMessage(),
                null,
                false
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }


    // Duplicate Resource - 409
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse<Object>> handleDuplicateResource(
            DuplicateResourceException ex) {

        ApiResponse<Object> response = new ApiResponse<>(
                ex.getMessage(),
                null,
                false
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }


    // Cloud Integration Error - 503
    @ExceptionHandler(CloudIntegrationException.class)
    public ResponseEntity<ApiResponse<Object>> handleCloudIntegration(
            CloudIntegrationException ex) {

        ApiResponse<Object> response = new ApiResponse<>(
                ex.getMessage(),
                null,
                false
        );

        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(response);
    }


    // Other Unexpected Errors - 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneralException(
            Exception ex) {

        ApiResponse<Object> response = new ApiResponse<>(
                "Something went wrong: " + ex.getMessage(),
                null,
                false
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}