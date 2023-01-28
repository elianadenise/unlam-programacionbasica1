package trabajoPracticoIntegrador;

import java.util.Scanner;

public class InterfazSistema {

	public static final int REGISTRAR_USUARIO = 1;
	public static final int ESTADISTICAS = 2;
	public static final int INICIAR_SESION = 3;
	public static final int BUSCAR = 4;
	public static final int SALIR = 9;
	
	
	public static void main(String args[]) {
		
		Scanner entrada = new Scanner(System.in);
		
		Sistema sistemita = new Sistema();
		
		int opcion = 0;
		
		do {
			System.out.println("Menu");
			System.out.println("1. Registrar usuarios\n2. Estadisticas del sistema\n3. Iniciar sesion\n4. Buscar Usuario\n9. Salir");
			
			opcion = entrada.nextInt();
			
			switch(opcion) {
			case REGISTRAR_USUARIO:
				System.out.println("-----------------------------");
				System.out.println("Registrar usuario");
				System.out.println("-----------------------------");
				
				System.out.println("Nombre:");
				String nombre = entrada.next();
				System.out.println("Apellido:");
				String apellido = entrada.next();
				System.out.println("Edad:");
				int edad = entrada.nextInt();
				System.out.println("Usuario:");
				String usuario = entrada.next();
				System.out.println("Contrasenia:");
				String contrasenia = entrada.next();
				
				Usuario nuevo = new Usuario(usuario, contrasenia, nombre, apellido, edad);
				
				if(sistemita.registrarUsuario(nuevo)) {
					System.out.println("Registrado con exito");
				} else { 
					System.out.println("No pudo registrarse");
				}
				break;
				
			case ESTADISTICAS:
				System.out.println("-----------------------------");
				System.out.println("Estadisticas del sistema");
				System.out.println("-----------------------------");
				System.out.println("Cantidad de usuarios registrados:");
				System.out.println(sistemita.cantidadUsuariosRegistrados());
				System.out.println("Cantidad de usuarios bloqueados: ");
				System.out.println(sistemita.cantidadUsuariosBloqueados());
				System.out.println("Edad promedio");
				System.out.println(sistemita.edadPromedio());
				break;
				
			case INICIAR_SESION: 
				System.out.println("-----------------------------");
				System.out.println("Iniciar sesion");
				System.out.println("-----------------------------");
				System.out.println("Usuario:");
				String usuarioAloguear = entrada.next();
				System.out.println("Contrasenia:");
				String contraseniaAloguar = entrada.next();
				if(sistemita.loguearUsuario(usuarioAloguear, contraseniaAloguar)) {
					System.out.println("Se logueo con exito");
				} else {
					System.out.println("ERROR");
				}
				break;
			case BUSCAR: 
				System.out.println("-----------------------------");
				System.out.println("Buscar usuario");
				System.out.println("-----------------------------");
				System.out.println("Usuario a buscar");
				String usuarioBuscado = entrada.next();
				//SI FUNCIONAAAAAA WIIII FUNCIONA CON Y SIN EL TO STRING
				System.out.println(sistemita.buscarUsuario(usuarioBuscado));
				break;
			case SALIR:
				System.out.println("HA SALIDO DEL MENU");
			default:
				System.out.println("Opcion no valida");
				break;
				
			}
			
			
			
		}while (opcion != 9);
		
		
	}
	
}
