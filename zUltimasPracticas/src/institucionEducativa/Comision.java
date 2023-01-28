package institucionEducativa;

public class Comision {
	private static final int CANTIDAD_PERSONAS = 100;
	private static final Integer DNI_DOCENTE = 123;
	private static final String CONTRASENIA = "qwer";

	private int id;
	private String materia;
	private char turno; // M -> Mañana | N -> Noche
	private Persona[] personas;
	private Integer dni;
	private String contrasenia;

	/**
	 * El constructor debe generar las condiciones necesaias para garantizar el
	 * correcto funcionamiento de la app
	 */
	public Comision() {
		this.dni = DNI_DOCENTE;
		this.contrasenia = CONTRASENIA;
		this.personas = new Persona[Comision.CANTIDAD_PERSONAS];
	}

	/**
	 * Agrega una persona a la comision.
	 * 
	 * @param persona Persona que se agregara
	 * @return true en caso de exito
	 * 
	 *         Debe proporcionar el codigo necesario para que funcione correctamente
	 */
	public boolean ingresarPersona(Persona persona) {
		// TODO: validar que la persona no exista en la comision (por dni).
		boolean ingreso = false;
		if(this.existePersonaEnComision(persona) == false) {
			for(int i = 0; i < personas.length; i++) {
				if(personas[i] == null) {
					personas[i] = persona;
					ingreso = true;
					break;
				}
			}
		}
		return ingreso;
	}

	/**
	 * Verifica si la persona que llega como parametro, existe en la comision
	 * 
	 * @param persona Persona que se validara
	 * @return true en caso de existir en la comision
	 * 
	 *         Debe proporcionar el codigo necesario para que funcione correctamente
	 * 
	 */
	private boolean existePersonaEnComision(Persona persona) {
		boolean existe = false;
		for(int i = 0; i < personas.length; i++) {
			if(personas[i] != null) {
				if(personas[i].getDni() == persona.getDni()) {
					existe = true;
					break;
				}
			}
		}
		return existe;
	}

	/**
	 * Devuelve una persona que debe ser encontrada por su DNI proporionado como
	 * parametro
	 * 
	 * @param dni DNI de la persona
	 * @return Persona Persona que aplica a la busqueda o null en caso de no
	 *         encontrarla.
	 * 
	 *         Debe proporcionar el codigo necesario para que funcione correctamente
	 * 
	 */
	public Persona buscarPorDni(Integer dni) {
		Persona persona = null;
		for(int i = 0; i < personas.length; i++) {
			if(personas[i] != null) {
				if(personas[i].getDni().equals(dni)) {
					persona = personas[i];
				}
			}
		}
		return persona;

	}

	/**
	 * Inicia la sesion de una persona en la comision
	 * 
	 * @param dni         DNI de la persona
	 * @param contrasenia Contrasenia de la persona
	 * @param esDocente   Define si la persona es el docente
	 * @return true en caso de exito
	 * 
	 *         Debe proporcionar el codigo necesario para que funcione correctamente
	 */
	public boolean iniciarSesion(Integer dni, String contrasenia, Boolean esDocente) {
		boolean inicioSesion = false;
		if(Comision.DNI_DOCENTE == dni && Comision.CONTRASENIA.equals(contrasenia) && esDocente == true) {
			inicioSesion = true;
		} else if(esDocente == false) {
			Persona estudiante = this.buscarPorDni(dni);
			if(estudiante != null) {
				if(estudiante.getContrasenia().equals(contrasenia)) {
					inicioSesion = true;
				}
			}
		}
		
		return inicioSesion;
	}

	/**
	 * Actualiza el valor de la Nota para la persona que cumple con el DNI pasado
	 * como parametro
	 * 
	 * @param dni  DNI de la persona
	 * @param nota Nota que se actualizará
	 * 
	 *             Debe proporcionar el codigo necesario para que funcione
	 *             correctamente
	 */
	public boolean recuperarNota(Integer dni, Nota nota) {
		Persona persona = this.buscarPorDni(dni);
		
		if(persona == null) {
			return false;
		}
		
		return persona.recuperarNota(nota);
	}

	/**
	 * Devuelve un array de personas que pertenecen a la carrera proporcionada como
	 * parametro y promocionaron la materia
	 * 
	 * @param carrera Carrera a la que pertenece la persona
	 * @return array de personas que pertenecen a la carrera
	 * 
	 *         Debe proporcionar el codigo necesario para que funcione correctamente
	 */
	public Persona[] obtenerPersonasDeLaCarreraQuePromocionaron(Carrera carrera) {
		// TODO: las personas devueltas deben estar ordenadas por DNI
		this.ordenarPersonasPorDni();
		Persona quePromocionaron[] = new Persona[personas.length];
		int indice = 0;
		for(int i = 0; i < personas.length; i++) {
			if(personas[i] != null) {
				if(personas[i].getCarrera().equals(carrera) && personas[i].obtenerCondicionFinal().equals(CondicionFinal.PROMOCIONA)) {
					quePromocionaron[indice++] = personas[i];
				}
			}
		}
		return quePromocionaron;
	}

	/**
	 * Devuelve el calculo del promedio de la nota 2 de las personas en la comision
	 * 
	 * @return Double Promedio
	 * 
	 *         Debe proporcionar el codigo necesario para que funcione correctamente
	 */
	public Double obtenerElPromedioDeNota2DeLasPersonasQueCursaron() {
		Double notasAcumuladas = 0.0;
		int cantidadDeEstudiantes = 0;
		for(int i = 0; i < personas.length; i++) {
			if(personas[i] != null) {
				if(personas[i].obtenerCondicionFinal().equals(CondicionFinal.CURSA)) {
					notasAcumuladas += personas[i].getParcial2().getValor();
					cantidadDeEstudiantes++;
				}
			}
		}
		return (notasAcumuladas/cantidadDeEstudiantes);
	}

	/**
	 * Ordena las personas en la comision por DNI
	 * 
	 * Debe proporcionar el codigo necesario para que funcione correctamente
	 */
	private void ordenarPersonasPorDni() {
		Persona auxiliar = null;
		for(int i = 1; i < personas.length; i++) {
			for(int j = 0; j < personas.length; j++) {
				if(personas[j] != null && personas[j+1] != null) {
					if(personas[j].getDni() > personas[j+1].getDni()) {
						auxiliar = personas[j];
						personas[j] = personas[j+1];
						personas[j+1] = auxiliar;
					}
				}
			}
		}
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public Persona[] getPersonas() {
		return personas;
	}

	public void setPersonas(Persona[] personas) {
		this.personas = personas;
	}

	public Integer getDni() {
		return dni;
	}

	public void setUsuario(Integer dni) {
		this.dni = dni;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
