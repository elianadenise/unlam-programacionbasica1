package trabajoPractico09;
//TP 09 -ACT 04
import java.util.Scanner;

public class InterfazNotasDosArrays {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese la cantidad de estudiantes: ");
		byte cantidadDeEstudiantes = entrada.nextByte();
		System.out.println("Ingrese la cantidad de notas del cuatrimestre: ");
		byte cantidadDeNotas = entrada.nextByte();
		String nombresEstudiantes [] = new String[cantidadDeEstudiantes];
		float notasEstudiantes [] = new float[cantidadDeNotas];
		
		for(int i = 0; i < nombresEstudiantes.length; i++) {
			System.out.println("Ingrese el nombre del estudiante numero: " + (i+1));
			String nombreEstudiante = entrada.next();
			nombresEstudiantes[i] = nombreEstudiante;
			int notaAcumulada = 0;
			
			for(int j = 0; j < notasEstudiantes.length; j++) {
				System.out.println("Ingrese la nota " + (j+1) + " del estudiante: " + nombresEstudiantes[i]);
				float notaEstudiante = entrada.nextFloat();
				notasEstudiantes[j] = notaEstudiante;
				notaAcumulada += notasEstudiantes[j];
			}
			
			float promedio = (notaAcumulada/cantidadDeNotas);
			System.out.println(promedio);
			if(promedio >= 4 && promedio < 7 ) {
				System.out.println("Estado de " + nombresEstudiantes[i] + ": APROBADO.");
			} else if(promedio >= 7 && promedio <= 10) {
				System.out.println("Estado de " + nombresEstudiantes[i] + ": PROMOCIONADO.");
			} else if(promedio >= 0 && promedio < 4) {
				System.out.println("Estado de " + nombresEstudiantes[i] + ": DESAPROBADO/RECURSA.");
			}
		}
		
		
		/*for(int i = 0; i < notasEstudiantes.length; i++) {
			System.out.println("Ingrese la nota del estudiante: " + nombresEstudiantes[i]);
			float notaEstudiante = entrada.nextFloat();
			notasEstudiantes[i] = notaEstudiante;
			if(notaEstudiante >= 4 && notaEstudiante < 7 ) {
				System.out.println("Estado de " + nombresEstudiantes[i] + ": APROBADO.");
			} else if(notaEstudiante >= 7 && notaEstudiante <= 10) {
				System.out.println("Estado de " + nombresEstudiantes[i] + ": PROMOCIONADO.");
			} else if(notaEstudiante >= 0 && notaEstudiante < 4) {
				System.out.println("Estado de " + nombresEstudiantes[i] + ": DESAPROBADO/RECURSA.");
			}
		}*/

	}

}
