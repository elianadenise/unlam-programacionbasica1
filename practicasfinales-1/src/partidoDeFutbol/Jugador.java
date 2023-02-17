package partidoDeFutbol;

public class Jugador {
	private int numero;
	private String nombre;
	private int edad;
	private double precio;
	
	public Jugador(int numero, String nombre, int edad, double precio) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String toString() {
		return "Jugador: " + this.nombre +" (" + this.numero + ").";
	}
}
