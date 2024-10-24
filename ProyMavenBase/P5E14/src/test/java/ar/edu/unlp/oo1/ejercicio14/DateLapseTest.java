package ar.edu.unlp.oo1.ejercicio14;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;

public class DateLapseTest {
	
	DateLapse lapso;
	LocalDate antes, durante, despues, limiteInicio, limiteFinal;
	
	@BeforeEach
	void setUp() throws Exception {
		
		lapso = new DateLapse(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 1));
		antes = LocalDate.of(2023, 6, 1);
		durante = LocalDate.of(2024, 1, 15);
		despues = LocalDate.of(2024, 4, 1);
		limiteInicio = LocalDate.of(2024, 1, 1);
		limiteFinal = LocalDate.of(2024, 2, 1);
	}
	
	@Test
	// test particion: verifica fecha anterior, decha dentro del lapso, y fecha posterior. test bordes: fecha inicial y final del lapso (deberian estar incluidos..)
	public void includesDateTest() {
		//particion
		assertTrue(lapso.includesDate(durante));
		assertFalse(lapso.includesDate(antes));
		assertFalse(lapso.includesDate(despues));
		//bordes
		assertTrue(lapso.includesDate(limiteInicio));
		assertTrue(lapso.includesDate(limiteFinal));
	}
}
