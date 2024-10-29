package ar.edu.unlp.oo1.ejercicio19.impl;

public class PersonaJuridica extends Cliente {

	private Integer CUIT;
	
	public PersonaJuridica(String nombre, String direccion, Integer CUIT) {
		super(nombre, direccion);
		this.CUIT = CUIT;
	}

	public double descuento() {
		return 1;
	}
}
