package trabajoPractico09;
//TP 09 - ACT 03
import java.util.Arrays;
import java.util.Scanner;

public class InterfazLetrasArray {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int cantidadDePosiciones = 0;
		while(cantidadDePosiciones != (-1)) {//al pedo pues nunca va a poder recibir un -1 porque es negativo
			System.out.println(" ");
			System.out.println("-------------------------------------------");
			System.out.println("Ingrese la cantidad de posiciones del array");
			cantidadDePosiciones = entrada.nextInt();
			char letras[] = new char [cantidadDePosiciones];
			
			for(int i = 0; i < letras.length; i++) {
				System.out.println("-----------------------");
				System.out.println("Letra en caracter " + (i+1));
				letras[i] = (char) entrada.nextInt();
				String cadena = String.valueOf(letras[i]);
				System.out.println("La letra ingresada por tabla Ascii es: " + cadena);
				System.out.println("La palabra formada es: " + Arrays.toString(letras));
			}
			
			//o 
			System.out.println("La Palabra formada es:");
			for(int i = 0; i < letras.length; i++) {
				System.out.print(letras[i]);
			}
			
		}	
	}
}
