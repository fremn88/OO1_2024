package ar.edu.unlp.oo1.ejercicio15.impl;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String domicilio;
	private String nombre;
	private List<Consumo> consumos;
	
	public Usuario(String domicilio, String nombre) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.consumos = new ArrayList<Consumo>();

	}
	
	public String getDomicilio() {
		return domicilio;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void agregarConsumo(Consumo medicion) {
		 consumos.add(medicion);
	}
	
	public Factura facturar(String nombre) {
		Factura factura = new Factura();
		Consumo ultimo = consumos.stream().max((c1, c2)->c1.getFecha().compareTo(c2.getFecha())).orElse(null);
		if(ultimo!=null) {
			factura = ultimo.emitirFactura(nombre);
		}
		return factura;
	}
	
}
