package ar.edu.unlp.oo1.ejercicio7.impl;

public class Empleado {
	private String nombre;
	
	public double montoBasico() {
		return 35000;
	}
	public double aportes() {
		return 13500;
	}
	public double sueldoBasico() {
		return this.montoBasico()+this.aportes();
	}
}
