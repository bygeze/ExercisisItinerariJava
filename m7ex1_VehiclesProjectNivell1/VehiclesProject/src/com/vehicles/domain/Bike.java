package com.vehicles.domain;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	public void addWheels(Wheel delantera, Wheel trasera) {
		wheels.add(delantera);
		wheels.add(trasera);
	}
	
	@Override
	public String toString() {
		String str = "Información del vehiculo: \n"
				+ "Tipo: Moto \n"
				+ "Matricula: " + this.plate + "\n"
				+ "Marca: " + this.brand+ "\n" 
				+ "Color: " + this.color + "\n"
				+ "Ruedas: \n"
				+ "  (Delantera) " + this.wheels.get(0).toString()
				+ "  (Trasera) " + this.wheels.get(1).toString() + "\n";
		
		return str;
	}

}
