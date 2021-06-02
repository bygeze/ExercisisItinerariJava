package com.vehicles.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class Vehicle {
	protected TitularVehiculo titular;
	protected List<Conductor> conductores = new ArrayList<Conductor>();
	protected static String tipoLicencia = "";
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
				+ titular.toString() + "\n"
				+ "Matricula: " + this.plate + "\n"
				+ "Marca: " + this.brand+ "\n" 
				+ "Color: " + this.color + "\n";
		
		return str;
	}
	
	public String getTipoLicencia() {
		return tipoLicencia;
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
	
	public void setTitular(TitularVehiculo titular) {
		this.titular = titular;
	}
	
	public void addConductor(Conductor conductor) {
		this.conductores.add(conductor);
	}
	
	public boolean isConductorAlready(int ID) {
		boolean toReturn = false;
		
		try {
			for(int i = 0; i < this.conductores.size(); i++) {
				if(ID == this.conductores.get(i).getID()) {
					toReturn = true;
					break;
				}
			}
		} catch(NullPointerException e) {
			
		}
		
		return toReturn;	
	}
}
