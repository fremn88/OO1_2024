package ar.edu.unlp.oo1.ejercicio25.impl;

import java.time.LocalDate;
import java.util.List;

public class Mascota {
	
	private String nombre, especie;
	private LocalDate fechaNac;
	private List<Servicio> servicios;
	
	public Consulta altaConsulta(Medico medico) {
		Consulta c = new Consulta(medico, this);
		servicios.add(c);
		return c;
	}
	
	public Vacunacion altaVacunacion(Medico medico, String vacuna, double costo) {
		Vacunacion v = new Vacunacion(medico,this,vacuna,costo);
		servicios.add(v);
		return v;
	}
	
	public Guarderia altaGuarderia(Integer cantDias) {
		Guarderia g = new Guarderia(this, cantDias);
		servicios.add(g);
		return g;
	}

	public double calcularRecaudacion(LocalDate fecha) {
		return servicios.stream().filter(s->s.fechaCoincide(fecha)).mapToDouble(s->s.calcularCosto()).sum();
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}
	
	
}
