package trabajoPractico02;

import java.util.Scanner;

//Estudiante Eliana Navarro
//ACT 3 & 4

public class InterfazCoche {

	public static void main(String args[]) {
		Scanner entrada = new Scanner(System.in);
		
		/*Coche autoNuevo, autoUsado;
		
		autoNuevo = new Coche("Chevrolet", "Onix", 233034.90, "plateado", 250);
		
		//para ingresar valores desde scanner al constructor
		String unaMarca;
		String unModelo;
		int losKm;
		int anioDeFab;
		double unPrecio;
		String unColor;
		int velocidadActual;
		
		System.out.println("Ingresá una marca");
		unaMarca = entrada.nextLine();
		System.out.println("Ingresá un modelo");
		unModelo = entrada.next(); //pongo algo separado y me tira error - SOLUCIONADO con nextLine
		System.out.println("Ingresá los km recorridos de este auto usado");
		losKm = entrada.nextInt();
		System.out.println("Ingresá el año de fabricación");
		anioDeFab = entrada.nextInt();
		System.out.println("Ingresá un precio");
		unPrecio = entrada.nextDouble();
		System.out.println("Ingresá un color");
		unColor = entrada.next();
		System.out.println("Ingresá la velocidad actual");
		velocidadActual = entrada.nextInt();
		
		autoUsado =  new Coche(unaMarca, unModelo, losKm, anioDeFab, unPrecio, unColor, velocidadActual);
		
		if(velocidadActual > 500 || velocidadActual < 0) {
			System.out.println("Error, ingresá una velocidad real");
			
		}
		
		//como hago para que se pregunte de nuevo la velocidad actual?
		
		System.out.println("Ahora vemos los valores ingresados");
		System.out.println(autoUsado.getMarca());
		System.out.println(autoUsado.getModelo());
		System.out.println(autoUsado.getKilometrosActuales());
		System.out.println(autoUsado.getAnioDeFabricacion());
		System.out.println(autoUsado.getPrecio());
		System.out.println(autoUsado.getColor());
		
		
		System.out.println("La cantidad de coches actual es: " + Coche.getCantidadCoches());
		
		*/
		
		Coche miniCooper = new Coche("Mini Cooper", 15, 55.55);
		
		System.out.println("Tiempo de aceleracion para llegar a velocidad maxima: " + miniCooper.alcanzarVelocidadMaxima() + " segundos.");
		
		Coche ferrari = new Coche("Ferrari", 40, 97.23);
		
		System.out.println("Tiempo de aceleracion para llegar a velocidad maxima: " + ferrari.alcanzarVelocidadMaxima() + " segundos.");
	
		Coche fitito = new Coche("Fitito", 4, 25);
		
		System.out.println("Tiempo de aceleracion para llegar a velocidad maxima: " + fitito.alcanzarVelocidadMaxima() + " segundos.");
	}


}
