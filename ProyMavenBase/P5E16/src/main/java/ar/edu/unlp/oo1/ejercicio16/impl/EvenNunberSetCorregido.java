package ar.edu.unlp.oo1.ejercicio16.impl;

import java.util.HashSet;

@SuppressWarnings("hiding")
public class EvenNunberSetCorregido<Integer> extends HashSet<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean add(Integer n){
		if ((int)n%2==0){
			return super.add(n);
		}
		return false;
	}
	
	/*
	 * La solucion anterior esta mal aplicada en el sentido de que existe un "pasamanos", es decir se deben implementar los metodos de la int Set
	 * La implementacion no aporta nada, solo llama a los metodos de la clase treeSet que ya los implementa. Esto es trabajar con composicion.
	 * Para evitar esto, se debe trabajar con Herencia.
	 */
}
