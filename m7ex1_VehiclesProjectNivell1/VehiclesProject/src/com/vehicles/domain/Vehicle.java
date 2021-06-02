package com.vehicles.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class Vehicle {

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
	
}
