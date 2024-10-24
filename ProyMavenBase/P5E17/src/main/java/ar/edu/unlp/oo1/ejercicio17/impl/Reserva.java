package ar.edu.unlp.oo1.ejercicio17.impl;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;

public class Reserva {

	private Propiedad propiedadReservada;
	private DateLapse periodoReserva;
	
	public Reserva(Propiedad propiedadReservada, DateLapse periodoReserva) {
		super();
		this.propiedadReservada = propiedadReservada;
		this.periodoReserva = periodoReserva;
	}

	public double calcularPrecio() {
		return propiedadReservada.getPrecioNoche()*periodoReserva.sizeInDays();
	}

	public Propiedad getPropiedadReservada() {
		return propiedadReservada;
	}

	public DateLapse getPeriodoReserva() {
		return periodoReserva;
	}
	
	public boolean estaReservada(Propiedad p, DateLapse l) {
		return propiedadReservada==p&&periodoReserva.overlaps(l);
	}
}
