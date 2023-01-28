package concesionaria;

public class Auto {

	//ATRIBUTOS
	private String modelo;
	private String marca;
	private long kilometros;
	private double precioDeCompra;
	
	//CONSTRUCTOR
	public Auto(String modelo, String marca, long kilometros, double precioDeCompra) {
		this.modelo = modelo;
		this.marca = marca;
		this.kilometros = kilometros;
		this.precioDeCompra = precioDeCompra;
	}

	//GETS&SETS
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public long getKilometros() {
		return kilometros;
	}

	public void setKilometros(long kilometros) {
		this.kilometros = kilometros;
	}

	public double getPrecioDeCompra() {
		return precioDeCompra;
	}

	public void setPrecioDeCompra(double precioDeCompra) {
		this.precioDeCompra = precioDeCompra;
	}
	
	public String toString() {
		return "Modelo: " + this.modelo + "\nMarca: " + this.marca + "\nPrecio: " + this.precioDeCompra;
	}
	
}
