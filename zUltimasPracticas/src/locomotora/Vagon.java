package locomotora;

public class Vagon {
	
	private String idVagon;
	private String descripcion;
	private MarcaVagon marca;
	private double pesoMaximoSoportado;
	private double pesoDeCarga;
	
	public Vagon() {
		this.idVagon = "";
		this.descripcion = "";
		this.marca = null;
		this.pesoDeCarga = 0.0;
		this.pesoMaximoSoportado = 0.0;
	}
	
	public boolean validarIdentificador(String identificador) {
		boolean valido = false;
		identificador.toUpperCase();
		if(identificador.substring(0,2).matches("[A-Z]*") && identificador.substring(3).matches("[0-9]*")) {
			valido = true;
		}
		return valido;
	}

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

	@Override
	public String toString() {
		return "Vagon [idVagon=" + idVagon + ", descripcion=" + descripcion + ", marca=" + marca
				+ ", pesoMaximoSoportado=" + pesoMaximoSoportado + ", pesoDeCarga=" + pesoDeCarga + "]";
	}

	
	
}
