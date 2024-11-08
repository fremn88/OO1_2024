package ar.edu.unlp.oo1.ejercicio23.impl;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona {
	
	private List<Producto> productos;
	
	public Vendedor(String nombre, String direccion) {
		super(nombre, direccion);
		productos = new ArrayList<Producto>();
	}
	
	public void agregarProducto(Producto p) {
		productos.add(p);
	}
	
}
