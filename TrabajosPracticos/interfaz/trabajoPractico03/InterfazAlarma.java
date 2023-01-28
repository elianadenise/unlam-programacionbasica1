package trabajoPractico03;

import java.util.Scanner;

import trabajoPractico03.Alarma;

public class InterfazAlarma {

public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Bienvenido/a, introduzca un nuevo codigo de seguridad");
		int codigoDeSeguridad = teclado.nextInt();
		Alarma nuevaAlarma = new Alarma(codigoDeSeguridad);
		System.out.println("Su codigo de seguridad es: " + nuevaAlarma.getCodigoDeSeguridad());
		
		System.out.println("------------------------------------------------------");
		System.out.println("Ingrese nuevamente el codigo de seguridad");
		int codigo = teclado.nextInt();
		
		nuevaAlarma.encender(codigo);
		
		
		if(nuevaAlarma.isEncendida()) {
			System.out.println("La alarma se enciende");
			
		} else {
			System.out.println("Codigo invalido");
		}
		
		System.out.println("------------------------------------------------------");
		System.out.println("El sensor de movimiento detecto actividad");
		nuevaAlarma.setSensorDeMovimiento(true);
		if (nuevaAlarma.activada()) {
			System.out.println("*WEEEEEO WEEEEEO TUIIIII TUIIIII*");
		}
		
		System.out.println("Desea apagar la alarma?, Ingrese el codigo nuevamente");
		int codigoDos = teclado.nextInt();
		
		nuevaAlarma.apagar(codigoDos);
		nuevaAlarma.setEncendida(false);
		nuevaAlarma.setSensorDeMovimiento(false);
		if(nuevaAlarma.isEncendida() == false) {
			System.out.println("La alarma se apago correctamente");
		} else {
			System.out.println("La alarma no se apago");
		}
	}
	
}
