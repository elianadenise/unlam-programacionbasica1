package trabajoPractico04;

public class Letra {

	//ATRIBUTOS
	private char letra;
	
	//CONSTRUCTOR
	public Letra() {
		
	}
	
	public Letra(char letra) {
		this.letra = letra;
	}

	//GET&SET
	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	//METODOS
	public boolean esVocal() {
		switch(this.letra) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;
		}
		return false;
	}
}
