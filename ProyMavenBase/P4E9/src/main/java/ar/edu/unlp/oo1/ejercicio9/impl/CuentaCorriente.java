package ar.edu.unlp.oo1.ejercicio9.impl;

public class CuentaCorriente extends Cuenta {

	private double saldoDescubierto;

	public CuentaCorriente() {
		saldoDescubierto = 0;
	}

	public boolean puedeExtraer(double monto) {
		if ((getSaldo() + saldoDescubierto) > monto * 1.02) {
			return true;	
		} else
			return false;
	}
}
