package ar.edu.unlp.oo1.ejercicio8;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio8.impl.Factura;
import ar.edu.unlp.oo1.ejercicio8.impl.Usuario;

public class FacturaTest {

	Factura factura;
	Usuario user;
	
	@BeforeEach
	public void setUp() {
		user = new Usuario("LA PLATA", "DAMI");
		factura = new Factura(user, 8, 10);
	}
	
	@Test
	public void testFactura() {
		assertEquals(user, factura.getUsuario());
		assertEquals(8, factura.getMontoEnergiaActiva());
		assertEquals(10, factura.getDescuento());
	}
}
