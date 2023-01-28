package ar.edu.unlam.pb1;

import java.util.Scanner;

public class Casino {
	private static final int CREAR_NUEVO_JUEGO = 1;
	private static final int ORDENAR_MAZO = 2;
	private static final int JUGAR = 3;
	private static final int SALIR = 9;
	
	public static void main(String[] args) {
		int opcionIngresada = 0;
		Scanner teclado = new Scanner(System.in);
		BlackJack actual = null;
		// TODO Auto-generated method stub
		BlackJack.inicializarCartasDisponibles();
		do {
			mostrarMenu();
			opcionIngresada  = teclado .nextInt();
			actual = determinarAccionARealizar(actual, opcionIngresada, teclado);
		}while (opcionIngresada!=9);
	}

	private static void mostrarMenu() {
		// TODO Auto-generated method stub
		System.out.println("Bienvenidos al Casino");
		System.out.println("1. Crear nuevo juego");
		System.out.println("2. Ordenar y mostrar mazo de cargas");
		System.out.println("3. Jugar");
	}
	
	private static BlackJack determinarAccionARealizar(BlackJack actual, int opcionIngresada, Scanner teclado) {
		
		switch(opcionIngresada) {
			case CREAR_NUEVO_JUEGO:
				actual = new BlackJack();
				break;
			case ORDENAR_MAZO:
				actual.ordenar();
				break;
			case JUGAR:
				actual.mezclar();
				char respuesta = 'S';
				
				while((respuesta == 's' || respuesta == 'S' || actual.perdio()) && respuesta != 'n') {//sume el 'n' para que corte, porque sino seguia pidiendo la carta
					System.out.println(actual.toString());
					System.out.println("Su carta actual es: " + actual.siguiente());
					System.out.println("Desea sacar una nueva carta?");
					respuesta = teclado.next().charAt(0);
				}
				actual.jugarGrupier();
				System.out.println(actual.toString());
				if(actual.gano()) {
					System.out.println("Felicitaciones. Ganó");
				}
				else {
					System.out.println("Ganó la banca");
				}
				break;
			case SALIR:
				break;
			}
		return actual;
	}
}
