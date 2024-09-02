package ar.edu.unlp.oo1.ejercicio2.impl;

public class Balanza {
	
	private Integer cantidadDeProductos;
	
	private double precioTotal;
	
	private double pesoTotal;
	
	public Balanza() {
		this.ponerEnCero();
	}
	
	public void ponerEnCero() {
		this.cantidadDeProductos = 0;
		this.pesoTotal = 0;
		this.precioTotal = 0;
	}
	
	public void agregarProducto(Producto producto) {
		this.cantidadDeProductos++;
		this.pesoTotal+=producto.getPeso();
		this.precioTotal+=producto.getPrecio();
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

	public Ticket emitirTicket() {	
		return new Ticket(this.getCantidadDeProductos(),this.getPrecioTotal(),this.pesoTotal);
	}
}
