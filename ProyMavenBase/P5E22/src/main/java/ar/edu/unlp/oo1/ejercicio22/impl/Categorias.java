package ar.edu.unlp.oo1.ejercicio22.impl;

import ar.edu.unlp.oo1.ejercicio21.impl.BagImplCorregido;

@SuppressWarnings("hiding")
public class Categorias<String> extends BagImplCorregido<String>{

	public boolean add(String element) {
		if(element.equals("Grande")||element.equals("Mediano")||element.equals("Pequeño")) {
			super.add(element);
			return true;
		} else return false;
	}
	
}
