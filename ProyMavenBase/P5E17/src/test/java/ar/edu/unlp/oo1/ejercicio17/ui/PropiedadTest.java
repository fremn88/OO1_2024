package ar.edu.unlp.oo1.ejercicio17.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio14.impl.DateLapse;
import ar.edu.unlp.oo1.ejercicio17.impl.Estricta;
import ar.edu.unlp.oo1.ejercicio17.impl.PoliticaCancelacion;
import ar.edu.unlp.oo1.ejercicio17.impl.Propiedad;
import ar.edu.unlp.oo1.ejercicio17.impl.Reserva;
import ar.edu.unlp.oo1.ejercicio17.impl.Usuario;

public class PropiedadTest {

	private Propiedad p1;
	private DateLapse l1,l2,l3,l4,l5,l6;
	private Reserva r1,r2,r3,r4,r5;
	private PoliticaCancelacion estricta;
	private Usuario u1;
	
	@BeforeEach
	void setup() throws Exception {
		l1 = new DateLapse(LocalDate.of(2024, 2, 1),LocalDate.of(2024, 3, 1));
		
		//propiedad que no tiene reservas en periodo l1
		estricta = new Estricta();
		p1 = new Propiedad("p1","calle1",100,estricta);
		
		//propiedad que si tiene reserva en periodo l1
		u1 = new Usuario("Damian","calle1",33772704);
		
		//con colision:
		//particion lapso solapa ambas fechas
		l2 = new DateLapse(LocalDate.of(2024, 2, 5),LocalDate.of(2024, 2, 10));
		//particion lapso solapa fecha inicial
		l3 = new DateLapse(LocalDate.of(2024, 2, 25),LocalDate.of(2024, 3, 10));
		//particion lapso solapa fecha final
		l4 = new DateLapse(LocalDate.of(2024, 1, 25),LocalDate.of(2024, 2, 10));
		//sin colision:
		//particion fecha anterior al lapso
		l5 = new DateLapse(LocalDate.of(2024, 1, 1),LocalDate.of(2024, 1, 20));
		//particion fecha posterior al lapso
		l6 = new DateLapse(LocalDate.of(2024, 10, 1),LocalDate.of(2024, 10, 20));
		
		r1 = new Reserva(p1,l2,u1);
		r2 = new Reserva(p1,l3,u1);
		r3 = new Reserva(p1,l4,u1);
		r4 = new Reserva(p1,l5,u1);
		r5 = new Reserva(p1,l6,u1);

	}
	
	@Test
	public void estoyDisponible() {
		//no tiene reservas en un periodo l1
		assertTrue(p1.estoyDisponible(l1));
		//tiene reserva particion solapada ambas fechas
		p1.addReserva(r1);
		assertFalse(p1.estoyDisponible(l1));
		//tiene reserva particion solapada fecha inicial
		p1.removerReserva(r1);
		p1.addReserva(r2);
		assertFalse(p1.estoyDisponible(l1));
		//tiene reserva part solapada fecha final
		p1.removerReserva(r2);
		p1.addReserva(r3);
		assertFalse(p1.estoyDisponible(l1));
		//tiene reserva no solapa con fecha anterior
		p1.removerReserva(r3);
		p1.addReserva(r4);
		assertTrue(p1.estoyDisponible(l1));
		//tiene reserva no solapa con fecha posterior
		p1.removerReserva(r4);
		p1.addReserva(r5);
		assertTrue(p1.estoyDisponible(l1));
	}

	
}
