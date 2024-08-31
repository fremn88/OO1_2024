package ar.edu.unlp.oo1.ejercicio4.impl;

public class Cuadrado implements FiguraBasal {
	private double lado;

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getPerimetro() {
		return lado*4;
	}
	
	public double getArea() {
		return Math.pow(lado, 2);
	}
}
