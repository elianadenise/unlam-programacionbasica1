package trabajoPractico09;

import java.util.Scanner;

public class InterfazSegundoEjeciciodeClase {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int numeroAleatorioEntero [];
		System.out.println("Numeros aleatorios Enteros:");
		numeroAleatorioEntero = new int [5];
		numeroAleatorioEntero[0] = 5;
		numeroAleatorioEntero[1] = 85;
		numeroAleatorioEntero[2] = 66;
		numeroAleatorioEntero[3] = 54;
		numeroAleatorioEntero[4] = 99;
		
		for(int i = 0; i < numeroAleatorioEntero.length; i++) {
			System.out.println("Numero aleatorio " + (i+1));
			System.out.println(numeroAleatorioEntero[i]);
		}
		
		//BUSQUEDA DEL MENOR
		int menorElemento = numeroAleatorioEntero[0];
		int posicionMenor = 0;
		for(int i = 0; i < numeroAleatorioEntero.length; i++) {			
			if(numeroAleatorioEntero[i] <= menorElemento) {
				menorElemento = numeroAleatorioEntero[i];
				posicionMenor = i;
			}
		}
		System.out.println("Elemento menor: " + menorElemento + " posicion: " + posicionMenor); 
		
		//BUSQUEDA DEL MAYOR
		int mayorElemento = numeroAleatorioEntero[0];
		int posicionMayor = 0;
		for(int i = 0; i < numeroAleatorioEntero.length; i++) {			
			if(numeroAleatorioEntero[i] >= mayorElemento) {
				mayorElemento = numeroAleatorioEntero[i];
				posicionMayor = i;
			}
		}
		System.out.println("Elemento mayor: " + mayorElemento + " posicion: " + posicionMayor); 
		
		//
		
		int numeroAleatorioEnteroSegundo [];
		System.out.println("Numeros aleatorios Enteros:");
		numeroAleatorioEnteroSegundo = new int [10];
		for(int i = 0; i < numeroAleatorioEnteroSegundo.length; i++) {
			System.out.println("Numero aleatorio " + (i+1));
			numeroAleatorioEnteroSegundo[i] = (int) (Math.random()*100+1);//del 1 a 99
			System.out.println(numeroAleatorioEnteroSegundo[i]);
		}
		
		//NUMERO MENOR EN UN ARRAY
		int menorElementoSegundo = numeroAleatorioEntero[0];
		int posicionMenorSegundo = 0;
		for(int i = 0; i < numeroAleatorioEntero.length; i++) {			
			if(numeroAleatorioEntero[i] <= menorElementoSegundo) {
				menorElementoSegundo = numeroAleatorioEntero[i];
				posicionMenorSegundo = i;
			}
		}
		System.out.println("Elemento menor: " + menorElementoSegundo + " posicion: " + posicionMenorSegundo); 
		
		//NUMERO MAYOR EN UN ARRAY
		int mayorElementoSegundo = numeroAleatorioEntero[0];
		int posicionMayorSegundo = 0;
		for(int i = 0; i < numeroAleatorioEntero.length; i++) {			
			if(numeroAleatorioEntero[i] >= mayorElementoSegundo) {
				mayorElementoSegundo = numeroAleatorioEntero[i];
				posicionMayorSegundo = i;
			}
		}
		System.out.println("Elemento mayor: " + mayorElementoSegundo + " posicion: " + posicionMayorSegundo); 
		
		//BUSQUEDA DE UN NUMERO
		System.out.println("Ingrese un numero a buscar:");
		int numeroBuscado = entrada.nextInt();
		int cantidadDeVecesQueAparece = 0;
		for(int i = 0; i < numeroAleatorioEnteroSegundo.length; i++) {			
			if(numeroAleatorioEnteroSegundo[i] == numeroBuscado) {
				cantidadDeVecesQueAparece++;
			}
		}
		System.out.println("El numero " + numeroBuscado + " se encuentra " + cantidadDeVecesQueAparece + " veces.");
	}

}
