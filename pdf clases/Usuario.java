package ar.edu.unlp.info.oo1.distribuidora;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String domicilio;
	private List<Consumo> consumos;

	public Usuario(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.consumos = new ArrayList<Consumo>();
	}

	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	/**
	 * Obtiene el consumo de energía activa desde el consumo con fecha más reciente.
	 * @return Consumo de energia activa si existe.  Sino 0.
	 */
	public double ultimoConsumoActiva() {
		Consumo consumo = this.ultimoConsumo();
		if (consumo == null) {
			return  0d;
		}
		return consumo.getConsumoDeEnergiaActiva();
	}

	/**
	 * Retorna el último consumo o null en caso que no exista
	 * @return
	 */
	public Consumo ultimoConsumo() {
		return this.consumos
			.stream()
			.max((Consumo c1, Consumo c2) -> c1.getFecha().compareTo(c2.getFecha()))
			.orElse(null);
	}

	/**
	 * Si hay consumos, retorna lo correspondiente al consumo realizado.
	 * Factura 0 si no hay consumos.
	 * @return
	 */
	public Factura facturar(CuadroTarifario cuadroTarifario) {
		Consumo ultimo = this.ultimoConsumo();
		Factura factura;
		if (ultimo == null) {
			factura = new Factura(0, 0, this);
		}
		else {
			double precio = cuadroTarifario.calcularPrecioBase(ultimo);
			double porcentajeDescuento = cuadroTarifario.porcentajeDescuento(ultimo);
			factura = new Factura(precio, precio * porcentajeDescuento / 100.0, this);
		}
		return factura;
	}
}
