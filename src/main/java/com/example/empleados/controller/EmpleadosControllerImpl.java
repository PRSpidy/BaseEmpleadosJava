package com.example.empleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;

import com.example.empleados.convertidorDeClases.ConvertidorClases;
import com.example.empleados.exceptions.EmpleadoNotCreatedException;
import com.example.empleados.exceptions.EmpleadoNotDeletedException;
import com.example.empleados.exceptions.EmpleadoNotEditException;
import com.example.empleados.exceptions.EmpleadoNotFoundException;
import com.example.empleados.model.EmpleadoDTO;
import com.example.empleados.model.EmpleadoGetResponse;
import com.example.empleados.model.EmpleadoPostRequest;
import com.example.empleados.service.EmpleadoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class EmpleadosControllerImpl {

	@Autowired
	EmpleadoService empleadoService;
	
	@GetMapping("/empleados")
	public ResponseEntity<List<EmpleadoGetResponse>> getAllEmpleados()throws EmpleadoNotFoundException{	
		try { 
			List<EmpleadoDTO> list = empleadoService.findAllEmpleados();
			List<EmpleadoGetResponse> listPostRequest = new ArrayList<EmpleadoGetResponse>();
			for (EmpleadoDTO empleadoDTO : list) {
				listPostRequest.add(ConvertidorClases.convertirClases(empleadoDTO, EmpleadoGetResponse.class));
				
			}
			
			return new ResponseEntity<List<EmpleadoGetResponse>>(listPostRequest,HttpStatus.OK);
		
		}catch(EmpleadoNotFoundException e) {
		
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	@GetMapping("/empleado/{id}")
	public ResponseEntity<EmpleadoGetResponse> getEmpleadoById(@PathVariable("id") int id)throws EmpleadoNotFoundException{	
		try { 
			EmpleadoDTO empleado = empleadoService.findEmpleadoById(id);
			
			return new ResponseEntity<>(ConvertidorClases.convertirClases(empleado, EmpleadoGetResponse.class), HttpStatus.OK);
		
		}catch(EmpleadoNotFoundException e) {
		
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}
	
	
	@PostMapping("/empleados")
	public ResponseEntity<?> createEmpleado(@Valid @RequestBody EmpleadoPostRequest empleadoPostRequest) throws EmpleadoNotCreatedException{
		empleadoPostRequest.setId(0);
		try {
			int response = empleadoService.createEmpleado(ConvertidorClases.convertirClases(empleadoPostRequest, EmpleadoDTO.class));
			System.out.println(response);
			return new ResponseEntity<Integer>(response, HttpStatus.CREATED);
		} catch (EmpleadoNotCreatedException e) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
	}
	
	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<?> deleteEmpleado(@PathVariable("id") int id) throws EmpleadoNotDeletedException{

		try {
			return new ResponseEntity<>(empleadoService.deleteEmpleadoById(id), HttpStatus.NO_CONTENT);
		} catch (EmpleadoNotDeletedException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,e.getMessage(),e);
		}	
	}	
	
	@PutMapping("/empleados/{id}")
	public ResponseEntity<?>  updateEmpleado(@PathVariable("id") int id, @Valid @RequestBody EmpleadoPostRequest empleadoPostRequest) throws EmpleadoNotEditException{
		empleadoPostRequest.setId(id);

		try {
			return new ResponseEntity<>(empleadoService.updateEmpleado(ConvertidorClases.convertirClases(empleadoPostRequest, EmpleadoDTO.class)),HttpStatus.OK);
		} catch (EmpleadoNotEditException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,e.getMessage(),e);
		
		}

	}
	
	
	
}
