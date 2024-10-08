package ar.edu.unlp.oo1.ejercicio12.impl;

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
		return carpetas.stream().map(c -> c.contieneTextoCarpeta(texto)).findFirst().orElse(null);
	}

	public Integer espacioOcupado() {
		return carpetas.stream().mapToInt(a -> a.getTamanio()).sum();
	}

}
