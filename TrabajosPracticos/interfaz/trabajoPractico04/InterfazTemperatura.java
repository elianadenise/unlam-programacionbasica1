package trabajoPractico04;

import java.util.Scanner;

public class InterfazTemperatura {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("--Ingrese una temperatura--");
		double valor = entrada.nextDouble();
		Temperatura temperaturita = new Temperatura(valor);
		
		//se utiliza el set
		System.out.println("Ingrese la unidad \n 'c' = Celsius \n 'f' = Farenheit \n 'k' = Kelvin");
		char unidad = entrada.next().charAt(0);
		//temperaturita.setUnidad(unidad);
		temperaturita.setValor(valor,unidad);
		
		System.out.println(temperaturita.getUnidad());
		System.out.println(temperaturita.getValor());
		System.out.println("Elija una opcion para convertir la unidad, tenga en cuenta la unidad elegida anteriormente"
				+ "\n 'c' = Celsius \\n 'f' = Farenheit \\n 'k' = Kelvin");
		char unidadAConvertir = entrada.next().charAt(0);
		if(unidad != unidadAConvertir) {
			System.out.println("Se convirtio la temperatura a la unidad deseada: " + temperaturita.convertir(unidadAConvertir) + "°.");
		} else { 
			System.out.println("No se puede convertir ya que está eligiendo la misma unidad"
					+ "\nLa temperatura es " + temperaturita.getValor() + temperaturita.getUnidad());
		}
		
	}

}
