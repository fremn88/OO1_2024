package ar.edu.unlp.oo1.ejercicio7;

import ar.edu.unlp.oo1.ejercicio7.impl.Gerente;

public class GerenteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gerente alan = new Gerente("Alan");
		System.out.println("aportes: "+alan.aportes());
		System.out.println("sueldoBasico: "+alan.sueldoBasico());
	}

}
