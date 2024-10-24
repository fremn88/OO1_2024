package ar.edu.unlp.oo1.ejercicio15.impl;

import java.time.LocalDate;

public class Factura {
	
	private LocalDate fecha;
	private Usuario usuario;
	private double montoBruto;
	private double descuento;
	
	public Factura() {
		
	}
	
	public Factura(Usuario usuario, double monto, double descuento) {
		this.fecha = LocalDate.now();
		this.usuario = usuario;
		this.montoBruto = monto;
		this.descuento = descuento;
	}

	public double montoTotal() {
		return montoBruto*(1-descuento)/100;
	}

	public double getDescuento() {
		return descuento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	
	
}
