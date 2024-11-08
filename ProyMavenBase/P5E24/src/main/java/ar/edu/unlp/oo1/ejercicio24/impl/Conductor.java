package ar.edu.unlp.oo1.ejercicio24.impl;

import java.time.LocalDate;

public class Conductor extends Usuario {
	
	public Conductor(String nombre, double saldo) {
		super(nombre, saldo);
		// TODO Auto-generated constructor stub
	}

	private Vehiculo vehiculo;
	
	public void cargarSaldo(double monto) {
		if(vehiculo!=null) {
			if(vehiculo.getAnio()<5) {
				this.saldo += monto*0.99;
			} else {
				this.saldo += monto*0.90;
			}
		}
	}
	
	public void altaViaje(String origen, String destino, double costo, LocalDate fecha, Vehiculo vehiculo) {
		this.viajes.add(new Viaje(origen, destino, costo, fecha, vehiculo));
	}

	@Override
	public void gastarSaldo(double monto, Vehiculo vehiculo) {
		saldo = saldo - monto + 0.001*vehiculo.getValor();	
	}
	
}
