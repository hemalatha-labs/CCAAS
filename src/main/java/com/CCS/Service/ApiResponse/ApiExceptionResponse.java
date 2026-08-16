package com.CCS.Service.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionResponse<T> {

    private String message;

    private T data;

    private Boolean status;
}