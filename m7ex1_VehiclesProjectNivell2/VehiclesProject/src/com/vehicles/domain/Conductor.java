package com.vehicles.domain;

public class Conductor extends Persona {
	protected int ID = 0;
	protected String tipoLicencia;
	protected String fechaCaducidadLicencia;
	protected String nombreCompleto;
	
	public Conductor(String nombre1, String nombre2, String apellido1, String apellido2, String fechaNacimiento, String tipoLicencia, String fechaCaducidadLicencia) {
		super(nombre1, nombre2, apellido1, apellido2, fechaNacimiento);

		this.ID++;
		this.tipoLicencia = tipoLicencia;
		this.fechaCaducidadLicencia = fechaCaducidadLicencia;		
	}
	
	@Override
	public String toString() {
		String str;
		str = nombre1 + nombre2 + apellido1 + apellido2 + "\nFecha de nacimiento: " + fechaNacimiento + "\nTipo de Licencia: " + tipoLicencia + "\nCaducidad licencia: " + fechaCaducidadLicencia;
		return str;
	}
	
	public String getTipoLicencia() {
		return this.tipoLicencia;
	}
	
}
