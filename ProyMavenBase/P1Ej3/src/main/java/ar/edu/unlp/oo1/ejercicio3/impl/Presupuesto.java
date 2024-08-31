package ar.edu.unlp.oo1.ejercicio3.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	
	private LocalDate fecha;
	
	private String cliente;
	
	private List<Item> items;
	
	public LocalDate getFecha() {
		return fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public Presupuesto(String cliente) {
		this.fecha = LocalDate.now();
		this.cliente = cliente;
		this.items = new ArrayList<Item>();
	}
	
	public void agregarItem(Item item) {
		this.items.add(item);
	}
	
	public double calcularTotal() {
		double total = 0;
		for(Item a: items) {
			total+=a.costo();
		}
		return total;
	}
}
