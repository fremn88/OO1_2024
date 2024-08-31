package ar.edu.unlp.oo1.ejercicio4.impl;

public class Circulo implements FiguraBasal {
	
	private double diametro;
	
	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	
	public double getDiametro() {
		return this.diametro;
	}
	
	public double getRadio() {
		return this.diametro/2;
	}
	
	public double getPerimetro() {
		return this.diametro*Math.PI;
	}
	
	public double getArea() {
		return Math.PI*Math.pow(diametro/2, 2);
	}

}
