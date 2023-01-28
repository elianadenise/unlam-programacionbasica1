package trabajoPractico09;

import java.util.Scanner;

public class InterfazLetrasArrayOrne {

	public static void main(String args[]) {
		
		Scanner teclado = new Scanner (System.in);
		
		char abecedarioMayusculas[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		char abecedarioMinusculas[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		int numeros[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		String nuevaContrasenia = "";
		int numeroAIngresar = 0;
		int numeroAIngresarDos = 0;
		
		do {
			System.out.println("Bienvenido, para generar su contrasenia, siga estos pasos:");
			
			
					System.out.println("Debe ser entre 0 y 25\nPrimera letra en mayusculas:");
					numeroAIngresar = teclado.nextInt();
					nuevaContrasenia += abecedarioMayusculas[numeroAIngresar];
					
					System.out.println("Segunda letra en mayusculas:");
					numeroAIngresarDos = teclado.nextInt();
					nuevaContrasenia += abecedarioMayusculas[numeroAIngresarDos];
					
					System.out.println("Debe ser entre 0 y 25\nUna minuscula:");
					numeroAIngresar = teclado.nextInt();
					nuevaContrasenia += abecedarioMinusculas[numeroAIngresar];
				
					
					System.out.println("Debe ser entre 0 y 9\nAhora un numero:");
					numeroAIngresar = teclado.nextInt();
					nuevaContrasenia += numeros[numeroAIngresar];
					
					System.out.println("Segundo numero:");
					numeroAIngresarDos = teclado.nextInt();
					nuevaContrasenia += numeros[numeroAIngresarDos];
					
				
					System.out.println("Su contrasenia es: " + nuevaContrasenia);
			
			
			
			
		} while(numeroAIngresar != (-1));
	}
}
