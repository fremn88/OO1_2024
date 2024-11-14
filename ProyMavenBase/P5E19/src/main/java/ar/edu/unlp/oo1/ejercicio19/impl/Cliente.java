	package ar.edu.unlp.oo1.ejercicio19.impl;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.oo1.ejercicio14.impl.Lapse;

public abstract class Cliente {
	
	private String nombre;
	private String direccion;
	
	private List<Envio> envios;
	
	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.envios = new ArrayList<Envio>();
	}
	
	public double montoAPagarPeriodo(Lapse periodo) {
		return envios.stream().filter(e->e.estaIncluido(periodo)).mapToDouble(e->e.montoAPagar()).sum()*descuento();
	}
	
	public void agregarEnvio (Envio e) {
		envios.add(e);
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Envio> getEnvios() {
		return envios;
	}
	
	public abstract double descuento();
	
}
