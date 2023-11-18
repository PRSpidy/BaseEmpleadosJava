package com.example.empleados.service;

import java.util.List;

import com.example.empleados.exceptions.EmpleadoNotCreatedException;
import com.example.empleados.exceptions.EmpleadoNotDeletedException;
import com.example.empleados.exceptions.EmpleadoNotEditException;
import com.example.empleados.exceptions.EmpleadoNotFoundException;
import com.example.empleados.model.EmpleadoDTO;

public interface EmpleadoService {

	List<EmpleadoDTO> findAllEmpleados() throws EmpleadoNotFoundException;

	EmpleadoDTO findEmpleadoById(int id) throws EmpleadoNotFoundException;

	int createEmpleado(EmpleadoDTO convertirDTOaResponse) throws EmpleadoNotCreatedException;

	int deleteEmpleadoById(int id)throws EmpleadoNotDeletedException;

	int updateEmpleado(EmpleadoDTO convertirClases) throws EmpleadoNotEditException;

}
