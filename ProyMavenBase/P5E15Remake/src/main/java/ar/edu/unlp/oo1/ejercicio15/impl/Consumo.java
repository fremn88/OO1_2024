package ar.edu.unlp.oo1.ejercicio15.impl;

import java.time.LocalDate;

public class Consumo {
	
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	private CuadroTarifario cuadro;
	
	public Consumo(LocalDate fecha, double consumoEnergiaActiva, double consumoEnergiaReactiva) {
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

	public double getConsumoEnergiaReactiva() {
		return consumoEnergiaReactiva;
	}

	private double factorDePotencia() {
		return this.consumoEnergiaActiva /Math.sqrt(Math.pow(this.consumoEnergiaActiva, 2) + Math.pow(this.consumoEnergiaReactiva, 2));
	}
	
	private boolean estaBonificado() {
		return factorDePotencia()>0.8;
	}
	
	public Factura emitirFactura(String nombre) {
		double bonificacion = 0;
		double monto = consumoEnergiaActiva*cuadro.getPrecio();
		if(estaBonificado()) {
			bonificacion = monto*0.1; 
		}
		Factura factura = new Factura(nombre, bonificacion, monto-bonificacion);
		return factura;
	}
}
