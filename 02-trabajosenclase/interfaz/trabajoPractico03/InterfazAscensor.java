package trabajoPractico03;

import java.util.Scanner;

import trabajoPractico02.Persona;
import trabajoPractico03.Ascensor;
//Estudiante Eliana Navarro
//TP03 - ACT 13
//TP 06 - ACT 01
public class InterfazAscensor {

	public static void main(String args[]) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("--Se inaugura un ascensor en el edificio--");
		System.out.println("Ingrese la capacidad maxima del ascensor:");
		int capacidad = entrada.nextInt();
		System.out.println("Ingrese el peso maximo del ascensor:");
		double peso = entrada.nextInt();
		Ascensor ascensorcito = new Ascensor(capacidad, peso);
		
		System.out.println("--Ingresa un vecino al ascensor--");
		System.out.println("Se abre la puerta?" + ascensorcito.abrirPuerta());
		System.out.println("Ingrese el peso del vecino:");
		double pesoVecinoUno = entrada.nextDouble();
		Persona vecinoUno = new Persona(pesoVecinoUno);
		if(vecinoUno.getPeso() < ascensorcito.getPESO_MAXIMO()) {
			ascensorcito.ingresar(vecinoUno);
			System.out.println("La puerta sigue abierta? " + ascensorcito.cerrarPuerta());
		
			System.out.println("El peso actual del ascensor es: " + ascensorcito.getPesoActual());
			System.out.println("La capacidad actual del ascensor es: " + ascensorcito.getCapacidadActual()); 
		
			System.out.println("El vecino desea subir tres pisos");
			ascensorcito.subir();
			ascensorcito.subir();
			ascensorcito.subir();
			System.out.println("Cual es el piso actual? " + ascensorcito.getPisoActual());
		
			System.out.println("Ahora quiere bajar dos pisos");
			ascensorcito.bajar();
			ascensorcito.bajar();
			System.out.println("Cual es el piso actual? " + ascensorcito.getPisoActual());	
		
			System.out.println("El vecino sale del ascensor");
			System.out.println("Se abre la puerta?" + ascensorcito.abrirPuerta());
			ascensorcito.salir(vecinoUno);
			System.out.println("El peso actual del ascensor es: " + ascensorcito.getPesoActual());
			System.out.println("La capacidad actual del ascensor es: " + ascensorcito.getCapacidadActual()); 
		} else {
			System.out.println("Se ha superado el peso maximo del ascensor");
		}
		
		System.out.println("Ahora ingresan dos vecinos");
		System.out.println("Se abre la puerta?" + ascensorcito.abrirPuerta());
		System.out.println("Ingrese el peso del primer vecino:");
		double pesoVecinoDos = entrada.nextDouble();
		Persona vecinoDos = new Persona(pesoVecinoDos);
		ascensorcito.ingresar(pesoVecinoDos);
		System.out.println("Ingrese el peso del segundo vecino:");
		double pesoVecinoTres = entrada.nextDouble();
		Persona vecinoTres = new Persona(pesoVecinoTres);
		ascensorcito.ingresar(pesoVecinoTres);
		System.out.println("El peso actual del ascensor es: " + ascensorcito.getPesoActual());
		System.out.println("La capacidad actual del ascensor es: " + ascensorcito.getCapacidadActual()); 
		ascensorcito.cerrarPuerta();
		//TP 06 - ACT 01
		System.out.println("Ingrese el piso al que desean ir los vecinos:");
		int piso = entrada.nextInt();
		ascensorcito.irAlPiso(piso);
		
		System.out.println("Ahora se encuentran en el piso: " + ascensorcito.getPisoActual());
		System.out.println("Ingrese el piso al que desean ir los vecinos:");
		int pisoDos = entrada.nextInt();
		ascensorcito.irAlPisoDos(pisoDos);
		System.out.println("Ahora se encuentran en el piso: " + ascensorcito.getPisoActual());
	}
	
}
