package ar.edu.unlp.oo1.ejercicio17.impl;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;

public class Propiedad {

	private String nombre;
	private String direccion;
	private double precioNoche;
	private PoliticaCancelacion politica;
	
	private List<Reserva> reservas;
	
	public Propiedad(String nombre, String direccion, double precioNoche, PoliticaCancelacion politica) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.precioNoche = precioNoche;
		this.politica = politica;
		reservas = new ArrayList<Reserva>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public double getPrecioNoche() {
		return precioNoche;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}
	
	public void addReserva(Reserva r) {
		reservas.add(r);
	}
	
	public void removerReserva(Reserva r) {
		reservas.remove(r);
	}
	
	public double ingresosReservas(DateLapse l) {
		return reservas.stream().filter(r->r.getPeriodoReserva().overlaps(l)).mapToDouble(r->r.calcularPrecio()).sum();
	}

	public void setPolitica(PoliticaCancelacion politica) {
		this.politica = politica;
	}
	
	public PoliticaCancelacion getPolitica() {
		return this.politica;
	}
	
	public double reembolso(Reserva r) {
		return politica.calcularReembolso(r);
	}
	
	public boolean estoyDisponible(DateLapse l) {
		return !reservas.stream().anyMatch(r->r.getPeriodoReserva().overlaps(l)==true);
	}
}
