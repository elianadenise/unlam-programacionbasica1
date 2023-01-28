package ensalada;

import java.util.Scanner;

public class interfazRestaurant {
	public static final int AGREGAR_NUEVO_INGREDIENTE_AL_RESTAURANT = 1;
	public static final int CREAR_NUEVA_ENSALADA_PREDETERMINADA = 2;
	public static final int CREAR_PEDIDO = 3;
	public static final int SALIR = 9;
	public static void main(String args[]) {
		
		final int CANTIDAD_MAXIMA_DE_INGREDIENTES = 50;
		final int CANTIDAD_MAXIMA_DE_ENSALADAS = 10;
		final int CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA = 100;
		
		Ingrediente ingredientesDisponibles[] = new Ingrediente[CANTIDAD_MAXIMA_DE_INGREDIENTES];
		Ensalada ensaladaPreEstablecidas[] = new Ensalada[CANTIDAD_MAXIMA_DE_ENSALADAS];
		Pedido pedidos[] = new Pedido[CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA];
		Scanner entrada = new Scanner(System.in);
		System.out.println("Bienvenido al Verde");
		
		ingredientesPreInstanciados(ingredientesDisponibles);
		
		/*
		 * En esta secci�n del c�digo se debe generar la interacci�n con el usuario. Se pueden incorporar tantos 
		 * m�todos como considere necesario. M�nimamente se debe invocar a los siguientes m�todos:
		 * 
		 * 	incorporarNuevoIngrediente
		 * 	crearUnNuevaEnsalada
		 * 	crearUnNuevoPedido
		 */

		int opcion = 0;
		do {
			System.out.println("Menu: \n1. Agregar ingredientes a la carta, \n2. Crear ensaladas preestablecidas, \n3. Crear pedido, \n9.Salir.");
			opcion = entrada.nextInt();
			switch(opcion) {
			case AGREGAR_NUEVO_INGREDIENTE_AL_RESTAURANT:
				incorporarNuevoIngrediente(ingredientesDisponibles, entrada);
				break;
			case CREAR_NUEVA_ENSALADA_PREDETERMINADA:
				/* Se visualiza el listado de ingredientes disponibles y a partir de ah� se crean nuevos platos, los cuales 
				 * pueden ser solicitados por los clientes 
				 */
				System.out.println("Crear nueva ensalada");
				System.out.println("Nombre de la ensalada:");
				String nombreEnsalada = entrada.next();
				Ensalada nueva = new Ensalada(nombreEnsalada, CANTIDAD_MAXIMA_DE_INGREDIENTES);
				mostrarIngredientes(ingredientesDisponibles);
				int siONo = 0;
				do {
					System.out.println("Desea agregar ingrediente a la ensalada? 1. Si, 2. No.");
					siONo = entrada.nextInt();
					if(siONo == 1) {
						System.out.println("Ingrese el numero del ingrediente:");
						boolean seAgrego = nueva.agregarIngrediente(ingredientesDisponibles[entrada.nextInt()-1]);
						if(seAgrego) {
							System.out.println("Ingrediente agregado con exito");
						}
					} else {
						System.out.println("La ensalada es sin TACC: " + nueva.esAptoCeliaco());
						System.out.println("La ensalada es apto vegetarianos: " + nueva.esAptoVegetariano());
						System.out.println("La ensalada es apto veganos: " + nueva.esAptoVegano());
						System.out.println("Su precio: $" + nueva.getPrecio());
					}
					
				} while (siONo != 2);
				boolean fueAgregada = agregarEnsaladaPreEstablecida(ensaladaPreEstablecidas, nueva);
				if(fueAgregada) {
					System.out.println("Se agrego con exito.");
				} else {
					System.out.println("Ups! algo salio mal.");
				}
				break;
			case CREAR_PEDIDO:
				System.out.println("Crear pedido");
				System.out.println("Nombre del Cliente:");
				String nombreCliente = entrada.next();
				Pedido nuevo = new Pedido(nombreCliente, CANTIDAD_MAXIMA_DE_ENSALADAS);
				for(int i = 0; i < ensaladaPreEstablecidas.length; i++) {
					if(ensaladaPreEstablecidas[i] != null) {
						System.out.println("[" + (i+1) + "] " + ensaladaPreEstablecidas[i]);
					}
				}
				int decision = 0;
				do {
					System.out.println("Desea agregar ensalada al pedido? 1. Si, 2. No.");
					decision = entrada.nextInt();
					if(decision == 1) {
						System.out.println("Ingrese el numero de la ensalada:");
						boolean agregado = nuevo.agregarNuevaEnsalada(ensaladaPreEstablecidas[entrada.nextInt()-1]);
						if(agregado) {
							System.out.println("Se agrego al pedido");
						} else {
							System.out.println("Ups! algo salio mal.");
						}
					} else {
						System.out.println("Importe total: $" + nuevo.getImporte());
					}
				}while(decision != 2);
				for(int i = 0; i < pedidos.length; i++) {
					if(pedidos[i] == null) {
						pedidos[i] = nuevo;
					}
				}
				break;
			case SALIR:
				System.out.println("Gracias por utilizar el sistema");
				break;
			default:
				System.out.println("Elija una opcion valida");
				break;
			}
		} while(opcion != SALIR);
	}

