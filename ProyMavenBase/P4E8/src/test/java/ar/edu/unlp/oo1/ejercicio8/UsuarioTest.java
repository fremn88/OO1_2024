package ar.edu.unlp.oo1.ejercicio8;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio8.impl.Consumo;
import ar.edu.unlp.oo1.ejercicio8.impl.Usuario;

public class UsuarioTest {
	
		Usuario user;
		Consumo medicion;
		
		@BeforeEach
		public void setUp() {
			user = new Usuario("La Plata","Damian");
			medicion = new Consumo(LocalDate.of(2024, 2, 20),9,1);
		}
		
		@Test
		public void agregarConsumo() {
			user.agregarMedicion(medicion);
			assertEquals(9, user.ultimoConsumoActiva());
		}
}
