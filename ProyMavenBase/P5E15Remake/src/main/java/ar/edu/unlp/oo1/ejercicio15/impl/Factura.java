package ar.edu.unlp.oo1.ejercicio15.impl;

import java.time.LocalDate;

public class Factura {
	
	private String nombre;
	private LocalDate fechaEmision;
	private double bonificacion,montoFinal;
	
	public Factura() {
		
	}
	
	public Factura(String nombre, double bonificacion, double montoFinal) {
		this.nombre = nombre;
		this.bonificacion = bonificacion;
		this.montoFinal = montoFinal;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaEmision() {
		return fechaEmision;
	}

	public double getBonificacion() {
		return bonificacion;
	}

	public double getMontoFinal() {
		return montoFinal;
	}

	
	
	
}
