package ar.edu.unlp.oo1.ejercicio12.impl;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {

	private String nombre;
	private List<Email> emails;

	public Carpeta() {
		this.emails = new ArrayList<Email>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nom) {
		nombre = nom;
	}

	protected void agregarCorreo(Email email) {
		emails.add(email);
	}

	protected void eliminarCorreo(Email email) {
		if (emails.contains(email)) {
			emails.remove(email);
		}
	}

	public void mover(Email email, Carpeta destino) {
		destino.agregarCorreo(email);
		this.eliminarCorreo(email);
	}

	public Email contieneTextoCarpeta(String cadena) {
		return emails.stream().filter(a -> a.contieneTextoEmail(cadena) == true).findFirst().orElse(null);
	}

	public Integer getTamanio() {
		return emails.stream().mapToInt(a -> a.tamanio()).sum();
	}
}
