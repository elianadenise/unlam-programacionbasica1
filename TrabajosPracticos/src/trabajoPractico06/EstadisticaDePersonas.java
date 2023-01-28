package trabajoPractico06;

public class EstadisticaDePersonas {

	//ATRIBUTOS
	private int edad;
	private double peso;
	private double altura;
	private static int cantidadDePersonasIngresadas;
	
	//CONSTRUCTORES
	public EstadisticaDePersonas(int edad, double peso, double altura) {
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;		
		EstadisticaDePersonas.cantidadDePersonasIngresadas++;
	}

	//GETS&SETS
	public int getEdad() {
		return edad;
	}

	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}


	public static int getCantidadDePersonasIngresadas() {
		return cantidadDePersonasIngresadas;
	}

	//METODOS

	
}
