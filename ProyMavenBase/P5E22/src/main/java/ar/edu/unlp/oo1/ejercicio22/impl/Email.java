package ar.edu.unlp.oo1.ejercicio22.impl;

import java.util.ArrayList;
import java.util.List;

public class Email {

	private String titulo;
	private String cuerpo;
	private List<Archivo> archivos;

	public Email(String titulo, String cuerpo) {
		super();
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.archivos = new ArrayList<Archivo>();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public List<Archivo> adjuntos() {
		return this.archivos;
	}

	public boolean contieneTextoEmail(String cadena) {
		return titulo.contains(cadena) || cuerpo.contains(cadena);
	}

	public Integer tamanio() {
		return this.titulo.length();
	}
	
	public String clasificacion() {
		Integer size = tamanio();
		if(size < 301) {
			return "Pequeño";
		} else if (size < 500) {
			return "Mediano";
		} else return "Grande";
	}
}
