package ar.edu.unlp.info.oo1.distribuidora;

public class CuadroTarifario {

	private double preciokWh;

	public double calcularPrecioBase(Consumo consumo) {
		return consumo.getConsumoDeEnergiaActiva() * this.preciokWh;
	}

	public double porcentajeDescuento(Consumo consumo) {
		double valor = 0;
		if (consumo.factorDePotencia() > 0.8) {
			valor = 10;
		}
		return valor;
	}

	public double getPreciokWh() {
		return preciokWh;
	}

	public void setPreciokWh(double preciokWh) {
		this.preciokWh = preciokWh;
	}
}
