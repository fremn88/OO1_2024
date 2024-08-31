package ar.edu.unlp.oo1.ejercicio4.impl;

public class Mamtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mamifero nala = new Mamifero("Nala");
		Mamifero melquiades = new Mamifero("Melquiades");
		Mamifero mufasa = new Mamifero("Mufasa");
		Mamifero alexa = new Mamifero("Alexa");
		Mamifero elsa = new Mamifero("Elsa");
		Mamifero scar = new Mamifero("Scar");
		Mamifero sarabi = new Mamifero("Sarabi");
		Mamifero anonimo = new Mamifero();

		alexa.setPadre(mufasa);
		alexa.setMadre(sarabi);
		mufasa.setPadre(melquiades);
		mufasa.setMadre(nala);
		sarabi.setPadre(scar);
		sarabi.setMadre(elsa);
		
		Mamifero alice = new Mamifero("Alice");
		Mamifero aaron = new Mamifero("Aaron");
		Mamifero anna = new Mamifero("Anna");
		Mamifero alexander = new Mamifero("Alexander");

		alice.setPadre(aaron);
		aaron.setMadre(anna);
		anna.setPadre(alexander);

		System.out.println(alice.tieneComoAncestroA(anna));
		System.out.println(alice.tieneComoAncestroA(aaron));
		System.out.println(alice.tieneComoAncestroA(alexander));
		System.out.println(alice.tieneComoAncestroA(nala));
		System.out.println(alice.tieneComoAncestroA(alice));
	}

}
