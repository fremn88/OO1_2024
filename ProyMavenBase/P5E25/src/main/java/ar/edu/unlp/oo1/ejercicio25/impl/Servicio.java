package ar.edu.unlp.oo1.ejercicio25.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class Servicio {

	protected LocalDate fechaServicio;
	protected Mascota mascota;
	public abstract double calcularCosto();
	// debe coincidir fecha inicio servicio o con el lapso de la guarderia??
	public boolean fechaCoincide(LocalDate fecha) {
		return fecha.equals(fechaServicio);
	}
	public LocalDate getFechaServicio() {
		return fechaServicio;
	}
	public Mascota getMascota() {
		return mascota;
	}
	
	public boolean esDomingo() {
		return (this.fechaServicio.getDayOfWeek() == DayOfWeek.SUNDAY);
	}
}

