package ar.edu.unlp.oo1.ejercicio8.impl;

import java.time.LocalDate;

public class Consumo {
	
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(LocalDate fecha, double consumoEnergiaActiva, double consumoEnergiaReactiva) {
		super();
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
		this.fecha = fecha;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}

	public double getConsumoEnergiaActiva() {
		return consumoEnergiaActiva;
	}

	public void setConsumoEnergiaActiva(double consumoEnergiaActiva) {
		this.consumoEnergiaActiva = consumoEnergiaActiva;
	}

	public double getConsumoEnergiaReactiva() {
		return consumoEnergiaReactiva;
	}

	public void setConsumoEnergiaReactiva(double consumoEnergiaReactiva) {
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}

	public double costoEnBaseA(double precioKW) {
		return this.getConsumoEnergiaActiva()*precioKW;
	}
	
	public double factorDePotencia() {
		return this.getConsumoEnergiaActiva() /Math.sqrt(Math.pow(this.getConsumoEnergiaActiva(), 2) + Math.pow(this.getConsumoEnergiaReactiva(), 2));
	}
}
