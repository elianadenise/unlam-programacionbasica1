package callCenter;

public class Contacto {
	/*
	 * Se deben incorporar los atributos necesarios.
	 * 
	 * �	Nombre y Apellido: No se aceptan n�meros.
	 * �	Celular: Compuesto del c�digo de pa�s + c�digo de �rea + n�mero de celular.
	 * �	E-Mail: Debe contener al menos el s�mbolo �@� y el caracter �.�.
	 * �	Direcci�n: Valor alfanum�rico.
	 * �	C�digo Postal: Valor num�rico.
	 * �	Localidad: Valor alfanum�rico.
	 * �	Provincia. Enumerador que contenga las 23 provincias argentinas.
	 * �	Es cliente (Si o No): Inicialmente se carga en �No�.
	 * �	Desea ser llamado nuevamente (Si o No): Inicialmente se carga en �Si�.
	 */
	
	private String nombreYApellido;
	private String celular;
	private String eMail;
	private String direccion;
	private int codigoPostal;
	private String localidad;
	private Provincia provincia;
	private boolean esCliente;
	private Llamada llamadasRecibidas[];
	private final int CANTIDAD_MAXIMA_DE_LLAMADOS_POR_CONTACTO;	
	
	public Contacto() {
		this.esCliente = false;
		this.deseaSerLlamadoNuevamente = true;
		this.CANTIDAD_MAXIMA_DE_LLAMADOS_POR_CONTACTO = 10;
		this.llamadasRecibidas = new Llamada[CANTIDAD_MAXIMA_DE_LLAMADOS_POR_CONTACTO];
	}
	
	public Contacto(String nombreYApellido, String celular, String eMail, String direccion, int codigoPostal, String localidad, Provincia provincia) {
		this.nombreYApellido = nombreYApellido;
		this.celular = celular;
		//this.eMail = eMail;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.esCliente = false;
		this.deseaSerLlamadoNuevamente = true;
		this.CANTIDAD_MAXIMA_DE_LLAMADOS_POR_CONTACTO = 10;
		this.llamadasRecibidas = new Llamada[CANTIDAD_MAXIMA_DE_LLAMADOS_POR_CONTACTO];
	}
	
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	
	public boolean isEsCliente() {
		return esCliente;
	}

	public void setEsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}

	private boolean deseaSerLlamadoNuevamente;
	
	public boolean isDeseaSerLlamadoNuevamente() {
		return deseaSerLlamadoNuevamente;
	}

	public void setDeseaSerLlamadoNuevamente(boolean deseaSerLlamadoNuevamente) {
		this.deseaSerLlamadoNuevamente = deseaSerLlamadoNuevamente;
	}
	
	public boolean esEmailValido(String eMail) {
		/*
		 * Eval�a si un String determinado puede ser almacenado como E-MAIL.
		 */
		boolean esValido = false;
		if(eMail.contains("@") && eMail.contains(".")) {
			esValido = true;
		}
		return esValido;		
	}
	
	public boolean esNombreValido(String nombre) {
		/*
		 * Eval�a si un String determinado puede ser almacenado como E-MAIL.
		 */
		boolean esValido = false;
		if(nombre.matches("[a-z]*")) {
			esValido = true;
		}
		return esValido;		
	}
	
	public boolean esCelularValido(String celular) {
		/*
		 * Eval�a si un String determinado puede ser almacenado como E-MAIL.
		 */
		boolean esValido = false;
		if(celular.matches("[0-9]*")) {
			esValido = true;
		}
		return esValido;		
	}
	
	public boolean registrarNuevaLlamada(Llamada nueva) {
		/*
		 * Registra una nueva llamada asociada al contacto actual.
		 */
		boolean seRegistro = false;
		for(int i = 0; i < llamadasRecibidas.length; i++) {
			if(llamadasRecibidas[i] == null) {
				llamadasRecibidas[i] = nueva;
				seRegistro = true;
				break;
			}
		}
		return seRegistro;		
	}
	
	public String toString() {
		/*
		 * Muestra los datos de un contacto, entre los que se debe incluir el registro de las llamadas realizadas.
		 */
		String llamadas = "";
		for(int i = 0; i < llamadasRecibidas.length; i++) {
			if(llamadasRecibidas[i] != null) {
				llamadas += llamadasRecibidas[i].toString() + "\n";
			}
		}
		return "Contacto: " + this.nombreYApellido + "\n" + llamadas;
		
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Llamada[] getLlamadasRecibidas() {
		return llamadasRecibidas;
	}

	public void setLlamadasRecibidas(Llamada[] llamadasRecibidas) {
		this.llamadasRecibidas = llamadasRecibidas;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}	
	
	
	
}
