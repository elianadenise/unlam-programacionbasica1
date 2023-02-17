package trabajoPractico09;


import java.util.Scanner;
//ACA SE HACE TODO CON LA INTERFAZ
public class InterfazConcesionariaDos {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Bienvenidx al sistema de la concesionaria");
		System.out.println("Ingrese su codigo de Vendedor");
		String vendedor = entrada.next();
		Concesionaria vendedorUno = new Concesionaria(vendedor);
		System.out.println(vendedorUno.mostrarVehiculosDisponibles()); //mostrar al profe
		ingresarVehiculos(entrada); //comun a la interfaz, si viene otro vendedor puede ingresar.
		venderAuto(entrada, vendedorUno);
	}

	public static void venderAuto(Scanner entrada, Concesionaria nuevo) {
		System.out.println("Ingrese el codigo del auto a vender");
		byte codigo = entrada.nextByte();
		nuevo.venderAuto(codigo);
		System.out.println("Autos vendidos por el vendedor " + nuevo.getVendedor() + ": " + nuevo.getAutosVendidos());
		System.out.println("Comision actual del vendedor " + nuevo.getVendedor() + ": " + nuevo.getComision());
		//FALTA ELIMINAR ELEMENTO DEL ARRAY
	}

	public static void ingresarVehiculos(Scanner entrada) {
		System.out.println("Ingrese la cantidad de autos disponibles");
		byte cantidadDeAutos = entrada.nextByte();
		
		String marcas[] = new String[cantidadDeAutos];
		String modelos[] = new String[cantidadDeAutos];
		float precios[] = new float[cantidadDeAutos];
		
		for(int i = 0; i < marcas.length; i++) {
			System.out.println("Marca en posicion: " + (i+1));
			String nombreMarca = entrada.next();
			marcas[i] = nombreMarca;
			
			System.out.println("Modelo en posicion: " + (i+1) );
			String nombreModelo = entrada.next(); 
			modelos[i] = nombreModelo;
			
			System.out.println("Precio en posicion: " + (i+1));
			float precioVehiculo = entrada.nextFloat();
			precios[i] = precioVehiculo;
		}
		
		System.out.println("Que desea realizar?\na. Ordenar por marca\nb. Ordenar por modelo");
		char opcion = entrada.next().charAt(0);
		switch(opcion) {
		case 'a':
			ordenarPorMarca(marcas, modelos, precios);	
			break;
		case 'b':
			ordenarPorModelo(marcas, modelos, precios);	
			break;
		default:
			System.out.println("Ingrese una opcion valida");
			break;
		}
		
		
	}

	public static void ordenarPorMarca(String[] marcas, String[] modelos, float[] precios) {
		String auxiliarMarca = null;
		String auxiliarModelo = null;
		float auxiliarPrecio = 0;
		for(int i = 1; i < marcas.length; i++) {
			for(int j = 0; j < marcas.length - 1; j++) {
				if(marcas[j].compareTo(marcas[j+1]) > 0) {
					auxiliarMarca = marcas[j];
					marcas[j] = marcas [j+1];
					marcas[j+1] = auxiliarMarca;
					
					auxiliarModelo = modelos[j];
					modelos[j] = modelos [j+1];
					modelos[j+1] = auxiliarModelo;
					
					auxiliarPrecio = precios[j];
					precios[j] = precios [j+1];
					precios[j+1] = auxiliarPrecio;
				}
			}
		}
		
		for(int i = 0; i < marcas.length; i++) {
			System.out.println("Codigo: " + i + "; Marca: " + marcas[i] +  "; Modelo: " + modelos[i] + "; Precio: " + precios[i]);
		}
	}
	
	public static void ordenarPorModelo(String[] marcas, String[] modelos, float[] precios) {
		String auxiliarMarca = null;
		String auxiliarModelo = null;
		float auxiliarPrecio = 0;
		for(int i = 1; i < modelos.length; i++) {
			for(int j = 0; j < modelos.length - 1; j++) {
				if(modelos[j].compareTo(modelos[j+1]) > 0) {
					auxiliarModelo = modelos[j];
					modelos[j] = modelos [j+1];
					modelos[j+1] = auxiliarModelo;
					
					auxiliarMarca = marcas[j];
					marcas[j] = marcas [j+1];
					marcas[j+1] = auxiliarMarca;
					
					auxiliarPrecio = precios[j];
					precios[j] = precios [j+1];
					precios[j+1] = auxiliarPrecio;
				}
			}
		}
		
		for(int i = 0; i < marcas.length; i++) {
			System.out.println("Codigo: " + i + "; Modelo: " + modelos[i] + "; Marca: " + marcas[i] + "; Precio: " + precios[i]);
		}
	}

}
