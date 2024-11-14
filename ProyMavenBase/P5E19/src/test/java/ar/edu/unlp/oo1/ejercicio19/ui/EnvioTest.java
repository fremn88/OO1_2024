package ar.edu.unlp.oo1.ejercicio19.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;
import ar.edu.unlp.oo1.ejercicio19.impl.Envio;
import ar.edu.unlp.oo1.ejercicio19.impl.Internacional;
import ar.edu.unlp.oo1.ejercicio19.impl.Interurbano;
import ar.edu.unlp.oo1.ejercicio19.impl.Local;


public class EnvioTest {
	
	private Envio int1, int2, int3, int4, int5, int6, int7, internac1, internac2, internac3, internac4, loc1, loc2;
	DateLapse lapso;
	
	@BeforeEach
	void setUp() throws Exception {

		//interurbano: tiene como atributo unico la distancia para el calculo, restofijo-
		int1 = new Interurbano(100,LocalDate.of(2024, 1, 1),"Capital","La PLata",50);
		int2 = new Interurbano(100,LocalDate.of(2024, 1, 1),"Capital","ciudad2",100);
		int3 = new Interurbano(100,LocalDate.of(2024, 1, 1),"Capital","ciudad3",400);
		int4 = new Interurbano(100,LocalDate.of(2024, 1, 1),"Capital","ciudad3",500);
		int5 = new Interurbano(100,LocalDate.of(2024, 1, 1),"Capital","ciudad3",600);
		int6 = new Interurbano(100,LocalDate.of(2024, 1, 1),"Capital","ciudad3",99);
		int7 = new Interurbano(100,LocalDate.of(2024, 1, 1),"Capital","ciudad3",501);
		//internacional: depende del peso, resto fijo
		internac1 = new Internacional(100,LocalDate.of(2024, 1, 1),"Argentina","Uruguay");
		internac2 = new Internacional(1000,LocalDate.of(2024, 1, 1),"Argentina","Uruguay");
		internac3 = new Internacional(1050,LocalDate.of(2024, 1, 1),"Argentina","Uruguay");
		internac4 = new Internacional(1001,LocalDate.of(2024, 1, 1),"Argentina","Uruguay");
		//local: tiene como atributo unico envio rapido o no, resto fijo
		loc1 = new Local(100,LocalDate.of(2024, 1, 1),"Capital","ciudad3",true);
		loc1 = new Local(100,LocalDate.of(2024, 1, 1),"Capital","ciudad3",false);
	}
	
	@Test
	public void InterurbanoTest() {
		//particiones --> distancia <100, >=100y<=500, >500
		//Valores borde --> distancia 99, 100, 500, 501
		//precio*peso con peso=100
		
		assertEquals(2000,int1.montoAPagar()); //dist=50
		assertEquals(2500,int3.montoAPagar()); //dist=400
		assertEquals(3000,int5.montoAPagar()); //dist=600
		
		assertEquals(2500,int2.montoAPagar()); //dist=100
		assertEquals(2000,int6.montoAPagar()); //dist=99
		assertEquals(2500,int4.montoAPagar()); //dist=500
		assertEquals(3000,int7.montoAPagar()); //dist=501
		}
	@Test
	public void InternacionalTest() {
		//particiones: peso<=1000 / peso>1000
		//Valores borde 1000 y 1001
		
		assertEquals(1000,internac1.montoAPagar()); //peso 100
		assertEquals(12600,internac3.montoAPagar()); //peso 1050 
		
		assertEquals(10000,internac2.montoAPagar()); //peso 1000
		assertEquals(12012,internac4.montoAPagar()); //peso 1001
	}
	
	@Test
	public void LocalTest() {
		//particiones: rapido=true / rapido=false
	}
	
}
