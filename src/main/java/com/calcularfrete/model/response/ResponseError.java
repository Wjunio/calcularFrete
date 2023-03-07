package com.calcularfrete.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseError {
	private final String message;
    private final int code;
    private final String status;
    private final String objectName;
    private final List<ErrorObjectResponse> errors;
}
