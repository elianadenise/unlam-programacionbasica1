package subsidio;

import java.util.Scanner;

public class InterfazSubsidio {
	public static Scanner entrada= new Scanner (System.in);
	public static final int AGREGAR_SUBSIDIO = 1;
	public static final int BUSCAR_POR_ID = 2;
		
	public static final int SALIR = 9;
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenido al sistema subsidiario");
		System.out.println("\n--Agregar beneficiario--");
		System.out.println("Nombre:");
		String nombre = entrada.next();
		System.out.println("Apellido:");
		String apellido = entrada.next();
		String nombreCompleto = nombre + " " + apellido;
		System.out.println("Localidad:");
		String localidad = entrada.next();
		System.out.println("Calle:");
		String calle = entrada.next();
		System.out.println("Numero");
		Integer numero = entrada.nextInt();
		System.out.println("Sueldo:");
		Double sueldo = entrada.nextDouble();
		if(sueldo.compareTo(5000.0) < 0) {
			Direccion direccion = new Direccion(localidad, calle, numero);
			Usuario nuevo = new Usuario(nombreCompleto, direccion, sueldo);
		
			int opcion = 0;
			do {
				System.out.println("\nMENU");
				System.out.println("1. Agregar subsidio, \n2. Buscar subsidio por id, \n9. Salir.");
			
				opcion = entrada.nextInt();
				switch(opcion) {
				case AGREGAR_SUBSIDIO:
					System.out.println("\nDatos del subcidio");
					System.out.println("Identificador:");
					Integer identificador = entrada.nextInt();
					System.out.println("Nombre subcidio:");
					String nombreSubsidio = entrada.next();
					System.out.println("Porcentaje de descuento:");
					Double porcentaje = entrada.nextDouble();
					System.out.println("Tipo de subsidio:");
					String tipo = entrada.next();
					Subsidio subsidio = new Subsidio(identificador, nombreSubsidio, porcentaje, tipo);
					boolean seagrego = nuevo.agregarSubsidio(subsidio);
					if(seagrego) {
						System.out.println("Se agrego el subsidio al usuario");
					} else {
						System.out.println("No pudo agregarse el subsidio");
					}
					break;
				case BUSCAR_POR_ID:
					System.out.println("Ingrese el identificador unico:");
					Integer ident = entrada.nextInt();
					Subsidio buscado = nuevo.buscarSubsidioPorIdentificador(ident);
					System.out.println(buscado);
					break;
				case SALIR:
					System.out.println("Gracias por usar el sistema.");
					break;
				default:
					System.out.println("Ingrese una opcion correcta.");
					break;
				}
			} while (opcion != SALIR);
		} else {
			System.out.println("El sueldo del usuario es superior, no puede recibir subsidio.");
		}
	}	
}
