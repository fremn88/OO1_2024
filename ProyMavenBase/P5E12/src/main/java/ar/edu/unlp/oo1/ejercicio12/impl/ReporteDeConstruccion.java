package ar.edu.unlp.oo1.ejercicio12.impl;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {

	private List<Pieza> piezas;

	public ReporteDeConstruccion() {
		piezas = new ArrayList<Pieza>();
	}

	public double getVolumenDeMaterial() {
		return piezas.stream().mapToDouble(a -> a.getVolumen()).sum();
	}

	
}
