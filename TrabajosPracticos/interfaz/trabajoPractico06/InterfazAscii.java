package trabajoPractico06;

import java.util.Scanner;

//TP 06 - ACT 03
public class InterfazAscii {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Que desea imprimir en la consola? "
				+ "\n1 = caracteres numericos \n2 = letras minusculas \n3 = letras mayusculas \n4 = caracteres especiales");
		
		byte opcion = entrada.nextByte();
		
		switch(opcion) {
		case 1:
			int caracter = 47;
			System.out.println("Caracteres numericos:");
			while(caracter < 57) {
				caracter++;
				char aCaracter = (char) caracter;
				System.out.println("Alt + " + caracter + " = " + aCaracter);
			}	
			break;
		case 2:
			int caracterDos = 96;
			System.out.println("Letras minuscula:");
			while(caracterDos < 122) {
				caracterDos++;
				char aCaracter = (char) caracterDos;
				System.out.print("Alt + " + caracterDos + " = " + aCaracter + ", ");
			}
			break;
		case 3: 
			int caracterTres = 65;
			System.out.println("Letras mayuscula:");
			while(caracterTres < 90) {
				caracterTres++;
				char aCaracter = (char) caracterTres;
				System.out.print("Alt + " + caracterTres + " = " + aCaracter + ", ");
			}
			break;
		case 4:
			int caracterCuatro = 128;
			System.out.println("Caracteres especiales:");
			while(caracterCuatro < 166) {
				caracterCuatro++;
				char aCaracter = (char) caracterCuatro;
				System.out.print("Alt + " + caracterCuatro + " = " + aCaracter + ", ");
			}
			break;
		default:
			System.out.println("Introduzca un valor valido.");
		}

	}

}