	public static boolean agregarEnsaladaPreEstablecida(Ensalada[] ensaladaPreEstablecidas, Ensalada nueva) {
		boolean fueAgregada = false;
		for(int i = 0; i < ensaladaPreEstablecidas.length; i++) {
			if(ensaladaPreEstablecidas[i] == null) {
				ensaladaPreEstablecidas[i] = nueva;
				fueAgregada = true;
				break;
			}
		}
		return fueAgregada;
	}

	public static void incorporarNuevoIngrediente(Ingrediente[] ingredientesDisponibles, Scanner entrada) {
		/* Se crean nuevos ingredientes los cuales pueden ser utilizados en los platos */
		mostrarIngredientes(ingredientesDisponibles);
		System.out.println("\nDesea incorporar un nuevo ingredientes? 1. Si, 2. No.");
		int siONo = entrada.nextInt();
		if(siONo == 1) {
			System.out.println("Nombre:");
			String nombreIngrediente = entrada.next();
			System.out.println("Precio:");
			double precio = entrada.nextDouble();
			System.out.println("Origen: 1. Vegetal, 2. Animal, 3. Tacc, 4. Leche, 5. Huevo");
			Origen disponibles[] = Origen.values();
			Origen elegido = disponibles[entrada.nextInt()-1];
			Ingrediente nuevo = new Ingrediente(nombreIngrediente, precio, elegido);
			boolean seAgrego = agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, nuevo);
			if(seAgrego) {
				System.out.println("Ingrediente fue agregado con exito.");
			} else {
				System.out.println("Ups! algo salio mal.");
			}
		} else {
			System.out.println("No se agregan mas ingredientes.");
		}
	}

	public static void mostrarIngredientes(Ingrediente[] ingredientesDisponibles) {
		for(int i = 0; i < ingredientesDisponibles.length; i++) {
			if(ingredientesDisponibles[i] != null) {
				System.out.println("[" + (i+1) + "] " + ingredientesDisponibles[i]);
			}
		}
	}

	public static void ingredientesPreInstanciados(Ingrediente[] ingredientesDisponibles) {
		Ingrediente zanahoria = new Ingrediente("zanahoria", 50.0, Origen.VEGETAL);
		Ingrediente lechuga = new Ingrediente("lechuga", 50.0, Origen.VEGETAL);
		Ingrediente legumbres = new Ingrediente("legumbres", 50.0, Origen.VEGETAL);
		Ingrediente coliflor = new Ingrediente("coliflor", 50.0, Origen.VEGETAL);
		Ingrediente brocoli = new Ingrediente("brocoli", 50.0, Origen.VEGETAL);
		Ingrediente arroz = new Ingrediente("arroz", 50.0, Origen.VEGETAL);
		Ingrediente mariscos = new Ingrediente("mariscos", 50.0, Origen.ANIMAL);
		Ingrediente ricotta = new Ingrediente("ricotta", 50.0, Origen.LECHE);
		Ingrediente mozzarella = new Ingrediente("mozzarella", 50.0, Origen.ANIMAL);
		Ingrediente jamon = new Ingrediente("jamon", 50.0, Origen.ANIMAL);
		Ingrediente pollo = new Ingrediente("pollo", 50.0, Origen.ANIMAL);
		Ingrediente pasta = new Ingrediente("pasta", 50.0, Origen.TACC);
		Ingrediente pan = new Ingrediente("pan", 50.0, Origen.TACC);
		Ingrediente huevoFrito = new Ingrediente("huevo frito", 50.0, Origen.HUEVO);
		Ingrediente huevoCocido = new Ingrediente("huevo cocido", 50.0, Origen.HUEVO);
		
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, zanahoria);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, lechuga);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, legumbres);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, coliflor);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, brocoli);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, arroz);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, mariscos);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, ricotta);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, mozzarella);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, jamon);	
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, pollo);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, pasta);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, pan);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, huevoFrito);
		agregarIngredienteAArrayDeIngredientes(ingredientesDisponibles, huevoCocido);
	}

	public static boolean agregarIngredienteAArrayDeIngredientes(Ingrediente[] ingredientesDisponibles,
			Ingrediente nuevo) {
		boolean seAgrego = false;
		for(int i = 0; i < ingredientesDisponibles.length; i++) {
			if(ingredientesDisponibles[i] == null) {
				ingredientesDisponibles[i] = nuevo;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}
	
	private static void crearUnNuevaEnsalada() {
		/* Se visualiza el listado de ingredientes disponibles y a partir de ah� se crean nuevos platos, los cuales 
		 * pueden ser solicitados por los clientes 
		 */
	}
	
	private static void crearUnNuevoPedido() {
		/*
		 * Se muestra el listado de ensaladas, y el cliente elige la ensalada deseada.
		 * Una vez elegida la ensalada el cliente puede incorporar nuevos ingredientes.
		 * Al finalizar informa el valor que debe abonar.
		 */
	}
}
