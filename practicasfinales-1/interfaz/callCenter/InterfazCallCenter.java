package callCenter;

import java.util.Scanner;

public class InterfazCallCenter {
public static void main(String args[]) {
		
		char opcionIngresada = '\0';
		final char SALIR = '9', INCORPORAR_ZONA_DE_COBERTURA = '1', DAR_DE_ALTA_NUEVO_CONTACTO = '2', REALIZAR_NUEVA_LLAMADA = '3', VER_INFORMACION_DEL_CONTACTO = '4';
		Scanner teclado = new Scanner(System.in);
		Empresa oesteCableColor = new Empresa("La empresa telefonica");
	
		do {
			mostrarMenu();
			opcionIngresada = teclado.next().charAt(0);
			switch(opcionIngresada) {
			case INCORPORAR_ZONA_DE_COBERTURA:
				incorporarZonaDeCobertura(teclado, oesteCableColor);
				break;
			case DAR_DE_ALTA_NUEVO_CONTACTO:
				darDeAltaNuevoContacto(teclado, oesteCableColor);
				break;
			case REALIZAR_NUEVA_LLAMADA:
				realizarNuevaLlamada(teclado, oesteCableColor);
				break;
			case VER_INFORMACION_DEL_CONTACTO:
				verInformacionDelContacto(teclado, oesteCableColor);
				break;
			}
			
		} while(opcionIngresada!=SALIR);

	}
	
	private static void incorporarZonaDeCobertura(Scanner teclado, Empresa actual) {
		/*
		 * Se registra un nuevo c�digo postal dentro de la zona de cobertura de la empresa
		 */
		System.out.println("Ingrese el codigo postal de la nueva zona de cobertura:");
		int codigo = teclado.nextInt();
		boolean seAgrego = actual.agregarNuevaZonaDeCobertura(codigo);
		if(seAgrego) {
			System.out.println("Se agrego la zona de cobertura correctamente");
		} else {
			System.out.println("Intente de nuevo");
		}
	}
	
	private static void mostrarMenu() {
		System.out.println("Bienvenido al callcenter");
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println("1 - Incorporar zona de cobertura");
		System.out.println("2 - Dar de alta un nuevo contacto");
		System.out.println("3 - Realizar nueva llamada");
		System.out.println("4 - Ver informaci�n del contacto");
		System.out.println("9 - Salir");
		System.out.println("************************");
	}
	
	private static void darDeAltaNuevoContacto(Scanner teclado, Empresa actual) {
		/*
		 * Registra un nuevo contacto en la empresa
		 */
		Contacto nuevo = new Contacto();
		System.out.println("Registrar nuevo contacto:");
		System.out.println("Nombre y apellido:");
		String nombre = teclado.next();
		if(nuevo.esNombreValido(nombre)) {
			nuevo.setNombreYApellido(nombre);
		} else {
			System.out.println("No es valido");
		}
		System.out.println("Celular:");
		String celular = teclado.next();
		if(nuevo.esCelularValido(celular)) {
			nuevo.setCelular(celular);;
		} else {
			System.out.println("No es valido");
		}
		System.out.println("Email:");
		String email = teclado.next();
		if(nuevo.esEmailValido(email)) {
			nuevo.seteMail(email);
		} else {
			System.out.println("No es valido");
		}
		System.out.println("Codigo Postal:");
		nuevo.setCodigoPostal(teclado.nextInt());
		System.out.println("Localidad:");
		nuevo.setLocalidad(teclado.next());
		mostrarElListadoDeProvincias();
		System.out.println("Provincia:");
		Provincia disponibles [] = Provincia.values();
		Provincia elegida = disponibles[teclado.nextInt()-1];
		nuevo.setProvincia(elegida);
		boolean seagrego = actual.agregarNuevoContacto(nuevo);
		if(seagrego) {
			System.out.println("Se agrego correctamente");
		} else {
			System.out.println("No se agrego");
		}
	}
	
	private static void mostrarElListadoDeProvincias() {
		System.out.println("1 - BUENOS_AIRES");
		System.out.println("2 - CABA");
		System.out.println("3 - CATAMARCA");
		System.out.println("4 - CHACO");
		System.out.println("5 - CHUBUT");
		System.out.println("6 - CORDOBA");
		System.out.println("7 - CORRIENTES");
		System.out.println("8 - ENTRE_RIOS");
		System.out.println("9 - FORMOSA");
		System.out.println("10 - JUJUY");
		System.out.println("11 - LA_PAMPA");
		System.out.println("12 - LA_RIOJA");
		System.out.println("13 - MENDOZA");
		System.out.println("14 - MISIONES");
		System.out.println("15 - NEUQUEN");
		System.out.println("16 - RIO_NEGRO");
		System.out.println("17 - SALTA");
		System.out.println("18 - SAN_JUAN");
		System.out.println("19 - SAN_LUIS");
		System.out.println("20 - SANTA_CRUZ");
		System.out.println("21 - SANTA_FE");
		System.out.println("22 - SANTIAGO_DEL_ESTERO");
		System.out.println("23 - TIERRA_DEL_FUEGO");
		System.out.println("24 - TUCUMAN");
	}
	
	private static void realizarNuevaLlamada(Scanner teclado, Empresa actual) {
		/*
		 * Busca un candidato,  muestra los datos del mismo, y permite almacenar el resultado de la llamada.
		 * 
		 * a.	Si la llamada fue exitosa (en ese caso el contacto pasa a ser cliente, y no se lo debe volver a 
		 * llamar).
		 * b.	Si el contacto no desea ser llamado nuevamente (la llamada pudo no haber sido exitosa, pero se haga 
		 * un nuevo intento en el futuro).
		 * c.	Observaciones: Texto libre donde el operador deja registro de lo conversado.
		 */
		System.out.println("La llamada se realiza al siguiente contacto:");
		Contacto llamado = actual.buscarCandidato();
		System.out.println(llamado);
		Llamada nueva;
		System.out.println("La llamada fue exitosa? 1. Contacto desea ser cliente, 2. Contacto no desea ser cliente");
		int decision = teclado.nextInt();
		if(decision == 1) {
			System.out.println("Observaciones: ");
			String observacion = teclado.next();
			System.out.println(llamado.getNombreYApellido() + " es cliente y desea ser llamado nuevamente.");
			nueva = new Llamada(true,observacion);
			boolean registrada = llamado.registrarNuevaLlamada(nueva);
			System.out.println("Se registro la llamada? " + registrada);
						
			llamado.setEsCliente(true);
			llamado.setDeseaSerLlamadoNuevamente(true);
		} else {
			System.out.println("Observaciones: ");
			String observacion = teclado.next();
			System.out.println(llamado.getNombreYApellido() + " es no cliente y desea no ser llamado nuevamente.");
			nueva = new Llamada(false,observacion);
			boolean registrada = llamado.registrarNuevaLlamada(nueva);
			System.out.println("Se registro la llamada? " + registrada);
			
			llamado.setEsCliente(false);
			llamado.setDeseaSerLlamadoNuevamente(false);
		}
		
	}
	
	private static void verInformacionDelContacto(Scanner teclado, Empresa actual) {
		/*
		 * Se visualiza la informaci�n del contacto, incluso el listado de las llamadas que se le hicieron
		 */
		System.out.println("Ingrese el nombre y apellido del contacto:");
		String nombre = teclado.next();
		System.out.println(actual.buscarPorNombre(nombre));
	}
}
