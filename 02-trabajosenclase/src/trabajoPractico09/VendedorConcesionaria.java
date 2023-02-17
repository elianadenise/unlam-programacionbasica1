package trabajoPractico09;

public class VendedorConcesionaria {

	//ATRIBUTOS
	private String nombreVendedor;
	private int cantidadDeAutosVendidos;
	private double comisionesAcumuladas;
	private double comision = 0.15;
	
	//CONSTRUCTOR
	public VendedorConcesionaria(String nombre) {
		this.nombreVendedor = nombre;
		this.cantidadDeAutosVendidos = 0;
		this.comisionesAcumuladas = 0;
	}
	
	//GETS&SETS
	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public int getCantidadDeAutosVendidos() {
		return cantidadDeAutosVendidos;
	}

	public void setCantidadDeAutosVendidos(int cantidadDeAutosVendidos) {
		this.cantidadDeAutosVendidos = cantidadDeAutosVendidos;
	}

	public double getComisionesAcumuladas() {
		return comisionesAcumuladas;
	}

	public void setComisionesAcumuladas(double comisionesAcumuladas) {
		this.comisionesAcumuladas = comisionesAcumuladas;
	}
	
	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	//METODOS
	public void comisionar() {
		this.comisionesAcumuladas = /*(Autito.getPrecio()) / */ this.comision;
		this.cantidadDeAutosVendidos++;
		//recibir en otro metodo de la concesionaria al vendedor 
		
	}
	
	public String toString() {
		return this.nombreVendedor + ".";
	}

	
}
