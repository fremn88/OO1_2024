package ar.edu.unlp.oo1.ejercicio24.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Viaje {

	private String origen, destino;
	private double costo;
	private LocalDate fecha;
	private List<Pasajero> pasajeros;
	private Vehiculo vehiculo;
	private boolean procesado;
	
	public Viaje(String origen, String destino, double costo, LocalDate fecha, Vehiculo vehiculo) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
		this.fecha = fecha;
		this.pasajeros = new ArrayList<Pasajero>();
		this.vehiculo = vehiculo;
		this.procesado = false;
		
	}

	public void procesarViaje(Viaje viaje) {
		if(!procesado) {
			//calculo monto bruto para todos
			Integer integrantes = pasajeros.size() + 1;
			double montoBruto = costo/integrantes;
			//??descuento el monto cada uno sabe su bonificacion (esta bien pasar vehiculo a conductor si no lo usa??
			this.pasajeros.stream().forEach(p->p.gastarSaldo(montoBruto, vehiculo)); //?? Esta ok usar foreach?? Deberia, porque la coleccion la obtengo de este objeto
			vehiculo.getConductor().gastarSaldo(montoBruto, vehiculo);
			vehiculo.disminuyeOcupacion(integrantes - 1);
			//marco procesado
			procesado = true;
		}
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public double getCosto() {
		return costo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public void agregarPasajero(Pasajero p) {
		pasajeros.add(p);
		vehiculo.incrementarOcupacion();
	}
	
	public void eliminarPasajero(Pasajero p) {
		pasajeros.remove(p);
		vehiculo.disminuyeOcupacion(1);
	}
	
}
