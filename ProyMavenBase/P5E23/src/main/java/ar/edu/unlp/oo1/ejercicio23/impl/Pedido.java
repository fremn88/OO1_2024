package ar.edu.unlp.oo1.ejercicio23.impl;

public class Pedido {

	private Producto producto;
	private FormaEnvio envio;
	private FormaPago pago;
	private Integer cantidad;
	private Usuario cli;
	
	public Pedido(Producto producto, FormaEnvio envio, FormaPago pago, Integer cantidad, Usuario u) {
		super();
		this.producto = producto;
		this.envio = envio;
		this.pago = pago;
		this.cantidad = cantidad;
		this.cli = u;
	}
	
	public double costo() {
		return cantidad*producto.getPrecio()*pago.costoPago()+envio.costoEnvio(cli.getDireccion(),producto.getVen().getDireccion());
	}

	public Producto getProducto() {
		return producto;
	}

	public FormaEnvio getEnvio() {
		return envio;
	}

	public FormaPago getPago() {
		return pago;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public Usuario getCli() {
		return cli;
	}
	
	
	
	
}
