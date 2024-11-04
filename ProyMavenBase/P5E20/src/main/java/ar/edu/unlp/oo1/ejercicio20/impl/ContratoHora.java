package ar.edu.unlp.oo1.ejercicio20.impl;

import java.time.LocalDate;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;

public class ContratoHora extends Contrato {
	
	private LocalDate fechaFin;
	private double valorHora, horasMes;


	@Override
	public double remuneracion(boolean tieneHijos) {
		return valorHora*horasMes;
	}

	@Override
	public int duracion() {
		DateLapse anios = new DateLapse(fechaIni, fechaFin);
		return anios.sizeInDays()/365;
	}

	public boolean activo() {
		return LocalDate.now().isBefore(fechaFin);
	}
}
