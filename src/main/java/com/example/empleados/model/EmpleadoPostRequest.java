package com.example.empleados.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class EmpleadoPostRequest {
	@NotNull(message = "El ID no puede ser nulo")
    @Min(value = 1, message = "El ID debe ser un número positivo")
    private Integer id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;

    @NotBlank(message = "La posición no puede estar en blanco")
    private String position;

    @Min(value = 0, message = "El salario no puede ser negativo")
    private int salary;

    @Min(value = 1, message = "El ID del jefe debe ser un número positivo")
    private Integer bossId;

    @Min(value = 1, message = "El ID del departamento debe ser un número positivo")
    private Integer departamentId;

	@Override
	public String toString() {
		return "EmpleadoPostRequest [id=" + id + ", name=" + name + ", position=" + position + ", salary=" + salary
				+ ", bossId=" + bossId + ", departamentId=" + departamentId + "]";
	}
	public EmpleadoPostRequest(Integer id, String name, String position, int salary, Integer bossId,
			Integer departamentId) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.bossId = bossId;
		this.departamentId = departamentId;
	}
	public EmpleadoPostRequest() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Integer getBossId() {
		return bossId;
	}
	public void setBossId(Integer bossId) {
		this.bossId = bossId;
	}
	public Integer getDepartamentId() {
		return departamentId;
	}
	public void setDepartamentId(Integer departamentId) {
		this.departamentId = departamentId;
	}
	
}
