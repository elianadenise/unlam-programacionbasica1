package trabajoPractico04;

import java.util.Scanner;

public class DiaDeLaSemana {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		byte numeroDeDia = 0;
		System.out.println("Ingrese un numero del 1 al 7 y el sistema informara el dia de la semana:");
		numeroDeDia = entrada.nextByte();
		
		switch(numeroDeDia) {
		case 1:
			System.out.println("Lunes");
			break;
		case 2:
			System.out.println("Martes");
			break;
		case 3:
			System.out.println("Miercoles");
			break;
		case 4:
			System.out.println("Jueves");
			break;
		case 5:
			System.out.println("Viernes");
			break;
		case 6:
			System.out.println("Sabado");
			break;
		case 7:
			System.out.println("Domingo");
			break;
		default:
			System.out.println("ERROR");
		}
		
	}

}
