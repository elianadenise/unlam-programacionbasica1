package trabajoPractico09;

import java.util.Scanner;
//ACA SE HACE TODO EN CONJUNTO CON LA CLASE
public class InterfazConcesionaria {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Bienvenidx al sistema de la concesionaria");
		System.out.println("Ingrese su codigo de Vendedor");
		String vendedor = entrada.next();
		/*Concesionaria vendedorUno = new Concesionaria(vendedor); //CONSULTAR AL PROFE
		System.out.println(vendedorUno.mostrarVehiculosDisponibles());*/
		
		System.out.println("Ingrese codigo de vehiculo a consultar");
		byte codigoDelVehiculo = entrada.nextByte();
		Concesionaria vendedorUno = new Concesionaria(vendedor, codigoDelVehiculo);
		System.out.println("El vehiculo consultado es:\n" + vendedorUno.getAutoConsultado());
		System.out.println("\n" + vendedorUno.mostrarVehiculosDisponibles()); //mostrar al profe
		
		System.out.println("\n---- Se procede a vender el auto ----");
		vendedorUno.venderAuto(codigoDelVehiculo);
		System.out.println("Autos vendidos por el vendedor " + vendedorUno.getVendedor() + ": " + vendedorUno.getAutosVendidos());
		System.out.println("Comision actual del vendedor " + vendedorUno.getVendedor() + ": " + vendedorUno.getComision());
		
		System.out.println("\nBuscar por marca, Ingrese la marca: ");
		String marcaBuscada = entrada.next();
		System.out.println(vendedorUno.buscarPorMarca(marcaBuscada));
	
		System.out.println("\nBuscar por modelo, Ingrese el modelo: ");
		String modeloBuscado = entrada.next();
		System.out.println(vendedorUno.buscarPorMarca(modeloBuscado));
	}

}
