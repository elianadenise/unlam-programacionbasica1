package trabajoPractico03;

import java.util.Scanner;

import trabajoPractico03.Cerradura;

//TP 3 - ACT 8
public class InterfazCerradura {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese la clave de apertura que usara desde un inicio:");
		int claveDeApertura = entrada.nextInt();
		
		Cerradura puertita = new Cerradura(claveDeApertura);
		
		System.out.println("-------pasaron los dias e intenta abrir la puerta------");
		System.out.println("Ingrese la clave para abrir la cerradura:");
		int claveDeAperturaDos = entrada.nextInt();

		if(puertita.abrir(claveDeAperturaDos)) {
			System.out.println("La puerta esta abierta " + puertita.estaAbierta(claveDeAperturaDos));
		} else { 
			System.out.println("--------------------------------------------------------");
			System.out.println("Error! La clave ingresada no es correcta.");
			puertita.cerrar(claveDeAperturaDos);
			System.out.println("Cantidad de fallos actuales: " + puertita.getCantidadDeFallosParaBloqueo());
			System.out.println("La puerta fue bloqueada: " + puertita.fueBloqueada(claveDeAperturaDos));
			
			System.out.println("Ingrese nuevamente la clave:");
			int claveDeAperturaTres = entrada.nextInt();
			if(puertita.abrir(claveDeAperturaTres)) {
				System.out.println("La puerta esta abierta: " + puertita.estaAbierta(claveDeAperturaTres));
			} else {
				puertita.cerrar(claveDeAperturaTres);
				System.out.println("La puerta fue bloqueada: " + puertita.fueBloqueada(claveDeAperturaTres));
				System.out.println("Cantidad de fallos actuales: " + puertita.getCantidadDeFallosParaBloqueo());
				System.out.println("-----debe esperar una hora para volver a intentar-----");
			}			
		}		
	}
}
