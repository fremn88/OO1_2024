package ar.edu.unlp.oo1.ejercicio8.impl;

import java.time.LocalDate;

public class Factura {
	
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	public Factura() {
		
	}
	
	public Factura(Usuario usuario, double energiaActiva, double descuento) {
		super();
		this.fecha = LocalDate.now();
		this.usuario = usuario;
		this.montoEnergiaActiva = energiaActiva;
		this.descuento = descuento;
	}

	public double montoTotal() {
		double monto = this.getMontoEnergiaActiva()*(1-this.getDescuento()/100);
		return monto;
	}

	public double getMontoEnergiaActiva() {
		return this.montoEnergiaActiva;
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
