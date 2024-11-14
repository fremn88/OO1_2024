package ar.edu.unlp.oo1.ejercicio24.impl;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
	
	protected String nombre;
	protected double saldo;
	protected List<Viaje> viajes;
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.saldo = 0;
		this.viajes = new ArrayList<Viaje>();
	}
	
	public abstract void cargarSaldo(double monto);
	public abstract void gastarSaldo(double monto, Vehiculo vehiculo);
}
