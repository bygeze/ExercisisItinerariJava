package com.vehicles.domain;

public class TitularVehiculo extends Conductor {
	protected Boolean seguro;
	protected Boolean garage;
	
	public TitularVehiculo(String nombre1, String nombre2, String apellido1, String apellido2, 
			String fechaNacimiento, String tipoLicencia, String fechaCaducidadLicencia, Boolean seguro,
			Boolean garage) {
		super(nombre1, nombre2, apellido1, apellido2, fechaNacimiento, tipoLicencia, fechaCaducidadLicencia);
		
		this.seguro = seguro;
		this.garage = garage;
	}
	
	@Override
	public String toString() {
		String str;
		str = nombre1 + nombre2 + apellido1 + apellido2 + "\nFecha de nacimiento: " + fechaNacimiento + "\nTipo de Licencia: " + tipoLicencia + "\nCaducidad licencia: " + fechaCaducidadLicencia + "\nTiene garage: " + garage + "\nTiene seguro: " + seguro;
		return str;
	}
	
	
}
