package trabajoPractico02;

import java.util.Scanner;

public class NotasEstudiantes {
	public static void main(String[] args) {
		
		//ENTRADA
		String nombreEstudiante1 = null;
		int nota1Estudiante1 = 0;
		int nota2Estudiante1 = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre del estudiante:");
		
		nombreEstudiante1 = entrada.next(); 
		
		System.out.println("Ingrese la primera nota del estudiante: " + nombreEstudiante1);
		
		nota1Estudiante1 = entrada.nextInt();
		
		System.out.println("Ingrese la segunda nota del estudiante: " + nombreEstudiante1);
		
		nota2Estudiante1 = entrada.nextInt();
		
		//SALIDA
		estadoFinal(nombreEstudiante1, nota1Estudiante1, nota2Estudiante1);

		
		//ESTUDIANTE 2
		//ENTRADA
		String nombreEstudiante2 = null;
		int nota1Estudiante2 = 0;
		int nota2Estudiante2 = 0;
		
		System.out.println("-----------------------------------");
		System.out.println("Ingrese el nombre del estudiante 2:");
		
		nombreEstudiante2 = entrada.next(); 
		
		System.out.println("Ingrese la primera nota del estudiante 2: " + nombreEstudiante2);
		
		nota1Estudiante2 = entrada.nextInt();
		
		System.out.println("Ingrese la segunda nota del estudiante: " + nombreEstudiante2);
		
		nota2Estudiante2 = entrada.nextInt();
		
		//SALIDA
		estadoFinal(nombreEstudiante2, nota1Estudiante2, nota2Estudiante2);

		
		
		//ESTUDIANTE 3
		//ENTRADA
		String nombreEstudiante3 = null;
		int nota1Estudiante3 = 0;
		int nota2Estudiante3 = 0;
		
		System.out.println("-----------------------------------");
		System.out.println("Ingrese el nombre del estudiante 3:");
		
		nombreEstudiante3 = entrada.next();
		
		System.out.println("Ingrese la primera nota del estudiante 3: " + nombreEstudiante3);
		
		nota1Estudiante3 = entrada.nextInt();
		
		System.out.println("Ingrese la segunda nota del estudiante 3: " + nombreEstudiante3);
		
		nota2Estudiante3 = entrada.nextInt();
		
		//SALIDA
		estadoFinal(nombreEstudiante3, nota1Estudiante3, nota2Estudiante3);
		
	}
	
		//PROCESOS
	
	public static void estadoFinal(String nombre,int nota1, int nota2) {
		boolean promocionado = (nota1 >= 7 && nota2 >=7);
		boolean aprueba = (nota1 >= 4 && nota2 >= 4);
		boolean desaprueba = (nota1 < 4 || nota2 <4);
		
		double promedio = (nota1 + nota2)/2;
		
		System.out.println("La estudiante " + nombre + " promociona? " + promocionado);
		System.out.println("La estudiante "  + nombre + " aprueba? " + aprueba);
		System.out.println("La estudiante " + nombre + " desaprueba? "+ desaprueba);
		System.out.println("El Promedio es " + promedio);
	}
}
