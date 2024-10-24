package ar.edu.unlp.oo1.ejercicio17.impl;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;

public abstract class PoliticaCancelacion {

	protected String descripcion;
	protected DateLapse diasCancelacion;
		
	public PoliticaCancelacion(String descripcion) {
		this.descripcion = descripcion;
	}

	public abstract double calcularReembolso(Reserva r);
}
