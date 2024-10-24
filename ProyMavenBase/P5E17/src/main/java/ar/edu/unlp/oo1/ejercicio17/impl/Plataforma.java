package ar.edu.unlp.oo1.ejercicio17.impl;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;

public class Plataforma {

	private List<Usuario> usuarios;

	public Plataforma() {
		usuarios = new ArrayList<Usuario>();
	}
	
	public void agregarUsuario(Usuario user) {
		usuarios.add(user);
	}
	
	public boolean propiedadDisponible(Propiedad p, DateLapse l) {
		return usuarios.stream().anyMatch(u->u.propiedadEstaDisponible(p, l)==true);
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
}

