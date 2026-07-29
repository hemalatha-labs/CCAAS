package com.CCS.Service.ApiResponse;

import com.CCS.Service.globalException.globalExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionResponse<T> extends globalExceptionHandler {
	
	private String message;
	private T data;
	private Boolean Status;

}
