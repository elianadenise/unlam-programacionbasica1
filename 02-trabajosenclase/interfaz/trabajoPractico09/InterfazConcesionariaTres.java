package trabajoPractico09;

import java.util.Scanner;

public class InterfazConcesionariaTres {

    public static void main (String args[]) {
        
        //bandera se utiliza para saber si el codigo en algun momento paso por ahi
        
        Scanner entrada = new Scanner(System.in);
        ConcesionariaUno laTablada = new ConcesionariaUno();
        laTablada.setNombre("La Tablada");
        System.out.println("Biendenidx al sistema de la Concesionaria " + laTablada.getNombre());
        
        FuncionalidadesDelSistema opcionElegida;
        
        do {
            menu();
            opcionElegida = ejecutarMenu(entrada, laTablada);
            
        }while(opcionElegida != FuncionalidadesDelSistema.SALIR);
        
    }

    private static FuncionalidadesDelSistema ejecutarMenu(Scanner entrada, ConcesionariaUno nuevaConcesionaria) {
        FuncionalidadesDelSistema opcionElegida = FuncionalidadesDelSistema.SALIR;
        FuncionalidadesDelSistema opcionesDisponibles[] = FuncionalidadesDelSistema.values();//(values) devuelve un array con todos los elementos del enum
        //opcionElegida = opcionesDisponibles[entrada.nextInt()-1];
        int opcionIngresada = entrada.nextInt();
        
        if(opcionIngresada > opcionesDisponibles.length) {
            System.out.println("Opcion no valida");
        } else {
            opcionElegida = opcionesDisponibles[opcionIngresada-1];
        }
        switch(opcionElegida) {
        case COMPRAR:
            imprimirTitulo("Agregar auto al sistema");
            agregarAListadoDeAutos(entrada, nuevaConcesionaria);
            break;
        case VENDER:
            imprimirTitulo("Vender auto");
            venderAuto(entrada, nuevaConcesionaria);
            break;
        case CONSULTAR_STOCK:
            imprimirTitulo("Consultar stock");
            autosDisponibles(nuevaConcesionaria);
            consultarStock(nuevaConcesionaria);
            break;
        case BUSCAR:
            imprimirTitulo("Buscar");
            System.out.println("Ingrese una palabra a buscar");
            String palabra = entrada.next();
            System.out.println(nuevaConcesionaria.buscar(palabra));
            break;
        case CONSULTAR_SUMA_ASEGURADA:
            imprimirTitulo("Consultar suma asegurada");
            System.out.println("La suma asegurada es: " + nuevaConcesionaria.sumaAsegurada());
            break;
        case AGREGAR_VENDEDOR:
        	imprimirTitulo("Agregar vendedor");
        	System.out.println("Ingrese nombre de usuario");
        	String vendedor = entrada.next();
        	VendedorConcesionaria vendedorcito = new VendedorConcesionaria(vendedor);
        	nuevaConcesionaria.agregarVendedores(vendedorcito);
        	if(nuevaConcesionaria.agregarVendedores(vendedorcito)) {
        		System.out.println("- Vendedor validado -");
        	} else { 
        		System.out.println("- No se ha validado -");
        	}
        	break;
        case SALIR: 
            imprimirTitulo("Ha salido del menu");
            break;
        default:
            imprimirTitulo("Elija un valor valido");
            break;
        }
        return opcionElegida;
    }

	public static void venderAuto(Scanner entrada, ConcesionariaUno nuevaConcesionaria) {
		autosDisponibles(nuevaConcesionaria);
		System.out.println("Ingrese el codigo del auto a vender: ");
		int codigoDeAutoAVender = entrada.nextInt();
		System.out.println("Elija el vendedor");
		System.out.println(nuevaConcesionaria.mostrarVendedores());
		int vendedor = entrada.nextInt();
		if(nuevaConcesionaria.venderAuto(codigoDeAutoAVender, vendedor)) { //si da true
			System.out.println("Venta exitosa");
		} else {
			System.out.println("No se realizo la venta");
		}
		
		System.out.println("Suma comisionada por vendedor " + vendedor + ": " + nuevaConcesionaria.cantidadComisionada(vendedor));
	}

	public static void autosDisponibles(ConcesionariaUno nuevaConcesionaria) {
		System.out.println("Los autos disponibles son: ");
		System.out.println(nuevaConcesionaria.mostrarAutosDisponibles());
	}

	public static void consultarStock(ConcesionariaUno nuevaConcesionaria) {
		System.out.println("Vehiculos en Stock en concesionaria "+ nuevaConcesionaria.getNombre() + ": " + nuevaConcesionaria.consultarStock());
	}

	public static void agregarAListadoDeAutos(Scanner entrada, ConcesionariaUno nuevaConcesionaria) {
		Autito nuevo = new Autito();
		System.out.println("Marca:");
		nuevo.setMarca(entrada.next());
		System.out.println("Modelo:");
		nuevo.setModelo(entrada.next());
		System.out.println("Anio:");
		nuevo.setAnio(entrada.nextInt());
		System.out.println("Kilometros actuales:");
		nuevo.setKilometrosActuales(entrada.nextInt());
		if(!nuevo.esCeroKm()) {
		    System.out.println("Patente:");
		    nuevo.setPatente(entrada.next());
		}
		System.out.println("Precio de venta:");
		nuevo.setPrecio(entrada.nextDouble());
		
		nuevaConcesionaria.comprarAuto(nuevo);
	}

    private static void menu() {
        System.out.println("Menu: \n1. Agregar auto \n2. Vender\n3. Consultar stock \n4. Buscar \n5. Consultar suma asegurada \n6. Agregar vendedor \n7. Salir");
    }

    private static void imprimirTitulo(String titulo) {
        System.out.println("--------------------------------");
        System.out.println(titulo);
        System.out.println("--------------------------------");
    }
    
}