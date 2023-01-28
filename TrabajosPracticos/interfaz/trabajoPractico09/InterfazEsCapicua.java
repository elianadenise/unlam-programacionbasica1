package trabajoPractico09;

import java.util.Arrays;
import java.util.Scanner;

public class InterfazEsCapicua {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		String valoresIngresados = "";
		String valoresAlReves = "";
		System.out.println("Ingrese la cantidad de valores final (palabra o numero)");
		int cantidadDeNumeros = entrada.nextInt();
		
		String[] valores = new String[cantidadDeNumeros];
		
		for(int i = 0; i < valores.length; i++) {
			System.out.println("Ingrese el numero de la posicion: " + (i+1));
			valores[i] = entrada.next();
			valoresIngresados += valores[i];
		}
		System.out.println("El valor ingresado es: " + valoresIngresados);
		
		for(int j = valores.length -1; j >= 0; j--) {
			valoresAlReves += valores[j];
		}
		
		System.out.println("El valor ingresado al reves es: " + valoresAlReves);
		System.out.println("El valor es capicua? " + valoresIngresados.equals(valoresAlReves));
	
	}

}
