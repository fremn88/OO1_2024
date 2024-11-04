package ar.edu.unlp.oo1.ejercicio21.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapTest {

	private Map<String, Integer> map;
	
	@BeforeEach
	void setUp() throws Exception {
		map = new HashMap<>();
		map.put("Lionel Messi", 111);
		map.put("Gabriel Batistuta", 56);
		map.put("Kun Aguero", 42);
	}
	
	@Test
	void test1() {
		//verifica valores iniciales cargados, imprimiendo en pantalla
		map.entrySet().stream().forEach(e->System.out.println("clave: "+e.getKey()+" - valor: "+e.getValue()));
		System.out.println("  -------  ");
		//elimina key 
		map.remove("Kun Aguero");
		//verifica que la key ya no existe e imprime las entires
		assertFalse(map.containsKey("Kun Aguero"));
		map.entrySet().stream().forEach(e->System.out.println("clave: "+e.getKey()+" - valor: "+e.getValue()));
		System.out.println("  -------  ");
		//actualiza cantidad goles messi y verifica
		map.put("Lionel Messi", 112);
		assertEquals(112,map.get("Lionel Messi"));
		//verifica que no se puede repetir clave batistuta
		assertEquals(56,map.put("Gabriel Batistuta", 56));
		map.entrySet().stream().forEach(e->System.out.println("clave: "+e.getKey()+" - valor: "+e.getValue()));
		System.out.println("  -------  ");
		//cantidad total de goles
		System.out.println(map.values().stream().mapToInt(v->v).sum());
	}
}
