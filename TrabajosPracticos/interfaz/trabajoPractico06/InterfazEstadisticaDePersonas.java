package trabajoPractico06;

import java.util.Scanner;

import trabajoPractico02.Persona;

public class InterfazEstadisticaDePersonas {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int muestra = 50;

		int edad;
		double peso;
		double altura;
		int personasConBajoPeso = 0;
		int personasConPesoNormal = 0;
		int personasConSobrePeso = 0;	
		int sumatoriaEdadBajoPeso = 0;
		int sumatoriaEdadPesoNormal = 0;
		int sumatoriaEdadSobrePeso = 0;
		int promedioEdadPesoNormal = 0;
		int promedioEdadBajoPeso = 0;
		int promedioEdadSobrePeso = 0;
		
		do{
			System.out.println("Ingrese la edad de la persona:");
			edad = entrada.nextInt();
			System.out.println("Ingrese el peso de la persona:");
			peso = entrada.nextDouble();
			System.out.println("Ingrese la altura de la persona:");
			altura = entrada.nextDouble();
			
			EstadisticaDePersonas nueva = new EstadisticaDePersonas(edad, peso, altura);
			
			double resultadoMasaCorporal = ((nueva.getPeso()) / (nueva.getAltura() * nueva.getAltura()));
			
			//CANTIDAD DE PERSONAS CON... & PROMEDIO DE EDADES
			if((resultadoMasaCorporal > 18.5) && (resultadoMasaCorporal < 29.9)) {
				personasConPesoNormal++;
				sumatoriaEdadPesoNormal += nueva.getEdad();
				promedioEdadPesoNormal = sumatoriaEdadPesoNormal / personasConPesoNormal;	
			} else if(resultadoMasaCorporal < 18.5) {
				personasConBajoPeso++;
				sumatoriaEdadBajoPeso += nueva.getEdad();
				promedioEdadBajoPeso = sumatoriaEdadBajoPeso / personasConBajoPeso;
				
			} else {
				personasConSobrePeso++;
				sumatoriaEdadSobrePeso += nueva.getEdad();
				promedioEdadSobrePeso = sumatoriaEdadSobrePeso / personasConSobrePeso;
			}
			
		} while (EstadisticaDePersonas.getCantidadDePersonasIngresadas() < muestra);
		
		System.out.println("Cantidad de personas con peso normal: " + personasConPesoNormal
				+ "\nLa edad promedio de las personas con peso normal es: " + promedioEdadPesoNormal);
		System.out.println("Cantidad de personas con bajo peso: " + personasConBajoPeso
				+ "\nLa edad promedio de las personas con bajo peso es: " + promedioEdadBajoPeso);
		System.out.println("Cantidad de personas con sobre peso: " + personasConSobrePeso
				+ "\nLa edad promedio de las personas con sobre peso es: " + promedioEdadSobrePeso);
		
		System.out.println("La cantidad de personas ingresadas hasta el momento son: " + EstadisticaDePersonas.getCantidadDePersonasIngresadas());
		
	}
}
