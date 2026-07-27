package com.CSS.Service.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApiExceptionResponse<T> extends GlobalExceptionHandler {
	
	private String message;
	private T data;
	private Boolean Status;

}
