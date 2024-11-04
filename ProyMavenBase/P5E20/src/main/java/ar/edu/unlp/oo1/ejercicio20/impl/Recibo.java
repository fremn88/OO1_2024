package ar.edu.unlp.oo1.ejercicio20.impl;

import java.time.LocalDate;

public class Recibo {

	private String nombre, apellido;
	private Integer CUIL;
	private double antiguedad, monto;
	private LocalDate fecha;
	
	public Recibo(String nombre, String apellido, Integer cUIL, double antiguedad, double monto) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		CUIL = cUIL;
		this.antiguedad = antiguedad;
		this.monto = monto;
		this.fecha = LocalDate.now();
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Integer getCUIL() {
		return CUIL;
	}

	public double getAntiguedad() {
		return antiguedad;
	}

	public double getMonto() {
		return monto;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	
	
}
