package ar.edu.unlp.oo1.ejercicio19.impl;

import java.time.LocalDate;

public class Interurbano extends Envio {
	
	private Integer distancia;
	
	public Interurbano(double peso, LocalDate despacho, String origen, String destino, Integer distancia) {
		super(peso, despacho, origen, destino);
		this.distancia = distancia;
	}

	@Override
	public double montoAPagar() {
		double precio;
		if(distancia>=100&&distancia<=500) {
			precio = 25;
		} else if(distancia>500){ 
			precio = 30;
		} else {
			precio = 20;
		}
		return precio*this.peso;
	}
	
	
}
