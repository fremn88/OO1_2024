package ar.edu.unlp.oo1.ejercicio9.impl;

public class CuentaCorriente extends Cuenta {

	private double saldoDescubierto;

	public double getSaldoDescubierto() {
		return saldoDescubierto;
	}

	public void setSaldoDescubierto(double saldoDescubierto) {
		this.saldoDescubierto = saldoDescubierto;
	}

	public CuentaCorriente() {
		saldoDescubierto = 0;
	}

	public boolean puedeExtraer(double monto) {
		return getSaldo() + saldoDescubierto >= monto;
	}
}
