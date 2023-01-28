package locomotora;

import java.util.Scanner;

public class InterfazLocomotora {

	public static final int REGISTRAR_VAGON = 1;
	public static final int EDITAR_NOMBRE_VAGON = 2;
	public static final int VAGON_MENOR_PESO = 3;
	public static final int PESO_PROMEDIO_POR_MARCA = 4;
	public static final int ORDENAR_VAGONES_POR_ID = 5;
	public static final int SALIR = 9;
	
	public static void main(String args[]) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Bienvenidos al sistema de trenes argentinos");
		System.out.println("Ingrese el id de la locomotora:");
		int id = entrada.nextInt();
		System.out.println("Ingrese el nombre de la locomotora:");
		String nombreLocomotora = entrada.next();
		System.out.println("Ingrese la cantidad maxima de vagones:");
		int cantidad = entrada.nextInt();
		Locomotora trencito = new Locomotora(id, nombreLocomotora, cantidad);
		
		int opcion = 0;
		do {
			System.out.println("Menu:\n1. Registrar vagon, \n2. Editar nombre vagon, \n3. Obtener vagon de menor peso,\n4. Peso promedio por marca, \n5. Ordenar vagones por id, \n9. Salir.");
			opcion = entrada.nextInt();
			switch(opcion) {
			case REGISTRAR_VAGON:
				Vagon vagoncito = new Vagon();
				System.out.println("Ingrese el id del vagon: (debe contener 3 letras y 3 numeros)");
				String idV = entrada.next();
				if(vagoncito.validarIdentificador(idV)) {
					vagoncito.setIdVagon(idV);
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
						} else { 
							System.out.println("No se ha podido agregar");
						}
					} else {
						System.out.println("El peso de carga es superior al maximo");
					}
				}
				/*Vagon nuevo = new Vagon();
				System.out.println("ID: (Debe contener 3 letras y 3 numeros)");
				String idv = entrada.next();
				if(nuevo.validarIdentificador(idv)) {
					System.out.println("ID valido");
					nuevo.setIdVagon(entrada.next());
					System.out.println("Descripcion:");
					nuevo.setDescripcion(entrada.next());
					System.out.println("Marca: 1. Lima, 2. Roco, 3. Philatrain.");
					MarcaVagon disponibles[] = MarcaVagon.values();
					MarcaVagon elegida = disponibles[entrada.nextInt()-1];
					nuevo.setMarca(elegida);
					System.out.println("Peso maximo soportado:");
					nuevo.setPesoMaximoSoportado(entrada.nextDouble());
					System.out.println("Peso de carga actual:");
					nuevo.setPesoDeCarga(entrada.nextDouble());
					if(trencito.agregarVagon(nuevo)) {
						System.out.println("Se agrego vagon a locomotora");
					} else { System.out.println("No se pudo agregar vagon"); }
				} else { System.out.println("ID no valido"); }*/
				
				break;
			case EDITAR_NOMBRE_VAGON:
				System.out.println("Id del vagon:");
				String idViejo = entrada.next();
				System.out.println("Id nuevo:");
				String idNuevo = entrada.next();
				boolean seedito = trencito.editarNombreVagon(idViejo, idNuevo);
				if(seedito) {
					System.out.println("Operacion exitosa");
				} else {System.out.println("No se pudo editar");}
				break;
			case VAGON_MENOR_PESO:
				System.out.println(trencito.obtenerVagonDeMenorPesoDeCarga());
				break;
			case PESO_PROMEDIO_POR_MARCA:
				System.out.println("Marca: 1. Lima, 2. Roco, 3. Philatrain.");
				MarcaVagon disponibles2[] = MarcaVagon.values();
				MarcaVagon elegida2 = disponibles2[entrada.nextInt()-1];
				System.out.println("Peso Promedio: " + trencito.obtenerPesoPromedioPorMarca(elegida2));
				break;
			case ORDENAR_VAGONES_POR_ID:
				trencito.ordenarVagonesPorId();
				for(int i = 0; i < trencito.getFormacion().length; i++) {
					if(trencito.getFormacion()[i] != null) {
						System.out.println(trencito.getFormacion()[i] + "\n------------" + "\n");
					}
				}
				break;
			case SALIR:
				System.out.println("Gracias por utilizar el sistema.");
				break;
			default:
				System.out.println("Ingrese una opcion correcta");
				break;
			}
			
		}while(opcion != SALIR);
	}
}
