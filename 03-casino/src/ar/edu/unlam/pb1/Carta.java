package ar.edu.unlam.pb1;

public class Carta {
	private int codigo; 
	private Palo palo;
	private Figura figura; 
	
	public Carta(int codigo, Palo palo, Figura figura) {
		this.codigo = codigo;
		this.palo = palo;
		this.figura = figura;
	}
	
	public int getValor() {
		/*
		 * Debe retornar el valor asociado a la figura
		 */
		
		int valor = 0;
		switch(this.figura) {
		case AS: 
			valor = 1;
			break;
		case DOS:
			valor = 2;
			break;
		case TRES: 
			valor = 3;
			break;
		case CUATRO:
			valor = 4;
			break;
		case CINCO:
			valor = 5;
			break;
		case SEIS:
			valor = 6;
			break;
		case SIETE:
			valor = 7;
			break;
		case OCHO:
			valor = 8;
			break;
		case NUEVE:
			valor = 9;
			break;
		case DIEZ:
			valor = 10;
			break;
		case J:
			valor = 10;
			break;
		case Q:
			valor = 10;
			break;
		case K:
			valor = 10;
			break;
			
		}
		
		/*
		if(this.figura.equals(Figura.AS)) {
			valor = 1;
		} else if(this.figura.equals(Figura.DOS)) {
			valor = 2;
		} else if(this.figura.equals(Figura.TRES)) {
			valor = 3;
		} else if(this.figura.equals(Figura.CUATRO)) {
			valor = 4;
		} else if (this.figura.equals(Figura.CINCO)) {
			valor = 5;
		} else if(this.figura.equals(Figura.SEIS)) {
			valor = 6;
		} else if(this.figura.equals(Figura.SIETE)) {
			valor = 7;
		} else if(this.figura.equals(Figura.OCHO)) {
			valor = 8;
		} else if(this.figura.equals(Figura.NUEVE)) {
			valor = 9;
		} else if(this.figura.equals(Figura.DIEZ) || this.figura.equals(Figura.J) || this.figura.equals(Figura.Q) || this.figura.equals(Figura.K)) {
			valor = 10;
		}*/
		
		return valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Palo getPalo() {
		return palo;
	}

	public void setPalo(Palo palo) {
		this.palo = palo;
	}

	public Figura getFigura() {
		return figura;
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
	}	
	
	public String toString() {
		return "Palo: " + this.palo + "; Figura: " + this.figura;
	}
}
