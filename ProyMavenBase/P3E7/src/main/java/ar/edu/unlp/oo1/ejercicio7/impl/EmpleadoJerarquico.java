package ar.edu.unlp.oo1.ejercicio7.impl;

public class EmpleadoJerarquico extends Empleado {
	public double sueldoBasico() {
		return super.sueldoBasico()+this.bonoPorCategoria();
	}
	
	public double montoBasico() {
		return 45000;
	}
	public double bonoPorCategoria() {
		return 8000;
	}
}
