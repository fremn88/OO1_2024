package ar.edu.unlp.oo1.ejercicio20.impl;

import java.time.LocalDate;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;

public class ContratoPlanta extends Contrato {
	
	private double sueldoMes, montoConyugue, montoHijos;

	@Override
	public double remuneracion(boolean tieneHijos) {
		double monto = sueldoMes + montoConyugue;
		if(tieneHijos) { monto += montoHijos; }
		return monto;
	}

	@Override
	public int duracion() {
		DateLapse anios = new DateLapse(fechaIni, LocalDate.now());
		return anios.sizeInDays()/365;
	}

}
