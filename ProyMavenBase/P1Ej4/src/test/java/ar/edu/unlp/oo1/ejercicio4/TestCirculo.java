package ar.edu.unlp.oo1.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio4.impl.Circulo;

public class TestCirculo {

	private Circulo circulo;

	@BeforeEach
	public void setUp() {
		circulo = new Circulo();
		circulo.setDiametro(3*2);
	}

	@Test
	public void testDiametro() {
		assertEquals(6, circulo.getDiametro());
	}

	@Test
	public void testArea() {
		assertEquals(28.27, circulo.getArea(), 0.01);
	}

	@Test
	public void testPerimetro() {
		assertEquals(18.85, circulo.getPerimetro(), 0.01);
	}

	@Test
	public void testRadio() {
		assertEquals(3, circulo.getRadio());
	}
}