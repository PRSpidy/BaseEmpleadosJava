package com.example.empleados.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Empleado not deleted.")
public class EmpleadoNotDeletedException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public EmpleadoNotDeletedException(String errorMessage) {
		super(errorMessage);
	}
}
