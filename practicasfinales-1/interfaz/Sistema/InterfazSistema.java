package Sistema;

import java.util.Scanner;

public class InterfazSistema {
	public static final int REGISTRAR_USUARIO = 1;
	public static final int INICIAR_SESION = 2;
	public static final int EDITAR_CONTRASENIA = 3;
	public static final int BUSCAR_USUARIO = 4;
	public static final int ELIMINAR_USUARIO = 5;
	public static final int SALIR = 9;

	public static void main(String args[]) {
		Scanner entrada = new Scanner(System.in);
		Sistema sistemita = new Sistema("Registro de registros -ahre-");
		System.out.println("Bienvenido al " + sistemita.getNombreSistema());
		
		int opcion = 0;
		do {
			System.out.println("Menu: \n1. Registrar usuario, \n2. Iniciar sesion, \n3. Editar contrasenia, \n4. Buscar usuario, \n5. Eliminar usuario, \n9.Salir");
			opcion = entrada.nextInt();
			switch(opcion) {
			case REGISTRAR_USUARIO:
				System.out.println("-REGISTRAR USUARIO-");
				System.out.println("Nombre:");
				String nombre = entrada.next();
				System.out.println("Usuario:");
				String usuario = entrada.next();
				System.out.println("Contrasenia:");
				String contrasenia = entrada.next();
				Usuario nuevo = new Usuario(nombre, usuario, contrasenia);
				nuevo.registrarContrasenias(contrasenia);
				if(sistemita.registrarUsuario(nuevo)) {
					System.out.println("Se registro exitosamente");
				} else {
					System.out.println("No se pudo registrar, intente nuevamente.");
				}
				
				break;
			case INICIAR_SESION:
				System.out.println("-INICIAR SESION-");
				System.out.println("Usuario:");
				String usuario2 = entrada.next();
				System.out.println("Contrasenia:");
				String contrasenia2 = entrada.next();
				if(sistemita.iniciarSesion(usuario2, contrasenia2)) {
					System.out.println("Se inicio sesion");
				} else { 
					System.out.println("No se pudo iniciar sesion");
				}
				
				break;
			case EDITAR_CONTRASENIA:
				System.out.println("-EDITAR CONTRASENIA-");
				System.out.println("Usuario:");
				String usuario3 = entrada.next();
				System.out.println("Contrasenia anterior:");
				String contrasenia3 = entrada.next();
				System.out.println("Contrasenia nueva");
				String contrasenianueva = entrada.next();
				if(sistemita.editarContrasenia(usuario3, contrasenia3, contrasenianueva)) {
					System.out.println("Se edito con exito");
				} else {
					System.out.println("No se pudo editar");
				}
				
				break;
			case BUSCAR_USUARIO:
				System.out.println("-BUSCAR USUARIO-");
				System.out.println("Usuario:");
				String usuario4 = entrada.next();
				System.out.println(sistemita.buscarPorUsuario(usuario4));
				break;
			case ELIMINAR_USUARIO:
				System.out.println("-ELIMINAR USUARIO-");
				System.out.println("Usuario:");
				String usuario5 = entrada.next();
				System.out.println("Contrasenia:");
				String contrasenia5 = entrada.next();
				if(sistemita.eliminarUsuario(usuario5, contrasenia5)) {
					System.out.println("Se elimino el usuario");
				} else {
					System.out.println("No se pudo eliminar");
				}
				break;
			case SALIR:
				System.out.println("Gracias por usar el sistema");
				break;
			}
		} while(opcion != SALIR);
		
	}
}
