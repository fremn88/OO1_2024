package ar.edu.unlp.oo1.ejercicio25.impl;

import java.time.LocalDate;

public class Consulta extends Servicio {
	
	private Medico medico;
	
	public Consulta(Medico medico, Mascota mascota) {
		this.medico = medico;
		this.mascota = mascota;
		this.fechaServicio = LocalDate.now();
	}
	
	@Override
	public double calcularCosto() {
		double costo = medico.getHonorarios()+300+medico.antiguedad(fechaServicio);
		if(esDomingo()) {
			costo += 200;
		}
		return costo;
	}

	public Medico getMedico() {
		return medico;
	}

	

}
