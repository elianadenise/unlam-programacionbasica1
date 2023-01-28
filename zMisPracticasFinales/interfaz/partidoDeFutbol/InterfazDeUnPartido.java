package partidoDeFutbol;

import java.util.Scanner;

public class InterfazDeUnPartido {
	private static final int AGREGAR_NUEVO_JUGADOR = 1, CALCULAR_EL_VALOR_DE_UN_EQUIPO = 2, CALCULAR_LA_EDAD_PROMEDIO = 3, CREAR_UN_PARTIDO = 4, REGISTRAR_UN_GOL = 5, AMONESTAR = 6, EXPULSAR = 7, VER_EL_RESUMEN = 8, SALIR = 9;
	
	public static void main(String args[]) {	
		EquipoDeFutbol inscriptosAlTorneo[] = obtenerEquipoDeFutbolesDisponibles();
		PartidoDeFutbol actual = null;
		int opcionIngresada;
		Scanner teclado = new Scanner(System.in);
				
		System.out.println("Bienvenido al sistema para la gesti�n de un partido de f�tbol desarrollado por la Unlam");
	
		do {
			mostrarMenu();
			opcionIngresada = teclado.nextInt();
			actual = determinarAccionARealizar(inscriptosAlTorneo, actual, opcionIngresada, teclado);
			}while (opcionIngresada!=9);
	}
	
	private static void mostrarMenu() {
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println(AGREGAR_NUEVO_JUGADOR + " - Agregar un nuevo jugador a un equipo");
		System.out.println(CALCULAR_EL_VALOR_DE_UN_EQUIPO + " - Calcular el valor de un equipo ");
		System.out.println(CALCULAR_LA_EDAD_PROMEDIO + " - Calcular la edad promedio de un equipo");
		System.out.println(CREAR_UN_PARTIDO + " - Crear nuevo partido");
		System.out.println(REGISTRAR_UN_GOL + " - Regitrar nuevo gol");
		System.out.println(AMONESTAR + " - Amonestar a un jugador");
		System.out.println(EXPULSAR + " - Expulsar a un jugador");
		System.out.println(VER_EL_RESUMEN + " - Ver el resumen del partido");
		System.out.println(SALIR + " - Salir");
		System.out.println("************************");
	}

	private static PartidoDeFutbol determinarAccionARealizar(EquipoDeFutbol[] inscriptosAlTorneo,
			PartidoDeFutbol actual, int opcionIngresada, Scanner teclado) {
		
		switch(opcionIngresada) {
			case AGREGAR_NUEVO_JUGADOR:
				agregarNuevoJugador(teclado, inscriptosAlTorneo);
				break;
			case CALCULAR_EL_VALOR_DE_UN_EQUIPO:
				calcularElValorDeUnEquipo(teclado, inscriptosAlTorneo);
				break;
			case CALCULAR_LA_EDAD_PROMEDIO:
				calcularLaEdadPromedioDeUnEquipo(teclado, inscriptosAlTorneo);
				break;
			case CREAR_UN_PARTIDO:
				actual = crearUnNuevoPartido(teclado, inscriptosAlTorneo);
				break;
			case REGISTRAR_UN_GOL:
				if(verificaQueElPartidoHayaSidoCreado(actual)) {
					registrarUnGol(teclado, actual);
				}
				break;
			case AMONESTAR:
				if(verificaQueElPartidoHayaSidoCreado(actual)) {
					amonestarAUnJugador(teclado, actual);
				}
				break;
			case EXPULSAR:
				if(verificaQueElPartidoHayaSidoCreado(actual)) {
					expulsarAUnJugador(teclado, actual);
				}
				break;
			case VER_EL_RESUMEN:
				if(verificaQueElPartidoHayaSidoCreado(actual)) {
					verElResumenDelPartido(teclado, actual);
				}
				break;
			case SALIR:
				break;
			}
		return actual;
	}
	
	private static void agregarNuevoJugador(Scanner teclado, EquipoDeFutbol inscriptos[]) {
		int equipoSeleccionado = 0;	
		int numero;
		String nombre;
		int edad;
		double precio;
		
		System.out.println("***************");
		System.out.println("Agregar nuevo jugador");
		System.out.println("***************");
		
		listarLosEquiposInscriptos();
		equipoSeleccionado = seleccionarEquipoDeseado(teclado); 
		
		System.out.println("Ingrese el numero");
		numero = teclado.nextInt();
		System.out.println("Ingrese el nombre");
		nombre = teclado.next();
		System.out.println("Ingrese la edad");
		edad = teclado.nextInt();
		System.out.println("Ingrese el precio");
		precio = teclado.nextDouble();
		
		Jugador nuevo = new Jugador(numero, nombre, edad, precio);
		inscriptos[equipoSeleccionado].agregarJugador(nuevo);
	}

