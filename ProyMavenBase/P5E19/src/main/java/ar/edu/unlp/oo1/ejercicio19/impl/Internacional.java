package ar.edu.unlp.oo1.ejercicio19.impl;

import java.time.LocalDate;

public class Internacional extends Envio {

	public Internacional(double peso, LocalDate despacho, String origen, String destino) {
		super(peso, despacho, origen, destino);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double montoAPagar() {
		double precio = 10;
		if(this.peso>1000) { precio = 12; }
		return precio*this.peso;
	}

}
