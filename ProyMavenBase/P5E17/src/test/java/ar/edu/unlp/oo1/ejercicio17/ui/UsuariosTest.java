package ar.edu.unlp.oo1.ejercicio17.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;
import ar.edu.unlp.oo1.ejercicio17.impl.Estricta;
import ar.edu.unlp.oo1.ejercicio17.impl.Flexible;
import ar.edu.unlp.oo1.ejercicio17.impl.Moderada;
import ar.edu.unlp.oo1.ejercicio17.impl.Plataforma;
import ar.edu.unlp.oo1.ejercicio17.impl.Propiedad;
import ar.edu.unlp.oo1.ejercicio17.impl.Reserva;
import ar.edu.unlp.oo1.ejercicio17.impl.Usuario;

public class UsuariosTest {

	private Plataforma OOBnB;
	private Usuario user1, user2;
	private Propiedad p1, p2, p3;
	private Reserva r1, r2, r3, r4;
	private DateLapse l1, l2;
	
	@BeforeEach
	void setUp() throws Exception {
		OOBnB = new Plataforma();
		user1 = new Usuario("user1", "calle 723", 33772704);
		user2 = new Usuario("user2", "calle 75", 23772703);
		p1 = new Propiedad("p1", "calle 88", 100, new Flexible("flexible"));
		p2 = new Propiedad("p2", "calle 88", 100, new Moderada("moderada"));
		p3 = new Propiedad("p3", "calle 88", 100, new Estricta("estricta"));
		user1.altaPropiedad(p1);
		user1.altaPropiedad(p2);
		user2.altaPropiedad(p3);
		OOBnB.agregarUsuario(user1);
		OOBnB.agregarUsuario(user2);
		l1 = new DateLapse(LocalDate.of(2024, 1, 1),LocalDate.of(2024, 2, 1));
		l2 = new DateLapse(LocalDate.of(2024, 3, 1),LocalDate.of(2024, 4, 1));
	}
	
	@Test
	//Se muestre cómo verificar la disponibilidad de una fecha para una propiedad que no tenga reservas en ese período.
	//Se muestre cómo verificar la disponibilidad de una fecha para una propiedaden la que haya reservas en ese período.
	//Se muestre cómo se reserva una propiedad para un período en particular
	public void disponibilidadTest() {
		//particiones: propiedad sin reserva
		assertTrue(OOBnB.propiedadDisponible(p1, l1));
		//particiones: propiedad con reserva
		r1 = user1.crearReserva(p1, l2);
		assertTrue(OOBnB.propiedadDisponible(p1, l1));
		assertFalse(OOBnB.propiedadDisponible(p1, l2));
		//reserva en un periodo - compara periodo de tiempo contra el periodo que esta en la reserva creada 
		assertEquals(l2,p1.getReservas().get(0).getPeriodoReserva());
		//cancelar reserva
		user1.cancelarReserva(r1);
		assertEquals(0,user1.getReservas().size());
	}
	
}
