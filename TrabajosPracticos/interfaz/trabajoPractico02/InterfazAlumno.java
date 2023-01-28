package trabajoPractico02;

import java.util.Scanner;

//Estudiante Eliana Navarro
//Actividad
/*Desarrollar un programa que permita registrar tres estudiantes
y de esos tres estudiantes querememos saber:
	- nombre
	- nota 1
	- nota 2
	- condicion (promociono, aprobo, desaprobo)*/

public class InterfazAlumno {

	public static void main(String[] args) {
	
		Alumno estudianteUno, estudianteDos, estudianteTres;
		Scanner entrada = new Scanner(System.in);
		
		estudianteUno = estadoFinal();
		estudianteDos = estadoFinal();
		estudianteTres = estadoFinal();
		
		informacionDelEstudiante(estudianteUno);
		informacionDelEstudiante(estudianteDos);
		informacionDelEstudiante(estudianteTres);
		
		
	}

	//PROCESOS
	public static void informacionDelEstudiante(Alumno estudiante) {
		System.out.println("-----------------------------------");
		System.out.println("Nombre del estudiante: " + estudiante.nombre);
		System.out.println("Promociona? " + estudiante.promociono());
		System.out.println("Aprueba? " + estudiante.aprobo());
		System.out.println("Desaprueba? " + estudiante.desaprobo());
	}
	
	
	public static Alumno estadoFinal() {
		Alumno nuevo = new Alumno();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("-----------------------------------");
		System.out.println("Ingrese el nombre del estudiante:");
		nuevo.nombre = entrada.next();
		
		System.out.println("Ingrese la primera nota del estudiante: " + nuevo.nombre);
		nuevo.nota1 = entrada.nextInt();
		
		System.out.println("Ingrese la segunda nota del estudiante: " + nuevo.nombre);
		nuevo.nota2 = entrada.nextInt();
		
		return nuevo;
	
	}
}
