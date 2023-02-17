package trabajoPractico03;
//TP 3 - ACT 4
import java.util.Scanner;

import trabajoPractico03.Nota;

public class InterfazNota {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese la nota de la estudiante:");
		float notaUno = entrada.nextFloat();
		Nota estudianteEliana = new Nota(notaUno);
		
		System.out.println("La nota ingresada es: " + estudianteEliana.getValor());
		System.out.println("Se encuentra aprobada? " + estudianteEliana.aprobado());
		
		recuperaOAprueba(entrada, notaUno, estudianteEliana);

		//System.out.println("Cuantos estudiantes van promocionando?" + estudianteEliana.cantidadDeEstudiantesPromocionados());

		System.out.println("-------------------------------------------------------");
		System.out.println("Ingrese la nota de la estudiante:");
		float notaDos = entrada.nextFloat();
		Nota estudianteLara = new Nota(notaDos);
		
		System.out.println("La nota ingresada es: " + estudianteLara.getValor());
		System.out.println("Se encuentra aprobada? " + estudianteLara.aprobado());
		
		recuperaOAprueba(entrada, notaDos, estudianteLara);
		
		//System.out.println(cantidadDeEstudiantesPromocionados(estudianteLara));	
		
	}

	public static void recuperaOAprueba(Scanner entrada, float nota, Nota nueva) {
		if(nota < 4) {
			System.out.println("Ingrese la nota del recuperatorio:");
			float notaRecupero = entrada.nextFloat();
			nueva.recuperar(notaRecupero);
			
			System.out.println("Aprobó el recuperatorio? " + nueva.aprobado());
		} else {
			System.out.println("La estudiante está aprobada, no debe recuperar");
		}
	}
	
	/*public static int cantidadDeEstudiantesPromocionados(Nota nueva) {
		int cantidadDeEstudiantesPromocionados = 0;
		if(nueva.getValor() > 7) {
			cantidadDeEstudiantesPromocionados++;
		}
		return cantidadDeEstudiantesPromocionados;
	}*/
}
