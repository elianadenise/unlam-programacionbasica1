package trabajoPractico05;

import java.util.Scanner;

public class InterfazDado {

	public static void main(String[] args) {
	
		Scanner entrada = new Scanner(System.in);
		Dado dadito = new Dado();
		System.out.println("Cantidad de veces que han sido tirados los dados: " + dadito.getTirarDados());
		System.out.println("Los dados han sido tirados? " + dadito.isHanSidoLanzados());
		
		dadito.tirarDados();
		System.out.println("Cantidad de veces que han sido tirados los dados: " + dadito.getTirarDados());
		System.out.println("Los dados han sido tirados? " + dadito.isHanSidoLanzados());
	}

}
