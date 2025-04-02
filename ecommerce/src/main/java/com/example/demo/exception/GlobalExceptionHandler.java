package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
 
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Map<String,String>> handleUserAlreadyExistsException(UserAlreadyExistsException ex)
	{
		Map<String, String>response=new HashMap<>();
		response.put("Status", "400");
		response.put("message",ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

    @ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String,String>> handleRuntimeException(RuntimeException ex)
	{
		Map<String, String>response=new HashMap<>();
		response.put("Status", "400");
		response.put("message",ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

    @ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,Object>> handleValidationException(MethodArgumentNotValidException ex)
	{
		Map<String, Object>response=new HashMap<>();
		response.put("Status", "400");
		response.put("message","Validation failed .please check the input data");
		
		Map<String, String>errors=new HashMap<>();
		for(FieldError error :ex.getBindingResult().getFieldErrors())
		{
			errors.put(error.getField(),error.getDefaultMessage());
		}
		response.put("errors", errors);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
