package com.example.empleados.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Empleado not edit.")
public class EmpleadoNotEditException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EmpleadoNotEditException(String errorMessage) {
		super(errorMessage);
	}
}
