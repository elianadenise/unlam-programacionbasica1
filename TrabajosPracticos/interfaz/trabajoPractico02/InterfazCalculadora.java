package trabajoPractico02;

import java.util.Scanner;

//Estudiante Eliana Navarro
//ACT 5
public class InterfazCalculadora {

	public static void main(String[] args) {
		Calculadora calculadoraNormal = new Calculadora(1,2);
		//TP 2 
		/*System.out.println("El resultado de la suma entre los operadores es: " + calculadoraNormal.sumar());
		System.out.println("El resultado de la resta entre los operadores es: " + calculadoraNormal.restar());
		System.out.println("El resultado de la multiplicacion entre los operadores es: " + calculadoraNormal.multiplicar());
		System.out.println("El resultado de la division entre los operadores es: " + calculadoraNormal.dividir());

		Calculadora calculadoraCasio = new Calculadora(1,2);
		
		System.out.println("El resultado de la suma entre los operadores es: " + calculadoraCasio.sumar());
		System.out.println("El resultado de la resta entre los operadores es: " + calculadoraCasio.restar());
		System.out.println("El resultado de la multiplicacion entre los operadores es: " + calculadoraCasio.multiplicar());
		System.out.println("El resultado de la division entre los operadores es: " + calculadoraCasio.dividir());

		*/
		//las calculadoras funcionan igual porque son ejemplos del mismo objeto.


		//TP 3 - ACT 1
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese el primer operador:");
		double operador1 = entrada.nextDouble();
		System.out.println("Ingrese el segundo operador:");
		double operador2 = entrada.nextDouble();
		
		Calculadora calculadorcita = new Calculadora(operador1,operador2);
		calculadorcita.dividir();
		//System.out.println("El resultado de la division es: " + calculadorcita.dividir()); //PREGUNTAR POR QUE NO FUNCIONA ASI
		//NO FUNCIONAAAAA me deja dividir por 0
		if(operador2 != 0.0) { //preguntar porque no funciona con el metodo
			System.out.println("El resultado de la division es: " + calculadorcita.dividir());
		} else {
			System.out.println("ERROR! no se puede dividir por 0");
		}
		
		if(calculadorcita.esPositivo()) { //esto si funciona
			System.out.println("Los operadores son positivos");
		} else {
			System.out.println("Ingrese datos positivos para poder realizar las operaciones en esta calculadora");
		}
		
		//TP 05 - ACT 02
		System.out.println("--Ingrese la base de la potencia:");
		double base = entrada.nextInt();
		System.out.println("--Ingrese la potencia:");
		double potencia = entrada.nextInt();
		System.out.println("El resultado de la potencia es: " + calculadorcita.potencia(base, potencia));
		//TP 05 - ACT 03
		System.out.println("--Ingrese el limite para la sumatoria:");
		int limite = entrada.nextInt();
		System.out.println("El resuldado de la sumatoria es: " + calculadorcita.sumatoria(limite));
		//TP 05 - ACT 04
		System.out.println("--Ingrese el limite inferior para la sumatoria:");
		int limiteInferior = entrada.nextInt();
		System.out.println("--Ingrese el limite superior para la sumatoria:");
		int limiteSuperior = entrada.nextInt();
		System.out.println("El resuldado de la sumatoria es: " + calculadorcita.sumatoria(limiteInferior, limiteSuperior));
		//TP 05 - ACT 05
		System.out.println("--Ingrese el limite para la productoria:");
		int limiteProductoria = entrada.nextInt();
		System.out.println("El resuldado de la productoria es: " + calculadorcita.sumatoria(limiteProductoria));
		//TP 05 - ACT 06
		System.out.println("--Ingrese el limite inferior para la productoria:");
		int limiteInferiorP = entrada.nextInt();
		System.out.println("--Ingrese el limite superior para la productoria:");
		int limiteSuperiorP = entrada.nextInt();
		System.out.println("El resuldado de la productoria es: " + calculadorcita.sumatoria(limiteInferiorP, limiteSuperiorP));
		//TP 05 - ACT 07
		System.out.println("--Ingrese un numero para contar sus divisores:");
		int numero = entrada.nextInt();
		System.out.println("Los divisores del numero son: " + calculadorcita.contarDivisores(numero));
		//TP 05 - ACT 07 otro ejemplo
		for(int i =1; i <= numero; i++) {
			if((numero % i) ==0) {
				System.out.println("Los divisores del numero son: " + i + ", ");
			}
		}
		//TP 06 - ACT 01
		System.out.println("factorial de 6 es: " + calculadoraNormal.factorial(6));
	
	}

}
