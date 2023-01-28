package trabajoPractico09;

public class Usuario {

	//ATRIBUTOS
	private String usuario;
	private String contrasenia;
	
	//CONSTRUCTOR
	public Usuario() {
		
	}
	public Usuario(String usuario, String contrasenia) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	
	//GETS&SETS
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
	
	//METODOS
	public String toString() {
		return this.usuario + ".";
	}
}