	private static void calcularElValorDeUnEquipo(Scanner teclado, EquipoDeFutbol[] inscriptosAlTorneo) {
		int equipoSeleccionado = 0;	
		
		System.out.println("***************");
		System.out.println("Calculo del valor de un equipo");
		System.out.println("***************");
		
		listarLosEquiposInscriptos();
		equipoSeleccionado = seleccionarEquipoDeseado(teclado); 
		
		System.out.println("El valor del equipo es: " + inscriptosAlTorneo[equipoSeleccionado].calcularElValorDelEquipo());
	}
	
	private static boolean verificaQueElPartidoHayaSidoCreado(PartidoDeFutbol actual) {
		boolean resultado = false;
		if(actual==null) {
			System.out.println("El partido no ha sido creado a�n");
		}
		else {
			resultado = true;
		}
		return resultado;
	}
	
	private static void calcularLaEdadPromedioDeUnEquipo(Scanner teclado, EquipoDeFutbol[] inscriptosAlTorneo) {
		int equipoSeleccionado = 0;	
		
		System.out.println("***************");
		System.out.println("Calculo de la edad promedio");
		System.out.println("***************");
		
		listarLosEquiposInscriptos();
		equipoSeleccionado = seleccionarEquipoDeseado(teclado); 
		
		System.out.println("El valor del equipo es: " + inscriptosAlTorneo[equipoSeleccionado].calcularLaEdadPromedioDelEquipo());	
	}

private static PartidoDeFutbol crearUnNuevoPartido(Scanner teclado, EquipoDeFutbol[] inscriptosAlTorneo) {
		
		int equipoSeleccionado = 0;	
		EquipoDeFutbol local, visitante;
		PartidoDeFutbol nuevo;
		
		System.out.println("***************");
		System.out.println("Nuevo partido");
		System.out.println("***************");
		
		System.out.println("Seleccione al local");
		listarLosEquiposInscriptos();
		equipoSeleccionado = seleccionarEquipoDeseado(teclado); 
		local = inscriptosAlTorneo[equipoSeleccionado];
		
		System.out.println("Seleccione al visitante");
		listarLosEquiposInscriptos();
		equipoSeleccionado = seleccionarEquipoDeseado(teclado); 
		visitante = inscriptosAlTorneo[equipoSeleccionado];
		
		nuevo = new PartidoDeFutbol(local, visitante);
		
		System.out.println("El partido fue creado correctamente");
		
		return nuevo;
	}

	private static void registrarUnGol(Scanner teclado, PartidoDeFutbol actual) {
		int minutos, tipoDeGol;
		EquipoDeFutbol equipoQueMarcoElGol;
		Jugador jugadorQueMarcoElGol;
		Evento gol;
		
		System.out.println("***************");
		System.out.println("Nuevo gol!");
		System.out.println("***************");
		
		equipoQueMarcoElGol = seleccionarEquipo(teclado, actual);
		jugadorQueMarcoElGol = seleccionarJugador(teclado, equipoQueMarcoElGol);
		minutos = ingresarMinutos(teclado);
		System.out.println(" Tipo de Gol (1 - A Favor | 2 - En contra");
		tipoDeGol = teclado.nextInt();
		
		if(tipoDeGol == 1) {
			gol = new Evento(minutos, jugadorQueMarcoElGol, TipoDeEvento.GOL_A_FAVOR);
		}
		else {
			gol = new Evento(minutos, jugadorQueMarcoElGol, TipoDeEvento.GOL_EN_CONTRA);
		}
		actual.marcar(gol);
	}
	
	private static void amonestarAUnJugador(Scanner teclado, PartidoDeFutbol actual) {
		int minutos, cantidadDeAmonestaciones;
		EquipoDeFutbol equipoQueRecibeLaAmonestacion;
		Jugador jugadorQueSeAmonesta;
		Evento amonestacion;
		
		System.out.println("***************");
		System.out.println("Nueva amonestacion");
		System.out.println("***************");
		
		equipoQueRecibeLaAmonestacion = seleccionarEquipo(teclado, actual);
		jugadorQueSeAmonesta = seleccionarJugador(teclado, equipoQueRecibeLaAmonestacion);
		minutos = ingresarMinutos(teclado);
		
		amonestacion = new Evento(minutos, jugadorQueSeAmonesta, TipoDeEvento.AMONESTACION);
		
		cantidadDeAmonestaciones = actual.amonestar(amonestacion);
		
		if(cantidadDeAmonestaciones == 1) {
			System.out.println("Se amonest� al jugador " + jugadorQueSeAmonesta.getNombre());
		}
		else {
			System.out.println("Se expuls� al jugador " + jugadorQueSeAmonesta.getNombre());
		}
	}
	
