package ar.edu.unlp.oo1.ejercicio23.impl;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.oo1.ejercicio21.impl.BagImplCorregido;

public class Cliente extends Persona {
	
	private List<Pedido> pedidos;

	public Cliente(String nombre, String direccion) {
		super(nombre, direccion);
		pedidos = new ArrayList<Pedido>();
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
	
}
