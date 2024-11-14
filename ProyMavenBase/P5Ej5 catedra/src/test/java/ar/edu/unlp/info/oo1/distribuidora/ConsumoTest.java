package ar.edu.unlp.info.oo1.distribuidora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsumoTest {

	private Consumo consumo;

	@BeforeEach
	public void setUp() {
		this.consumo = new Consumo(LocalDate.of(2020, 8, 20), 200, 300);
	}

	@Test
	public void testConsumo() {
		assertEquals(LocalDate.of(2020, 8, 20), this.consumo.getFecha());
		assertEquals(200, this.consumo.getConsumoDeEnergiaActiva());
		assertEquals(300, this.consumo.getConsumoDeEnergiaReactiva());
	}

	@Test
	public void testFactorDePotencia() {
		// 200 / sqrt(200^2 + 300^2)
		assertEquals(0.55, this.consumo.factorDePotencia(), 0.01);
	}

	@Test
	public void testCostoEnBase() {
		CuadroTarifario cuadro = new CuadroTarifario();
		cuadro.setPreciokWh(25);
		// 200 * 25
		assertEquals(5000, this.consumo.costoEnBase(cuadro));
	}
}
