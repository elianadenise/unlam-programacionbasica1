package feb2023;

public class Persona {

	// ATRIBUTOS
	private String nombre;
	private String apellido;
	private char sexo;
	private int dni;
	private float saldo;
	private String contrasenia;
	
	// CONSTRUCTOR
	public Persona(String nombre, String apellido, char sexo, int dni, float saldo, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.dni = dni;
		this.saldo = saldo;
		this.contrasenia = contrasenia;
	}

	// GETS & SETS
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public char getSexo() {
		return sexo;
	}

	public int getDni() {
		return dni;
	}

	public float getSaldo() {
		return saldo;
	}

	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	// toSTRING
	public String toString() {
		return this.nombre + " " + this.apellido + "\nDNI: " + this.dni + "\nSaldo: $" + this.saldo;
	}
	public String toStringDos() {
		return this.nombre + " " + this.apellido + "\nDNI: " + this.dni;
	}
}
