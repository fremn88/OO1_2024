package ar.edu.unlp.oo1.ejercicio17.impl;


public class Flexible extends PoliticaCancelacion {
	
	public Flexible(String descripcion) {
		super(descripcion);
		// TODO Auto-generated constructor stub
	}

	public double calcularReembolso(Reserva r) {
		// al momento de hacer el calculo ya se verifico que la fecha es anterior a la reserva.
		return r.calcularPrecio();
	}

}
