package locomotora;

import java.util.Scanner;

import locomotora.Locomotora;
import locomotora.MarcaVagon;
import locomotora.Vagon;

public class InterfazLocomotora {
	
	public static final int AGREGAR_VAGON = 1;
	public static final int OBTENER_VAGON_MENOR_PESO = 2;
	public static final int EDITAR_NOMBRE_VAGON = 3;
	public static final int ORDENAR_VAGONES_POR_ID = 4;
	public static final int PESO_PROMEDIO = 5;
	public static final int SALIR = 9;

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("----Bienvenido a la interfaz de Trenes Matanceros----");
		System.out.println("- Se creara una nueva locomotora par aponer en funcionamiento.");
		System.out.println("Ingrese el nombre:");
		String nombre = entrada.nextLine();
		System.out.println("Ingrese la cantidad maxima de vagones:");
		int maximaVagones = entrada.nextInt();
		Locomotora trencito = new Locomotora(nombre, maximaVagones);
		System.out.println("Se ha creado la Locomotora " + trencito.getNombre() + " con una maxima de vagones de " + trencito.getCantidadMaximaDeVagones());

		int opcion = 0;
		
		do {
			System.out.println("Menu:");
			System.out.println("1. Agregar vagon, \n2. Obtener vagon de menor peso, \n3. Editar nombre del vagon, \n4. Ordenar vagones por ID, \n5. Peso promedio por marca\n9. Salir.");
			System.out.println("\nIngrese la opcion elegida:");
			opcion = entrada.nextInt();
			
			switch(opcion) {
			case AGREGAR_VAGON:
				mensaje("Agregar vagon");
				Vagon vagoncito = new Vagon();
				System.out.println("Ingrese el id del vagon: (debe contener 3 letras y 3 numeros)");
				String id = entrada.next();
				if(vagoncito.validarIdentificador(id)) {
					vagoncito.setIdVagon(id);
					System.out.println("Ingrese la descripcion del vagon:");
					vagoncito.setDescripcion(entrada.next()); //NO FUNCIONA SI HAY ESPACIOS
					entrada.nextLine();//asi se arregla el error de arriba
					System.out.println("Ingrese la marca elegida: 1. Lima, 2. Roco, 3. Philotrain");
					byte numero = entrada.nextByte();
					MarcaVagon opciones[] = MarcaVagon.values();
					MarcaVagon elegida = opciones[numero-1];
					vagoncito.setMarca(elegida);
					
					System.out.println("Ingrese el peso maximo del vagon:");
					vagoncito.setPesoMaximoSoportado(entrada.nextDouble());
					System.out.println("Ingrese el peso cargado:");
					vagoncito.setPesoDeCarga(entrada.nextDouble());
					if(vagoncito.getPesoMaximoSoportado() > vagoncito.getPesoDeCarga()) {
						if(trencito.agregarVagon(vagoncito)) {
							System.out.println("Se ha agregado vagon con exito.");
							System.out.println("Vagones en el tren: " + trencito.contadorVagonesAgregados());
							System.out.println("Disponibilidad: " + trencito.contadorDeVagonesDisponibles());
						} else { 
							System.out.println("No se ha podido agregar");
						}
					} else {
						System.out.println("El peso de carga es superior al maximo");
					}
					
					
				} else {
					System.out.println("El id no corresponde. \nIntente de nuevo.");
				}
				//Vagon vagoncito = new Vagon(id, descripcion, elegida, pesoMaximo, pesoCarga);
				break;
				
			case OBTENER_VAGON_MENOR_PESO:
				mensaje("Obtener vagon de menor peso");
				System.out.println(trencito.obtenerVagonDeMenorPeso());
				break;
				
			case EDITAR_NOMBRE_VAGON:
				mensaje("Editar nombre del vagon");
				System.out.println("Ingrese el id del vagon a editar:");
				String idAeditar = entrada.next();
				System.out.println("Ingrese el id nuevo:");
				String idNuevo = entrada.next();
				if(trencito.editarNombreDeVagon(idAeditar, idNuevo)) {
					System.out.println("Se ha cambiado el id con exito.");
				} else {
					System.out.println("El id no corresponde. \nIntente de nuevo.");
				}
				break;
				
			case ORDENAR_VAGONES_POR_ID:
				mensaje("Ordenar vagones por Id Vagon");
				trencito.ordenarVagonesPorIdVagon();
				for(int i = 0; i < trencito.getFormacion().length; i++) {
					if(trencito.getFormacion()[i] !=null) {
						System.out.println("[" + (i+1) + "] " + trencito.getFormacion()[i].getIdVagon());
					}
				}
				break;
				
			case PESO_PROMEDIO:
				mensaje("Peso promedio por marca");
				System.out.println("Ingrese la marca elegida: 1. Lima, 2. Roco, 3. Philotrain");
				byte numero = entrada.nextByte();
				MarcaVagon opciones[] = MarcaVagon.values();
				MarcaVagon elegida = opciones[numero-1];
				System.out.println("El peso promedio es: " + trencito.obtenerPesoPromerdioDeVagonesParaLaMarca(elegida));
				
			case SALIR:
				mensaje("Gracias por usar el sistema de administracion de trenes");
				break;
			default:
				mensaje("Opcion inexistente. \nIntente de nuevo.");
				break;
			}
			
			
			
		} while (opcion != SALIR);
		
		
	}
	
	public static void mensaje(String mensaje) {
		System.out.println("-------------------------------");
		System.out.println(mensaje);
		System.out.println("-------------------------------");
	}

}
