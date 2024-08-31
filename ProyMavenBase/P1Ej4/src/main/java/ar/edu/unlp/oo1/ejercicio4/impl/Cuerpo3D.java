package ar.edu.unlp.oo1.ejercicio4.impl;

public class Cuerpo3D {
	
	private double altura;
	
	private FiguraBasal caraBasal;

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setCaraBasal(FiguraBasal cara) {
		this.caraBasal = cara;
	}
	
	public double getVolumen() {
		return this.caraBasal.getArea()*this.altura;
	}
	
	public double getSuperficieExterior() {
		return this.caraBasal.getPerimetro()*this.altura+2*this.caraBasal.getArea();
	}
}
