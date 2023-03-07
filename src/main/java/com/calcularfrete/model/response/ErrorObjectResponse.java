package com.calcularfrete.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorObjectResponse {
	 	private final String message;
	    private final String field;
	    private final Object parameter;
}
