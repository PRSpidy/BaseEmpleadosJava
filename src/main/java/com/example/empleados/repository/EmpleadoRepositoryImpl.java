package com.example.empleados.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.empleados.exceptions.EmpleadoNotCreatedException;
import com.example.empleados.exceptions.EmpleadoNotDeletedException;
import com.example.empleados.exceptions.EmpleadoNotEditException;
import com.example.empleados.exceptions.EmpleadoNotFoundException;
import com.example.empleados.model.EmpleadoDAO;

@Repository
public class EmpleadoRepositoryImpl implements EmpleadoRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<EmpleadoDAO> findAllEmpleados() throws EmpleadoNotFoundException {
	    try {
	        return jdbcTemplate.query(
	                "SELECT * FROM employees",
	                BeanPropertyRowMapper.newInstance(EmpleadoDAO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	throw new EmpleadoNotFoundException("No se han encontrado empleados");
	    } catch (DataAccessException e) {
	        // Manejar otras excepciones de acceso a datos según sea necesario
	        throw new EmpleadoNotFoundException("Error al obtener la lista de empleados");
	    }
	}


	@Override
	public EmpleadoDAO findEmpleadoById(int id) throws EmpleadoNotFoundException {
		try {
			return jdbcTemplate.queryForObject(
					"SELECT * FROM employees WHERE id = ?",
					BeanPropertyRowMapper.newInstance(EmpleadoDAO.class),
					id);
		}  catch (EmptyResultDataAccessException e) {
	        throw new EmpleadoNotFoundException("Empleado no encontrado en el repositorio");
	    } catch (IncorrectResultSizeDataAccessException e) {
	        throw new EmpleadoNotFoundException("Múltiples empleados encontrados para el ID: " + id);
	    }
	}

	@Override
	public int createEmpleado(EmpleadoDAO empleadoDAO) throws EmpleadoNotCreatedException {
		try {
	        return jdbcTemplate.update(
	                "INSERT INTO employees (name, position, salary, bossId, departmentId) VALUES (?, ?, ?, ?, ?)",
	                new Object[] {
		                empleadoDAO.getName(),
		                empleadoDAO.getPosition(),
		                empleadoDAO.getSalary(),
		                empleadoDAO.getBossId(),
		                empleadoDAO.getDepartamentId()
	                }
	        );
	    } catch (DataAccessException e) {
	        throw new EmpleadoNotCreatedException("Error al crear el empleado");
	    }
	}

	@Override
	public int deleteEmpleadoById(int id) throws EmpleadoNotDeletedException {
	    try {
	        return jdbcTemplate.update(
	                "DELETE FROM employees WHERE id = ?",
	                id
	        );
	    } catch (DataAccessException e) {
	        throw new EmpleadoNotDeletedException("Error al eliminar el empleado con ID: " + id);
	    }
	}


	@Override
	public int updateEmpleado(EmpleadoDAO empleadoDAO) throws EmpleadoNotEditException {
	    try {
	        return jdbcTemplate.update(
	                "UPDATE employees SET name = ?, position = ?, salary = ?, bossId = ?, departmentId = ? WHERE id = ?",
	                empleadoDAO.getName(),
	                empleadoDAO.getPosition(),
	                empleadoDAO.getSalary(),
	                empleadoDAO.getBossId(),
	                empleadoDAO.getDepartamentId(),
	                empleadoDAO.getId()
	        );
	    } catch (DataAccessException e) {
	        throw new EmpleadoNotEditException("Error al actualizar el empleado con ID: " + empleadoDAO.getId());
	    }
	}

}
