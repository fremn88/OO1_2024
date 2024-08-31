package ar.edu.unlp.oo1.ejercicio9.impl;

public class CajaDeAhorro extends Cuenta {
	
	public boolean puedeExtraer(double monto) {
		if(this.getSaldo()>monto*1.2) {
			return true;
		} else return false;
	}
}
