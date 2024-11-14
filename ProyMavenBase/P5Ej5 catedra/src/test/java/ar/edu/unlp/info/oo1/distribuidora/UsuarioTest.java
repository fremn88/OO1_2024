package ar.edu.unlp.info.oo1.distribuidora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	
	private Usuario usuario;
	private Consumo consumoEnero;
	private Consumo consumoFebrero;
	private Consumo consumoMarzo;

	private Consumo consumoAbril;

	private Usuario usuarioSinDescuento;
	private Usuario usuarioSinConsumos;

	private CuadroTarifario cuadro; 

	@BeforeEach
	public void setup() {
		this.usuario= new Usuario("Towers", "La Plata");

		this.consumoEnero = new Consumo(LocalDate.of(2021, 1, 1) , 800, 100);
		this.consumoFebrero = new Consumo(LocalDate.of(2021, 2, 1) , 860, 30);
		this.consumoMarzo = new Consumo(LocalDate.of(2021, 3, 1) , 820, 10);
		this.consumoAbril = new Consumo(LocalDate.of(2021, 4, 1) , 200, 150);

		this.usuario.agregarMedicion(consumoFebrero);
		this.usuario.agregarMedicion(consumoMarzo);
		this.usuario.agregarMedicion(consumoEnero);

		this.usuarioSinDescuento = new Usuario("Turing", "Mendoza");
		this.usuarioSinDescuento.agregarMedicion(consumoAbril);

		this.usuarioSinConsumos = new Usuario("Pedro", "City Bell");

		cuadro = new CuadroTarifario();
		cuadro.setPreciokWh(10);
	}

	@Test
	public void testUsuario() {
		assertEquals("Towers", this.usuario.getNombre());
		assertEquals("La Plata", this.usuario.getDomicilio());
		assertNull(this.usuarioSinConsumos.ultimoConsumo());
		assertEquals(0d, this.usuarioSinConsumos.ultimoConsumoActiva());
	}

	@Test
	public void testUltimoConsumoActiva() {
		assertEquals(820, this.usuario.ultimoConsumoActiva());
		assertEquals(0, this.usuarioSinConsumos.ultimoConsumoActiva());
	}

	@Test
	public void testFacturarEnBaseAUsuarioConDescuento() {
		Factura result = this.usuario.facturar(cuadro);
		assertEquals(8200,result.getMontoEnergiaActiva());
		assertEquals(820, result.getDescuento());
		assertEquals(LocalDate.now(),result.getFecha());
	}

	@Test
	public void testFacturarEnBaseAUsuarioSinDescuento() {
		Factura result = this.usuarioSinDescuento.facturar(cuadro);
		assertEquals(2000,result.getMontoEnergiaActiva());
		assertEquals(0, result.getDescuento());
		assertEquals(LocalDate.now(),result.getFecha());
	}

	@Test
	public void testFacturarEnBaseAUsuarioSinConsumo() {
		Factura result = this.usuarioSinConsumos.facturar(cuadro);
		assertEquals(0,result.getMontoEnergiaActiva());
		assertEquals(0, result.getDescuento());
		assertEquals(LocalDate.now(),result.getFecha());
	}

	/**
	 * Testea el agregar medición verificando que sea el último insertado.
	 */
	@Test
	public void testAgregarMedicion() {
		Consumo ultimoConsumo = new Consumo(LocalDate.of(2021, 5, 8), 500, 5000);
		this.usuario.agregarMedicion(ultimoConsumo);
		assertEquals(ultimoConsumo, this.usuario.ultimoConsumo());
	}

}
