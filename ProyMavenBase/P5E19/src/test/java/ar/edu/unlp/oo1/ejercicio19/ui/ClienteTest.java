package ar.edu.unlp.oo1.ejercicio19.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;
import ar.edu.unlp.oo1.ejercicio19.impl.Cliente;
import ar.edu.unlp.oo1.ejercicio19.impl.Envio;
import ar.edu.unlp.oo1.ejercicio19.impl.Internacional;
import ar.edu.unlp.oo1.ejercicio19.impl.Interurbano;
import ar.edu.unlp.oo1.ejercicio19.impl.PersonaFisica;
import ar.edu.unlp.oo1.ejercicio19.impl.PersonaJuridica;

public class ClienteTest {

	private Cliente c1, c2;
	private Envio int1, int2, int3, int4, int5, locEstandar, locRapido, internac1, internac2, internac3;
	DateLapse lapso;
	
	@BeforeEach
	void setUp() throws Exception {
		c1 = new PersonaFisica("c1","calle1", 33999888);
		c2 = new PersonaJuridica("c2","calle2", 330001112);
		int1 = new Interurbano(100,LocalDate.of(2024, 1, 1),"Capital","La PLata",50);
		int2 = new Interurbano(100,LocalDate.of(2024, 1, 1),"Capital","ciudad2",100);
		int3 = new Interurbano(100,LocalDate.of(2024, 1, 1),"Capital","ciudad3",400);
		int4 = new Interurbano(100,LocalDate.of(2024, 1, 1),"Capital","ciudad3",500);
		int5 = new Interurbano(100,LocalDate.of(2024, 1, 1),"Capital","ciudad3",600);
		internac1 = new Internacional(100,LocalDate.of(2024, 1, 1),"Argentina","Uruguay");
		internac2 = new Internacional(1000,LocalDate.of(2024, 1, 1),"Argentina","Uruguay");
		internac3 = new Internacional(1050,LocalDate.of(2024, 1, 1),"Argentina","Uruguay");
		lapso = new DateLapse(LocalDate.of(2023, 12, 1),LocalDate.of(2024, 1, 31));
	}
	
	@Test
	public void InterurbanoTest() {
		//particiones: por distancia. Valores borde: 100 500.
		assertEquals(2000,int1.montoAPagar());
		assertEquals(2500,int2.montoAPagar());
		assertEquals(2500,int3.montoAPagar());
		assertEquals(2500,int4.montoAPagar());
		assertEquals(3000,int5.montoAPagar());
	}
	
	public void InternacionalTest() {
		//particiones <1000 y >1000. limite: 1000
		assertEquals(1000,internac1.montoAPagar());
		assertEquals(10000,internac2.montoAPagar());
		assertEquals(12600,internac3.montoAPagar());
	}
	
	public void PersonasTest() {
		c1.agregarEnvio(int1);
		c1.agregarEnvio(int2);
		c2.agregarEnvio(int1);
		c2.agregarEnvio(int2);
		//monto a pagar por personaFisica
		assertEquals(4050,c1.montoAPagarPeriodo(lapso));
		//monto a pagar por personaJuridica
		assertEquals(4500,c2.montoAPagarPeriodo(lapso));
		
	}
	
}
