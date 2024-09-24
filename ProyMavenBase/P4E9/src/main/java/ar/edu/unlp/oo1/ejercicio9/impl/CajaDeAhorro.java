package ar.edu.unlp.oo1.ejercicio9.impl;

public class CajaDeAhorro extends Cuenta {

	public boolean puedeExtraer(double monto) {
		return getSaldo() >= monto * 1.02;
	}

	protected void extraerSinControl(double monto) {
		saldo -= monto * 1.02;
	}
	
	public void depositar(double monto) {
		saldo += monto * 0.98;
	}
}
