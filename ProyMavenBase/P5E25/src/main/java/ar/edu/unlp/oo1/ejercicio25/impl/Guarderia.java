package ar.edu.unlp.oo1.ejercicio25.impl;

public class Guarderia extends Servicio {
	
	private Integer cantDias;
	
	public Guarderia(Mascota mascota, Integer cantDias) {
		this.mascota = mascota;
		this.cantDias = cantDias;
	}
	
	@Override
	public double calcularCosto() {
		double cost = 500*cantDias;
		if(this.mascota.getServicios().size()>4) {
			cost = cost*0.9;
		}
		return cost;
	}


	public Integer getCantDias() {
		return cantDias;
	}
	
	

}
