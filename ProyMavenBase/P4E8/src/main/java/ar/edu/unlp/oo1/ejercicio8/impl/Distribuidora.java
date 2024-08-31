package ar.edu.unlp.oo1.ejercicio8.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {
	
	private double precioKW;
	
	private List<Usuario> usuarios;
	
	public Distribuidora() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public Distribuidora(double precioKW) {
		this.usuarios = new ArrayList<Usuario>();
		this.precioKW = precioKW;
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public List<Factura> facturar() {
		List<Factura> facturacion = this.usuarios.stream().map(usuario -> usuario.facturarEnBaseA(this.getPrecioKW())).collect(Collectors.toList());
		return facturacion;
	}
	
	public double consumoTotalActiva() {
		double consumoActiva = 0;
		
		return consumoActiva;
	}

	public double getPrecioKW() {
		return precioKW;
	}

	public void setPrecioKW(double precioKW) {
		this.precioKW = precioKW;
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
}
