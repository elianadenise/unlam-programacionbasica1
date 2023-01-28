package veterinaria;

import java.util.Scanner;

public class InterfazVeterinaria {
	private static final int REGISTRAR_ATENCION = 1;
	private static final int BUSCAR_POR_ID = 2;
	private static final int LISTADO_POR_ESPECIE = 3;
	private static final int ELIMINAR_ATENCION = 4;
	private static final int ATENCIONES_REALIZADAS_DISPONIBLES = 5;
	private static final int MONTO_TOTAL = 6;
	private static final int LISTAR_POR_MONTO_DESCENDIENTE = 7;
	private static final int SALIR= 9;
	private static final int CANTIDAD_MAXIMA_ATENCIONES = 5;

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		String nombreVeterinaria = "UNLaM-Vet";
		mostrarMensaje("Bienvenido a " + nombreVeterinaria);
		
		Atencion [] CantidadMaximaAtencion = new Atencion [CANTIDAD_MAXIMA_ATENCIONES];
		
		Veterinaria veterinaria = new Veterinaria(nombreVeterinaria, CantidadMaximaAtencion);

		int opcion = 0;

		do {
			opcion = seleccionarOpcion(teclado);

			switch (opcion) {
			case REGISTRAR_ATENCION:
				mostrarMensaje("-REGISTRAR ATENCION-");
				crearAtencion(teclado, veterinaria);
				// Registra una atencion con los datos ingresados por el empleado e informa el resultado
				break;
			case BUSCAR_POR_ID:
				mostrarMensaje("-BUSCAR POR ID-");
				System.out.println("Ingrese ID:");
				int idBuscado = teclado.nextInt();
				System.out.println(veterinaria.buscarAtencionPorId(idBuscado));
				// Se solicita el ingreso del id y se muestra la informacion de la atencion
				// encontrada. Si no se encuentra, mostrar un mensaje
				break;
			case LISTADO_POR_ESPECIE:
				mostrarMensaje("-ATENCIONES POR ESPECIE-");
				System.out.println("Ingrese especie: 1. Perro, 2. Gato, 3. Ave.");
				Especie disponible[] = Especie.values();
				Especie elegida = disponible[teclado.nextInt()-1];
				Atencion lista [] = veterinaria.listarAtencionesPorEspecieDeMascota(elegida);
				for(int i = 0; i < lista.length; i++) {
					if(lista[i] != null) {
						System.out.println(lista[i] + "\n-------------" + "\n");
					}
				}
				// Ingresar la especie de mascota para listar las atenciones que correspondan.
				// Si no hay atenciones indicar lo propio
				break;
			case ELIMINAR_ATENCION:
				mostrarMensaje("-ELIMINAR POR ID-");
				System.out.println("Ingrese ID:");
				int idAEliminar = teclado.nextInt();
				boolean seElimino = veterinaria.eliminarAtencionPorId(idAEliminar);
				if(seElimino) {
					System.out.println("Se elimino");
				} else {
					System.out.println("No se elimino");
				}
				// Se solicita el ingresdo del id de la atencion y se elimina. Indicar el
				// resultado de la operacion
				break;
			case ATENCIONES_REALIZADAS_DISPONIBLES:
				mostrarMensaje("-ATENCIONES REALIZADAS Y DISPONIBLES-");
				System.out.println("Realizadas: " + veterinaria.obtenerCantidadDeAtencionesRealizadas());
				System.out.println("Disponibles: " + veterinaria.obtenerCantidadDeAtencionesDisponibles(veterinaria.obtenerCantidadDeAtencionesRealizadas()));
				// Listar las atenciones realizadas y las disponibles
				break;
			case MONTO_TOTAL:
				mostrarMensaje("-MONTO TOTAL DE ATENCIONES-");
				System.out.println("Ingrese usuario:");
				String usuario = teclado.next();
				System.out.println("Ingrese contrasenia:");
				String contrasenia = teclado.next();
				boolean inicio = veterinaria.iniciarSesion(usuario, contrasenia);
				if(inicio) {
					System.out.println("Monto: $" + veterinaria.obtenerTotalDeAtenciones());
				} else {
					System.out.println("Inicio de sesion denegado");
				}
				// Informar el total de todas las atenciones realizadas. Debe inciar sesión para realizar esta operacion.
				// Si las credenciales son invalidas, indicarlo y volver al menu principal.
				break;
			case LISTAR_POR_MONTO_DESCENDIENTE:
				mostrarMensaje("-LISTADO POR MONTO DESCENDENTE-");
				System.out.println("Ingrese usuario:");
				String usuario2 = teclado.next();
				System.out.println("Ingrese contrasenia:");
				String contrasenia2 = teclado.next();
				boolean inicio2 = veterinaria.iniciarSesion(usuario2, contrasenia2);
				if(inicio2) {
					veterinaria.ordenarAtencionesPorMontoDescendente();
					Atencion listaPorMonto [] = veterinaria.getAtenciones();
					for(int i = 0; i < listaPorMonto.length; i++) {
						if(listaPorMonto[i] != null) {
							System.out.println(listaPorMonto[i] + "\n-------------" + "\n");
						}
					}
				} else {
					System.out.println("Inicio de sesion denegado");
				}
				// Informar por pantalla atenciones ordenadas en forma decreciente. Si no hay atenciones mostrar un mensaje aclaratorio.
				// Si las credenciales son invalidas, indicarlo y volver al menu principal.
				break;
			case SALIR:
				mostrarMensaje("Gracias por utilizar el sistema");		
				break;
			}

		} while (opcion != SALIR);
	
		teclado.close();
	}

	public static boolean crearAtencion(Scanner teclado, Veterinaria veterinaria) {
		/**
		 * Solicita el ingreso de la informacion para crear una atencion y la crea
		 * @param teclado	Para el ingreso de datos
		 * */
		mostrarMensaje("ID:");
		int id = teclado.nextInt();
		mostrarMensaje("Cliente:");
		String cliente = teclado.next();
		mostrarMensaje("Mascota:");
		String mascota = teclado.next();
		mostrarMensaje("Especie: 1. Perro, 2. Gato, 3. Ave.");
		Especie disponibles [] = Especie.values();
		Especie opciones = disponibles[teclado.nextInt()-1];
		mostrarMensaje("Monto:");
		double monto = teclado.nextDouble();
		Atencion nueva = new Atencion(id, cliente, mascota, opciones, monto);
		boolean registrada = veterinaria.registrarAtencion(nueva);
		if(registrada) {
			System.out.println("Registro exitoso");
		} else {
			System.out.println("No se pudo registrar");
		}
		return registrada;
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
	
	private static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
