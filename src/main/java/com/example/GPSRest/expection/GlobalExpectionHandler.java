package com.example.GPSRest.expection;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExpectionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult bindingResult = e.getBindingResult();
		ArrayList<String> errors = new ArrayList<String>();
		for (ObjectError error : bindingResult.getGlobalErrors()) {
			errors.add(error.getDefaultMessage());
		}
		for (FieldError error : bindingResult.getFieldErrors()) {
			errors.add(String.format("%s %s", error.getField(), error.getDefaultMessage()));
		}
		return handleExceptionInternal(e, errors, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
	}

}
