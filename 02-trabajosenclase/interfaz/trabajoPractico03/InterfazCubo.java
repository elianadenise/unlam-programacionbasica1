package trabajoPractico03;
//TP 3 - ACT 7
import java.util.Scanner;

import trabajoPractico03.Cubo;

public class InterfazCubo {

	public static void main(String[] args) {
		
	Scanner entrada = new Scanner(System.in);
	
	System.out.println("Ingrese la longitud de los lados del cubo:");
	float lado = entrada.nextFloat();
	Cubo cubito = new Cubo(lado);
	
	/*System.out.println("La superficie del cubo es: " + cubito.superficieCara() + "cm2."); //si lo pongo asi no anda, onda calcula, no tira error
	System.out.println("El volumen del cubo es: " + cubito.volumen() + "cm3.");*/
	
	positivoSuperficieVolumen(cubito);
	
	}

	public static void positivoSuperficieVolumen(Cubo nuevo) {
		if(nuevo.getLongitudLado()> 0) {
			System.out.println("La superficie del cubo es: " + nuevo.superficieCara() + "cm2."); 
			System.out.println("El volumen del cubo es: " + nuevo.volumen() + "cm3.");
		} else {
			System.out.println("Ingrese valores positivos, por favor.");
		}
	}
}
