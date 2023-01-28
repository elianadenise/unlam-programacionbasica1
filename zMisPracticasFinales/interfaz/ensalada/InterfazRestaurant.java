package ensalada;

import java.util.Scanner;

public class InterfazRestaurant {
	public final static int INCORPORAR_NUEVO_INGREDIENTE = 1;
	public final static int CREAR_NUEVA_ENSALADA = 2;
	public final static int CREAR_NUEVO_PEDIDO = 3;
	public final static int SALIR = 9;
	
	public static void main(String args[]) {
		
		Scanner entrada = new Scanner(System.in);
		
		final int CANTIDAD_MAXIMA_DE_INGREDIENTES = 50;
		final int CANTIDAD_MAXIMA_DE_ENSALADAS = 10;
		final int CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA = 100;
		
		Ingrediente ingredientesDisponibles[] = new Ingrediente[CANTIDAD_MAXIMA_DE_INGREDIENTES];
		Ensalada ensaladaPreEstablecidas[] = new Ensalada[CANTIDAD_MAXIMA_DE_ENSALADAS];
		Pedido pedidos[] = new Pedido[CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA];
		//Se incorporan los ingredientes al array
		ingredientesDisponibles(ingredientesDisponibles);
		
		System.out.println("Bienvenido al Verde");

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
			mostrarMenu();
			System.out.println("Elija una opcion: ");
			opcion = entrada.nextInt();
			switch(opcion) {
			case INCORPORAR_NUEVO_INGREDIENTE:
				incorporarNuevoIngrediente(entrada, ingredientesDisponibles);
				break;
			case CREAR_NUEVA_ENSALADA:
				//muestra los ingredientes disponibles y los agrega en una nueva ensalada
				crearUnNuevaEnsalada(entrada, CANTIDAD_MAXIMA_DE_INGREDIENTES, ingredientesDisponibles,
						ensaladaPreEstablecidas);
				break;
			case CREAR_NUEVO_PEDIDO:
				//sumamos casa ensalada pedida?
				crearNuevoPedido(entrada, CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA, ensaladaPreEstablecidas, pedidos);
				break;
			case SALIR:
				System.out.println("Gracias por utilizar el sistema");
				break;
			}
			
		} while(opcion != SALIR);
	}
	
	public static void mostrarMenu() {
		System.out.println("\nMenu");
		System.out.println("1. Agregar nuevo ingrediente al menu, \n2. Crear nueva ensalada, \n3. Crear nuevo pedido, \n9. Salir.\n");
	}

	public static void crearUnNuevaEnsalada(Scanner entrada, final int CANTIDAD_MAXIMA_DE_INGREDIENTES,
			Ingrediente[] ingredientesDisponibles, Ensalada[] ensaladaPreEstablecidas) {
		/* Se visualiza el listado de ingredientes disponibles y a partir de ah� se crean nuevos platos, los cuales 
		 * pueden ser solicitados por los clientes 
		 */
		mostrarIngrediestesDisponibles(ingredientesDisponibles);
		System.out.println("Ingrese el nombre de la ensalda preEstablecida: ");
		String nombreEnsalada = entrada.next();
		
		Ensalada ensaladita = new Ensalada(nombreEnsalada, CANTIDAD_MAXIMA_DE_INGREDIENTES);
		
			int opcion = 0;
			do {
				System.out.println("Desea agregar un ingrediente a la ensalda? 1. Si, 2. No.");
				opcion = entrada.nextInt();
				if(opcion == 1) {
					System.out.println("Ingrese el numero del ingrediente:");
					int numeroIngrediente = (entrada.nextInt()) - 1;
					boolean seAgrego = ensaladita.agregarIngrediente(ingredientesDisponibles[numeroIngrediente]);
					System.out.println("Se agrego el ingrediente: " + seAgrego);
				} else {
					System.out.println("La ensalada es apta celiacos: " + ensaladita.esAptoCeliaco());
					System.out.println("La ensalada es apta vegetarianos: " + ensaladita.esAptoVegetariano());
					System.out.println("La ensalada es apta veganos: " + ensaladita.esAptoVegano());
				}
			}while(opcion == 1);
		agregarAEnsaladasPreEstablecidas(ensaladaPreEstablecidas, ensaladita);
	}

	public static void incorporarNuevoIngrediente(Scanner entrada, Ingrediente[] ingredientesDisponibles) {
		/* Se crean nuevos ingredientes los cuales pueden ser utilizados en los platos */
		
		mostrarIngrediestesDisponibles(ingredientesDisponibles);
		int opcion;
		do {
			System.out.println("Desea agregar otro ingrediente al menu? 1. Si, 2. No.");
			opcion = entrada.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Nombre ingrediente: ");
				String nombre = entrada.next();
				System.out.println("Precio: ");
				double precio = entrada.nextDouble();
				System.out.println("Origen: 1. Vegetal, 2. Animal, 3. TACC, 4. Leche, 5. Huevo.");
				Origen disponibles[] = Origen.values();
				Origen elegido = disponibles[entrada.nextInt()-1];
				Ingrediente nuevo = new Ingrediente(nombre, precio, elegido);
				agregarAIngredientesDisponibles(ingredientesDisponibles, nuevo);
				break;
			case 2: 
				System.out.println("No se agregan mas ingredientes.");
				break;
			default:
				System.out.println("No se agregan mas ingredientes.");
				break;
			}
			
		} while(opcion == 1);
	}

	public static void crearNuevoPedido(Scanner entrada, final int CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA,
			Ensalada[] ensaladaPreEstablecidas, Pedido[] pedidos) {
		/*
		 * Se muestra el listado de ensaladas, y el cliente elige la ensalada deseada.
		 * Una vez elegida la ensalada el cliente puede incorporar nuevos ingredientes.
		 * Al finalizar informa el valor que debe abonar.
		 */
		
		System.out.println("Las ensaldas disponibles son: ");
		for(int i = 0; i < ensaladaPreEstablecidas.length; i++) {
			if(ensaladaPreEstablecidas[i] != null) {
				System.out.println("[" + (i+1) + "] " + ensaladaPreEstablecidas[i].getNombreDeLaEnsalada());
			}
		}
		System.out.println("Ingrese nombre del Cliente: ");
		String nombreCliente= entrada.next();
		
		Pedido nuevo = new Pedido(nombreCliente, CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA);
		
		int opcion = 0;
		
		do {
			System.out.println("Desea agregar una ensalada a su pedido? 1. Si, 2. No.");
			opcion = entrada.nextInt();
			if(opcion == 1) {
				System.out.println("Ingrese el numero de la ensalada");
				int numeroEnsalada = (entrada.nextInt()) - 1;
				boolean seAgrego = nuevo.agregarNuevaEnsalada(ensaladaPreEstablecidas[numeroEnsalada]);
				System.out.println("Se agrego la ensalada al pedido?: " + seAgrego);
			
			} else {
				System.out.println("Importe total: " + nuevo.getImporte());
			}
			agregarAPedidos(pedidos, nuevo);	
			
		}while(opcion == 1);
	}

	public static void agregarAPedidos(Pedido[] pedidos, Pedido nuevo) {
		for(int i = 0; i < pedidos.length; i++) {
			if(pedidos[i] == null) {
				pedidos[i] = nuevo;
				break;
			}
		}
	}

	public static void mostrarIngrediestesDisponibles(Ingrediente[] ingredientesDisponibles) {
		System.out.println("Los ingredientes disponibles son: ");
		for(int i = 0; i < ingredientesDisponibles.length; i++) {
			if(ingredientesDisponibles[i] != null) {
				System.out.println("[" + (i+1) + "] " + ingredientesDisponibles[i].getNombre());
			}
		}
	}

	public static void incorporarIngredienteAEnsaladaPreEstablecida(Scanner entrada,
			Ingrediente[] ingredientesDisponibles, Ensalada nueva) {
		System.out.println("Desea agregar un ingrediente a la ensalda? 1. Si, 2. No.");
		int siOno = entrada.nextInt();
		
		if(siOno == 1) {
			System.out.println("Ingrese el numero del ingrediente:");
			int numeroIngrediente = (entrada.nextInt()) - 1;
			boolean seAgrego = nueva.agregarIngrediente(ingredientesDisponibles[numeroIngrediente]);
			System.out.println("Se agrego el ingrediente: " + seAgrego);
			
		} else {
			System.out.println("La ensalada es apta celiacos: " + nueva.esAptoCeliaco());
			System.out.println("La ensalada es apta vegetarianos: " + nueva.esAptoVegetariano());
			System.out.println("La ensalada es apta veganos: " + nueva.esAptoVegano());
		}
	}

	public static void agregarAEnsaladasPreEstablecidas(Ensalada[] ensaladaPreEstablecidas, Ensalada nueva) {
		for(int i = 0; i < ensaladaPreEstablecidas.length; i++) {
			if(ensaladaPreEstablecidas[i] == null) {
				ensaladaPreEstablecidas[i] = nueva;
				break;
			}
		}
	}

	public static boolean agregarAIngredientesDisponibles(Ingrediente[] ingredientesDisponibles, Ingrediente nuevo) {
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
	
	public static void ingredientesDisponibles(Ingrediente[] ingredientesDisponibles) {
		//lo incorpora en el array ingredientes disponibles
		Ingrediente zanahoria = new Ingrediente("Zanahoria", 50.0, Origen.VEGETAL);
		Ingrediente lechuga = new Ingrediente("Lechuga", 45.0, Origen.VEGETAL);
		Ingrediente tomate = new Ingrediente("Tomate", 60.0, Origen.VEGETAL);
		Ingrediente porotos = new Ingrediente("Porotos", 20.0, Origen.VEGETAL);
		Ingrediente legumbres = new Ingrediente("Legumbres", 25.0, Origen.VEGETAL);
		Ingrediente kale = new Ingrediente("Kale", 90.0, Origen.VEGETAL);
		Ingrediente frutas = new Ingrediente("Frutas", 80.0, Origen.VEGETAL);
		Ingrediente almendras = new Ingrediente("Almendras", 90.0, Origen.VEGETAL);
		Ingrediente aceite = new Ingrediente("Aceite", 25.0, Origen.VEGETAL);
		Ingrediente queso = new Ingrediente("Queso", 90.0, Origen.VEGETAL);
		Ingrediente leche = new Ingrediente("Leche", 30.0, Origen.VEGETAL);
		Ingrediente jamon = new Ingrediente("Jamon", 60.0, Origen.ANIMAL);
		Ingrediente pollo = new Ingrediente("Pollo", 75.0, Origen.ANIMAL);
		Ingrediente pasta = new Ingrediente("Pasta", 50.0, Origen.TACC);
		Ingrediente pan = new Ingrediente("Pan", 55.0, Origen.TACC);
		Ingrediente huevo = new Ingrediente("Huevo", 35.0, Origen.HUEVO);
		
		//agregar ingrediente a array de ingredientes de interfaz
		agregarAIngredientesDisponibles(ingredientesDisponibles, zanahoria);
		agregarAIngredientesDisponibles(ingredientesDisponibles, lechuga);
		agregarAIngredientesDisponibles(ingredientesDisponibles, tomate);
		agregarAIngredientesDisponibles(ingredientesDisponibles, porotos);
		agregarAIngredientesDisponibles(ingredientesDisponibles, legumbres);
		agregarAIngredientesDisponibles(ingredientesDisponibles, kale);
		agregarAIngredientesDisponibles(ingredientesDisponibles, frutas);
		agregarAIngredientesDisponibles(ingredientesDisponibles, almendras);
		agregarAIngredientesDisponibles(ingredientesDisponibles, aceite);
		agregarAIngredientesDisponibles(ingredientesDisponibles, queso);
		agregarAIngredientesDisponibles(ingredientesDisponibles, leche);
		agregarAIngredientesDisponibles(ingredientesDisponibles, jamon);
		agregarAIngredientesDisponibles(ingredientesDisponibles, pollo);
		agregarAIngredientesDisponibles(ingredientesDisponibles, pasta);
		agregarAIngredientesDisponibles(ingredientesDisponibles, pan);
		agregarAIngredientesDisponibles(ingredientesDisponibles, huevo);
	}
}
