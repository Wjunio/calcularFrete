package com.calcularfrete.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.calcularfrete.model.response.ErrorObjectResponse;
import com.calcularfrete.model.response.ResponseError;

@RestControllerAdvice
public class RestEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static String MENSAGEM = "Requisição possui campos inválidos";

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ErrorObjectResponse> errors = getErrors(ex);
		ResponseError errorResponse = getErrorResponse(ex, status, errors);
		return new ResponseEntity<>(errorResponse, status);
	}

	private ResponseError getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status,
			List<ErrorObjectResponse> errors) {
		return new ResponseError(MENSAGEM, status.value(), status.getReasonPhrase(),
				ex.getBindingResult().getObjectName(), errors);
	}

	private List<ErrorObjectResponse> getErrors(MethodArgumentNotValidException ex) {
		return ex.getBindingResult().getFieldErrors().stream().map(
				error -> new ErrorObjectResponse(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
				.collect(Collectors.toList());
	}
}
