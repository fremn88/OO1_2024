package ar.edu.unlp.oo1.ejercicio19.impl;

import java.time.LocalDate;

public class Local extends Envio {
	
	private boolean rapido;

	public Local(double peso, LocalDate despacho, String origen, String destino, boolean rapido) {
		super(peso, despacho, origen, destino);
		this.rapido = rapido;
	}

	@Override
	public double montoAPagar() {
		double monto = 1000;
		if(rapido) { monto+=500; }
		return monto;
	}

	
	
}
