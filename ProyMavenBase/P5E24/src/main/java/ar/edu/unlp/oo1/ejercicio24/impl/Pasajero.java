package ar.edu.unlp.oo1.ejercicio24.impl;

import java.time.LocalDate;

public class Pasajero extends Usuario {

	public Pasajero(String nombre, double saldo) {
		super(nombre, saldo);
		// TODO Auto-generated constructor stub
	}

	public void cargarSaldo(double monto) {
		if(!viajoUltimos30Dias()) {
			this.saldo += monto*0.9;
		} else this.saldo += monto;
	}
	
	public void registrarViaje(Viaje viaje) {
		if(viaje.getVehiculo().getCapacidad()>0 && this.saldo > 0 && viaje.getFecha().isAfter(LocalDate.now().plusDays(2))) {
			viaje.agregarPasajero(this);
		}
	}
	
	private boolean viajoUltimos30Dias() {
		LocalDate fechaLimite = LocalDate.now().minusDays(30);
		long cantidadViajes = this.viajes.stream().filter(v->v.getFecha().isAfter(fechaLimite)).count();
		if(cantidadViajes>0) {
			return true;
		} else return false;
	}

	@Override
	public void gastarSaldo(double monto, Vehiculo vehiculo) {
		saldo -= monto;
		//??verificar si este pasajero hizo un viaje en este vehiculo anteriormente o solo si no hizo algun viaje cualquiera??
		long cantViajes = this.viajes.stream().filter(v->v.getVehiculo().equals(vehiculo)).count();
		if(cantViajes>0) {
			saldo += 500;
		}
	}
	
}
