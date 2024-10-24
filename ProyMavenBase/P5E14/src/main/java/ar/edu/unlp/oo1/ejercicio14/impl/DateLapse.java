package ar.edu.unlp.oo1.ejercicio14.impl;

import java.time.LocalDate;

public class DateLapse implements Lapse {
	
	private LocalDate from;
	private LocalDate to;
	

	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}

	public LocalDate getFrom() {
		//“Retorna la fecha de inicio del rango”
		return from;
	}
	
	public LocalDate getTo() {
		//“Retorna la fecha de fin del rango”
		return to;
	}
	
	public int sizeInDays() {
		//“retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
		return from.until(to).getDays();
	}
	
	public boolean includesDate(LocalDate other) {
		//	“recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario, incluyendo extremos”.
		return from.isBefore(other)&&to.isAfter(other)||from.isEqual(other)||to.isEqual(other);
	}

	//para ej17
	@Override
	public boolean overlaps(DateLapse lapso) {
		return (this.includesDate(lapso.getFrom())||this.includesDate(lapso.getTo()));
	}

	
}
