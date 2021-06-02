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

	private void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception("Maximo dos ruedas por paquete");

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception("La rueda izquierda y la derecha no pueden ser diferentes");

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
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
				+ "  (Traseras x 2) " + this.wheels.get(1).toString();
		
		return str;
	}

}
