package trabajoPracticoIntegrador;

//Estudiantes:
//- Alonso Reyes, Ornella
//- Fazzari Clerici, Mayra
//- Ferreira, Tahiel
//- Navarro, Eliana

public class Televisor {
	//ATRIBUTOS
	private boolean botonPower;
	private char entradaActual;
	private byte canalAbiertoActual;
	private short canalCableActual;
	private byte canalAbiertoAnterior;
	private short canalCableAnterior;
	private byte volumenActual;
	private final byte CANTIDAD_MAX_CANALES_ABIERTOS;
	private final short CANTIDAD_MAX_CANALES_CABLE;
	private final byte VOLUMEN_MAX;
	private static long numeroDeSerie; 
	private final char ENTRADA_POR_CANAL_ABIERTO = 'A';
	private final char ENTRADA_POR_CANAL_CABLE = 'C';
	private final char ENTRADA_POR_USB = 'U';
	private final char ENTRADA_POR_HDMI1 = '1';
	private final char ENTRADA_POR_HDMI2 ='2';

	//COSTRUCTORES
	//1.a.
	public Televisor() {
		Televisor.numeroDeSerie++;
		this.botonPower = false;
		this.CANTIDAD_MAX_CANALES_ABIERTOS = 127;
		this.CANTIDAD_MAX_CANALES_CABLE = 32767;
		this.VOLUMEN_MAX = 100;
		this.canalAbiertoActual = 1;
		this.canalCableActual = 1;
		this.entradaActual = '\0'; 
	}
	  
	//1.b.
	public Televisor(byte canalMaximoTelevisionAbierta, short canalMaximoTelevisionCable) {
		Televisor.numeroDeSerie++;
		this.botonPower = false;
		this.CANTIDAD_MAX_CANALES_ABIERTOS = canalMaximoTelevisionAbierta;
		this.CANTIDAD_MAX_CANALES_CABLE = canalMaximoTelevisionCable;
		this.VOLUMEN_MAX = 100;
		this.canalAbiertoActual = 1;
		this.canalCableActual = 1;
		this.entradaActual = '\0';
	}
	  
	//GETS&SETS
	//1.h. y 2.m.
	public static long getNumeroDeSerie() {
		return numeroDeSerie;
	}
		
	//1.h. y 2.n.
	public boolean isBotonPower() {
		return botonPower;
	}

	//1.h. y 2.o
	public byte getVolumenActual() {
		return volumenActual;
	}
		
	//1.h. y 2.p
	public byte getCanalAbiertoActual() {
		return canalAbiertoActual;
	}
			
	//1.h. y 2.p
	public short getCanalCableActual() {
		return canalCableActual;
	}
		
	//1.h. y 2.q.
	public char getEntradaActual() {
		return entradaActual;
	}

	public byte getVOLUMEN_MAX() {
		return VOLUMEN_MAX;
	}

	//METODOS
	//1.a. y 2.c.
	public boolean encenderOApagar() {
		if(this.botonPower == false) {
			this.botonPower = true;
		} else if(this.botonPower == true) {
			this.botonPower = false;
		}
		return this.botonPower;
	}

	//1.b. y 2.d
	public String toString() {
		if ((this.entradaActual == this.ENTRADA_POR_CANAL_ABIERTO)) {
			return "El estado actual del televisor es:"
					+ "\nVolumen: " + this.volumenActual 
					+ "\nCanal de television abierta: " + this.canalAbiertoActual;
		} else if ((this.entradaActual == this.ENTRADA_POR_CANAL_CABLE)) {
			return "El estado actual del televisor es:"
					+ "\nVolumen: " + this.volumenActual 
					+ "\nCanal de cable: " + this.canalCableActual;
		} 
		return "Primero, seleccione la entrada (Canal abierto o cable)";
	}

