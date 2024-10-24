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
	
	private List<Reserva> reservas;
	private List<Propiedad> propiedades;//propiedades de las cuales el usuario es dueño
	
	public Usuario(String nombre, String direccion, Integer DNI) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.DNI = DNI;
		reservas = new ArrayList<Reserva>();
		propiedades = new ArrayList<Propiedad>();
	}
	
	//???como evalua desde un usario si la propiedad esta disponible??Hay propiedades de distintos usuarios.
	public boolean propiedadEstaDisponible(Propiedad p, DateLapse l) {
		boolean dispo = propiedades.contains(p);
		if(dispo) {
			dispo = p.estoyDisponible(l);
		}
		return dispo;
	}
	
	
	public Reserva crearReserva(Propiedad p, DateLapse l) {
		if(propiedadEstaDisponible(p,l)) {
			Reserva r = new Reserva(p,l);
			reservas.add(r);
			p.addReserva(r);
			return r;
		} else return null;
	}
	
	public void cancelarReserva(Reserva r) {
		if(!r.getPeriodoReserva().includesDate(LocalDate.now())) {
			Propiedad prop = r.getPropiedadReservada();
			prop.removerReserva(r);
			reservas.remove(r);
		}
	}
	
	public double precioReserva(Reserva r) {
		return r.calcularPrecio();
	}
	
	public double calcularIngresosPropietario(DateLapse l) {
		return propiedades.stream().mapToDouble(p->p.ingresosReservas(l)).sum()*0.75;
	}
	
	//Ej 18
	public void politicaCancelarReserva(Reserva r) {
		if(!r.getPeriodoReserva().includesDate(LocalDate.now())) {
			Propiedad prop = r.getPropiedadReservada();
			prop.removerReserva(r);
			reservas.remove(r);
		}
	}
	
	public void altaPropiedad(Propiedad p) {
		this.propiedades.add(p);
	}

	public List<Reserva> getReservas() {
		return reservas;
	}
	
}
