package ar.edu.unlp.oo1.ejercicio9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio9.impl.CajaDeAhorro;
import ar.edu.unlp.oo1.ejercicio9.impl.CuentaCorriente;

public class CuentaTest {
	
	CajaDeAhorro caja1;
	CuentaCorriente cuenta1;
	
	@BeforeEach
	void setUp() throws Exception {
		caja1 = new CajaDeAhorro();
		cuenta1 = new CuentaCorriente();
	}
	
	// cajaAhorro1: test de particion equivalente --> deposita montos saldos positivos y negativos -- borde??
	@Test
	void testDepositar() {
		caja1.depositar(100);
		caja1.depositar(-1000);
		assertTrue(caja1.getSaldo()>=0);
	}
	// cajaAhorro2: verifica metodo puede extraer particion equivalente --> monto < saldo+2% y monto > saldo+2%  -- borde??

	
	// cuentaCorriente1: idem caja ahorro

	
	// cuentaCorriente2: verifica metodo puede extraer particion equivalente --> monto+descubierto < saldo+2% y monto+descubierto > saldo+2%  -- borde??

	
}
