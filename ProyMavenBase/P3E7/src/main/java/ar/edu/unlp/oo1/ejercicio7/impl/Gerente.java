package ar.edu.unlp.oo1.ejercicio7.impl;

public class Gerente extends EmpleadoJerarquico {
	
	private String nombre;
	
	public Gerente(String nombre) {
		this.nombre = nombre;
	}
	
	public double aportes() {
		return this.montoBasico()*0.05;
	}
	public double montoBasico() {
		return 57000;
	}
}
