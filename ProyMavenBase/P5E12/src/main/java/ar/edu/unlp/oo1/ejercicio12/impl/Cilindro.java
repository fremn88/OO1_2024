package ar.edu.unlp.oo1.ejercicio12.impl;

public class Cilindro extends Pieza {

	private Integer radio;
	private Integer altura;
	
	public Cilindro(String material, String color, Integer radio, Integer altura) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}

	@Override
	public double getVolumen() {
		return Math.PI*Math.pow(radio, 2)*altura;
	}

	public double getSuperficie() {
		return 2*Math.PI*radio*(altura+radio);
	}
}
