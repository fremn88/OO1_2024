package ar.edu.unlp.oo1.ejercicio8.impl;

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
		super();
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.consumos = new ArrayList<Consumo>();
		this.facturas = new ArrayList<Factura>();
	}
	
	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}
	
	public double ultimoConsumoActiva() {
		double cons = this.ultimoConsumo().getConsumoEnergiaActiva();
		return cons;
	}
	
	// si no existe consumo para el usuario, emito factura vacia?? o cual es una mejor alternativa???
	public Factura facturarEnBaseA(double precioKW) {
		Consumo c = this.ultimoConsumo();
		if(c!=null) {
			if(c.factorDePotencia()>0.8) {
				return new Factura(this, c.costoEnBaseA(precioKW),10);
			} else {
				return new Factura(this, c.costoEnBaseA(precioKW),0);
			}
		} else return new Factura(this,0,0); 
	}
	
	public List<Factura> facturas() {
		return this.facturas;
	}
	
	// se puede usar metodo compareTo con objetos clase "LocalDate" porque lo implementan.
	private Consumo ultimoConsumo() {
		Consumo c = this.consumos
								.stream()
								.max((Consumo cons1, Consumo cons2) -> cons1.getFecha().compareTo(cons2.getFecha())).orElse(null);
		return c;
	}
}
