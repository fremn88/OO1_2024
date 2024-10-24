package ar.edu.unlp.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio13.impl.Carpeta;
import ar.edu.unlp.oo1.ejercicio13.impl.ClienteCorreo;
import ar.edu.unlp.oo1.ejercicio13.impl.Email;

public class ClienteCorreoTest {

	ClienteCorreo cliente;
	Email correo, correo2;
	Carpeta favoritos;
	
	@BeforeEach
	void setUp() throws Exception {
		cliente = new ClienteCorreo();
		correo = new Email("titulo", "cuerpo");
		correo2 = new Email("abc", "abc");
	}
	
	
	
	// test metodo recibir: particion -> verifica que agrega un email mediante long coleccion inbox
	@Test
	public void recibirTest() {
		cliente.recibir(correo);
		assertEquals(1, cliente.getInbox().getEmails().size());
	}
	
	// test buscarTexto, particiones: texto que existe, texto que no, y string que es parte de un texto que existe. contempla inbox.
	@Test
	public void buscarTextoTest() {
		cliente.recibir(correo);
		assertEquals(correo, cliente.buscarTexto("titulo"));
		assertEquals(correo, cliente.buscarTexto("tit"));
		assertEquals(null, cliente.buscarTexto("papa"));
	}
	
	// test espacioOcupado, particiones -> para un correo: long titulo -> para varios correos: suma de las longitudes
	@Test
	public void espacioOcupadoTest() {
		cliente.recibir(correo);
		assertEquals(6, cliente.espacioOcupado());
		cliente.recibir(correo2);
		assertEquals(9, cliente.espacioOcupado());
	}
	
	// test mover, limite/particion?? : pasa de tener 0 correos en carpeta a tener 1.
	@Test
	public void moverTest() {
		favoritos = new Carpeta();
		cliente.agregarCarpeta(favoritos);
		cliente.recibir(correo);
		cliente.getInbox().mover(correo, favoritos);
		assertEquals(correo, favoritos.getEmails().get(0));
	}
	
}
