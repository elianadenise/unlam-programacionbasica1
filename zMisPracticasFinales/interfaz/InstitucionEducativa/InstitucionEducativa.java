package InstitucionEducativa;

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
					System.out.println("Nombre estudiante: ");
					String nombre = teclado.next();
					System.out.println("Apellido estudiante:");
					String apellido = teclado.next();
					System.out.println("DNI:");
					int dniEstudiante = teclado.nextInt();
					System.out.println("Carrera: 1. Web, 2. Mobile.");
					Carrera opciones[] = Carrera.values();
					Carrera elegida = opciones[teclado.nextInt()-1];
					System.out.println("Nota parcial 1:");
					double parcial1 = teclado.nextInt();
					System.out.println("Nota parcial 2:");
					double parcial2 = teclado.nextInt();
					
					Nota primerParcial = new Nota(nombre, parcial1, true);
					Nota segundoParcial = new Nota(nombre, parcial2, false);
					
					persona = new Persona(apellido, dniEstudiante, elegida, primerParcial, segundoParcial);
					exito = turnoM.ingresarPersona(persona);

					if (exito) {
						mostrarMensaje("\nPersona ingresada correctamente!");
					} else {
						mostrarMensaje("\nNo fue posible ingresar la persona");
					}
					break;
				case MENU_DOCENTE_MOSTRAR_PERSONA_POR_DNI:
					mostrarMensaje("\nIngrese DNI de la persona");
					dni = teclado.nextInt();
					persona = turnoM.buscarPorDni(dni);
					if (persona != null) {
						mostrarMensaje("\nPersona: " + persona.toString());
					} else {
						mostrarMensaje("\nPersona no encontrada");
					}
					break;
				case MENU_DOCENTE_RECUPERAR_NOTA_PERSONA:
					mostrarMensaje("\nIngrese DNI de la persona");
					dni = teclado.nextInt();
					String nombrecito = null;
					mostrarMensaje("\nIngrese Nota de la persona");
					double notaIngresada = teclado.nextInt(); //cambie de Integer a double, lo siento
					
					System.out.println("Cual recupera? 1. Primer parcial, 2. Segundo parcial");
					int parcial = teclado.nextInt();
					boolean primerParcial1;
					if(parcial == 1) {
						primerParcial1 = true;
					} else {
						primerParcial1 = false;
					}
					Nota nota = new Nota(nombrecito, notaIngresada, primerParcial1); 

					exito = turnoM.recuperarNota(dni, nota);
					if (exito) {
						mostrarMensaje("\nNota recuperada correctamente!");
					} else {
						mostrarMensaje("\nNo fue posible recuperar la nota");
					}
					break;
					
					
				case MENU_DOCENTE_PERSONAS_PROMOCIONARON:
					System.out.println("Carrera: 1. Web, 2. Mobile.");
					Carrera opciones2[] = Carrera.values();
					Carrera elegida2 = opciones2[teclado.nextInt()-1];
					Persona[] personasPromocion = turnoM.obtenerPersonasDeLaCarreraQuePromocionaron(elegida2);
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
					System.out.println("Ingrese su dni:");
					Integer dniEstudiante = teclado.nextInt();
					Persona persona = turnoM.buscarPorDni(dniEstudiante);
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
				System.out.println(personas[i]);
				System.out.println("------------------");
			}
		}
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
