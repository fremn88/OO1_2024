package ar.edu.unlp.oo1.ejercicio20.impl;

import java.time.LocalDate;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;

public class ContratoPlanta extends Contrato {
	
	private double sueldoMes, montoConyugue, montoHijos;
	
	public ContratoPlanta(LocalDate fechaIni, Empleado empleado, double sueldoMes, double montoConyugue,
			double montoHijos) {
		super(fechaIni, empleado);
		this.sueldoMes = sueldoMes;
		this.montoConyugue = montoConyugue;
		this.montoHijos = montoHijos;
	}

	@Override
	public double remuneracion() {
		double monto = sueldoMes + montoConyugue;
		if(this.empleado.isHijosTiene()) { monto += montoHijos; }
		if(this.empleado.isHijosTiene()) { monto += montoConyugue; }
		return monto;
	}

	@Override
	public int duracion() {
		DateLapse anios = new DateLapse(fechaIni, LocalDate.now());
		return anios.sizeInDays()/365;
	}

}
