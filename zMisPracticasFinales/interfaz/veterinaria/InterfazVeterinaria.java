package veterinaria;

import java.util.Scanner;

public class InterfazVeterinaria {
	private static final int REGISTRAR_ATENCION = 1;
	private static final int BUSCAR_POR_ID = 2;
	private static final int ATENCIONES_POR_MASCOTA = 3;
	private static final int ELIMINAR_ATENCION_POR_ID = 4;
	private static final int ATENCIONES_REALIZADAS_DISPONIBLES = 5;
	private static final int MONTO_TOTAL = 6;
	private static final int ATENCIONES_FINALES = 7;
	
	private static final int SALIR= 9;
	private static final int CANTIDAD_MAXIMA_ATENCIONES = 5;

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		String nombreVeterinaria = "UNLaM-Vet";
		mostrarMensaje("Bienvenido a " + nombreVeterinaria);
		
		Atencion [] CantidadMaximaAtencion = new Atencion [CANTIDAD_MAXIMA_ATENCIONES];
		
		Veterinaria veterinaria = new Veterinaria(nombreVeterinaria, CantidadMaximaAtencion);

		int opcion = 0;

		do {
			opcion = seleccionarOpcion(entrada);

			switch (opcion) {
			case REGISTRAR_ATENCION:
				// Registra una atencion con los datos ingresados por el empleado e informa el resultado
				crearAtencion(entrada, veterinaria);
				break;
			case BUSCAR_POR_ID:
				// Se solicita el ingreso del id y se muestra la informacion de la atencion
				// encontrada. Si no se encuentra, mostrar un mensaje
				System.out.println("\nBuscar por ID:");
				System.out.println("Ingrese el id: ");
				int id = entrada.nextInt();
				if(veterinaria.buscarAtencionPorId(id) != null) {
					System.out.println("La atencion es:");
					System.out.println(veterinaria.buscarAtencionPorId(id));
				} else {
					System.out.println("No se han encontrado atenciones");
				}
				break;
			case ATENCIONES_POR_MASCOTA:
				// Ingresar la especie de mascota para listar las atenciones que correspondan.
				// Si no hay atenciones indicar lo propio
				System.out.println("\nBuscar atenciones por mascota");
				System.out.println("Ingrese la mascota: 1. Perro, 2. Gato, 3. Ave.");
				Especie disponible [] = Especie.values();
				Especie elegida = disponible[entrada.nextInt()-1];
				
				//copiado de luxo observar
				Atencion filtrar[] = veterinaria.listarAtencionesPorEspecieDeMascota(elegida);
				
				for(int i = 0; i < filtrar.length; i++) {
					if(filtrar[i] != null) {
						System.out.println("--------------");
						System.out.println(filtrar[i]);
					}
				}
				
				break;
			case ELIMINAR_ATENCION_POR_ID:
				// Se solicita el ingresdo del id de la atencion y se elimina. Indicar el
				// resultado de la operacion
				System.out.println("\nEliminar por id");
				System.out.println("Ingrese el id:");
				int idIngresado = entrada.nextInt();
				boolean seElimino = veterinaria.eliminarAtencionPorId(idIngresado);
				if(seElimino) {
					System.out.println("Se ha eliminado la atencion");
				} else {
					System.out.println("No se ha eliminado la atencion");
				}
				break;
			case ATENCIONES_REALIZADAS_DISPONIBLES:
				// Listar las atenciones realizadas y las disponibles
				System.out.println("\nAtenciones realizadas: " + veterinaria.obtenerCantidadDeAtencionesRealizadas());
				System.out.println("Atenciones disponibles: " + veterinaria.obtenerCantidadDeAtencionesDisponibles(veterinaria.obtenerCantidadDeAtencionesRealizadas()));
				break;
			case MONTO_TOTAL:
				// Informar el total de todas las atenciones realizadas. Debe inciar sesión para realizar esta operacion.
				// Si las credenciales son invalidas, indicarlo y volver al menu principal.
				System.out.println("Usuario:");
				String usuario2 = entrada.next();
				System.out.println("Contrasenia:");
				String contrasenia2 = entrada.next();
				if(veterinaria.iniciarSesion(usuario2, contrasenia2)) {
					System.out.println("\nMonto total:");
					System.out.println("$" + veterinaria.obtenerTotalDeAtenciones());
				} else {
					System.out.println("Datos incorrectos");
				}
				
				break;
			case ATENCIONES_FINALES:
				// Informar por pantalla atenciones ordenadas en forma decreciente. Si no hay atenciones mostrar un mensaje aclaratorio.
				// Si las credenciales son invalidas, indicarlo y volver al menu principal.
				System.out.println("Atenciones finales");
				System.out.println("Usuario:");
				String usuario = entrada.next();
				System.out.println("Contrasenia:");
				String contrasenia = entrada.next();
				if(veterinaria.iniciarSesion(usuario, contrasenia)) {
					veterinaria.ordenarAtencionesPorMontoDescendente();
					//medio copiado de lucho
					Atencion finales[] = veterinaria.getAtenciones();
					for(int i = 0; i < finales.length; i++) {
						if(finales[i] != null) {
							System.out.println(finales[i]);
							System.out.println("------------");
						}
					}
					/*for(int i = 0; i < CantidadMaximaAtencion.length; i++) {
						if(CantidadMaximaAtencion != null) {
							System.out.println(CantidadMaximaAtencion[i]);
						}
					}*/
				} else {
					System.out.println("Datos incorrectos");
				}
				
				break;
			case SALIR:
				mostrarMensaje("Gracias por utilizar el sistema");		
				break;
			}

		} while (opcion != SALIR);
	
