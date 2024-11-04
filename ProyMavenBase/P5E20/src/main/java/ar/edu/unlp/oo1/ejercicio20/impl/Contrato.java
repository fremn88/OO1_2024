package ar.edu.unlp.oo1.ejercicio20.impl;

import java.time.LocalDate;

public abstract class Contrato {
	
	protected LocalDate fechaIni;
	
	public abstract double remuneracion(boolean tieneHijos);
	public abstract int duracion();
	
	public boolean activo() {
		return true;
	}
	
}
