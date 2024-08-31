package ar.edu.unlp.oo1.ejercicio9.impl;

public class CuentaCorriente extends Cuenta {
	
	private double saldoDescubierto;
	
	public CuentaCorriente() {
		this.saldoDescubierto = 0;
	}
	
	public boolean puedeExtraer(double monto) {
		if((this.getSaldo()+this.saldoDescubierto)>monto*1.2) {
			return true;
		} else return false;
	}
}
