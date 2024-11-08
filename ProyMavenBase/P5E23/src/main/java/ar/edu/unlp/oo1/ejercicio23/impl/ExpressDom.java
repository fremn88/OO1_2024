package ar.edu.unlp.oo1.ejercicio23.impl;

public class ExpressDom implements FormaEnvio {

	@Override
	public double costoEnvio(String dir1, String dir2) {
		CalculadoraDistancia dist = new CalculadoraDistancia();
		return dist.distanciaEntre(dir1, dir2);
	}

}
