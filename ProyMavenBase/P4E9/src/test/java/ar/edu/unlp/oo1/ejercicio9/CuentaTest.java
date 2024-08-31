package ar.edu.unlp.oo1.ejercicio9;

import org.junit.jupiter.api.BeforeEach;

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
	
	// cajaAhorro2: verifica metodo puede extraer particion equivalente --> monto < saldo+2% y monto > saldo+2%  -- borde??
	@Test
	
	// cuentaCorriente1: idem caja ahorro
	@Test
	
	// cuentaCorriente2: verifica metodo puede extraer particion equivalente --> monto+descubierto < saldo+2% y monto+descubierto > saldo+2%  -- borde??
	@Test 
	
}
