package com.example.empleados.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Empleado not found.")
public class EmpleadoNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public EmpleadoNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
