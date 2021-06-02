package com.vehicles.domain;

import java.util.ArrayList;
import java.util.List;

public class Bike extends Vehicle {
	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	public void addWheels(List<Wheel> theWheels) throws Exception {
		addTwoWheels(theWheels);
	}
	
	@Override
	public String toString() {
		String str = "Información del vehiculo: \n"
				+ titular.toString() + "\n"
				+ "Tipo: Moto \n"
				+ "Matricula: " + this.plate + "\n"
				+ "Marca: " + this.brand+ "\n" 
				+ "Color: " + this.color + "\n"
				+ "Ruedas: \n"
				+ "  (Delantera) " + this.wheels.get(0).toString()
				+ "  (Trasera) " + this.wheels.get(1).toString() + "\n";
		
		return str;
	}
	
	
	public String getTipoLicencia() {
		return "A";
	}
	
	public static String staticGetTipoLicencia() {
		return "A";
	}
}
