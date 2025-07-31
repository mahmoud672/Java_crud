package io.gad.demo.validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.gad.demo.util.ApiResponse;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ValidationErrorsHandler {
	
	/**
	 * 
	 * @param exception
	 * @return
	 * @description handle not valid exception like all validation errors that happened by rules 
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<Map<String, String>>> handleNotValidException(MethodArgumentNotValidException exception)
	{
		Map<String, String> errors = new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(error ->
					errors.put(error.getField(), error.getDefaultMessage())
				);
		ApiResponse<Map<String, String>> response = new ApiResponse<>("validation errors","error",422,errors);
		//return ResponseEntity.ok(response);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiResponse<Void>> handleNotFoundException(ConstraintViolationException exception)
	{
		String message = exception.getConstraintViolations().stream().findFirst().map(cv -> cv.getMessage()).orElse("validation failed");
		
		ApiResponse<Void> response = new ApiResponse<>(message,"error",404, null);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	
	
}
