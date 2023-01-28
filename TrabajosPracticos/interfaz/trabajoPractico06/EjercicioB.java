package trabajoPractico06;

import java.util.Scanner;

public class EjercicioB {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		//A.
		System.out.println("Ha seleccionado X producto \nDesea continuar?");
		char opcion = entrada.next().charAt(0);
		while ((opcion == 's') || (opcion == 'S'))  {
			System.out.println("Opciones de pago bla bla bla");
			
			opcion = entrada.next().charAt(0);
		} 
		System.out.println("Ha vuelto a la pagina principal."); 
		
		
		//B.
		System.out.println("Ingrese un numero por teclado.");
		int valor = entrada.nextInt();
		
		do {
			System.out.println("El numero que es: " + valor);
			
			System.out.println("Ingrese un numero nuevo");
			valor = entrada.nextInt();
			
		} while ((valor >= 1000 ) && (valor <= 9999));
		System.out.println("El numero que ingreso no es valido");
		
		// C.
		
		
		System.out.println("Ingrese un numero entre valido en byte");
		byte numero = entrada.nextByte();
		while (numero <= 127) {
			System.out.println("El numero es: " + numero);
			System.out.println("Ingrese un numero nuevo");
			numero = entrada.nextByte();
		}
		System.out.println("El numero que ingreso no es valido");
		

	}

}
