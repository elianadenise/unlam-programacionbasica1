package trabajoPractico09;

import java.util.Scanner;

public class InterfazSistema {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre del sistema:");
		String nombre = entrada.next();
		Sistema sistemita = new Sistema(nombre);
		int opcion;
		
		do {
			System.out.println("Menu: \n1. Registrar usuario \n2. Iniciar sesion \n3. Usuarios del Sistema\n4. Cerrar ventana");
			opcion = entrada.nextInt();
			switch(opcion) {
			case 1: 
				Usuario nuevoUsuario = new Usuario();
				System.out.println("Registrar nuevo usuario");
				System.out.println("Ingrese nombre de usuario:");
				nuevoUsuario.setUsuario(entrada.next());
				//String usuario = entrada.next();
				System.out.println("Ingrese contrasenia:");
				nuevoUsuario.setContrasenia(entrada.next());
				//String contrasenia = entrada.next();
				//Usuario nuevoUsuario = new Usuario(usuario, contrasenia);
				sistemita.registrarUsuario(nuevoUsuario);
				if(sistemita.registrarUsuario(nuevoUsuario)) {
					System.out.println("Registro exitoso");
				} else { 
					System.out.println("No se ha podido registrar el usuario");
				}
				break;
			case 2:
				System.out.println("Iniciar sesion:");
				System.out.println("Ingrese usuario:");
				String usuarioIngresado = entrada.next();
				System.out.println("Ingrese contrasenia:");
				String contraseniaIngresada = entrada.next();
				sistemita.iniciarSesion(usuarioIngresado, contraseniaIngresada);
				break;
			case 3:
				System.out.println("Los usuarios del sistema son:");
				System.out.println(sistemita.usuariosDelSistema());
				break;
			case 4:
				System.out.println("Ha salido del sistema.");
				break;
			default:
				System.out.println("Ingrese valor valido");
				break;
			}
		} while(opcion != 3);
	}
}
