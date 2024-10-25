package ar.edu.unlp.oo1.ejercicio19.impl;

import ar.edu.unlp.oo1.ejercicio14.impl.Lapse;

public class PersonaFisica extends Cliente {

	@SuppressWarnings("unused")
	private Integer DNI;

	public PersonaFisica(String nombre, String direccion, Integer dNI) {
		super(nombre, direccion);
		DNI = dNI;
	}
	
	public double montoAPagarPeriodo(Lapse periodo) {
		return super.montoAPagarPeriodo(periodo)*0.9;
	}
	
}
