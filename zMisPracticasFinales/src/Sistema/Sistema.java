package Sistema;

public class Sistema {

	//ATRIBUTOS
	String nombreSistema;
	Usuario usuarios[];
	
	//CONSTRUCTOR
	public Sistema(String nombre) {
		this.nombreSistema = nombre;
		this.usuarios = new Usuario[1000];
	}

	//GETS&SETS
	public String getNombreSistema() {
		return nombreSistema;
	}

	public void setNombreSistema(String nombreSistema) {
		this.nombreSistema = nombreSistema;
	}

	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	
	//METODOS
	public boolean registrarUsuario(Usuario nuevo) {
		boolean seRegistro = false;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] == null) {
				if(this.usuariosRepetidos(nuevo.getNombreUsuario()) == false) {
					usuarios[i] = nuevo;
					seRegistro = true;
					break;
				}
			}
		}
		return seRegistro;
	}
	
	public boolean usuariosRepetidos(String nombreUsuario) {
		boolean esRepetido = false;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null) {
				if(usuarios[i].getNombreUsuario().equals(nombreUsuario)) {
					esRepetido = true;
				}
			}
		}
		return esRepetido;
	}
	
	public boolean iniciarSesion(String usuario, String contrasenia) {
		boolean seInicio = false;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null) {
				if(usuarios[i].getNombreUsuario().equals(usuario) && usuarios[i].getContrasenia().equals(contrasenia)) {
					seInicio = true;
				}
			}
		}
		return seInicio;
	}
	
	public boolean editarContrasenia(String usuario, String contraseniaAnterior, String nueva) {
		boolean seEdito = false;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null) {
				if(usuarios[i].getNombreUsuario().equals(usuario) && usuarios[i].getContrasenia().equals(contraseniaAnterior)) {
					usuarios[i].setContrasenia(nueva);
					seEdito = true;
				}
			}
		}
		return seEdito;
	}
	
	public Usuario buscarPorUsuario(String usuario) {
		Usuario buscado = null;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null) {
				if(usuarios[i].getNombreUsuario().equals(usuario)) {
					buscado = usuarios[i];
				}
			}
		}
		return buscado;
	}
	
	public boolean eliminarUsuario(String usuario, String contrasenia) {
		boolean seElimino = false;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null) {
				if(usuarios[i].getNombreUsuario().equals(usuario) && usuarios[i].getContrasenia().equals(contrasenia)) {
					usuarios[i] = null;
					seElimino = true;
				}
			}
		}
		return seElimino;
	}
	
}
