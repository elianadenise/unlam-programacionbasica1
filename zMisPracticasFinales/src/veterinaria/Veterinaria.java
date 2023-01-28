package veterinaria;

public class Veterinaria {
	private String nombre;
	private Atencion[] atenciones;
	private String usuario;
	private String contrasenia;
	
	public Veterinaria(String nombre, Atencion[] atenciones) {
		this.nombre = nombre;
		this.atenciones = atenciones ;
		this.usuario = "admin";
		this.contrasenia = "1234";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Atencion[] getAtenciones() {
		return atenciones;
	}

	public void setAtenciones(Atencion[] atenciones) {
		this.atenciones = atenciones;
	}

	/**
	 * Agrega una atenciona al arreglo de atenciones
	 * 
	 * @param atencion Atencion	que se agregara
	 * @return true en caso de exito
	 * */
	public boolean registrarAtencion(Atencion atencion) {
		boolean seRegistro = false;
		for(int i = 0; i < atenciones.length; i++) {
			if(atenciones[i] == null) {
				atenciones[i] = atencion;
				seRegistro = true;
				break;
			}
		}
		return seRegistro;
	}
	
	/**
	 * Obtiene una atencion por su identificador
	 * 
	 * @param id	Identificador de la atencion
	 * @return atencion o null en caso de no encontrarse
	 * */
	public Atencion buscarAtencionPorId(int id) {
		
		Atencion buscada = null;
		for(int i = 0; i < atenciones.length; i++) {
			if(atenciones[i] != null) {
				if(atenciones[i].getId() == id) {
					buscada = atenciones[i];
				}
			}
		}
		return buscada;
	}
	
	/**
	 * Obtiene atenciones filtradas por la especie de la mascota
	 * 
	 * @return array de atenciones
	 * */
	public Atencion[] listarAtencionesPorEspecieDeMascota(Especie especieMascota){
		
		Atencion listaPorEspecie [] = new Atencion[atenciones.length];
		int indice = 0;
		for(int i = 0; i < atenciones.length; i++) {
			if(atenciones[i] != null) {
				if(atenciones[i].getEspecieMascota().equals(especieMascota)) {
					if(listaPorEspecie[indice] == null) {
						listaPorEspecie[indice] = atenciones[i];
						indice++;
					}
				}
			}
		}
		return listaPorEspecie;
	}
	
	/**
	 * Elimina una atencion por su identificador
	 * 
	 * @param id 	Identificador de la atencion
	 * @return true en caso de exito
	 * */
	public boolean eliminarAtencionPorId(int id) {
		boolean seElimino = false;
		for(int i = 0; i < atenciones.length; i++) {
			if(atenciones[i] != null) {
				if(atenciones[i].getId() == id) {
					atenciones[i] = null;
					seElimino = true;
				}
			}
		}
		return seElimino;
	}
	
	/**
	 * Obtiene la cantidad de atenciones realizadas hasta el momento
	 * 
	 * @return cantidad de atenciones
	 * */
	public int obtenerCantidadDeAtencionesRealizadas() {
		
		int atencionesRealizadas = 0;
		for(int i = 0; i < atenciones.length; i++) {
			if(atenciones[i] != null) {
				atencionesRealizadas++;
			}
		}
		return atencionesRealizadas;
	}
	
	/**
	 * Obtiene la cantidad de atenciones disponibles
	 * 
	 * @return atenciones
	 * */
	public int obtenerCantidadDeAtencionesDisponibles(int atencionesRealizadas) {
		int atencionesDisponibles = atenciones.length - atencionesRealizadas;
		return atencionesDisponibles;
	}
	
	/**
	 * Calcula y devuelve el total de todas las atenciones realizadas
	 * 
	 * @return monto total
	 * */
	public double obtenerTotalDeAtenciones() {
		double montoTotal = 0.0;
		for(int i = 0; i < atenciones.length; i++) {
			if(atenciones[i] != null) {
				montoTotal += atenciones[i].getMonto();
			}
		}
		return montoTotal;
	}
	
	/**
	 * Obtiene atenciones ordenadas por monto descendente
	 * 
	 * @return atenciones
	 * */
	public void ordenarAtencionesPorMontoDescendente() {
		
		Atencion auxiliar = null;
		for(int i = 1; i < atenciones.length; i++) {
			for(int j = 0; j < atenciones.length-1; j++) {
				if(atenciones[j] != null && atenciones[j+1] != null) {
					if(atenciones[j].getMonto() > atenciones[j+1].getMonto()) {
						auxiliar = atenciones[j];
						atenciones[j] = atenciones[j+1];
						atenciones[j+1] = auxiliar;
					}
				}
			}
		}
		
	}
	
	/**
	 * Valida las credenciales proporcionadas
	 * 
	 * @param nombreUsuario		Nombre de usuario del administrador
	 * @param contrasenia		Contrasenia del administrador
	 * @return verdadero en caso de exito
	 * */
	public boolean iniciarSesion(String nombreUsuario, String contrasenia) {
		boolean seInicio = false;
		if(this.usuario.equals(nombreUsuario) && this.contrasenia.equals(contrasenia)) {
			seInicio = true;
		}
		
		return seInicio;
	}
	
	public String toString() {
		String resultado = "";
		for(int i = 0; i < atenciones.length; i++) {
			if(atenciones[i] != null) {
				resultado += atenciones[i].toString() + "\n";
			}
		}
		return resultado;
	}
	
}
