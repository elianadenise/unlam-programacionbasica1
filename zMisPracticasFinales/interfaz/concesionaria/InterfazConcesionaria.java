package concesionaria;

import java.util.Scanner;

public class InterfazConcesionaria {

	public static final int AGREGAR_VENDEDOR = 1;
	public static final int COMPRAR_AUTO = 2;
	public static final int VENDER_AUTO = 3;
	public static final int BUSCAR_AUTO = 4;
	public static final int SALIR = 9;
	
	public static void main(String args[]) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Bienvenido al sistema");
		System.out.println("Ingrese el nombre de la Concesionaria: ");
		Concesionaria nueva = new Concesionaria(entrada.next());
		
		int opcion = 0;
		
		do {
			System.out.println("Menu: \n1. Agregar vendedor, \n2. Comprar auto, \n3. Vender auto,\n4. Buscar auto, \n9. Salir.");
			opcion = entrada.nextInt();
			switch(opcion) {
			case AGREGAR_VENDEDOR:
				System.out.println("-AGREGAR VENDEDOR-");
				System.out.println("Nombre:");
				String vendedor = entrada.next();
				Vendedor vendedorcito = new Vendedor(vendedor);
				boolean agregado = nueva.agregarVendedor(vendedorcito);
				if(agregado) {
					System.out.println("Se agrego el vendedor");
				} else {
					System.out.println("No pudo agregarse");
				}
				
				break;
			case COMPRAR_AUTO:
				System.out.println("-COMPRAR AUTO-");
				System.out.println("Modelo:");
				String modelo = entrada.next();
				System.out.println("Marca:");
				String marca = entrada.next();
				System.out.println("Kilometros:");
				long kilometros = entrada.nextLong();				
				System.out.println("Precio de compra:");
				double precio = entrada.nextDouble();
				Auto nuevo = new Auto(modelo, marca, kilometros, precio);
				boolean seAgrego = nueva.comprarAuto(nuevo);
				if(seAgrego) {
					System.out.println("Se compro exitosamente");
				} else {
					System.out.println("No se pudo comprar");
				}
				break;
			case VENDER_AUTO:
				System.out.println("-VENDER AUTO-");
				System.out.println(nueva.mostrarAutosDisponibles());
				System.out.println("Ingrese el identificador del auto:");
				int id = entrada.nextInt();
				System.out.println(nueva.mostrarVendedores());
				int idvendedor = entrada.nextInt();
				boolean seVendio = nueva.venderAuto(id, idvendedor);
				if(seVendio) {
					System.out.println("Se vendio");
				} else {
					System.out.println("No se pudo vender");
				}
				break;
			case BUSCAR_AUTO:
				System.out.println("-BUSCAR AUTO-");
				System.out.println("Ingrese modelo o marca a buscar:");
				String palabra = entrada.next();
				Auto buscados [] = nueva.buscarPorPalabra(palabra);
				for(int i = 0; i < buscados.length; i++) {
					if(buscados[i] != null) {
						System.out.println(buscados[i] + "\n----------" + "\n");
					}
				}
				
				break;
			case SALIR:
				System.out.println("Gracias por utilizar el sistema");
				break;
			default:
				System.out.println("Ingrese una opcion valida.");
				break;
			}
		} while(opcion != SALIR);
	}
}
