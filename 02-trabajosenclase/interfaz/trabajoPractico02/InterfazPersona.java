package trabajoPractico02;

//Estudiante Eliana Navarro

import java.util.Scanner;

public class InterfazPersona {

	public static void main(String[] args) {
		
		Persona personaUno, personaDos;
		
		Scanner entrada = new Scanner(System.in);
		
		/*personaUno = nacimiento();
		//personaDos = nacimiento();
		
		personaUno = enCrecimiento(personaUno);
		//personaDos = enCrecimiento(personaDos);
		
		personaUno = seMurio(personaUno);
		//personaDos = seMurio(personaDos);
		
		System.out.println(personaUno);
		
		Persona eliana = new Persona();
		
		long dni = entrada.nextLong();
		if(dni>0) {
			eliana.setDni(dni);
		} else {
			System.out.println("Colocaste un numero que no va negri");
		}
		
		System.out.println("-------------------------------------");
		System.out.println("Pasaron los años y la persona creció, indica su edad:");
		int nuevaEdad = entrada.nextInt();
		personaUno.setEdad(nuevaEdad);
		System.out.println("Su edad ahora es " + personaUno.getEdad() + ".");
		System.out.println("Es mayor de edad? " + personaUno.esMayorDeEdad());*/
		
		Persona personita = new Persona();
		System.out.println("Años que crece la persona:");
		int edad = entrada.nextInt();
		personita.edadSeleccionada(edad);
		System.out.println("Ahora la edad de la persona es: " + personita.getEdad());
		
		
	}
	
	public static Persona nacimiento() {
		Persona nueva = new Persona();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre de la persona que ha nacido:");
		nueva.setNombre(entrada.nextLine());
		
		System.out.println("Ingrese el genero de " + nueva.getNombre() + " (F, M o X)");
		nueva.setGenero(entrada.next());
		
		System.out.println("Ingrese el DNI de " + nueva.getNombre() + " (sin puntos)");
		nueva.setDni(entrada.nextLong());
		
		System.out.println("Ingrese el peso de " + nueva.getNombre() + " (en kilos)"); 
		nueva.setPeso(entrada.nextDouble());
		
		System.out.println("Ingrese la altura de " + nueva.getNombre() + " (en centrimetros)");
		nueva.setAltura(entrada.nextDouble());
		
		System.out.println("Ingrese la edad de " + nueva.getNombre());
		nueva.setEdad(entrada.nextInt());
		
		return nueva;
	}

	
	public static Persona enCrecimiento(Persona nueva) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("--------------------------------------------------------");
		System.out.println(nueva.getNombre() + " se encuentra en crecimiento...");
		System.out.println("Ingresá kilos de comida para alimentar a " + nueva.getNombre());
		nueva.alimentar(entrada.nextDouble());
		System.out.println("Ingresá centimetros para que " + nueva.getNombre() + " crezca");
		nueva.crecer(entrada.nextDouble());
		System.out.println("La edad actual de " + nueva.getNombre() + " es:");
		nueva.masEdad();
		System.out.println(nueva.getEdad());
		
		System.out.println("---------------------------------------------------------");
		System.out.println("Los datos actuales de " + nueva.getNombre() + " son:");
		System.out.println("Edad: " + nueva.getEdad());
		System.out.println("Altura: " + nueva.getAltura());
		System.out.println("Peso: " + nueva.getPeso());
		
		return nueva;
	}
	
	public static Persona seMurio(Persona nueva) {
		nueva.morir();
		
		System.out.println("--------------------------------------------------------");
		System.out.println(nueva.getNombre() + ", está viva?: " + nueva.getVive());
		
		return nueva;
	}
	
}
