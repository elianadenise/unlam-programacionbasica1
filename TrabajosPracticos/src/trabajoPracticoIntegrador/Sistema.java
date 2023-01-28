package trabajoPracticoIntegrador;

public class Sistema {

	//ATRIBUTOS
	private String nombreDelSistema;
	private Usuario usuarios[];
	private final int CANTIDAD = 100;
	
	//CONSTRUCTOR
	public Sistema() {
		this.nombreDelSistema = "Sistema de Eliana";
		this.usuarios = new Usuario[CANTIDAD];
	}
	
	//METODOS
	public boolean registrarUsuario(Usuario nuevo) {
		/*boolean pudoRegistrar = false;
		int i = 0;
		
		while(i < usuarios.length && !pudoRegistrar) {
			if(usuarios[i] == null) {
				usuarios[i] = nuevo;
				pudoRegistrar = true;
				break;
			}
			i++;
		}
		
		return pudoRegistrar;*/
		
		
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] == null) {
				usuarios[i] = nuevo;
				return true;
				//break;
			}
		}
		return false;
	}
	
	public int cantidadUsuariosRegistrados() {
		int usuariosTotal = 0;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null) {
				usuariosTotal++;
			}
		}
		return usuariosTotal;			
	}
	
	public int cantidadUsuariosBloqueados() {
		int usuariosTotal = 0;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null && usuarios[i].isBloqueado() == true) {
				usuariosTotal++;
			}
		}
		return usuariosTotal;	
	}
	
	public double edadPromedio() {
		int sumaEdades = 0;
		double resultado = 0.0;
		int usuarioRegistrado = 0;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null) {
				usuarioRegistrado++;
				sumaEdades += usuarios[i].getEdad();
			}
		}
		resultado = sumaEdades / usuarioRegistrado;		
		return resultado;
	}
	
	public boolean loguearUsuario(String usuario, String contrasenia) {
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null && usuarios[i].getUsuario().equals(usuario) && usuarios[i].getContrasenia().equals(contrasenia)) {
				return true;
			} else if (usuarios[i] != null && !usuarios[i].getUsuario().equals(usuario) && !usuarios[i].getContrasenia().equals(contrasenia)){
				int contador = usuarios[i].getContadorFallos();
				usuarios[i].setContadorFallos(contador++);
				if(contador >= 2) {
					return false;
				}
				
			}
		}
		
		return false;
	}
	
	public Usuario buscarUsuario(String usuarioBuscado) {
		Usuario encontrado = null;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null && usuarios[i].getUsuario().equals(usuarioBuscado)) {
				encontrado = usuarios[i];
				break;
			}
		}
		return encontrado;
	}
	
}
