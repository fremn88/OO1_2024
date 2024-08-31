package ar.edu.unlp.oo1.ejercicio6.impl;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	
	@SuppressWarnings("unused")
	private boolean encendido;
	@SuppressWarnings("unused")
	private List<Farola> vecinas;
	
	public Farola() {
		this.encendido = false;
		this.vecinas = new ArrayList<Farola>();
	}
	
	public boolean isOn() {
		return this.encendido;
	}
	
	public void turnOn() {
		if(!this.isOn()) {
			this.encendido = true;
			for(Farola f: vecinas) {
				f.turnOn();
			}
		}
	}
	
	public void turnOff() {
		if(this.isOn()) {
			this.encendido = false;
			for(Farola f: vecinas) {
				f.turnOff();
			}
		}
	}
	
	public List<Farola> getNeighbors(){
		return this.vecinas;
	}
	
	public void pairWithNeighbor(Farola otraFarola) {
		if(!this.vecinas.contains(otraFarola)) {
			this.vecinas.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}
}

