package ar.edu.unlp.oo1.ejercicio17.impl;


public class Flexible implements PoliticaCancelacion {

	@Override
	public double montoReembolso(Reserva r) {
		// TODO Auto-generated method stub
		return r.calcularPrecio();
	}

}
