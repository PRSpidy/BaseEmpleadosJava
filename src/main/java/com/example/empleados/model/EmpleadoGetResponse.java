package com.example.empleados.model;

public class EmpleadoGetResponse {
	private int id;
	private String name;
	private String position;
	private int salary;
	private Integer bossId;
	private Integer departamentId;
	@Override
	public String toString() {
		return "EmpleadoGetResponse [id=" + id + ", name=" + name + ", position=" + position + ", salary=" + salary
				+ ", bossId=" + bossId + ", departamentId=" + departamentId + "]";
	}
	public int getId() {
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
	public EmpleadoGetResponse(int id, String name, String position, int salary, Integer bossId,
			Integer departamentId) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.bossId = bossId;
		this.departamentId = departamentId;
	}
	public EmpleadoGetResponse() {
		super();
	}
	
	
}
