package trabajoPractico09;

public class Sistema {

	//ATRIBUTOS
	private String nombreDelSistema;
	private Usuario comunidad[];
	private final int CANTIDAD_USUARIOS = 100;
	private boolean usuarioCorrecto;
	private boolean contraseniaCorrecta;
	
	//CONSTRUCTOR
	public Sistema(String nombre) {
		this.nombreDelSistema = nombre;
		comunidad = new Usuario[CANTIDAD_USUARIOS];
		this.usuarioCorrecto = false;
		this.contraseniaCorrecta = false;
	}
	
	//GETS&SETS

	
	//METODOS
	public boolean registrarUsuario(Usuario nuevo) {
		int usuariosIguales = 0;
		for(int i = 0; i < comunidad.length; i++) {
			if(comunidad[i] == null /*&& usuariosIguales == 0*/) {
				comunidad[i] = nuevo;
				return true;
			}/*else if(comunidad[i].getUsuario().equals(nuevo.getUsuario())) {
				//usuariosIguales++;
				if(usuariosIguales != 0) {
					comunidad[i] = null;
					return false;
				}
			}*/
			
		}
		return false;
	}
	
	public boolean iniciarSesion(String usuario, String contrasenia) {
		boolean inicioExitoso = false;
		this.usuarioCorrecto = false;
		this.contraseniaCorrecta = false;
		for(int i = 0; i < comunidad.length; i++) {
			if(comunidad[i].getUsuario().equals(usuario)) {
				this.usuarioCorrecto = true;
				if(comunidad[i].getContrasenia().equals(contrasenia)) {
					this.contraseniaCorrecta = true;
					if(this.contraseniaCorrecta == true && this.usuarioCorrecto == true) {
						inicioExitoso = true;
					}
				}
			}
			
			
		}
		return inicioExitoso;
	}
	
	public String usuariosDelSistema() {
		String listadoDeUsuarios = "";
		for(int i = 0; i < comunidad.length; i++) {
			listadoDeUsuarios += "[ " + (i+1) + " ] " + comunidad[i].toString() + ".\n";
		}
		return listadoDeUsuarios;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public boolean ingresarNuevoUsuario(Usuario nuevo) {
		for(int i = 0; i < comunidad.length; i++) {
			if(comunidad[i] == null) {
				comunidad[i] = nuevo;
				return true;
			}
		}
		return false;
	}
	
	public void loguarUsuario(String usuario, String contrasenia) {
		this.usuarios = new String[this.cantidadDeUsuariosPosibles];
		this.contrasenias = new String[this.cantidadDeUsuariosPosibles];
		//int i = 0;
		for(int i = 0; i < usuarios.length; i++) {
			usuarios[i] = usuario; //igual no se pues en cual de las i se guarda el usuario?
			contrasenias[i] = contrasenia;
		}
	}
	
	public void contraseniaOcultaEnConsola() {
		
	}
	
	/*public void loguarUsuario(String usuario, String contrasenia) {
		this.usuarios = new String[this.cantidadDeUsuariosPosibles];
		this.contrasenias = new String[this.cantidadDeUsuariosPosibles];
		//int i = 0;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null) {
				usuarios[i] = usuario; //igual no se pues en cual de las i se guarda el usuario?
				contrasenias[i] = contrasenia;
			}

		}*/
	
	
}
