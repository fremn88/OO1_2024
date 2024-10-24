package ar.edu.unlp.oo1.ejercicio15;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio15.impl.Consumo;
import ar.edu.unlp.oo1.ejercicio15.impl.Distribuidora;
import ar.edu.unlp.oo1.ejercicio15.impl.Factura;
import ar.edu.unlp.oo1.ejercicio15.impl.Usuario;

import java.time.LocalDate;
import java.util.List;

public class DistribuidoraTest {
	
	Distribuidora edelap;
	Usuario Damian;
	Usuario Bruno;
	Usuario Ariel;
	Consumo medicion1;
	Consumo medicion2;
	Consumo medicion3;
	Consumo medicion4;
	List<Factura> facturas;
	
	//debe testear c/metodo ??? como aplicamos particiones eq o cond de bordes en c/caso, es obligatorio hacerlo ???
	//la funcion que figuar en el beforEach se ejecuta antes de la ejecucion de c/test
	@BeforeEach
	void setUp() throws Exception {
		edelap = new Distribuidora(100);
		Damian = new Usuario("La Plata","Damian");
		Bruno = new Usuario("La Plata","Bruno");
		Ariel = new Usuario("La Plata","Ariel");
		medicion1 = new Consumo(LocalDate.of(2024,2,20),9,1);
		medicion2 = new Consumo(LocalDate.of(2024,3,20),8,2);
		medicion3 = new Consumo(LocalDate.of(2024,4,20),7,3);
		medicion4 = new Consumo(LocalDate.of(2024,5,20),4,6);
	}
	
	@Test
	//prueba que se "agrega un usuario"
	public void testAgregarUsuario() {
		edelap.agregarUsuario(Damian);
		assertTrue(edelap.getUsuarios().contains(Damian));
	}
	
	@Test
	//test emision de facturas
	public void testEmitirFactura() {
		Damian.agregarConsumo(medicion1);
		Damian.agregarConsumo(medicion2);
		Bruno.agregarConsumo(medicion3);
		Bruno.agregarConsumo(medicion2);
		edelap.agregarUsuario(Damian);
		edelap.agregarUsuario(Bruno);
		edelap.agregarUsuario(Ariel);
		//verifica creacion y numero de facturas creadas ?????????
		facturas = edelap.facturar();
		assertEquals(3, facturas.size());
		//verifica montoEnergia activa
		assertEquals(800, facturas.get(0).getMontoEnergiaActiva());
	}

	@Test
	//test consumo total de la red para ultimo periodo: meses 4 y 5. ????????????
	public void testConsumoTotalRed() {
		Damian.agregarConsumo(medicion1);
		Damian.agregarConsumo(medicion2);
		Bruno.agregarConsumo(medicion3);
		Bruno.agregarConsumo(medicion2);
		edelap.agregarUsuario(Damian);
		edelap.agregarUsuario(Bruno);
		edelap.agregarUsuario(Ariel);
		facturas = edelap.facturar();

	}
}
