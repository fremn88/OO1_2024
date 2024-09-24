package ar.edu.unlp.oo1.ejercicio11.impl;

import java.util.ArrayList;
import java.util.List;

public class Inversor {

	private List<Inversion> inversiones;

	public Inversor() {
		this.inversiones = new ArrayList<Inversion>();
	}

	public List<Inversion> getInversiones() {
		return inversiones;
	}

	public double valorActual() {
		double valor;
		valor = this.getInversiones().stream().mapToDouble(i -> i.valor()).sum();
		return valor;
	}
}
