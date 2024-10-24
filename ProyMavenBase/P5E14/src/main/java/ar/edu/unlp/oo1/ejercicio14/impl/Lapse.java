package ar.edu.unlp.oo1.ejercicio14.impl;

import java.time.LocalDate;

public interface Lapse {
		
	public int sizeInDays();
	public boolean includesDate(LocalDate otra);
	public boolean overlaps(DateLapse lapso); //para ej17
	
}
