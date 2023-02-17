package trabajoPractico03;

public class InterfazReferencia {

	public static void main(String[] args) {
	
		String textoUno = new String("Hola");
		String textoDos = new String("Hola");
		
		if(textoUno == textoDos) {
			System.out.println("Los textos son iguales");
		} else {
			System.out.println("Los textos son distintos");
		} // da los textos distintos porque "==" compara los espacios en memoria
		
		if(textoUno.equals(textoDos)) {
			System.out.println("Los textos son iguales");
		} else {
			System.out.println("Los textos son distintos");
		} //da los textos son iguales porque compara el contenido
		
		
	}
}