		//1.c. y 2.e.
	public void seleccionarEntrada(char entradaDeseada) {
		entradaDeseada = String.valueOf(entradaDeseada).toUpperCase().charAt(0);
		switch(entradaDeseada) {
		case ENTRADA_POR_CANAL_ABIERTO:
		case 'a':
		case ENTRADA_POR_CANAL_CABLE:
		case 'c':
		case ENTRADA_POR_HDMI1:
		case ENTRADA_POR_HDMI2:
		case ENTRADA_POR_USB:
		case 'u':
			this.entradaActual = entradaDeseada;
			break;
		}
			
	}

	//1.d. y 2.f.
	public void subirObajarAnalogicamente(char seleccionarOpcion) {
		if(this.botonPower == true) {
			switch (seleccionarOpcion) {
			case '+':
				if ((this.volumenActual >= 0) && (this.volumenActual < VOLUMEN_MAX)){
					this.volumenActual++;
				}
				break;
			case '-' :
				if ((this.volumenActual > 0) && (this.volumenActual <= VOLUMEN_MAX)) {
					this.volumenActual--;
				}
				break;
			case '>':
				if ((this.canalAbiertoActual >= 1) && (this.canalAbiertoActual < CANTIDAD_MAX_CANALES_ABIERTOS) && ((this.entradaActual == this.ENTRADA_POR_CANAL_ABIERTO))){
					this.canalAbiertoAnterior = this.canalAbiertoActual;
					this.canalAbiertoActual++;
				}else if ((this.canalCableActual >= 1) && (this.canalCableActual < CANTIDAD_MAX_CANALES_CABLE) && ((this.entradaActual == this.ENTRADA_POR_CANAL_CABLE))) {
					this.canalCableAnterior = this.canalCableActual;
					this.canalCableActual++;
				}
				break;
			case '<':
				if ((this.canalAbiertoActual >= 2) && (this.canalAbiertoActual < CANTIDAD_MAX_CANALES_ABIERTOS) && ((this.entradaActual == this.ENTRADA_POR_CANAL_ABIERTO))){
					this.canalAbiertoAnterior = this.canalAbiertoActual;
					this.canalAbiertoActual--;
				} else if ((this.canalCableActual >= 2) && (this.canalCableActual < CANTIDAD_MAX_CANALES_CABLE) && (this.entradaActual == this.ENTRADA_POR_CANAL_CABLE)) {
					this.canalCableAnterior = this.canalCableActual;
					this.canalCableActual--;
				}
				break;
			}
		}
	}
	  
	//1.e y 2.g.
	public void cambiarDeCanal(byte canalDeseado) { 
		if(this.botonPower == true) {
			if((canalDeseado >= 1) && (canalDeseado <= 9) && ((this.entradaActual == this.ENTRADA_POR_CANAL_ABIERTO))) {
				this.canalAbiertoAnterior = this.canalAbiertoActual;
				this.canalAbiertoActual = canalDeseado;
			} else if((canalDeseado >= 1) && (canalDeseado <= 9) && ((this.entradaActual == this.ENTRADA_POR_CANAL_CABLE))) {
				this.canalCableAnterior = this.canalCableActual;
				this.canalCableActual = canalDeseado;
			}
		}
	}

	//1.e y 2.h.
	public void cambiarDeCanal(byte primerDigito, byte segundoDigito) {
		if(this.botonPower == true) {
			if(((primerDigito >= 1) && (primerDigito <= 9)) && ((segundoDigito >= 0) && (segundoDigito <= 9)) && ((this.entradaActual == this.ENTRADA_POR_CANAL_ABIERTO))){
				this.canalAbiertoAnterior = this.canalAbiertoActual;
				this.canalAbiertoActual = (byte) ((primerDigito*10) + segundoDigito);
			} else if(((primerDigito >= 1) && (primerDigito <= 9)) && ((segundoDigito >= 0) && (segundoDigito <= 9)) && ((this.entradaActual == this.ENTRADA_POR_CANAL_CABLE))){
				this.canalCableAnterior = this.canalCableActual;
				this.canalCableActual = (short) ((primerDigito*10) + segundoDigito);
			}
		}
	}
	  
