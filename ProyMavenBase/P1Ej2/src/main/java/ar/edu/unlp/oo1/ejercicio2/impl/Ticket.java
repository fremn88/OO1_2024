package ar.edu.unlp.oo1.ejercicio2.impl;

import java.time.LocalDate;

public class Ticket {

	private LocalDate fecha;
	private Integer cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;

	public Ticket(Integer cantidadProductos, double precioTotal, double pesoTotal) {
		this.fecha = LocalDate.now();
		this.cantidadDeProductos = cantidadProductos;
		this.precioTotal = precioTotal;
		this.pesoTotal = pesoTotal;
	}

	public double impuesto() {
		return this.precioTotal * 0.21;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Integer getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

}
