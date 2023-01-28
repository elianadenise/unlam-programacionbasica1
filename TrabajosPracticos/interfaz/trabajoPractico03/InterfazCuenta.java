package trabajoPractico03;
//TP 3 - ACT 6
import java.util.Scanner;

import trabajoPractico03.Cuenta;

public class InterfazCuenta {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre del titular de la cuenta:");
		String titular = entrada.nextLine();
		System.out.println("Ingrese el saldo de la cuenta");
		double saldo = entrada.nextDouble();
		Cuenta eliana = new Cuenta(titular,saldo);
		
		System.out.println("Monto a depositar:");
		double deposito = entrada.nextDouble();
		eliana.depositar(deposito);
		System.out.println("El saldo actual de la cuenta es " + eliana.getSaldoActual());
		
		System.out.println("Monto a retirar:");
		double retiro = entrada.nextDouble();
		if(retiro > eliana.getSaldoActual()) {
			System.out.println("No se puede retirar ese monto debido a que es mayor al saldo de la cuenta");
		} else { 
			eliana.retirar(retiro);
			System.out.println("El saldo actual de la cuenta es: " + eliana.getSaldoActual());
		}
		
		System.out.println("La new Cuenta devuelve: " + eliana);
		
		eliana.soyUnaHackerEncubierta();
		System.out.println("El saldo actual es: " + eliana.getSaldoActual());
	}

}
