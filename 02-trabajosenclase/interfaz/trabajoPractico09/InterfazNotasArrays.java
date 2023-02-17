package trabajoPractico09;
//TP 09 - ACT 02
import java.util.Scanner;

public class InterfazNotasArrays {

	public static void main(String[] args) {//aca hay otro array
		
		Scanner entrada = new Scanner(System.in);
		int numeroIngresado = 0;
		int auxiliar = 0;
		int CANTIDAD_DE_NUMEROS_A_INGRESAR = 5;
		int numeros [] = new int[CANTIDAD_DE_NUMEROS_A_INGRESAR];
		
		for(int i = 0; i < CANTIDAD_DE_NUMEROS_A_INGRESAR; i++) {
			System.out.println("Ingrese un valor entero");
			numeros[i] = entrada.nextInt();
		}

		for(int i = 1; i < CANTIDAD_DE_NUMEROS_A_INGRESAR; i++) {
			for(int j = 0; j < CANTIDAD_DE_NUMEROS_A_INGRESAR - 1; j++) {
				if(numeros[j] > numeros[j+1]) {
					auxiliar = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = auxiliar;
				}
				
			}
		}
		System.out.println("Array ordenado crecientemente: ");
		for(int i = 0; i < CANTIDAD_DE_NUMEROS_A_INGRESAR; i++) {
			System.out.println(numeros[i]);
		}
		
		
		
		
		
		
		
		
		/*System.out.println("Cuantos estudiantes hay?");
		int cantidadDeEstudiantes = entrada.nextInt();
		notas = new int [cantidadDeEstudiantes];
		//System.out.println(notas);//obtengo el espacio en memoria del array
		//System.out.println(notas[0]);//obtengo el espacio en memoria de la posicion 0
		
		for(int i = 0; i < notas.length; i++) {//algoritmo estandar para recorrer un array
			System.out.println("Nota " + (i+1));
			notas[i] = entrada.nextInt();
			System.out.println(notas);
		}

		int sumatoria = 0;
		for(int i = 0; i < notas.length; i++) {//algoritmo estandar para recorrer un array
			sumatoria += notas[i];
		}
		System.out.println("El promedio es: " + (sumatoria/notas.length));*/
	}

}
