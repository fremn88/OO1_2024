package ar.edu.unlp.oo1.ejercicio17.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;

public class Usuario {
	
	@SuppressWarnings("unused")
	private String nombre;
	@SuppressWarnings("unused")
	private String direccion;
	@SuppressWarnings("unused")
	private Integer DNI;
	
	private List<Propiedad> propiedades;//propiedades de las cuales el usuario es dueño
	
	public Usuario(String nombre, String direccion, Integer DNI) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.DNI = DNI;
		propiedades = new ArrayList<Propiedad>();
	}
	
	public void cancelarReserva(Reserva r) {
		if(r.reservaNoEstaEnCurso(LocalDate.now())) {
			r.getPropiedadReservada().removerReserva(r);;
		}
	}	
	
	public double precioReserva(Reserva r) {
		return r.calcularPrecio();
	}
	
	public Reserva crearReserva(Propiedad p, DateLapse l) {
		if(p.estoyDisponible(l)) {
			Reserva r = new Reserva(p,l,this);
			p.addReserva(r);
			return r;
		} else return null;
	}

	public void altaPropiedad(Propiedad p) {
		this.propiedades.add(p);
	}
	
	public double calcularIngresosPropietario(DateLapse l) {
		return propiedades.stream().mapToDouble(p->p.ingresosReservas(l)).sum()*0.75;
	}
	
	//Ej 18
	public void politicaCancelarReserva(Reserva r) {
		if(!r.getPeriodoReserva().includesDate(LocalDate.now())) {
			Propiedad prop = r.getPropiedadReservada();
			prop.removerReserva(r);

		}
	}

}
