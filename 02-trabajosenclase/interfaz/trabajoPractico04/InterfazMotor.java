package trabajoPractico04;

import java.util.Scanner;

public class InterfazMotor {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("--Ingrese el tipo de bomba:"
				+ "\n 0 = No hay valor establecido"
				+ "\n 1 = Bomba de agua"
				+ "\n 2 = Bomba de gasolina"
				+ "\n 3 = Bomba de hormigon"
				+ "\n 4 = Bomba de pasta alimenticia");
		int tipoDeBomba = entrada.nextInt();
		Motor motorcito = new Motor(tipoDeBomba, "liquido", "gasoil");
		decimeElTipoDeMotor(motorcito);
		
	}

	//metodo creado en la interfaz para usar syso
	public static void decimeElTipoDeMotor(Motor nuevo) {
		switch(nuevo.getTipoDeBomba()) {
		case 0:
			System.out.println("No hay establecido un valor definido para el tipo de bomba");
			break;
		case 1:
			System.out.println("La bomba es una bomba de agua");
			break;
		case 2: 
			System.out.println("La bomba es una bomba de gasolina");
			break;
		case 3:
			System.out.println("La bomba es una bomba de hormigón");
			break;
		case 4:
			System.out.println("La bomba es una bomba de pasta alimenticia");
			break;
		default:
			System.out.println("No existe un valor válido para tipo de bomba");
			break;
		}
	}

}
