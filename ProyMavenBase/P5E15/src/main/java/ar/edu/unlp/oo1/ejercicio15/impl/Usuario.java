package ar.edu.unlp.oo1.ejercicio15.impl;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	@SuppressWarnings("unused")
	private String domicilio;
	@SuppressWarnings("unused")
	private String nombre;
	private List<Consumo> consumos;
	private List<Factura> facturas;
	
	public Usuario(String domicilio, String nombre) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.consumos = new ArrayList<Consumo>();
		this.facturas = new ArrayList<Factura>();
	}
	
	public void agregarConsumo(Consumo medicion) {
		 consumos.add(medicion);
	}
	
	// si no existe consumo para el usuario, emito factura vacia?? o cual es una mejor alternativa???
	public Factura emitirFactura(double precioKW) {
		Consumo c = ultimoConsumo();
		if(c!=null) {
			if(c.factorDePotencia()>0.8) {
				return new Factura(this, c.getConsumoEnergiaReactiva()*precioKW,10);
			} else {
				return new Factura(this, c.getConsumoEnergiaActiva()*precioKW,0);
			}
		} else return new Factura(this,0,0); 
	}
	
	// se puede usar metodo compareTo con objetos clase "LocalDate" porque lo implementan.
	private Consumo ultimoConsumo() {
		return consumos.stream().max((Consumo cons1, Consumo cons2) -> cons1.getFecha().compareTo(cons2.getFecha())).orElse(null);
	}
	
	public List<Factura> facturas() {
		return facturas;
	}
}
