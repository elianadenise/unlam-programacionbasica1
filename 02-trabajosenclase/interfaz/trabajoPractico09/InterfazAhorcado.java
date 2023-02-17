
package trabajoPractico09;

import java.util.Scanner;
import java.util.Arrays;

public class InterfazAhorcado {

	public static void main(String[] args) {
		
		double inversion = 100;
		double interes = 1.1;
		int anios = 0;
		double calculo_interes = 0;
		while (anios < 7) {
		    calculo_interes = inversion * interes;
		    inversion =  calculo_interes;
		    anios += 1;
		    System.out.println("Saldo total al final del año: "+ anios+ " es de: $"+ calculo_interes);
		    System.out.println(inversion);
		    System.out.println(calculo_interes);
		}
		
		
		Scanner entrada = new Scanner (System.in);
	        
		Ahorcado jugadorUno = new Ahorcado("Elo");
		Ahorcado jugadorDos = new Ahorcado("Orne");
	        
		jugar(entrada, jugadorUno);
		jugar(entrada, jugadorDos);
		/*bienvenidoAlAhorcado(entrada, jugadorUno);
		bienvenidoAlAhorcado(entrada, jugadorDos);
		bienvenidoAlAhorcado(entrada, jugadorUno);
		bienvenidoAlAhorcado(entrada, jugadorDos);*/
		
		if(jugadorUno.puntaje() > jugadorDos.puntaje()) {
			System.out.println(jugadorUno.getNombreJugador() + " HA GANADO EL JUEGO");
		} else if(jugadorUno.puntaje() < jugadorDos.puntaje()) {
			System.out.println(jugadorDos.getNombreJugador() + " HA GANADO EL JUEGO");
		} else { 
			System.out.println("SE DECLARA UN EMPATE");
		}

	}

	public static void jugar(Scanner entrada, Ahorcado nuevo) {
		System.out.println("Bienvenidx " + nuevo.getNombreJugador() +" al juego, su palabra a adivinar es:");
		nuevo.seleccionarPalabra();
		nuevo.arrayDeGuiones();
		System.out.println(Arrays.toString(nuevo.getLetrasAcertadas()));
		nuevo.cambioAcaracter();		

		char letra;
		char opcionElegida;
		String palabraArriesgada;

		do {			
			arriesgarLetra(entrada, nuevo);
			
			arriesgarPalabra(entrada, nuevo);
			
			cantidadDeFallos(nuevo);
			
			System.out.println("Puntaje actual de " + nuevo.getNombreJugador() + " es: " + nuevo.puntaje());	
			
		}while((nuevo.getCantidadDeFallos() < nuevo.getCANTIDAD_MAXIMA_DE_FALLOS()) && nuevo.isPalabraCompleta() == false);
	}

	public static void cantidadDeFallos(Ahorcado nuevo) {
		if(nuevo.getCantidadDeFallos() == nuevo.getCANTIDAD_MAXIMA_DE_FALLOS()){
			System.out.println("Llegaste a la cantidad maxima de fallos. \n*estas ahorcado*");
		}
	}

	public static void arriesgarPalabra(Scanner entrada, Ahorcado nuevo) {
		char opcionElegida;
		String palabraArriesgada;
		if((nuevo.getCantidadDeFallos() < nuevo.getCANTIDAD_MAXIMA_DE_FALLOS()) && (nuevo.isPalabraCompleta() == false)) {
			System.out.println("Desea arriesgar la palabra?\ns = si,\nn = no.");
			opcionElegida = entrada.next().charAt(0);
			
			if(opcionElegida == 's') {
				System.out.println("Ingrese la palabra que desea arriesgar:");
				palabraArriesgada = entrada.next();
				nuevo.palabraArriesgada(palabraArriesgada);
				System.out.println("La palabra es correcta? " + nuevo.isPalabraCompleta());
				if(nuevo.isPalabraCompleta() == true) {
					System.out.println("Te salvaste de ser ahorcado! Ganaste!");
				} else {
					System.out.println("Arriesgo mal");
					System.out.println("Contador de fallos: " + nuevo.getCantidadDeFallos());
				}
			}
		}
	}

	public static void arriesgarLetra(Scanner entrada, Ahorcado nuevo) {
		char letra;
		System.out.println("Arriesgue una letra:");
		letra = entrada.next().charAt(0);
		nuevo.letraAcertada(letra);
		System.out.println(Arrays.toString(nuevo.getLetrasAcertadas()));
		System.out.println("La palabra es correcta? " + nuevo.isPalabraCompleta());
		System.out.println("Contador de fallos: " + nuevo.getCantidadDeFallos());
	}
}
