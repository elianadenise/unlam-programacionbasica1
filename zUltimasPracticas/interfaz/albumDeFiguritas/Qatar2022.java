package albumDeFiguritas;

import java.util.Scanner;

import albumDeFiguritas.Album;
import albumDeFiguritas.Figurita;

public class Qatar2022 {
private static final int ACTUALIZAR_DATOS_FIGURITA = 1, COMPRAR_SOBRE = 2, VISUALIZAR_FIGURITAS_ACTUALES = 3, CALCULAR_PORCENTAJE_DE_COMPLETADO = 4, SALIR = 9;
	
	public static void main(String[] args) {
		Album actual = new Album();
		Album.inicializarCodigosDeFiguritas();
		
		int opcionIngresada;
		Scanner teclado = new Scanner(System.in);

		System.out.println("Bienvenido album de figuritas Panini Virtual");

		do {
			mostrarMenu();
			opcionIngresada = teclado.nextInt();
			actual = determinarAccionARealizar(actual, opcionIngresada, teclado);
		}while (/*!actual.elAlbumEstaCompleto()*/ opcionIngresada != SALIR);
	}

	private static void mostrarMenu() {
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println(ACTUALIZAR_DATOS_FIGURITA + " - Actualizar datos de la figurita");
		System.out.println(COMPRAR_SOBRE + " - Comprar sobre ");
		System.out.println(VISUALIZAR_FIGURITAS_ACTUALES + " - Visualizar figuritas actuale");
		System.out.println(SALIR + " - Salir");
		System.out.println("************************");
	}

	private static Album determinarAccionARealizar(Album actual, int opcionIngresada, Scanner teclado) {

		switch(opcionIngresada) {
		case ACTUALIZAR_DATOS_FIGURITA:
			actualizardatosFigurita(teclado, actual);
			break;
		case COMPRAR_SOBRE:
			comprarSobre(teclado, actual);
			break;
		case VISUALIZAR_FIGURITAS_ACTUALES:
			visualizarFiguritasActuales(teclado, actual);
			break;
		case CALCULAR_PORCENTAJE_DE_COMPLETADO:
			calcularElPorcentajeDeCompletado(teclado, actual);
			break;
		case SALIR:
			break;
		}
		return actual;
	}

	private static void actualizardatosFigurita(Scanner teclado, Album actual) {
		String codigo;
		char grupo;
		String seleccion;
		String nombreJugador;
		double valor;
		Figurita aActualizar;

		System.out.println("***************");
		System.out.println("Actualizar datos de figurita");
		System.out.println("***************"); 

		System.out.println("Ingrese el codigo a actualizar");
		codigo = teclado.next();
		aActualizar = actual.getFigurita(codigo);
		
		System.out.println("Selecci�n: " + aActualizar.getSeleccion());
		
		System.out.println("Ingrese el grupo al que pertenece la selecci�n");
		grupo = teclado.next().charAt(0);
		System.out.println("Ingrese el nombre del jugador");
		nombreJugador = teclado.next();
		System.out.println("Ingrese el valor");
		valor = teclado.nextDouble();

		Album.actualizarDatosFigurita(codigo, grupo, nombreJugador, valor);
	}

	private static void comprarSobre(Scanner teclado, Album actual) {
		Figurita compradas[] = actual.comprarSobre();
		
		System.out.println("Las figuritas son");

		/*
		 * Mostrar las figuritas obtenidas
		 */
		for(int i = 0; i < compradas.length; i++) {
			if(compradas[i] != null) {
				System.out.println(compradas[i].getCodigo() +"\n");
				actual.agregarFigurita(compradas[i]);
			}
		}
		/* 
		 * Por cada figuria comprada, agregarlas al album actual actual.agregarFigurita(compradas[i]);
		 */
		
	}
	
	private static void visualizarFiguritasActuales(Scanner teclado, Album actual) {
		/*
		 * Se deben mostrar las figuritas que posee el usuario de manera ordenada.
		 */
		actual.ordenarFiguritasActuales();
		for(int i = 0; i < actual.getFiguritasActuales().length; i++) {
			if(actual.getFiguritasActuales()[i] != null) {
				System.out.println(actual.getFiguritasActuales()[i].getCodigo());
			}
		}
	}
	
	private static void calcularElPorcentajeDeCompletado(Scanner teclado, Album actual) {
		System.out.println("El album est� completo en un " + actual.calcularPorcentajeCompletado() + "%");
	}
}
