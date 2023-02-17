package Sistema;

public class Usuario {
	
	//ATRIBUTOS
	String nombreCompleto;
	String nombreUsuario;
	String contrasenia;
	String contrasenias[];
	
	//CONSTRUCTOR
	public Usuario(String nombreCompleto, String nombreUsuario, String contrasenia) {
		this.nombreCompleto = nombreCompleto;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.contrasenias = new String[100];
	}

	//GET&SETS
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String[] getContrasenias() {
		return contrasenias;
	}

	public void setContrasenias(String[] contrasenias) {
		this.contrasenias = contrasenias;
	}
	
	//METODOS
	public boolean registrarContrasenias(String contrasenia) {
		boolean seRegistro = false;
		for(int i = 0; i < contrasenias.length; i++) {
			if(contrasenias[i] == null) {
				this.editarContrasenia(contrasenia);
				seRegistro = true;
				break;
			}
		}
		return seRegistro;
	}
	
	public boolean editarContrasenia(String contrasenia) {
		boolean seEdito = false;
		int contador = 0;
		for(int i = 0; i < contrasenias.length; i++) {
			if(contrasenias[i] != null) {
				if(contrasenias[i].equals(contrasenia)) {
					contador++;
					if(contador == 0) {
						this.setContrasenia(contrasenia);
						seEdito = true;
					}
					
				}
			}
		}
		return seEdito;
	}
	
	public String mostrarContrasenias() {
		String contraseniasAcumuladas = null;
		for(int i = 0; i < contrasenias.length; i++) {
			if(contrasenias[i] != null) {
				contraseniasAcumuladas += contrasenias[i] + "\n";
			}
		}
		return contraseniasAcumuladas;
	}
	
	public String toString() {
		return "Usuario: " + this.nombreUsuario +"\nContrasenia: " + this.contrasenia;
	}
}
