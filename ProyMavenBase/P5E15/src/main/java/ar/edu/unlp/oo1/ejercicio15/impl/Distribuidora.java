package ar.edu.unlp.oo1.ejercicio15.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {
	
	private CuadroTarifario precioKW;
	
	private List<Usuario> usuarios;
		
	public Distribuidora(double p) {
		usuarios = new ArrayList<Usuario>();
		precioKW = new CuadroTarifario(p);
	}
	
	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public List<Factura> facturar() {
		List<Factura> facturacion = usuarios.stream().map(usuario -> usuario.emitirFactura(getPrecioKW())).collect(Collectors.toList());
		return facturacion;
	}

	public double getPrecioKW() {
		return precioKW.getPrecio();
	}

	public void setPrecioKW(double p) {
		precioKW.setPrecio(p);
	}
	
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
}
