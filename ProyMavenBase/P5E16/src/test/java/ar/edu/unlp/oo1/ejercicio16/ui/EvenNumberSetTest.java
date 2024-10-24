package ar.edu.unlp.oo1.ejercicio16.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio16.impl.EvenNumberSet;

public class EvenNumberSetTest {

	EvenNumberSet<Integer> pruebas;
	
	@BeforeEach
	void setUp() throws Exception {
		pruebas = new EvenNumberSet<Integer>();
	}
	
	@Test
	//particion eq. test agregado valor repetido
	
	public void addTest() {
		assertTrue(pruebas.add(4));
		assertTrue(pruebas.add(2));
		assertFalse(pruebas.add(4));
	}
	
	@Test
	//particion eq. test agregado valor impar
	public void addImparTest() {
		assertFalse(pruebas.add(3));		
	}
}
