package trabajoPractico04;

public class Distancia {

	//ATRIBUTOS
	private final double KILOMETRO = 1000;
	private final double HECTOMETRO = 100;
	private final double DECAMETRO = 10;
	private char unidad;
	private double valor;
	
	//CONSTRUCTOR
	public Distancia(double valor, char unidad) {
		this.valor = valor;
		this.unidad = unidad;
	}

	//GETS&SETS
	public double getUnidad() {
		return unidad;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void setValor(double valor, char unidad) {
		this.unidad = unidad;
		switch(unidad) {
		case 'm':
		case 'k':
		case 'h':
		case 'd':
			this.valor = valor;
			break;
		default:
			break;
		}
	}

	public double getKILOMETRO() {
		return KILOMETRO;
	}

	public double getHECTOMETRO() {
		return HECTOMETRO;
	}

	public double getDECAMETRO() {
		return DECAMETRO;
	}
	
	//METODOS
	
	public double convertir(char unidadAConvertir) {
		double resultado = 0.0;
		if((this.unidad == 'm') && (this.unidad != unidadAConvertir)) {
			switch(unidadAConvertir) {
			case 'm':
				resultado = this.valor;
				break;
			case 'k':
				resultado = this.valor / this.KILOMETRO;
				break;
			case 'h':
				resultado = this.valor / this.HECTOMETRO;
				break;
			case 'd':
				resultado = this.valor / this.DECAMETRO;
				break;
			}
		}
		return resultado;
	}
	
}
