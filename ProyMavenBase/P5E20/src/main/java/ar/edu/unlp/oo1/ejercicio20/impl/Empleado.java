package ar.edu.unlp.oo1.ejercicio20.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	
	private String nombre, apellido;
	private LocalDate fechaNac;
	private boolean hijosTiene;
	private Integer CUIL;
	private List<Contrato> contratos;
	
	
	
	public Empleado(String nombre, String apellido, LocalDate fechaNac, boolean hijosTiene, Integer cUIL) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.hijosTiene = hijosTiene;
		CUIL = cUIL;
		contratos = new ArrayList<Contrato>();
	}

	public Recibo generarRecibo() {
		Recibo reciboMes = new Recibo(nombre,apellido, CUIL, antiguedad(), montoFinal());
		return reciboMes;
	}
	
	private double antiguedad() {
		double antiguedad = 0;
		if(!contratos.isEmpty()) {
			antiguedad = contratos.stream().mapToDouble(c->c.duracion()).sum();
		}
		return antiguedad;
	}
	
	private double montoFinal() {
		Contrato activo = vigente();
		double monto = 0;
		if(activo!=null) {
			monto = activo.remuneracion(hijosTiene);
			double ant = antiguedad();
			if(ant>=20) {
				monto*=2;
			} else if(ant>=15) {
				monto*=1.7;
			} else if(ant>=10) {
				monto*=1.5;
			} else if(ant>=5) {
				monto*=1.3;
			}
		}
		return monto;
	}
	
	private Contrato vigente() {
		return this.contratos.stream().filter(c->c.activo()).findFirst().orElseGet(null);
	}
	
	public void agregarContrato(Contrato c) {
		this.contratos.add(c);
	}
	
	//Getters y Setters
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public boolean isHijosTiene() {
		return hijosTiene;
	}

	public Integer getCUIL() {
		return CUIL;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}
	
}