	//1.e y 2.i.
	public void cambiarDeCanal(byte primerDigito, byte segundoDigito, byte tercerDigito) {
		if(this.botonPower == true) {
			if((primerDigito == 1) && ((segundoDigito >= 0) && (segundoDigito <= 2)) && ((tercerDigito >= 0) && (tercerDigito <= 7)) && ((this.entradaActual == this.ENTRADA_POR_CANAL_ABIERTO))) {
				this.canalAbiertoAnterior = this.canalAbiertoActual;
				this.canalAbiertoActual = (byte) ((primerDigito * 100) + (segundoDigito * 10) + tercerDigito);
			}else if(((primerDigito >= 1) && (primerDigito <= 9)) && ((segundoDigito >= 0) && (segundoDigito <= 9)) && ((tercerDigito >= 0) && (tercerDigito <= 9)) && ((this.entradaActual == this.ENTRADA_POR_CANAL_CABLE))) {
				this.canalCableAnterior = this.canalCableActual;
				this.canalCableActual = (short) ((primerDigito * 100) + (segundoDigito * 10) + tercerDigito);
			} 
		}
	}
		
	//1.e y 2.j.
	public void cambiarDeCanal(byte primerDigito, byte segundoDigito, byte tercerDigito, byte cuartoDigito) {
		if(this.botonPower == true) {
			if(((primerDigito >= 1) && (primerDigito <= 9)) && ((segundoDigito >= 0) && (segundoDigito <= 9)) && ((tercerDigito >= 0) && (tercerDigito <= 9)) && ((cuartoDigito >= 0) && cuartoDigito <= 9) && ((this.entradaActual == this.ENTRADA_POR_CANAL_CABLE))) {
				this.canalCableAnterior = this.canalCableActual;
				this.canalCableActual = (short) ((primerDigito * 1000) + (segundoDigito * 100) + (tercerDigito * 10) + cuartoDigito);
			}
		}
	}
	
	//1.e y 2.
	public void cambiarDeCanal(byte primerDigito, byte segundoDigito, byte tercerDigito, byte cuartoDigito, byte quintoDigito) {
		if(this.botonPower == true) {
			if(((primerDigito >= 1) && (primerDigito <= 3)) && ((segundoDigito >= 0) && (segundoDigito <= 2)) && ((tercerDigito >= 0) && (tercerDigito <= 7)) && ((cuartoDigito >= 0) && (cuartoDigito <= 6)) && ((quintoDigito >= 0) && (quintoDigito <= 7)) && ((this.entradaActual == this.ENTRADA_POR_CANAL_CABLE))) {
				this.canalCableAnterior = this.canalCableActual;
				this.canalCableActual = (short) ((primerDigito * 10000) + (segundoDigito * 1000) + (tercerDigito * 100) + (cuartoDigito * 10) + quintoDigito);
			}
		}
	}
		
	//1.f. y 2.k.
	public void volverAlCanalAnterior() {
		short temporal;
		if(this.botonPower == true) {
			if(this.entradaActual == this.ENTRADA_POR_CANAL_ABIERTO) {
				temporal = this.canalAbiertoActual;
				this.canalAbiertoActual = this.canalAbiertoAnterior;
				this.canalAbiertoAnterior = (byte) temporal;
			} else if(this.entradaActual == this.ENTRADA_POR_CANAL_CABLE) {
				temporal = this.canalCableActual;
				this.canalCableActual = this.canalCableAnterior;
				this.canalCableAnterior = temporal;
			}
		}
	}

	//1.g. y 2.l.
	public void silenciar() {
		if((this.volumenActual >= 1) && (this.volumenActual <= this.VOLUMEN_MAX) && (this.botonPower == true)) {
			this.volumenActual = 0;
		}
	}
}