package ar.edu.unlp.oo1.ejercicio11.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo extends Inversion {
	
	private LocalDate fechaConstitucion;
	private double montoDepositado;
	private double porcentajeInteresDiario;
	
	public PlazoFijo(LocalDate fechaConstitucion, double montoDepositado, double porcentajeInteresDiario) {
		super();
		this.fechaConstitucion = fechaConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeInteresDiario = porcentajeInteresDiario;
	}

	public LocalDate getFechaConstitucion() {
		return fechaConstitucion;
	}

	public double getMontoDepositado() {
		return montoDepositado;
	}

	public double getPorcentajeInteresDiario() {
		return porcentajeInteresDiario;
	}

	@Override
	public double valor() {
		double dias = this.getFechaConstitucion().until(LocalDate.now(), ChronoUnit.DAYS);
		return this.getMontoDepositado()*(1+this.getPorcentajeInteresDiario()/100*dias);
	}
}
