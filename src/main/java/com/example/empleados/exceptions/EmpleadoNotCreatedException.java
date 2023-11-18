package com.example.empleados.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Empleado can't be created.")
public class EmpleadoNotCreatedException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EmpleadoNotCreatedException(String errorMessage) {
		super(errorMessage);
	}
	
}
