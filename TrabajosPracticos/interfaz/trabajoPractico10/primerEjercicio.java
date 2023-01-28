package trabajoPractico10;

import java.util.Scanner;

public class primerEjercicio {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int filas = 3;
		int columnas = 3;
		
		int numerosRandom [][] = new int [filas][columnas];
		
		for(int i = 0; i < numerosRandom.length; i++) {
			for(int j = 0; j < numerosRandom[i].length; j++) {
				if(numerosRandom[i][j] == 0) {
					numerosRandom[i][j] = (int) (Math.random()*100);	
				}
			}
		}
		
		for(int i = 0; i < numerosRandom.length; i++) {
			for(int j = 0; j < numerosRandom[i].length; j++) {
				System.out.println(numerosRandom[i][j]);
			}
		}
	
	
	
	
		final int FILA = 2;
		final int COLUMNA = 2;
		int vectorBidimensional[][] = new int [FILA][COLUMNA];

		for(int i = 0; i<vectorBidimensional.length; i++) {
			for(int j = 0; j<vectorBidimensional[i].length; j++) {
				System.out.print("Cargue un numero en la posicion del vector " + i + j);
				vectorBidimensional[i][j] = teclado.nextInt();
				
			}
		}
		for(int i = 0; i<vectorBidimensional.length; i++) {
			for(int j = 0; j<vectorBidimensional[i].length; j++) {
				System.out.println("Lo que se encuentra en el vector " + i + j + " es: " + vectorBidimensional[i][j]);
			}
		}
		
	
	}

}
