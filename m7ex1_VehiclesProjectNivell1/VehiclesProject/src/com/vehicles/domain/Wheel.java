package com.vehicles.domain;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		//if(diameter < 0.4 || diameter > 4) {
			//throw new Exception("El diametro de la rueda debe comprender entre 0.4 y 4");
		//}
		
		this.brand = brand;
		this.diameter = diameter;
	}
	
	// Sobrecarga del metodo equals
	public boolean equals(Object obj) {
		// Si el objeto es exactamente el mismo.
		if(obj == this) {
			return true;
		}
		
		// Si el objeto no es una instancia de Wheel.
		if(!(obj instanceof Wheel)) {
			return false;
		}
		
		// Si el objeto es wheel comparamos que los datos sean correctos.
		Wheel wheel = (Wheel) obj;
		return brand.equals(wheel.brand) && Double.compare(diameter, wheel.diameter) == 0;
	}
	
	@Override
	public String toString() {
		String str = brand + " / " + diameter; 
		
		return str;
	}
}
