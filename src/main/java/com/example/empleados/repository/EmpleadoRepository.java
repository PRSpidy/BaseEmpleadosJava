package com.example.empleados.repository;

import java.util.List;

import com.example.empleados.exceptions.EmpleadoNotCreatedException;
import com.example.empleados.exceptions.EmpleadoNotDeletedException;
import com.example.empleados.exceptions.EmpleadoNotEditException;
import com.example.empleados.exceptions.EmpleadoNotFoundException;
import com.example.empleados.model.EmpleadoDAO;

public interface EmpleadoRepository {

	List<EmpleadoDAO> findAllEmpleados() throws EmpleadoNotFoundException;

	EmpleadoDAO findEmpleadoById(int id) throws EmpleadoNotFoundException;

	int createEmpleado(EmpleadoDAO convertirClases) throws EmpleadoNotCreatedException;

	int deleteEmpleadoById(int id) throws EmpleadoNotDeletedException;

	int updateEmpleado(EmpleadoDAO convertirClases) throws EmpleadoNotEditException;

	
}