		entrada.close();
	}

	/**
	 * Muestra el menu principal y solicita el ingreso de la funcionalidad deseada
	 * 
	 * @param teclado	Para el ingreso de datos
	 * @return opcion seleccionada
	 * */
	private static int seleccionarOpcion(Scanner teclado) {
		
		int opcionSeleccionada = 0;

		mostrarMensaje("\n************************");
		mostrarMensaje("Menu Principal\n");
		mostrarMensaje("1 - Registar una atencion ");
		mostrarMensaje("2 - Buscar atencion por su identificador unico");
		mostrarMensaje("3 - Listar atenciones por una especie determinada");
		mostrarMensaje("4 - Eliminar una atencion por su id");
		mostrarMensaje("5 - Informar la cantidad de atenciones realizadas y las disponibles");
		mostrarMensaje("6 - Infomar el total de todas las atenciones realizadas [Requiere iniciar sesion]");
		mostrarMensaje("7 - Listar atenciones por monto descendente [Requiere iniciar sesion]");
		mostrarMensaje("\n9 - Salir");
		mostrarMensaje("\n************************");
		mostrarMensaje("\nIngrese una opcion");

		opcionSeleccionada = teclado.nextInt();

		return opcionSeleccionada;
	}
	
	/**
	 * Solicita el ingreso de la informacion para crear una atencion y la crea
	 * @param teclado	Para el ingreso de datos
	 * */
	private static boolean crearAtencion(Scanner entrada, Veterinaria veterinaria) {
		System.out.println("\nCrear atencion");
		System.out.println("Id:");
		int id = entrada.nextInt();
		/*int indices = 1;
		int id = indices++;*/
		System.out.println("Cliente: ");
		String cliente = entrada.next();
		System.out.println("Mascota: ");
		String mascota = entrada.next();
		System.out.println("Especie: 1. Perro, 2. Gato, 3. Ave.");
		Especie disponibles[] = Especie.values();
		Especie elegida = disponibles[entrada.nextInt()-1];
		System.out.println("Monto: ");
		double monto = entrada.nextDouble();
		
		Atencion nueva = new Atencion(id, cliente, mascota, elegida, monto);
		boolean seCreo = veterinaria.registrarAtencion(nueva);
		return seCreo;
	}
	
	private static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
