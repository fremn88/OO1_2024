package ar.edu.unlp.oo1.ejercicio22.impl;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.oo1.ejercicio21.impl.BagImplCorregido;

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

	private void eliminarCorreo(Email email) {
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
	
	public List<Email> getEmails() {
		return emails;
	}
	
	public Integer cantEmails() {
		return this.emails.size();
	}
	
	public void cantEmailsCategorias(BagImplCorregido<String> categorias) {
		emails.stream().forEach(e->categorias.add(e.clasificacion()));
	}
	
	//Nota_ se usa "ForEach" porque es una operacion terminal que consume un Stream. Usar map seria incorrecto por no ser terminal y no asegurar correcto funcionamiento
}
