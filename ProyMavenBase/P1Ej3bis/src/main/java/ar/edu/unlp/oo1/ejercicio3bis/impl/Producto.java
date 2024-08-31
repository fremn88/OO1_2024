package ar.edu.unlp.oo1.ejercicio3bis.impl;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public double getPrecioPorKilo() {
		return precioPorKilo;
	}
	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPrecio() {
		return this.peso*this.precioPorKilo;
	}
	public double getPeso() {
		return this.peso;
	}
}
