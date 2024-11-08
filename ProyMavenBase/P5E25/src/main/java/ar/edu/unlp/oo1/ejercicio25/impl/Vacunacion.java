package ar.edu.unlp.oo1.ejercicio25.impl;

import java.time.LocalDate;

public class Vacunacion extends Servicio {

	private Medico medico;
	private String vacuna;
	private double costo;
	
	public Vacunacion(Medico medico, Mascota mascota, String vacuna, double costo) {
		this.fechaServicio = LocalDate.now();
		this.medico = medico;
		this.mascota = mascota;
		this.vacuna = vacuna;
		this.costo = costo;
	}

	@Override
	public double calcularCosto() {
		double cost = medico.getHonorarios()+500+costo;
		if(esDomingo()) {
			costo += 200;
		}
		return cost;
	}


	public Medico getMedico() {
		return medico;
	}

	public String getVacuna() {
		return vacuna;
	}

	public double getCosto() {
		return costo;
	}

	
}
