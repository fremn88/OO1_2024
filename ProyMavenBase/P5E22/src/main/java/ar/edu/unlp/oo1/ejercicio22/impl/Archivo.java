package ar.edu.unlp.oo1.ejercicio22.impl;

public class Archivo {
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Archivo(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer tamanio() {
		return nombre.length();
	}
	
}
