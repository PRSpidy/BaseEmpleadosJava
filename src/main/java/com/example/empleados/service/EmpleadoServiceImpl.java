package com.example.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.example.empleados.convertidorDeClases.ConvertidorClases;
import com.example.empleados.exceptions.EmpleadoNotCreatedException;
import com.example.empleados.exceptions.EmpleadoNotDeletedException;
import com.example.empleados.exceptions.EmpleadoNotEditException;
import com.example.empleados.exceptions.EmpleadoNotFoundException;
import com.example.empleados.model.EmpleadoDAO;
import com.example.empleados.model.EmpleadoDTO;
import com.example.empleados.model.EmpleadoGetResponse;
import com.example.empleados.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	EmpleadoRepository empleadoRepository;

	@Override
	public List<EmpleadoDTO> findAllEmpleados() throws EmpleadoNotFoundException {
		// TODO Auto-generated method stub
		List<EmpleadoDAO> list = empleadoRepository.findAllEmpleados();
		List<EmpleadoDTO> listDTO = new ArrayList<EmpleadoDTO>();
		
		for(EmpleadoDAO Dao : list) {
		
			listDTO.add(ConvertidorClases.convertirClases(Dao, EmpleadoDTO.class));
		}
		return listDTO;
	}

	@Override
	public EmpleadoDTO findEmpleadoById(int id) throws EmpleadoNotFoundException {
		EmpleadoDAO Dao = empleadoRepository.findEmpleadoById(id);
		return ConvertidorClases.convertirClases(Dao, EmpleadoDTO.class);
	}

	@Override
	public int createEmpleado(EmpleadoDTO empleadoDTO) throws EmpleadoNotCreatedException {
		return empleadoRepository.createEmpleado(ConvertidorClases.convertirClases(empleadoDTO, EmpleadoDAO.class));
		
	}

	@Override
	public int deleteEmpleadoById(int id) throws EmpleadoNotDeletedException {
		// TODO Auto-generated method stub
		return empleadoRepository.deleteEmpleadoById(id);
	}

	@Override
	public int updateEmpleado(EmpleadoDTO empleadoDTO) throws EmpleadoNotEditException {
		// TODO Auto-generated method stub
		return empleadoRepository.updateEmpleado(ConvertidorClases.convertirClases(empleadoDTO, EmpleadoDAO.class));
	}
	
}
