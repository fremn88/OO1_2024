package ar.edu.unlp.oo1.ejercicio13.impl;

import java.util.ArrayList;
import java.util.List;

public class ClienteCorreo {

	private Carpeta inbox;
	private List<Carpeta> carpetas;

	public ClienteCorreo() {
		inbox = new Carpeta();
		carpetas = new ArrayList<Carpeta>();
	}

	public void recibir(Email email) {
		inbox.agregarCorreo(email);
	}

	public Email buscarTexto(String texto) {
		Email email = inbox.contieneTextoCarpeta(texto);
		if (email==null) {
			return carpetas.stream().map(c -> c.contieneTextoCarpeta(texto)).findFirst().orElse(null);
		} else return email;
	}

	public Integer espacioOcupado() {
		return carpetas.stream().mapToInt(a -> a.getTamanio()).sum()+inbox.getTamanio();
	}

	public Carpeta getInbox() {
		return inbox;
	}
	
	public void agregarCarpeta(Carpeta c) {
		carpetas.add(c);
	}
}
