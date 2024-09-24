package ar.edu.unlp.oo1.ejercicio9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio9.impl.CajaDeAhorro;
import ar.edu.unlp.oo1.ejercicio9.impl.CuentaCorriente;

@SuppressWarnings("unused")
public class CuentaTest {
	
	CajaDeAhorro caja1;
	CuentaCorriente cuenta1;
	
	@BeforeEach
	void setUp() throws Exception {
		caja1 = new CajaDeAhorro();
		cuenta1 = new CuentaCorriente();
	}
	
	// regla general: 1 test por c/metodo (excepto getters y setters). Testear borde y part equivalente (siempre que se pueda)
	
	// cajaAhorro1: test borde?? funcionamiento de depositar
	@Test
	void testDepositar() {
		caja1.depositar(100);
		cuenta1.depositar(200);
		assertEquals(caja1.getSaldo(),98);
		assertEquals(cuenta1.getSaldo(),200);
	}
	// cajaAhorro2: verifica metodo puede extraer particion equivalente --> monto < saldo+2% y monto > saldo+2%  -- borde??
	@Test
	void testPuedeExtraer() {
		caja1.depositar(100);
		cuenta1.depositar(100);
		cuenta1.setSaldoDescubierto(100);
		// Caja ahorro
		assertTrue(caja1.puedeExtraer(50)); // particion saldos menores
		assertTrue(caja1.puedeExtraer(96)); // borde
		assertFalse(caja1.puedeExtraer(100)); //borde
		assertFalse(caja1.puedeExtraer(200)); // particion saldos mayores
		// Cuenta corriente
		assertTrue(cuenta1.puedeExtraer(50)); // particion ext menor a saldo
		assertTrue(cuenta1.puedeExtraer(100)); // borde
		assertTrue(cuenta1.puedeExtraer(150)); // particion ext mmenor a saldo + desc
		assertTrue(cuenta1.puedeExtraer(200)); //borde
		assertFalse(cuenta1.puedeExtraer(250)); // particion ext mayor a saldo + desc
	}
	
	@Test
	void testTransferirACuenta() {
		caja1.depositar(100); // saldo=98
		cuenta1.depositar(100);
		cuenta1.setSaldoDescubierto(100);
		caja1.transferirACuenta(50, cuenta1); //saldo=98-51=47
		assertEquals(cuenta1.getSaldo(),150);
		assertEquals(caja1.getSaldo(),47);
		cuenta1.transferirACuenta(150, caja1); // borde
		assertEquals(cuenta1.getSaldo(),0);
		assertEquals(caja1.getSaldo(),194);
		cuenta1.transferirACuenta(50, caja1); // particion: descubierto
		assertEquals(cuenta1.getSaldo(),-50);
		assertEquals(caja1.getSaldo(),243);
	}

	
}
