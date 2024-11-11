package ar.edu.unlp.oo1.ejercicio17.impl;

import java.time.LocalDate;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;

public class Reserva {

	private Propiedad propiedadReservada;
	private DateLapse periodoReserva;
	private Usuario user;
	
	public Reserva(Propiedad propiedadReservada, DateLapse periodoReserva, Usuario user) {
		super();
		this.propiedadReservada = propiedadReservada;
		this.periodoReserva = periodoReserva;
		this.user = user;
	}

	public double calcularPrecio() {
		return propiedadReservada.getPrecioNoche()*periodoReserva.sizeInDays();
	}

	public boolean estaReservada(Propiedad p, DateLapse l) {
		return propiedadReservada==p&&periodoReserva.overlaps(l);
	}
	
	public boolean reservaNoEstaEnCurso(LocalDate fecha) {
		return !this.periodoReserva.includesDate(fecha);
	}
	
	public Propiedad getPropiedadReservada() {
		return propiedadReservada;
	}

	public DateLapse getPeriodoReserva() {
		return periodoReserva;
	}

}
