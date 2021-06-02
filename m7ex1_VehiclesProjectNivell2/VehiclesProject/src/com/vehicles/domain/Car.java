package com.vehicles.domain;

import java.util.List;
import java.util.regex.Pattern;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	@Override
	public String toString() {
		String str = "Información del vehiculo: \n"
				+ "Tipo: Coche \n"
				+ "Matricula: " + this.plate + "\n"
				+ "Marca: " + this.brand+ "\n" 
				+ "Color: " + this.color + "\n\n"
				+ "Ruedas: \n"
				+ "  (Delanteras x 2) " + this.wheels.get(0).toString()
				+ "  (Traseras x 2) " + this.wheels.get(2).toString();
		
		return str;
	}
	
	public static String getTipoLicencia() {
		return "B";
	}

}
