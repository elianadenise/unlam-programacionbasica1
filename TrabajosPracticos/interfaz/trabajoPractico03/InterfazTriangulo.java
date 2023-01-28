package trabajoPractico03;

import java.util.Scanner;

import trabajoPractico03.Triangulo;

public class InterfazTriangulo {

	public static void main(String[] args) {
	
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese la medida del lado 1");
		double lado1 = entrada.nextDouble();
		System.out.println("Ingrese la medida del lado 2");
		double lado2 = entrada.nextDouble();
		System.out.println("Ingrese la medida del lado 3");
		double lado3 = entrada.nextDouble();
		
		Triangulo x = new Triangulo(lado1,lado2,lado3);
		
		System.out.println("equilatero " + x.equilatero());
		System.out.println("escaleno " + x.escaleno());
		System.out.println("isosceles " + x.isosceles());
		
		
		tipoDeTriangulo(x);
		
		
	}
	
	public static void tipoDeTriangulo(Triangulo nuevo) {
		if(nuevo.equilatero()) {
			System.out.println("Es equilatero");
		} else if(nuevo.escaleno()) {
			System.out.println("Es escaleno");
		} else if(nuevo.isosceles()) {
			System.out.println("Es isosceles");
		}
		
	}

}
