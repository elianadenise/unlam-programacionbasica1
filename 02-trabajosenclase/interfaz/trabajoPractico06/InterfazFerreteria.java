package trabajoPractico06;

import java.util.Scanner;

public class InterfazFerreteria {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println(" ----------------------------------------------- ");
		System.out.println("| Bienvenido a la ferreteria                    |");
		System.out.println(" ----------------------------------------------- ");
		System.out.println("| ------------eleccion del tornillo------------ |");
		System.out.println("| 1° ingresar el tipo de cabeza del tornillo    |");
		System.out.println("| P: Plana                                      |");
		System.out.println("| H: Phillips                                   |");
		System.out.println("| A: Allen                                      |");		
		char cabezaTornillito;
		do {
			cabezaTornillito = entrada.next().charAt(0);
			eleccionDeCabeza(cabezaTornillito);
		}while((cabezaTornillito != 'P') && (cabezaTornillito != 'p') && (cabezaTornillito != 'H') && (cabezaTornillito != 'h') && (cabezaTornillito != 'A') && (cabezaTornillito != 'a'));
		System.out.println("| 2° ingresar la longitud del tornillo          |");
		int longitudTornillito = entrada.nextInt();
		System.out.println("| 3° ingresar la cantidad de rosaca del tornillo|");
		int roscaTornillito = entrada.nextInt();
		Tornillo tornillito = new Tornillo(cabezaTornillito, longitudTornillito, roscaTornillito);
		
		System.out.println(" ----------------------------------------------- ");
		System.out.println("|-----------eleccion del destornillador---------|");
		System.out.println("| debe elegir el tipo de cabeza                 |");
		System.out.println("| debe ser la misma cabeza que el tonillo       |");
		System.out.println("| P: Plana                                      |");
		System.out.println("| H: Phillips                                   |");
		System.out.println("| A: Allen                                      |");		
		char cabezaDestornilladorcito;
		do {
			cabezaDestornilladorcito = entrada.next().charAt(0);
			eleccionDeCabeza(cabezaDestornilladorcito);
		}while((cabezaDestornilladorcito != 'P') && (cabezaDestornilladorcito != 'p') && (cabezaDestornilladorcito != 'H') && (cabezaDestornilladorcito != 'h') && (cabezaDestornilladorcito != 'A') && (cabezaDestornilladorcito != 'a'));
		
		Destornillador destornilladorcito = new Destornillador(cabezaDestornilladorcito);
		
		System.out.println(" ----------------------------------------------- ");
		System.out.println("|--------------eleccion del tarugo--------------|");
		System.out.println("| debe elegir la longitud                       |");
		System.out.println("| debe ser la misma longitud que el tonillo     |");
		int longitudTaruguito = entrada.nextInt();
		Tarugo taruguito = new Tarugo(longitudTaruguito);
		System.out.println(" ----------------------------------------------- ");

		atornillar(entrada, tornillito, destornilladorcito, taruguito, longitudTornillito, longitudTaruguito);
		desatornillar(entrada, tornillito, destornilladorcito, taruguito, longitudTornillito, longitudTaruguito);
		
	}

	public static void atornillar(Scanner entrada, Tornillo tornillo, Destornillador destornillador, Tarugo tarugo, int longitudTornillo, int longitudTarugo) {
		char opcion = '\u0000';
		do {
			if((longitudTarugo == longitudTornillo) && (tornillo.getTIPO_DE_CABEZA() == destornillador.getTIPO_DE_CABEZA())) {
				
				System.out.println("opciones de accion: \nA: atornillar manual \nB: atornillar c/ tarugo");

				opcion  = entrada.next().charAt(0);
				
				switch(opcion) {
				case 'a':
				case 'A':
					tornillo.girar('H');
					destornillador.atornillar(tornillo);
					System.out.println("La posicion actual del tornillo es: " + tornillo.getPosicionActual());
					break;
				case 'b':
				case 'B':
					tornillo.girar('H');
					destornillador.atornillar(tornillo, tarugo);
					System.out.println("La posicion actual del tornillo es: " + tornillo.getPosicionActual());
					break;
				default:
					System.out.println("ingrese una opcion valida.");
					break;
				}
			}
		} while ((opcion != 'a') && (opcion != 'A') && (opcion != 'b') && (opcion != 'B'));
		
	}
	
	public static void desatornillar(Scanner entrada, Tornillo tornillo, Destornillador destornillador, Tarugo tarugo, int longitudTornillo, int longitudTarugo) {
		char opcion = '\u0000';
		do { //CREO QUE NO ESTA BIEN ESTO, VER LAS CONDICIONES ONDA NADA QUE VER. 
			if((longitudTarugo == longitudTornillo) && (tornillo.getTIPO_DE_CABEZA() == destornillador.getTIPO_DE_CABEZA())) {
				System.out.println(" ----------------------------------------------- ");
				System.out.println("opciones de accion: \nA: destornillar manual \nB: desatornillar c/ tarugo");

				opcion = entrada.next().charAt(0);
				
				switch(opcion) {
				case 'a':
				case 'A':
					tornillo.girar('A');
					destornillador.desatornillar(tornillo);
					System.out.println("La posicion actual del tornillo es: " + tornillo.getPosicionActual());
					break;
				case 'b':
				case 'B': 
					tornillo.girar('A');
					destornillador.desatornillar(tornillo, tarugo);
					System.out.println("La posicion actual del tornillo es: " + tornillo.getPosicionActual());
					break;
				default:
					System.out.println("ingrese una opcion valida.");
					break;
				}
			}
		} while ((opcion != 'a') && (opcion != 'A') && (opcion != 'b') && (opcion != 'B'));
	}

	public static void eleccionDeCabeza(char valor) {
		switch(valor) {
		case 'P':
		case 'p':
		case 'H':
		case 'h':
		case 'A':
		case 'a':
			break;
		default:
				System.out.println("Elija un valor válido.");
		}
	}

}
