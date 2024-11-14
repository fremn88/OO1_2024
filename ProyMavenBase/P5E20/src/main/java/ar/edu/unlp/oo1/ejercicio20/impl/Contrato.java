package ar.edu.unlp.oo1.ejercicio20.impl;

import java.time.LocalDate;

public abstract class Contrato {
	
	protected LocalDate fechaIni;
	protected Empleado empleado;
	
	public Contrato(LocalDate fechaIni, Empleado empleado) {
		super();
		this.fechaIni = fechaIni;
		this.empleado = empleado;
	}
	public abstract double remuneracion();
	public abstract int duracion();
	
	public boolean activo() {
		return true;
	}
	
}
