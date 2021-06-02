package com.vehicles.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class Vehicle {
	protected String tipoLicencia = "";
	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
	
	@Override
	public String toString() {
		String str = "Información del vehiculo: \n"
				+ "Matricula: " + this.plate + "\n"
				+ "Marca: " + this.brand+ "\n" 
				+ "Color: " + this.color + "\n";
		
		return str;
	}
	
	public static String getTipoLicencia() {
		return null;
	}
	
	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception("Maximo dos ruedas por paquete");

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception("La rueda izquierda y la derecha no pueden ser diferentes");

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}
	
}
