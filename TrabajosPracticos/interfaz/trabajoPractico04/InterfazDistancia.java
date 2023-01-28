package trabajoPractico04;

import java.util.Scanner;

public class InterfazDistancia {

	public static void main(String args[]) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese un valor en metros:");
		double valor = entrada.nextDouble();
		Distancia distancita = new Distancia(valor, 'm');
		
		System.out.println("Ingrese la unidad a la que desea convertir: "
				+ "\n 'k' = Kilometros \n 'h' = Hectometros \n 'd' = Decametros");
		char unidadAConvertir = entrada.next().charAt(0);
				
		if((unidadAConvertir == 'k') || (unidadAConvertir == 'd') || (unidadAConvertir == 'h') || (unidadAConvertir == 'm')) {
			System.out.println("La conversion da como resultado: " + distancita.convertir(unidadAConvertir));
		} else { 
			System.out.println("Ingrese una unidad valida.");
		}
		
		
	}
	
}
