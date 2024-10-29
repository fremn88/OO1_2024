package ar.edu.unlp.oo1.ejercicio19.impl;

import java.time.LocalDate;

import ar.edu.unlp.oo1.ejercicio14.impl.Lapse;

public abstract class Envio {
	
	protected double peso;
	protected LocalDate despacho;
	protected String origen;
	protected String destino;

	public double getPeso() {
		return peso;
	}

	public LocalDate getDespacho() {
		return despacho;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public Envio(double peso, LocalDate despacho, String origen, String destino) {
		this.peso = peso;
		this.despacho = despacho;
		this.origen = origen;
		this.destino = destino;
	}

	public abstract double montoAPagar();
	
	public boolean estaIncluido(Lapse ventanaDespacho) {
		return ventanaDespacho.includesDate(despacho);
	}
	
}
