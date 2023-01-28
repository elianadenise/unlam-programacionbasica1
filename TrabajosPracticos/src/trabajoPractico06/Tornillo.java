package trabajoPractico06;
//TP 06 - ACT 02
public class Tornillo {
	
	//ATRIBUTOS
	private final char TIPO_DE_CABEZA;
	private final int LONGITUD;
	private final int CANTIDAD_DE_ROSCA;
	private int posicionActual;
	
	//CONSTRUCTOR
	public Tornillo(char tipoDeCabeza, int longitud, int cantidadDeRoscas) {
		this.posicionActual = 0;
		this.TIPO_DE_CABEZA = tipoDeCabeza;
		this.LONGITUD = longitud;
		this.CANTIDAD_DE_ROSCA = cantidadDeRoscas;
	}

	//GETS&SETS
	public char getTIPO_DE_CABEZA() {
		return TIPO_DE_CABEZA;
	}

	public int getLONGITUD() {
		return LONGITUD;
	}

	public int getCANTIDAD_DE_ROSCA() {
		return CANTIDAD_DE_ROSCA;
	}
	
	public int getPosicionActual() {
		return posicionActual;
	}

	public void setPosicionActual(int posicionActual) {
		this.posicionActual = posicionActual;
	}

	//METODOS
	public boolean girar(char sentido) {
		boolean sePuedeGirar = false;
		if(sentido == 'A' && this.posicionActual >= 0) {//desatornillar
				this.posicionActual--;
				sePuedeGirar = true;
		} else if(sentido == 'H') {//atornillar
				this.posicionActual++;
				sePuedeGirar = true;
		}
		return sePuedeGirar;
	}
	
}
