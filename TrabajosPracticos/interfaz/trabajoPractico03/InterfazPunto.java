package trabajoPractico03;
//TP 3 - ACT 5
import java.util.Scanner;

import trabajoPractico03.Punto;

public class InterfazPunto {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese la coordenada X");
		float coordX = entrada.nextFloat();
		System.out.println("Ingrese la coordenada Y");
		float coordY = entrada.nextFloat();
		Punto coordenadas = new Punto(coordX,coordY);
		
		System.out.println("La coord y se encuentra sobre el eje de las x? " + coordenadas.sobreEjeX());
		System.out.println("La coord x se encuentra sobre el eje de las y? " + coordenadas.sobreEjeY());
		System.out.println("Se encuentra en el punto de origen? " + coordenadas.enPuntoDeOrigen());
		
		//este es mi codigo
		posicionCoordenadaX(coordenadas.getCoordenadaX());
		posicionCoordenadaY(coordenadas.getCoordenadaY());

	}

	public static void posicionCoordenadaX(float coordX) { //este es mi codigo
		if(coordX > 0) {
			System.out.println("La coordenada X es positiva");
		} else if(coordX < 0) {
			System.out.println("La coordenada X es negativa");
		} else {
			System.out.println("La coordenada X se encuentra sobre el origen de coordenadas");
		}
	}
	
	public static void posicionCoordenadaY(float coordY) { //este es mi codigo
		if(coordY > 0) {
			System.out.println("La coordenada Y es positiva");
		} else if(coordY < 0) {
			System.out.println("La coordenada Y es negativa");
		} else {
			System.out.println("La coordenada Y se encuentra sobre el origen de coordenadas");
		}
	}

}
