package ar.edu.unlp.oo1.ejercicio24.impl;

public class Vehiculo {

	private Conductor conductor;
	private String descripcion;
	private Integer capacidad, anio, valor;
	
	public Vehiculo(String descripcion, Integer capacidad, Integer anio, Integer valor, Conductor conductor) {
		super();
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.anio = anio;
		this.valor = valor;
		this.conductor = conductor;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public Integer getAnio() {
		return anio;
	}

	public Integer getValor() {
		return valor;
	}

	public boolean disminuirCapacidad() {
		if(capacidad == 0) {
			return false;
		} else {
			capacidad -= 1;
			return true;
		}
	}
	
	public void incrementarCapacidad(Integer cant) {
		capacidad += cant;
	}
}
