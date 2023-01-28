package callCenter;

public class Empresa {
	/*
	 * Se deben incorporar los atributos necesarios.
	 */
	private int zonasDeCobertura[];
	private String nombre;
	private Contacto contactos[];
	
	private final int CANTIDAD_MAXIMA_DE_ZONAS_DE_COBERTURA = 100;
	private final int CANTIDAD_MAXIMA_DE_CONTACTOS = 10;
	
	//private int cantidadDeContactosActuales;
	
	public Empresa(String nombre) {
		this.nombre = nombre;
		inicializarZonasDeCoberturas();
		//zonasDeCobertura = new int[CANTIDAD_MAXIMA_DE_ZONAS_DE_COBERTURA];
		contactos = new Contacto[CANTIDAD_MAXIMA_DE_CONTACTOS];
		//this.cantidadDeContactosActuales = 0;
		
	}
	
	private void inicializarZonasDeCoberturas() {
		zonasDeCobertura = new int[CANTIDAD_MAXIMA_DE_ZONAS_DE_COBERTURA];
	}
	
	public String getNombreEmpresa() {
		/*
		 * Devuelve el nombre de la empresa
		 */
		return this.nombre;
	}
	
	public boolean agregarNuevoContacto(Contacto nuevo) {
		/*
		 * Incorpora un nuevo contacto a la empresa
		 */
		boolean seAgrego = false;
		for(int i = 0; i < contactos.length; i++)
			if(contactos[i] == null) {
				contactos[i] = nuevo;
				seAgrego = true;
			}
		return seAgrego;
	}
	
	public boolean agregarNuevaZonaDeCobertura(int codigoPostal) {
		/*
		 * Incorpora una nueva zona de cobertura (Las zonas de cobertura se identifican por el codigo postal)
		 */
		boolean seAgrego = false;
		for(int i = 0; i < zonasDeCobertura.length; i++) {
			if(zonasDeCobertura[i] == 0) {
				zonasDeCobertura[i] = codigoPostal;
				seAgrego = true;
			}
		}
		return seAgrego;
		
	}	
	
	private boolean elCodigoPostalEstaDentroDeLaZonaDeCobertura(int codigoPostal) {
		/*
		 * Determina si un c�digo postal est� dentro de la zona de cobertura
		 */
		boolean encontrado = false;
		for(int i = 0; i < zonasDeCobertura.length; i++) {
			if(zonasDeCobertura[i] != 0) {
				if(zonasDeCobertura[i] == codigoPostal) {
					encontrado = true;
				}
			}
		}
		return encontrado;
	}
	
	public Contacto buscarCandidato() {
		/*
		 * Para determinar qu� contacto el sistema debe mostrar, se debe realizar la siguiente b�squeda:
		 * 1.	El contacto NO debe ser cliente a�n.
		 * 2.	El contacto desea ser llamado o al menos no inform� lo contrario.
		 * 3.	El c�digo postal del contacto debe existir en las zonas de cobertura existente.
		 * 4.	Del conjunto de contactos resultante se debe seleccionar aleatoriamente el pr�ximo llamado.
		 */
		Contacto buscado [] = new Contacto[contactos.length];
		int indice = 0;
		for(int i = 0; i < contactos.length; i++) {
			if(contactos[i] != null) {
				if (contactos[i].isEsCliente() == false && contactos[i].isDeseaSerLlamadoNuevamente() == true) {
					buscado[indice++] = contactos[i];
				}
			}
		}
		int aleatorio = (int)(Math.random()*contactos.length);
		return buscado[aleatorio];
	}
	
	public Contacto buscarPorNombre(String nombreABuscar) {
		Contacto buscado = null;
		for(int i = 0; i < contactos.length; i++) {
			if(contactos[i] != null) {
				if(contactos[i].getNombreYApellido().equals(nombreABuscar)) {
					buscado = contactos[i];
				}
			}
		}
		return buscado;
	}
		
}
