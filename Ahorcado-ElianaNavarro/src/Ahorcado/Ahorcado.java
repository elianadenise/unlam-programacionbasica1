package Ahorcado;

public class Ahorcado {
	//ATRIBUTOS
	private boolean palabraCompleta;
	private boolean letraPositiva;
	private byte letraPositivaa = 0;
	private byte puntosAcumulados;
	private byte cantidadDeFallos = 0;
	private final byte CANTIDAD_MAXIMA_DE_FALLOS = 6;
	private char letrasAcertadas[];
	private char letrasArriesgadas[];
	private char palabraArriesgada[];
	private String nombreJugador;
    private String palabraSeleccionada;
    char palabraACaracter [];
    private String palabrasPosibles []= {"perro", "gato", "ornitorrinco", "otorrinolaringologo", "bienvenido", "murcielago", "capitalismo", "economia", "turismo", "algoritmo", "tazas", "mariposa", ""};

    //CONSTRUCTOR
    public Ahorcado(String nombre) {
    	this.puntosAcumulados = 0;
    	this.nombreJugador = nombre;
    	this.palabraSeleccionada = seleccionarPalabra();
    	this.letrasAcertadas = new char[palabraSeleccionada.length()];
	}

	//GETS&SETS
	public boolean isPalabraCompleta() {
		return palabraCompleta;
	}

	public char[] getLetrasArriesgadas() {
		return letrasArriesgadas;
	}

	public void setLetrasArriesgadas(char[] letrasArriesgadas) {
		this.letrasArriesgadas = letrasArriesgadas;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public String getPalabraSeleccionada() {
		return palabraSeleccionada;
	}

	public String[] getPalabrasPosibles() {
		return palabrasPosibles;
	}

	public byte getCantidadDeFallos() {
		return cantidadDeFallos;
	}

	public byte getCANTIDAD_MAXIMA_DE_FALLOS() {
		return CANTIDAD_MAXIMA_DE_FALLOS;
	}

	public char[] getLetrasAcertadas() {
		return letrasAcertadas;
	}
    //METODOS
	public String seleccionarPalabra() {
		int posicionDePalabra = (int)(Math.random()*palabrasPosibles.length);
		return this.palabrasPosibles[posicionDePalabra];
	}
	
    //del string palabra a caracter
	public void cambioAcaracter() {
		this.palabraACaracter = this.palabraSeleccionada.toCharArray();
	}
	
	public void arrayDeGuiones() {
		for(int i = 0; i < this.letrasAcertadas.length; i++) {
			this.letrasAcertadas[i] = '_';
		}    
	}
    
	public void letraAcertada(char letra) {
		byte letraNegativa = 0;
		this.palabraCompleta = false;
		for (int i = 0; i < this.palabraACaracter.length; i++) {
			if(letra == this.palabraACaracter[i]) {
				this.letrasAcertadas[i] = letra;
				if(this.letrasAcertadas[i] == letra) {//EVALUAR SI SE PUEDE OMITIR
					letraPositivaa++;
					if(letraPositivaa == this.palabraACaracter.length) {
						this.palabraCompleta = true;
					}
				}
			} else {
				letraNegativa++;
				if(letraNegativa == this.palabraACaracter.length) {
					this.cantidadDeFallos++;
				}
			}
		}
	}
	
	public void palabraArriesgada(String palabra) {
		this.palabraCompleta = false;
    	if (palabra.equalsIgnoreCase(this.palabraSeleccionada) == true) {
    		this.palabraCompleta = true;
    	} else { 
    		this.cantidadDeFallos++;
    	} 	
	}
	
	public byte puntaje() {
		if(this.palabraCompleta == true) {
			this.puntosAcumulados++;
		}
		return this.puntosAcumulados;
	}

}

/*public void arriesgarPalabraCompleta(String palabra) {//eliminar esto
	this.palabraArriesgada = palabra.toCharArray();
}

public void recorrerPalabraArriesgada() {
	byte letraNegativa = 0;
	byte contadorDeLetras = 0;
	this.letraPositiva = false;
	this.palabraCompleta = false;
	for (int i = 0; i < this.palabraArriesgada.length; i++) {
		for(int j = 0; j < this.palabraACaracter.length; j++) {
			if(this.palabraArriesgada[i] == this.palabraACaracter[j]) {
				this.letraPositiva = true;//corregir esto porque va a dar true si la ultima letra es igual a la palabra arriesgada
				if(this.letraPositiva == true) {
					contadorDeLetras++;
					if(contadorDeLetras == this.palabraACaracter.length) {
						this.palabraCompleta = true;
					}
				} 
			} else {
				letraNegativa++;
				if(letraNegativa == this.palabraACaracter.length) {
					this.cantidadDeFallos++;
				}
			}
		}
	}
}
*/