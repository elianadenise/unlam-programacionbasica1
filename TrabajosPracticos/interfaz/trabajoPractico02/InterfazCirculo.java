package trabajoPractico02;

import java.util.Scanner;

//Estudiante Eliana Navarro
//ACT 6, 7, 8 & 13
public class InterfazCirculo {
	public static void main(String[] args) {
		Scanner entrada;
		entrada = new Scanner(System.in);
		
		System.out.println("Ingrese el radio de la circunferencia para calcular el area y el perimetro:");
		double radio = entrada.nextDouble();
		calcularElArea(radio);
		calcularElPerimetro(radio);
		
		//prueba con random - - da un numero al azar.
		double randomcito = Math.random();
		System.out.println("Un numero random: " + randomcito);
		
		//prueba con sqrt - - da la raiz cuadrada del numero ingresado
		double sqrticito = Math.sqrt(4);
		System.out.println("La raiz cuadrada del numero 4 es: " + sqrticito);
		
		//ACT 6
		/*Como sabes, para poder utilizar una clase en Java, es necesario instanciar un objeto de
		dicha clase. Sin embargo, existen casos en los que esto no se cumple. Tomando como base
		los ejemplos vistos hasta el momento, ¿Te animás a identificar en qué caso no estamos
		instanciando la clase para poder utilizarla? ¿Cómo explicarías esta situación?*/
		//esto no se cumple cuando hablamos de por ejemplo clases como Math o System. 
		//Son clases que ya vienen preestablecidas con el lenguaje.
	}
	
	public static void calcularElArea(double elRadioDelMetodo) {
		double area = 0.0;
		area = Math.PI * Math.pow(elRadioDelMetodo, 2); //potencia
		System.out.println("el area del circulo es: " + area);
	}
	
	public static void calcularElPerimetro(double elRadioDelMetodo) {
		double perimetro = 0.0;
		perimetro = 2 * Math.PI * elRadioDelMetodo;
		System.out.println("el perimetro del circulo es: " + perimetro);
	}
	
}
