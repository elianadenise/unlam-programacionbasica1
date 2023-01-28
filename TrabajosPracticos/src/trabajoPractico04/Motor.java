package trabajoPractico04;

public class Motor {
	
	//ATRIBUTOS
	private int tipoDeBomba;
	private String tipoDeFluido;
	private String combustible;
	
	//CONSTRUCTOR
	public Motor(int tipoDeBomba, String tipoDeFluido, String combustible) {
		this.tipoDeBomba = tipoDeBomba;
		this.tipoDeFluido = tipoDeFluido;
		this.combustible = combustible;
	}

	//GETS&SETS
	public int getTipoDeBomba() {
		return tipoDeBomba;
	}

	public void setTipoDeBomba(int tipoDeBomba) {
		this.tipoDeBomba = tipoDeBomba;
	}

	public String getTipoDeFluido() {
		return tipoDeFluido;
	}

	public void setTipoDeFluido(String tipoDeFluido) {
		this.tipoDeFluido = tipoDeFluido;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	
}
