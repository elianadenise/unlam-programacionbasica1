package trabajoPractico02;
//Estudiante Eliana Navarro
//ACT 9
import java.util.Scanner;

public class InterfazDiscoRigido {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese manualmente el tamaño del Seagate");
		double tamanioseagate = entrada.nextDouble();
		DiscoRigido seagate = new DiscoRigido(tamanioseagate);
		System.out.println("Un seagate equivale a " + seagate.cantidadDvd() + " cantidad de DVDs");
		System.out.println("Un seagate equivale a " + seagate.cantidadBlueRay() + " cantidad de Blue Rays");
		
		System.out.println("------------------------------------------------");
		System.out.println("Ingrese manualmente el tamaño del hitachi");
		double tamaniohitachi = entrada.nextDouble();
		DiscoRigido hitachi = new DiscoRigido(tamaniohitachi);
		System.out.println("Un hitachi equivale a " + hitachi.cantidadDvd() + " cantidad de DVDs");
		System.out.println("Un hitachi equivale a " + hitachi.cantidadBlueRay() + " cantidad de Blue Rays");
		
		System.out.println("------------------------------------------------");
		System.out.println("Ingrese manualmente el tamaño del westerndigital");
		double tamaniowesterndigital = entrada.nextDouble();
		DiscoRigido westerndigital = new DiscoRigido(tamaniowesterndigital);
		System.out.println("Un westerndigital equivale a " + westerndigital.cantidadDvd() + " cantidad de DVDs");
		System.out.println("Un westerndigital equivale a " + westerndigital.cantidadBlueRay() + " cantidad de Blue Rays");
		
		System.out.println("------------------------------------------------");
		System.out.println("Ingrese manualmente el tamaño del toshiba");
		double tamaniotoshiba = entrada.nextDouble();
		DiscoRigido toshiba = new DiscoRigido(tamaniotoshiba);
		System.out.println("Un toshiba equivale a " + toshiba.cantidadDvd() + " cantidad de DVDs");
		System.out.println("Un toshiba equivale a " + toshiba.cantidadBlueRay() + " cantidad de Blue Rays");
		
		
		
	}

}
