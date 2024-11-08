package ar.edu.unlp.oo1.ejercicio23.impl;

public class Producto {

	private String nombre;
	private double precio;
	private Integer stock;
	private Categoria categoria;
	private Vendedor ven;
	
	public Producto(String nombre, double precio, Integer stock, Categoria categoria, Vendedor ven) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
		this.ven = ven;
	}
	
	public boolean hayStock(Integer pedido) {
		return stock>=pedido;
	}
	
	public void bajarStock(Integer cant) {
		stock-=cant;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public Integer getStock() {
		return stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Vendedor getVen() {
		return ven;
	}
	
	
	
}
