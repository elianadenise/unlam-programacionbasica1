package trabajoPracticoIntegrador;

public class Usuario {

	//ATRIBUTOS
	private String usuario;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private int edad;
	private boolean loguado;
	private boolean bloqueado;
	private int contadorFallos;
	
	//CONSTRUCTOR
	public Usuario() {
		this.usuario = "";
		this.apellido = "";
		this.edad = 0;
		this.usuario = "";
		this.contrasenia = "";
	}
	public Usuario(String usuario, String contrasenia, String nombre, String apellido, int edad) {
		this.usuario = usuario;
		if(laContraseniaEsValida(contrasenia)) {
			this.contrasenia = contrasenia;
		}
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.loguado = false;
		this.bloqueado = false;
		this.contadorFallos = 0;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public boolean isLoguado() {
		return loguado;
	}

	public void setLoguado(boolean loguado) {
		this.loguado = loguado;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getContadorFallos() {
		return contadorFallos;
	}
	public void setContadorFallos(int contadorFallos) {
		this.contadorFallos = contadorFallos;
	}
	
	//METODOS
	public boolean laContraseniaEsValida(String contraseniaEvaluada) {
		if(contraseniaEvaluada.length() >= 8) {
			this.setContrasenia(contraseniaEvaluada);
			return true;
		}
		return false;
	}
	
	public boolean cambiarContrasenia(String cambiar) {
		String contraseniaAnterior = this.contrasenia;
		if(cambiar.length() >= 8 && !contraseniaAnterior.equals(cambiar)) {
			this.setContrasenia(cambiar);
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "Usuario: " + this.usuario + "\nNombre: " + this.nombre + "\nApellido: " + this.apellido + "\nEdad: " + this.edad;
	}
	
	public boolean esBloqueado() {
		if(this.contadorFallos > 2) {
			this.bloqueado = true;
		}
		return this.bloqueado;
	}
	
}
	