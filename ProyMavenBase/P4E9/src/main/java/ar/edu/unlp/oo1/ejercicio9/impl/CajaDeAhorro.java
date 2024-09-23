package ar.edu.unlp.oo1.ejercicio9.impl;

public class CajaDeAhorro extends Cuenta {

	public boolean puedeExtraer(double monto) {
		if (getSaldo() > monto * 1.02) {
			return true;
		} else
			return false;
	}

	public boolean extraer(double monto) {
		if (puedeExtraer(monto)) {
			extraerSinControl(monto * 1.02);
			return true;
		} else
			return false;
	}

	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		if (puedeExtraer(monto)) {
			extraerSinControl(monto * 1.02);
			cuentaDestino.depositar(monto);
			return true;
		} else
			return false;
	}

	public void depositar(double monto) {
		saldo += monto * 0.98;
	}
}
