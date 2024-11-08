package ar.edu.unlp.oo1.ejercicio25.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Medico {
	
	private String nombre;
	private LocalDate fechaIngreso;
	private double honorarios;
	
	public Medico(String nombre, LocalDate fechaIngreso, double honorarios) {
		super();
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.honorarios = honorarios;
	}
	
	public Integer antiguedad(LocalDate fecha) {
		return (int) ChronoUnit.YEARS.between(fechaIngreso, fecha);
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public double getHonorarios() {
		return honorarios;
	}
	
	
}
