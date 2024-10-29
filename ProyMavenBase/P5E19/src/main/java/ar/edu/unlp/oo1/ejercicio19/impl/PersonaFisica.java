package ar.edu.unlp.oo1.ejercicio19.impl;

public class PersonaFisica extends Cliente {

	@SuppressWarnings("unused")
	private Integer DNI;

	public PersonaFisica(String nombre, String direccion, Integer dNI) {
		super(nombre, direccion);
		DNI = dNI;
	}
	
	public double descuento() {
		return 0.9;
	}
}
