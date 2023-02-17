package concesionaria;

public class Vendedor {

	//ATRIBUTOS
	private String nombre;
	private double comision;
	private int autosVendidos;
	
	//CONSTRUCTOR
	public Vendedor(String nombre) {

		this.nombre = nombre;
		this.comision = 0;
		this.autosVendidos = 0;
	}

	//GETS&SETS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public int getAutosVendidos() {
		return autosVendidos;
	}

	public void setAutosVendidos(int autosVendidos) {
		this.autosVendidos = autosVendidos;
	}
	
	public String toString() {
		return "Nombre: " + this.nombre + "\nAutos vendidos: " + this.autosVendidos + "\nComision: " + this.comision;
	}
}
