package institucionEducativa;

import java.util.Scanner;

public class InstitucionEducativa {

	private static final int MENU_DOCENTE_INGRESAR_PERSONA = 1, MENU_DOCENTE_MOSTRAR_PERSONA_POR_DNI = 2,
			MENU_DOCENTE_RECUPERAR_NOTA_PERSONA = 3, MENU_DOCENTE_PERSONAS_PROMOCIONARON = 4,
			MENU_DOCENTE_PROMEDIO_NOTA_2_PERSONAS_CURSARON = 5, MENU_PERSONA_VER_INFORMACION_MATERIA = 1, SALIR = 9;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		mostrarMensaje("Bienvenido a la comision turno M");
		Comision turnoM = new Comision();

		boolean sesionIniciada = false;
		Integer dni = null;
		String contrasenia = "";
		Boolean esDocente = false;

		do {
			mostrarMensaje("\nIngrese DNI para iniciar sesion.");
			dni = teclado.nextInt();

			mostrarMensaje("\nIngrese contrasenia");
			contrasenia = teclado.next();

			mostrarMensaje("\nEs docente?");
			char letra = teclado.next().charAt(0);
			esDocente = letra == 'S' || letra == 's';

			sesionIniciada = turnoM.iniciarSesion(dni, contrasenia, esDocente);

			if (!sesionIniciada) {
				mostrarMensaje("\nDNI o contrasenia incorrectos.");
			} else {
				mostrarPantalla(turnoM, dni, esDocente);
				sesionIniciada = false;
			}

		} while (!sesionIniciada);

	}

	private static void mostrarPantalla(Comision turnoM, Integer dni, Boolean esDocente) {
		int opcion = 0;

		if (esDocente) {
			do {
				mostrarMenuDocente();

				opcion = teclado.nextInt();
				Persona persona = null;
				boolean exito = false;

				switch (opcion) {
				case MENU_DOCENTE_INGRESAR_PERSONA:
					System.out.println("-INGRESAR ESTUDIANTE AL SISTEMA-");
					System.out.println("Nombre:");
					String nombre = teclado.next();
					System.out.println("Apellido:");
					String apellido = teclado.next();
					System.out.println("DNI:");
					Integer dniest = teclado.nextInt();
					System.out.println("Carrera: 1. Web, 2. Mobile");
					Carrera disponible [] = Carrera.values();
					Carrera elegida = disponible[teclado.nextInt()-1];
					System.out.println("Nota primer parcial:");
					Double nota1 = teclado.nextDouble();
					System.out.println("Nota segundo parcial:");
					Double nota2 = teclado.nextDouble();
					
					Nota primerParcial = new Nota((nombre+ " " +apellido), nota1, true);
					Nota segundoParcial = new Nota((nombre+ " " +apellido), nota2, false);

					persona = new Persona(nombre, apellido, dniest, elegida, primerParcial, segundoParcial);
					exito = turnoM.ingresarPersona(persona);

					if (exito) {
						mostrarMensaje("\nPersona ingresada correctamente!");
					} else {
						mostrarMensaje("\nNo fue posible ingresar la persona");
					}
					break;
				case MENU_DOCENTE_MOSTRAR_PERSONA_POR_DNI:
					System.out.println("-MOSTRAR PERSONA POR DNI-");
					mostrarMensaje("\nIngrese DNI de la persona");
					Integer dniBuscado = teclado.nextInt();
					Persona personaBuscada = turnoM.buscarPorDni(dniBuscado);
					if (personaBuscada != null) {
						mostrarMensaje("\nPersona: " + personaBuscada.toString());
					} else {
						mostrarMensaje("\nPersona no encontrada");
					}
					break;
				case MENU_DOCENTE_RECUPERAR_NOTA_PERSONA:
					System.out.println("-RECUPERAR NOTA-");
					mostrarMensaje("\nIngrese DNI de la persona");
					dni = teclado.nextInt();
					System.out.println("Recupera: 1. Primer parcial, 2. Segundo parcial.");
					int parcial = teclado.nextInt();
					Boolean esPrimerParcial = null;
					if(parcial == 1) {
						esPrimerParcial = true;
					} else {
						esPrimerParcial = false;
					}
					mostrarMensaje("\nIngrese Nota de la persona");
					Double notaIngresada = teclado.nextDouble();

					
					Nota nota = new Nota("recuperatorio", notaIngresada, esPrimerParcial);

					exito = turnoM.recuperarNota(dni, nota);
					if (exito) {
						mostrarMensaje("\nNota recuperada correctamente!");
					} else {
						mostrarMensaje("\nNo fue posible recuperar la nota");
					}
					break;
				case MENU_DOCENTE_PERSONAS_PROMOCIONARON:
					System.out.println("-PERSONAS QUE PROMOCIONARON-");
					System.out.println("Ingrese la carrera: 1. Web, 2. Mobile.");
					Carrera disponibles [] = Carrera.values();
					Carrera carrera = disponibles[teclado.nextInt()-1];
					Persona[] personasPromocion = turnoM.obtenerPersonasDeLaCarreraQuePromocionaron(carrera);
					mostrarPersonas(personasPromocion);
					break;
				case MENU_DOCENTE_PROMEDIO_NOTA_2_PERSONAS_CURSARON:
					Double promedio = turnoM.obtenerElPromedioDeNota2DeLasPersonasQueCursaron();
					mostrarMensaje(
							"\nEl promedio de segundo parcial de personas que cursaron es: " + Math.round(promedio));
					break;
				case SALIR:
					break;
				}

			} while (opcion != SALIR);

		} else {
			do {
				mostrarMenuPersona();
				opcion = teclado.nextInt();
				switch (opcion) {
				case MENU_PERSONA_VER_INFORMACION_MATERIA:
					Persona persona = turnoM.buscarPorDni(dni);
					if (persona != null) {
						mostrarMensaje("\nPersona: " + persona.toString());
					}else {
						mostrarMensaje("\nOoops, algo salio mal.");
					}
					break;
				case SALIR:
					break;

				}
			} while (opcion != SALIR);
		}

	}

	private static void mostrarMenuDocente() {
		mostrarMensaje("\nBienvenido al menu de docentes. ¿Que desea hacer?");
		mostrarMensaje("\n\n" + MENU_DOCENTE_INGRESAR_PERSONA + " - Para ingresar una persona.");
		mostrarMensaje("\n" + MENU_DOCENTE_MOSTRAR_PERSONA_POR_DNI + " - Para buscar una persona por DNI.");
		mostrarMensaje("\n" + MENU_DOCENTE_RECUPERAR_NOTA_PERSONA + " - Para recuperar la nota de una persona.");
		mostrarMensaje("\n" + MENU_DOCENTE_PERSONAS_PROMOCIONARON
				+ " - Para recuperar visualizar las personas que promocionaron.");
		mostrarMensaje("\n" + MENU_DOCENTE_PROMEDIO_NOTA_2_PERSONAS_CURSARON
				+ " - Para ver el promedio de la nota 2 de personas que cursaron.");
		mostrarMensaje("\n" + SALIR + " - Para salir.");
	}

	private static void mostrarMenuPersona() {
		mostrarMensaje("\nBienvenido al menu de personas. ¿Que desea hacer?");
		mostrarMensaje("\n\n" + MENU_PERSONA_VER_INFORMACION_MATERIA + " - Para ver su informacion de la materia.");
		mostrarMensaje("\n" + SALIR + " - Para salir.");
	}

	/**
	 * Muestra la informacion de las personas en un array
	 * 
	 * @param personas Personas que se mostraran
	 * 
	 * Debe proporcionar el codigo necesario para que funcione correctamente
	 * 
	 */
	public static void mostrarPersonas(Persona[] personas) {
		for(int i = 0; i < personas.length; i++) {
			if(personas[i] != null) {
				System.out.println(personas[i] + "\n--------------" + "\n");
			}
		}
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

}
