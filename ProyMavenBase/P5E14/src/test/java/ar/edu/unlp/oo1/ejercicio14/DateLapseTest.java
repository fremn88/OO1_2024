package ar.edu.unlp.oo1.ejercicio14;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;

public class DateLapseTest {
	
	DateLapse lapso, casoBase, caso1, caso2, caso3, caso4, caso5, caso6, caso7;
	LocalDate antes, durante, despues, limiteInicio, limiteFinal;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Includes
		lapso = new DateLapse(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 1));
		antes = LocalDate.of(2023, 6, 1);
		durante = LocalDate.of(2024, 1, 15);
		despues = LocalDate.of(2024, 4, 1);
		limiteInicio = LocalDate.of(2024, 1, 1);
		limiteFinal = LocalDate.of(2024, 2, 1);
		//overlaps
		casoBase= new DateLapse(LocalDate.of(2024,10,10),LocalDate.of(2024,10,20));

		//Todos estos se superponen
		caso1= new DateLapse(LocalDate.of(2024,10,5),LocalDate.of(2024,10,11)); // superpuesto por adelante
		caso2= new DateLapse(LocalDate.of(2024,10,19),LocalDate.of(2024,10,22)); // superpuesto por atras
		caso3= new DateLapse(LocalDate.of(2024,10,11),LocalDate.of(2024,10,19)); // superpuesto por contenido por dentro
		caso4= new DateLapse(LocalDate.of(2024,10,9),LocalDate.of(2024,10,21)); // superpuesto por contenido por fuera
		caso5= new DateLapse(LocalDate.of(2024,10,10),LocalDate.of(2024,10,20)); // superpuesto mismo periodo

		//Estos no
		caso6= new DateLapse(LocalDate.of(2024,10,5),LocalDate.of(2024,10,9)); // no se superpone por adelante
		caso7= new DateLapse(LocalDate.of(2024,10,21),LocalDate.of(2024,10,25)); // no se superpone por atrás
		
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
	
	public void overlapsTest() {
		assertTrue(casoBase.overlaps(caso1));
		assertTrue(casoBase.overlaps(caso2));
		assertTrue(casoBase.overlaps(caso3));
		assertTrue(casoBase.overlaps(caso4));
		assertTrue(casoBase.overlaps(caso5));
		assertFalse(casoBase.overlaps(caso6));
		assertFalse(casoBase.overlaps(caso7));
	}
	
}
