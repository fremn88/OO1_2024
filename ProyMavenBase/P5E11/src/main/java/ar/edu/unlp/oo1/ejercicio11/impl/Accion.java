package ar.edu.unlp.oo1.ejercicio11.impl;

public class Accion extends Inversion {

	private String nombre;
	private int cantidad;
	private int valorUnitario;
	
	public Accion(String nombre, int cantidad, int valorUnitario) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(int valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public double valor() {
		return this.getCantidad()*this.getValorUnitario();
	}
	
	
	
	
}
