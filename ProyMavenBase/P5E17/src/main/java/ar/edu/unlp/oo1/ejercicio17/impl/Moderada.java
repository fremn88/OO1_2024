package ar.edu.unlp.oo1.ejercicio17.impl;

import java.time.LocalDate;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;

public class Moderada implements PoliticaCancelacion {
	
	@Override
	public double montoReembolso(Reserva r) {
		// previo a entrar a este metodo ya se verifica la fecha actual contra la reserva.
		// moderada devuelve: 100% si es con >1semana anticipacion y 50% caso contrario
		DateLapse diasCancelacion = new DateLapse(LocalDate.now(), r.getPeriodoReserva().getFrom());
		double reembolso = r.calcularPrecio();
		if(diasCancelacion.sizeInDays()<7) {
			reembolso = reembolso*0.5;
		}
		return reembolso;
	}


}
