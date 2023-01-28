public class Promedio{
	public static void main(String args[]){
		//Declaracion
		float notaUno;
		float notaDos;
		float notaTres;
		float resultado;
		
		//Entrada
		notaUno = 7;
		notaDos = 9;
		notaTres = 4;
		
		//Proceso
		resultado = (notaUno + notaDos + notaTres) / 3;
		
		//Salida
		System.out.println("El promedio del estudiante es: " + resultado);
	}
	
}