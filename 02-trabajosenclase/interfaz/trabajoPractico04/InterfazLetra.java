package trabajoPractico04;

import java.util.Scanner;

public class InterfazLetra {

	public static void main(String[] args) {
		 Scanner entrada = new Scanner(System.in);
		 System.out.println("Ingrese una letra:");
		 char letra = entrada.next().charAt(0);
		 Letra letrita = new Letra(letra);
		 System.out.println("La letra ingresada es vocal? " + letrita.esVocal());
	}

}
