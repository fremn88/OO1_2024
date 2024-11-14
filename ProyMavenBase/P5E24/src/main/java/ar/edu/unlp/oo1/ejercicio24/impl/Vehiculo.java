package ar.edu.unlp.oo1.ejercicio24.impl;

public class Vehiculo {

	private Conductor conductor;
	private String descripcion;
	private Integer capacidad, anio, valor, ocupacion;
	
	public Vehiculo(String descripcion, Integer capacidad, Integer anio, Integer valor, Conductor conductor) {
		super();
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.anio = anio;
		this.valor = valor;
		this.conductor = conductor;
		this.ocupacion = 1;
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

	public Integer getOcupacion() {
		return ocupacion;
	}

	public void disminuyeOcupacion(Integer cant) {
		ocupacion-=cant;
	}
	
	public void incrementarOcupacion() {
		ocupacion++;
	}
	
	public boolean tieneLugar() {
		if(ocupacion==capacidad) {
			return false;
		} else return true;
	}
}
