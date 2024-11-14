package ar.edu.unlp.oo1.ejercicio23.impl;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.oo1.ejercicio21.impl.BagImplCorregido;

public class Usuario {
	
	private String nombre, direccion;
	private List<Producto> productos;
	private List<Pedido> pedidos;
	
	public Usuario(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		productos = new ArrayList<Producto>();
		pedidos = new ArrayList<Pedido>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public BagImplCorregido<Categoria> pedidosCategoria() {
		BagImplCorregido<Categoria> listado = new BagImplCorregido<Categoria>();
		pedidos.stream().forEach(p->listado.add(p.getProducto().getCategoria()));
		return listado;
	}
	
	public void crearPedido(Producto producto, Integer cantidad, FormaPago pago, FormaEnvio envio) {
		if(producto.hayStock(cantidad)) {
			pedidos.add(new Pedido(producto, envio, pago, cantidad, this));
			producto.bajarStock(cantidad);
		}
	}
	
	public void agregarProducto(Producto p) {
		productos.add(p);
	}
	
}
