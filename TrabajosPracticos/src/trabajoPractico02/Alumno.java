package trabajoPractico02;

public class Alumno {
//NO HAY SALIDAS POR CONSOLA ACA
//NO HAY SYSO
	
	//ATRIBUTOS
	String nombre;
	int nota1;
	int nota2;
	
	//COMPORTAMIENTO O METODOS
	public boolean promociono() {
		boolean resultado = nota1 >= 7 && nota2 >= 7;
		
		return resultado;
	}
	
	public boolean aprobo() {
		boolean resultado = (!promociono() && (nota1 >= 4 && nota2 >= 4));
		
		return resultado;
	}
	
	public boolean desaprobo() {
		boolean resultado = !promociono() && !aprobo();
		
		return resultado;
	}
	
}
