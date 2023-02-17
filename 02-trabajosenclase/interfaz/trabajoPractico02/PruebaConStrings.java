package trabajoPractico02;
//Estudiante Eliana Navarro
//ACT 11 & 12
public class PruebaConStrings {
	
	public static void main(String[] args) {

		//charAt()
		String palabra = "Lara";
		char letra;
		letra = palabra.charAt(2);
		System.out.println("El caracter esta que esta en esa posicion es: " + letra);
		
		//length()
		String oracion = "Iron Maiden";
		System.out.println("El largo de oracion es (tambien cuenta espacios): " + oracion.length());
		
		//toLowerCase()
		System.out.println("La oracion en minuscula es: " + oracion.toLowerCase());
		
		//toUpperCase()
		System.out.println("La oracion en mayuscula es: " + oracion.toUpperCase());
		
		//trim()
		
		String sacoEspacios = "   Saca espacios al inicio y final ";
		System.out.println(sacoEspacios.trim());

		//equals() - es case sensitive
		String palabraUno = "Milu";
		String palabraDos = "milu";
		String palabraTres = "Milu";
		String palabraCuatro = "MILU";
		System.out.println(palabraUno.equals(palabraDos));//false
		System.out.println(palabraUno.equals(palabraTres));//true
		System.out.println(palabraUno.equalsIgnoreCase(palabraCuatro));//true
		
		//compareTo() - compara caracter por caracter (ASCII) y los va restando a penas hay una diferente
		System.out.println(palabraUno.compareTo(palabraDos));
		System.out.println(palabraUno.compareTo(palabraTres));
		System.out.println(palabraUno.compareTo(palabraCuatro));
		
		String palabra1 = "ornella";
		String palabra2 = "ornitorrinco";
		System.out.println(palabra1.compareTo(palabra2));
		
		//substring
		String oracion1 = "el Chaqueño Palavecino";
		String subOracion1 = oracion1.substring(5);
		System.out.println(subOracion1);
		String subOracion2 = oracion1.substring(4,13);
		System.out.println(subOracion2);
		
		
		//ACT 12
		String minuscula = "java es case sensitive";
		System.out.println(minuscula.length());
		
		String mayuscula = "JAVA ES CASE SENSITIVE";
		System.out.println(mayuscula + ".");
	}
}
