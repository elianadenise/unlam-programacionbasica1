package trabajoPractico09;

import java.util.Scanner;

public class InterfazEjecicioDeClase {

	public static void main(String[] args) {
		
		double numeroAleatorio [];
		System.out.println("Numeros aleatorios Double:");
		numeroAleatorio = new double [10];
		for(int i = 0; i < numeroAleatorio.length; i++) {
			System.out.println("Numero aleatorio " + i);
			numeroAleatorio[i] = (Math.random()*100); //del 0 al 99
			System.out.println(numeroAleatorio[i]);
		}		
	
		System.out.println("---------------------------");
		
		int numeroAleatorioEntero [];
		System.out.println("Numeros aleatorios Enteros:");
		numeroAleatorioEntero = new int [10];
		for(int i = 0; i < numeroAleatorioEntero.length; i++) {
			System.out.println("Numero aleatorio " + (i+1));
			numeroAleatorioEntero[i] = (int) (Math.random()*100+1);//del 1 a 99
			System.out.println(numeroAleatorioEntero[i]);
		}
	}
}
