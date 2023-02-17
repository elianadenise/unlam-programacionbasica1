package trabajoPractico04;

public class Temperatura {

	//ATRIBUTOS
	public final double CELSIUS = 0;
	public final double FARENHEIT = 32;
	public final double KELVIN = 273.15;
	private double valor;
	private char unidad;
	
	//CONSTRUCTOR
	public Temperatura(double valor) {
		this.valor = valor;
	}

	//GETS&SETS

	public double getCELSIUS() {
		return CELSIUS;
	}

	public double getFARENHEIT() {
		return FARENHEIT;
	}

	public double getKELVIN() {
		return KELVIN;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
	
	public char getUnidad() {
		return unidad;
	}

	/*public void setUnidad(char unidad) {
		this.unidad = unidad;
	}*/

	public void setValor(double valor, char unidad) { //este setea tanto unidad como valor
		this.unidad = unidad;
		switch(unidad) {
		case 'c':
		case 'f':
		case 'k':
			this.valor = valor;
			break;
		default:
			break;
		}
	}
	
	public double convertir(char convertirAUnidad) {
		double resultado = 0.0;
		if(this.unidad != convertirAUnidad) {
			if(this.unidad == 'c') {
				switch(convertirAUnidad) {
				case 'f':
					resultado = (this.valor*1.8) + this.FARENHEIT;
					break;
				case 'k':
					resultado = valor + this.KELVIN;
					break;
				default:
					break;
				}
			}
			
			if(this.unidad == 'f') {
				switch(convertirAUnidad) {
				case 'c':
					resultado = (this.valor - this.FARENHEIT) / (1.8);
					break;
				case 'k':
					resultado = ((this.valor - this.FARENHEIT) / (1.8)) + this.KELVIN;
					break;
				default:
					break;
				}
			}
			
			if(this.unidad == 'k') {
				switch(convertirAUnidad) {
				case 'c':
					resultado = this.valor - this.KELVIN;
					break;
				case 'f':
					resultado = (1.8) * (this.valor - this.KELVIN) + 32;
					break;
				default:
					break;
				}
			}
		}
		return resultado;
	}
	
	
}
