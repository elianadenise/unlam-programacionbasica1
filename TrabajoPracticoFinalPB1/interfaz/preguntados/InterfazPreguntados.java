package preguntados;
//Estudiantes: Alonso Reyes, Ornella; Navarro, Eliana.

import java.util.Scanner;
import preguntados.Categoria;

public class InterfazPreguntados {

public static void main(String[] args) {	
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("- - Bienvenido a preguntados - -");
		
		System.out.println("Ingrese el nombre del jugador uno:");
		Preguntados jugadorUno = new Preguntados(entrada.next());
		
		System.out.println("Ingrese el nombre del jugador dos:");
		Preguntados jugadorDos = new Preguntados(entrada.next());
	
		do {
			jugar(entrada, jugadorUno);
			jugar(entrada, jugadorDos);
			System.out.println(jugadorUno);
			System.out.println(jugadorDos);
		}while(!jugadorUno.gano() && !jugadorDos.gano());
		
		if(jugadorUno.gano()) {
			System.out.println("Ha ganado " + jugadorUno.getNombreJugador());
		} else if(jugadorDos.gano()) {
			System.out.println("Ha ganado " + jugadorDos.getNombreJugador());
		} else if(jugadorUno.gano() && jugadorDos.gano()) {
			System.out.println("Se declara empate");
		}
		
	}

	public static void jugar(Scanner entrada, Preguntados jugador) { // tiene q ser aleatorio
		
		System.out.println(jugador.getNombreJugador() + " la categoria que le toco es: ");
		Categoria opcionElegida;
		Categoria opcionesDisponibles[] = Categoria.values();
		opcionElegida = opcionesDisponibles[(int) (Math.random()*6)];
		System.out.println(" . . . ");
		switch(opcionElegida) {
		case ENTRETENIMIENTO:
			System.out.println("- ENTRETENIMIENTO -");
			Pregunta entretenimiento = jugador.preguntaPorCategoria(jugador.getCategoriaEntretenimiento());
			System.out.println(entretenimiento);
			System.out.println("Ingrese la opcion:");
			int opcionEntretenimiento = entrada.nextInt()-1;
			if(entretenimiento.getPosibles()[opcionEntretenimiento].isCorrecta() == true) {
				if(jugador.agregarACoronas(entretenimiento)) {
					System.out.println(jugador.getNombreJugador() + " ha ganado la corona de Entretenimiento.");
				} else {
					System.out.println("No se puede agregar la corona porque la habia ganado anteriormente.");
				} 
			}	else {
				System.out.println("Opcion incorrecta");
			}
			
			break;
		case GEOGRAFIA:
			System.out.println("- GEOGRAFIA -");
			Pregunta geografia = jugador.preguntaPorCategoria(jugador.getCategoriaGeografia());
			System.out.println(geografia);
			System.out.println("Ingrese la opcion:");
			int opcionGeografia = entrada.nextInt()-1;
			if(geografia.getPosibles()[opcionGeografia].isCorrecta() == true) {
				if(jugador.agregarACoronas(geografia)) {
					System.out.println(jugador.getNombreJugador() + " ha ganado la corona de Geografia.");
				} else {
					System.out.println("No se puede agregar la corona porque la habia ganado anteriormente.");
					}
				}	else {
				System.out.println("Opcion incorrecta");
			}
			
			break;
		case CIENCIA:
			System.out.println("- CIENCIA -");
			Pregunta ciencia = jugador.preguntaPorCategoria(jugador.getCategoriaCiencia());
			System.out.println(ciencia);
			System.out.println("Ingrese la opcion:");
			int opcionCiencia = entrada.nextInt()-1;
			if(ciencia.getPosibles()[opcionCiencia].isCorrecta() == true) {
				if(jugador.agregarACoronas(ciencia)) {
				System.out.println(jugador.getNombreJugador() + " ha ganado la corona de Ciencia.");
			} else {
				System.out.println("No se puede agregar la corona porque la habia ganado anteriormente.");
				}
			}	else {
				System.out.println("Opcion incorrecta");
			}
			break;
		case HISTORIA:
			System.out.println("- HISTORIA -");
			Pregunta historia = jugador.preguntaPorCategoria(jugador.getCategoriaHistoria());
			System.out.println(historia);
			System.out.println("Ingrese la opcion:");
			int opcionHistoria = entrada.nextInt()-1;
			if(historia.getPosibles()[opcionHistoria].isCorrecta() == true) {
				if(jugador.agregarACoronas(historia)) {
					System.out.println(jugador.getNombreJugador() + " ha ganado la corona de Historia.");
				} else {
					System.out.println("No se puede agregar la corona porque la habia ganado anteriormente.");
				}
			} else {
				System.out.println("Opcion incorrecta");
			}
			break;
		case DEPORTE:
			System.out.println("- DEPORTE -");
			Pregunta deporte = jugador.preguntaPorCategoria(jugador.getCategoriaDeporte());
			System.out.println(deporte);
			System.out.println("Ingrese la opcion:");
			int opcionDeporte = entrada.nextInt()-1;
			if(deporte.getPosibles()[opcionDeporte].isCorrecta() == true) {
				if(jugador.agregarACoronas(deporte)) {
					System.out.println(jugador.getNombreJugador() + " ha ganado la corona de Deporte.");
				} else {
					System.out.println("No se puede agregar la corona porque la habia ganado anteriormente.");
					} 
			} else {
				System.out.println("Opcion incorrecta");
			}
			
			break;
		case ARTE: 
			System.out.println("- ARTE -");
			Pregunta arte = jugador.preguntaPorCategoria(jugador.getCategoriaArte());
			System.out.println(arte);
			System.out.println("Ingrese la opcion:"); 
			int opcionArte = entrada.nextInt()-1;
			if(arte.getPosibles()[opcionArte].isCorrecta() == true) {
				if(jugador.agregarACoronas(arte)) {
					System.out.println(jugador.getNombreJugador() + " ha ganado la corona de Arte.");
				} else {
					System.out.println("No se puede agregar la corona porque la habia ganado anteriormente.");
					} 
				} else {
					System.out.println("Opcion incorrecta");
				}
			
			break;
			}
		}
	

}
