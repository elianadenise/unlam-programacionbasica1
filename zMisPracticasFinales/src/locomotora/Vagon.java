package locomotora;

public class Vagon {

	//ATRIBUTOS
	private String idVagon;
	private String descripcion;
	private MarcaVagon marca;
	private double pesoMaximoSoportado;
	private double pesoDeCarga;
	
	//CONSTRUCTOR
	public Vagon() {
		this.idVagon = "";
		this.descripcion = "";
		this.marca = null;
		this.pesoDeCarga = 0.0;
		this.pesoMaximoSoportado = 0.0;
	}
	public Vagon(String idVagon, String descripcion, MarcaVagon marca, double pesoMaximo, double pesoCarga) {
		this.idVagon = idVagon;
		this.descripcion = descripcion;
		this.marca = marca;
		this.pesoMaximoSoportado = pesoMaximo;
		this.pesoDeCarga = pesoCarga;
	}
	
	//GETS&SETS
	public String getIdVagon() {
		return idVagon;
	}

	public void setIdVagon(String idVagon) {
		this.idVagon = idVagon;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MarcaVagon getMarca() {
		return marca;
	}

	public void setMarca(MarcaVagon marca) {
		this.marca = marca;
	}

	public double getPesoMaximoSoportado() {
		return pesoMaximoSoportado;
	}

	public void setPesoMaximoSoportado(double pesoMaximoSoportado) {
		this.pesoMaximoSoportado = pesoMaximoSoportado;
	}

	public double getPesoDeCarga() {
		return pesoDeCarga;
	}

	public void setPesoDeCarga(double pesoDeCarga) {
		this.pesoDeCarga = pesoDeCarga;
	}
	
	//METODOS
	public boolean validarIdentificador(String idVagon) {//le saque el static avisar al profe
		boolean validado = false;
		if((idVagon.length() == 6) && (idVagon.substring(0, 3).matches("[A-Z]*")) && (idVagon.substring(3).matches("[0-9]*"))) {
			validado = true;
		}
		return validado;
	}

	public String toString() {
		return "Datos del vagon:\nId: " + this.idVagon + "\nDescripcion: " + this.descripcion + "\nMarca: " + this.marca + "\nPeso maximo: " + this.pesoMaximoSoportado + "\nPeso actual de carga: " + this.pesoDeCarga;
	}
	
	
}
