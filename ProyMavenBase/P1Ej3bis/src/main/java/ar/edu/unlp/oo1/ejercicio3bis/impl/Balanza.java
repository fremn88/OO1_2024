package ar.edu.unlp.oo1.ejercicio3bis.impl;

import java.util.List;

public class Balanza {
	private Integer cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	
	private List<Producto> productos;
	
	public Balanza() {
		super();
		this.ponerEnCero();
	}
	
	public void ponerEnCero() {
		this.cantidadDeProductos=0;
		this.pesoTotal=0;
		this.precioTotal=0;
	}
	
	public void agregarProducto(Producto producto) {
		this.cantidadDeProductos++;
		this.pesoTotal+=producto.getPeso();
		this.precioTotal+=producto.getPrecio();
		this.productos.add(producto);
	}
	
	public Ticket emitirTicket() {
		return new Ticket(this.cantidadDeProductos,this.pesoTotal,this.precioTotal);
	}

	public Integer getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public void setCantidadDeProductos(Integer cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
}
