package ar.edu.unlp.oo1.ejercicio17.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;
import ar.edu.unlp.oo1.ejercicio17.impl.Estricta;
import ar.edu.unlp.oo1.ejercicio17.impl.Flexible;
import ar.edu.unlp.oo1.ejercicio17.impl.Moderada;
import ar.edu.unlp.oo1.ejercicio17.impl.Plataforma;
import ar.edu.unlp.oo1.ejercicio17.impl.PoliticaCancelacion;
import ar.edu.unlp.oo1.ejercicio17.impl.Propiedad;
import ar.edu.unlp.oo1.ejercicio17.impl.Reserva;
import ar.edu.unlp.oo1.ejercicio17.impl.Usuario;

public class UsuariosTest {
	
	private Usuario u1;
	private Propiedad prop1;
	private DateLapse l1,l2;
	private PoliticaCancelacion pol1;
	private Reserva r1;
	
	//inciso c) se muestre como se reserva una propiedad para un periodo particular
	//particiones: realiza una reserva en un periodo disponible, y en periodo no disponible
	//inciso d) como se cancela una reserva creada
	//particiones: cancelar reserva existente y reserva inexistente
	
	@BeforeEach
	void setUp() throws Exception {
		u1 = new Usuario("Damian","calle1",33772704);
		pol1 = new Estricta();
		prop1 = new Propiedad("prop1", "calle1", 100, pol1);
		l1 = new DateLapse(LocalDate.of(2024, 2, 1),LocalDate.of(2024, 3, 1));
		//lapso l2 se superpone con l1
		l2 = new DateLapse(LocalDate.of(2024, 2, 10),LocalDate.of(2024, 3, 10));
	}
	
	@Test
	public void crearReservaTest() {
		u1.crearReserva(prop1, l1);
		//verifica propiedad no disponible en periodo reservado
		assertFalse(prop1.estoyDisponible(l1));
		//verifica que no se crea  una reserva en un periodo ya reservado
		assertNull(u1.crearReserva(prop1, l2));
	}
	
	public void cancelarReservaTest() {
		//crea una reserva, luego cancela y verifica disponibilidad
		r1 = u1.crearReserva(prop1, l1);
		assertFalse(prop1.estoyDisponible(l1));
		u1.cancelarReserva(r1);
		assertTrue(prop1.estoyDisponible(l1));
		
	}
}
