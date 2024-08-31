package ar.edu.unlp.oo1.ejercicio4.impl;

import java.time.LocalDate;

public class Mamifero {
	
	private String identificador;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	// constructores
	
	public Mamifero(String identificador) {
		this.identificador = identificador;
	}
	
	public Mamifero() {
		
	}
	
	// getters y setters
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	//???
	public Mamifero getAbueloPaterno() {
		if (this.padre!=null) {
			return this.padre.getPadre();
		}
		return null;
	}
	
	public Mamifero getAbuelaPaterna() {
		if (this.padre!=null) {
			return this.padre.getMadre();
		}
		return null;
	}
	
	public Mamifero getAbueloMaterno() {
		if (this.madre!=null) {
			return this.madre.getPadre();
		}
		return null;
	}
	
	public Mamifero getAbuelaMaterna() {
		if (this.madre!=null) {
		return this.madre.getMadre();
		}
		return null;
	}
	
	public boolean tieneComoAncestroA(Mamifero a) {
		return (ancestro(madre, a)||ancestro(padre, a));
	}
	
	private boolean ancestro(Mamifero padre, Mamifero a) {
		boolean resultado = false;
		// chequeo del padre se hace para el caso de que al menos uno de los padres no exista
		if(padre!=null) {
			resultado = padre == a || padre.tieneComoAncestroA(a);
		}
		return resultado;
	}
	
	// no deberia comparar con equals por identificador ??? ---
	// en la consigna no explicita posibilidad de que tenga 1 padre y no una madre y viceversa... dificulta la comprension.

}
