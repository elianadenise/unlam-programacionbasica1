package trabajoPractico02;

//Estudiante Eliana Navarro
//TP 02
//TP 03
//TP 06

public class Persona {

	//ATRIBUTOS
	private String nombre;
	private String genero;
	private long dni;
	private double peso;
	private double altura;
	private int edad;
	private boolean vive;
	//
	private static int cantidadDePersonasIngresadas;
	private double pesoTotal;
	private double pesoPromedio;
	private final double bAJO_pESO = 18.5;
	private final double pESO_nORMAL = 24.9;
	private final double sOBRE_pESO = 25.0;
	private int cantidadPersonasBajoPeso;
	private int cantidadPersonasPesoNormal;
	private int cantidadPersonasSobrePeso;
	
	//METODOS - COMPORTAMIENTO
	public Persona() {
		this.nombre = "";
		this.genero = "";
		this.dni = 0;
		this.peso = 0.0;
		this.altura = 0.0;
		this.edad = 0;
		this.vive = true;
	}
	
	public Persona(String nombre, String genero, long dni, double peso, double altura, int edad) {
		this.nombre = nombre;
		this.genero = genero;
		this.dni = dni;
		this.peso = peso;
		this.altura = altura;
		this.edad = edad;
		vive = true;
	}
	
	public Persona(double peso) {
		this.peso = peso;
	}
	
	public Persona(int edad, double peso, double altura) {
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;		
		Persona.cantidadDePersonasIngresadas++;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String valor) {
		nombre = valor;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String valor) {
		genero = valor;
	}
	
	public long getDni() {
		return dni;
	}
	
	public void setDni(long valor) {
		//condicional simple
		if(valor>0) {
			dni = valor;
		}
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double valor) {
		peso = valor;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double valor) {
		altura = valor;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int valor) {
		edad = valor;
	}
	
	public boolean getVive() {
		return vive;
	}
	
	
	public void alimentar(double kilos) {
		this.peso += kilos;
	}
	
	public void crecer(double metros) {
		this.altura += metros;
	}
	
	public void masEdad() {
		this.edad++;
	}
	
	public void morir() {
		this.vive = false;
	}
	
	public double pesar() {
		return peso;
	}
	
	public double medir() {
		return altura;
	}
	
	public static int getCantidadDePersonasIngresadas() {
		return cantidadDePersonasIngresadas;
	}

	//TP 03
	public boolean esMayorDeEdad() {
		boolean mayoriaDeEdad = false;
		if(this.edad >= 18) {
			mayoriaDeEdad = true;
		}
		return mayoriaDeEdad;
	}
	
	public String toString() {
		return this.nombre;
	}
	
	public void edadSeleccionada(int edad) {
		for(int i = getEdad(); i < edad; i++) {
			this.edad++;
		}
	}
	
	//asi tambien va
	/*public void edadSeleccionada(int edad) {
		for(this.edad = getEdad(); this.edad < edad; this.edad++) {
			this.edad++;
		}
	}*/
	
	
	//TP 06 - ACT 04
	public IMC definicionPesoCorporal() {
		double imc = this.peso / (Math.pow(this.altura, 2));
		if(imc < this.bAJO_pESO) {
			return IMC.BAJO_PESO;
		} else if((imc > this.bAJO_pESO) && (imc < this.pESO_nORMAL)) {
			return IMC.PESO_NORMAL;
		} else { 
			return IMC.SOBREPESO;
		}
	}
	
	
	//todo lo que puede salir mal, salio mal.
	/*
	public void ingresarPersonaABaseDeDatos(Persona nueva) {
		this.pesoTotal =+ nueva.getPeso();
	}
	public void pesoPromedio() {//no puede ser asi, tiene que entrar directo al final.
		//al final, llamo al metodo y tiene que calcularlo
		this.pesoPromedio = this.pesoTotal / Persona.getCantidadDePersonasIngresadas();
	}
	
	public int bajoPeso(Persona nueva) {
		this.cantidadPersonasBajoPeso = 0;
		double imc = (nueva.getPeso()) / (Math.pow(nueva.getAltura(), 2));
		while(imc < this.bAJO_pESO) {
			cantidadPersonasBajoPeso++;
		}
		return cantidadPersonasBajoPeso;
	}
	
	
	public void calculoIMC(Persona nueva, IMC unidadPeso) {
		double imc = (nueva.getPeso()) / (Math.pow(nueva.getAltura(), 2));
				
				
				switch(unidadPeso) {
				case BAJO_PESO:
				case PESO_NORMAL:
				case SOBREPESO:
					
				}
	}

	public double promedioEdades(IMC unidadPeso) {
		double promedioEdades = 0.0;
		
		switch(unidadPeso) {
		case BAJO_PESO:
		case PESO_NORMAL:
		case SOBREPESO:
			
		}
		return promedioEdades;
	}
	*/
	
}