	private static void expulsarAUnJugador(Scanner teclado, PartidoDeFutbol actual) {
		int minutos;
		EquipoDeFutbol equipoQueRecibeLaExpulsion;
		Jugador jugadorQueSeExpulsa;
		Evento expulsion;
		
		System.out.println("***************");
		System.out.println("Nueva expulsi�n");
		System.out.println("***************");
		
		equipoQueRecibeLaExpulsion = seleccionarEquipo(teclado, actual);
		jugadorQueSeExpulsa = seleccionarJugador(teclado, equipoQueRecibeLaExpulsion);
		minutos = ingresarMinutos(teclado);
		
		expulsion = new Evento(minutos, jugadorQueSeExpulsa, TipoDeEvento.EXPULSION);
		actual.expulsar(expulsion);
		
		System.out.println("El jugador fue expulsado");		
	}

	private static void verElResumenDelPartido(Scanner teclado, PartidoDeFutbol actual) {
		System.out.println("***************");
		System.out.println("El resumen del partido llega a usted gracias a Iveco");
		System.out.println("***************");
		
		System.out.println(actual);
	}

	private static int ingresarMinutos(Scanner teclado) {
		int minutos;
		do {
			System.out.println("Ingrese los minutos: ");
			minutos = teclado.nextInt();
		} while (minutos < 0 && minutos > 90);
		return minutos;
	}

	private static Jugador seleccionarJugador(Scanner teclado, EquipoDeFutbol equipoBuscado) {
		int jugador;
		Jugador buscado;
		do {
			System.out.println("Ingrese el n�mero de jugador");
			jugador = teclado.nextInt();
			buscado = equipoBuscado.buscar(jugador);
		} while(buscado == null);
		
		return buscado;
	}

	private static EquipoDeFutbol seleccionarEquipo(Scanner teclado, PartidoDeFutbol actual) {
		int equipo;
		EquipoDeFutbol equipoBuscado;
		do {
			System.out.println("Ingrese el equipo");
			System.out.println("1 - Local (" + actual.getLocal() + ")");
			System.out.println("2 - Visitante (" + actual.getVisitante() + ")");
			equipo = teclado.nextInt();
		} while(equipo!=1 && equipo!= 2);
		if(equipo==1) {
			equipoBuscado = actual.getLocal();
		}
		else {
			equipoBuscado = actual.getVisitante();
		}
		return equipoBuscado;
	}

	private static int seleccionarEquipoDeseado(Scanner teclado) {
		int equipoSeleccionado;
		do {
			System.out.println("Ingrese el equipo deseado: ");
			equipoSeleccionado = teclado.nextInt();
		}while(equipoSeleccionado < 0 && equipoSeleccionado >= obtenerEquipoDeFutbolesDisponibles().length);
		return equipoSeleccionado;
	}

	public static EquipoDeFutbol[] obtenerEquipoDeFutbolesDisponibles() {
		
		EquipoDeFutbol inscriptos [] = {new EquipoDeFutbol("Union"),
				new EquipoDeFutbol("Boca"),
				new EquipoDeFutbol("Aldosivi"),
				new EquipoDeFutbol("Patronato"),
				new EquipoDeFutbol("Newells"),
				new EquipoDeFutbol("Talleres"),
				new EquipoDeFutbol("Velez"),
				new EquipoDeFutbol("Racing"),
				new EquipoDeFutbol("Arsenal"),
				new EquipoDeFutbol("San Lorenzo"),
				new EquipoDeFutbol("Independiente"),
				new EquipoDeFutbol("Argentinos"),
				new EquipoDeFutbol("Godoy Cruz"),
				new EquipoDeFutbol("Rosario Central"),
				new EquipoDeFutbol("Sarmiento"),
				new EquipoDeFutbol("Estudiantes"),
				new EquipoDeFutbol("Lan�s"),
				new EquipoDeFutbol("Atl�tico Tucum�n"),
				new EquipoDeFutbol("Gimnasia"),
				new EquipoDeFutbol("Platense"),
				new EquipoDeFutbol("Hurac�n"),
				new EquipoDeFutbol("Defensa"),
				new EquipoDeFutbol("River"),
				new EquipoDeFutbol("Col�n"),
				new EquipoDeFutbol("Central C�rdoba"),
				new EquipoDeFutbol("Banfield")
				};
		
		return inscriptos;
	}
	
	private static void listarLosEquiposInscriptos() {
		EquipoDeFutbol[] inscriptos = obtenerEquipoDeFutbolesDisponibles();
		
		for(int i=0; i<inscriptos.length; i++) {
			System.out.println("" + (i) + " - " + inscriptos[i]);
		}
	}
}
