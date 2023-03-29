package feb2023;

import java.util.Scanner;

public class InterfazPersona {
	public final static int ALTA_NUEVA_PERSONA = 1;
	public final static int CONSULTA_PERSONA_MAYOR_SALDO = 2;
	public final static int IMPRIMIR_LISTADO_PERSONAS = 3;
	public final static int CARGAR_SALDO_CUENTA_PERSONA = 4;
	public final static int INGRESO_CAJERO_DNI_CONTRASENIA = 5;
	public final static int SALIR = 0;
	
	public final static char DEPOSITAR = 'a';
	public final static char EXTRAER = 'b';
	public final static char CONSULTAR_SALDO = 'c';
	public final static char TRANSFERIR = 'd';
	public final static char CAMBIAR_CONTRASENIA = 'e';
	public final static char EXIT = 'z';
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int opcion = 0;
		
		System.out.println("--- Bienvenido al sistema del banco ---");
		System.out.println("Ingrese el tamaño del vector personas:");
		int tamanio = entrada.nextInt();
		Banco nuevo = new Banco(tamanio);
		do {
			System.out.println("\nMenu");
			System.out.println("1. Alta nueva persona, \n2. Consulta persona con mayor saldo, "
					+ "\n3. Imprimir listado personas, \n4. Cargar saldo a la cuenta de una persona,"
					+ "\n5. Ingreso al cajero (DNI y contraseña), \n0. Salir.\n");
			opcion = entrada.nextInt();
			
			switch(opcion) {
				case ALTA_NUEVA_PERSONA:
					System.out.println("Alta nueva persona:\n");
					System.out.println("Nombre: ");
					String nombre = entrada.next();
					System.out.println("Apellido: ");
					String apellido = entrada.next();
					System.out.println("Sexo: m o f: ");
					char sexo = entrada.next().charAt(0);
					System.out.println("DNI: ");
					int dni = entrada.nextInt();
					System.out.println("Saldo: ");
					float saldo = entrada.nextFloat();
					System.out.println("Contrasenia: ");
					String contrasenia = entrada.next();
					
					Persona nueva = new Persona(nombre, apellido, sexo, dni, saldo, contrasenia);
					if(nuevo.altaNuevaPersona(nueva)) {
						System.out.println("Se ha registrado con éxito");
					} else {
						System.out.println("¡ERROR!");
					}
					break;
				case CONSULTA_PERSONA_MAYOR_SALDO:
					System.out.println("Persona con mayor saldo:\n");
					System.out.println(nuevo.personaConMayorSaldo());
					break;
				case IMPRIMIR_LISTADO_PERSONAS:
					System.out.println("Listado de personas:\n");
					for(int i = 0; i < nuevo.getCuentas().length-1; i++) {
						if(nuevo.getCuentas()[i] != null) {
							System.out.println(nuevo.getCuentas()[i].toStringDos() + "\n-----------\n");
						}
					}
					break;
				case CARGAR_SALDO_CUENTA_PERSONA:
					System.out.println("Cargar saldo:\n");
					System.out.println("Ingrese el dni del titular de la cuenta: \n");
					int dniCargar = entrada.nextInt();
					System.out.println("Ingrese el monto a cargar: \n");
					float montoCargar = entrada.nextFloat();
					if(nuevo.cargarSaldoEnCuenta(dniCargar, montoCargar)) {
						System.out.println("Carga efectuada.");
					} else { 
						System.out.println("¡ERROR!");
					}
					break;
				case INGRESO_CAJERO_DNI_CONTRASENIA:
					System.out.println("Ingreso cajero:\n");
					System.out.println("Ingrese DNI: \n");
					int dniVerificar = entrada.nextInt();
					System.out.println("Ingrese contrasenia: \n");
					String contraseniaVerificar = entrada.next();
					if(nuevo.iniciarSesion(dniVerificar, contraseniaVerificar)) {
						char elegir = 'z';
						do {
							System.out.println("\nMenu");
							System.out.println("a. Depositar, \nb. Extraer, "
									+ "\nc. Consultar saldo, \nd. Transferir,"
									+ "\ne. Cambiar contrasenia, \nz. Salir.\n");
							elegir = entrada.next().charAt(0);
							switch(elegir) {
							case DEPOSITAR, 'A':
								System.out.println("Depositar");
								System.out.println("Ingrese el monto a depositar: \n");
								float monto = entrada.nextFloat();
								
								System.out.println("Su monto actual es: $" + nuevo.depositar(monto, dniVerificar));
								break;
							case EXTRAER, 'B':
								System.out.println("Extraer");
								System.out.println("Ingrese el monto a extraer: \n");
								float montoEx = entrada.nextFloat();
								
								System.out.println("Su monto actual es: $" + nuevo.extraer(montoEx, dniVerificar));
								break;
							case CONSULTAR_SALDO, 'C':
								System.out.println("Consultar saldo");
								System.out.println("Saldo actual: $" + nuevo.consultarSaldo(dniVerificar));
								break;
							case TRANSFERIR, 'D':
								System.out.println("Transferir a otra cuenta");
								System.out.println("Ingrese el dni de la cuenta a transferir");
								int dniCuenta = entrada.nextInt();
								System.out.println("Ingrese el monto a transferir");
								float montoTransferir = entrada.nextFloat();
								if(nuevo.transferir(dniVerificar, dniCuenta, montoTransferir)) {
									System.out.println("Se ha realizado la transferencia con exito");
								} else {
									System.out.println("¡ERROR!");
								}
								break;
							case CAMBIAR_CONTRASENIA, 'E':
								System.out.println("Cambiar contrasenia");
								System.out.println("Ingrese la nueva contrasenia:");
								String nuevaC = entrada.next();
								System.out.println("Repita la contrasenia:");
								String nuevaCDos = entrada.next();
								if(nuevo.cambiarContrasenia(dniVerificar, contraseniaVerificar, nuevaC, nuevaCDos)) {
									System.out.println("Cambio con exito");
								} else {
									System.out.println("¡ERROR!");
								}
								break;
							case EXIT, 'Z':
								break;
							default:
								break;
							}
						} while (elegir != EXIT);
					} else {
						System.out.println("¡ERROR! Verificar datos");
					}
					
					break;
				case SALIR:
					break;
			}
			
		} while (opcion != SALIR);
		

	}

}
