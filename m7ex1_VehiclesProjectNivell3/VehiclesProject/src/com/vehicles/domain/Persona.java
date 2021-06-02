package com.vehicles.domain;

public class Persona {
	private static int counter = 0;
	protected int ID;
	protected String nombre1;
	protected String nombre2;
	protected String apellido1;
	protected String apellido2;
	protected String fechaNacimiento;
	
	public Persona(String nombre1, String nombre2, String apellido1, String apellido2, String fechaNacimiento) {
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		counter++;
		this.ID = counter;
		
	}
	
	public Integer getID() {
		return this.ID;
	}
	
}
