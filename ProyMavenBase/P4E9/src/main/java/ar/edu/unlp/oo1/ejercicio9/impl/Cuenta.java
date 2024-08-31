package ar.edu.unlp.oo1.ejercicio9.impl;

public abstract class Cuenta {
	
	private double saldo;
	
	public Cuenta() {
		this.saldo = 0;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void depositar(double monto) {
		this.saldo+=monto;
	}
	
	protected void extraerSinControl(double monto) {
		this.saldo-=monto;
	}
	
	public boolean extraer(double monto) {
		if(this.puedeExtraer(monto)) {
			this.extraerSinControl(monto);
			return true;
		} else return false;
	}
	
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		if(this.puedeExtraer(monto)) {
			this.extraerSinControl(monto);
			cuentaDestino.depositar(monto);
			return true;
		} else return false;
	}
	
	protected abstract boolean puedeExtraer(double monto);
	
	// respuestas preguntas
	/*
	 * this es el objeto que ejecuta el mensaje, es una instancia que puede ser clase "cajaAhorro" o "CuentaCorriente".
	 * visibilidad protegido permite que las sublcases de cuenta puedan acceder al metodo en cuestion en clase padre.
	 * deberia poder transferir dado que el metodo transferirACuenta recibe objetos de tipo cuenta, siendo cajaAhorro y cuentaCorriente ambos con clase padre Cuenta
	 * en java el metodo abstracto se declara con el modificador de visibilidad, tipo de retorno, nombre y parametros ingresados si los requiere, pero sin cuerpo. Es de implementacion obligatoria por las subclases que la extienden.
	 */
}
