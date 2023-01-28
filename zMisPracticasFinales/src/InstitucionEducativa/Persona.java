package InstitucionEducativa;

public class Persona {
	private String nombre;
	private String apellido;
	private Integer dni;
	private String contrasenia;
	private Carrera carrera;
	private Nota parcial1;
	private Nota parcial2;
	
	/**
	 * El constructor debe generar las condiciones necesaias para garantizar el correcto funcionamiento de la app
	 * */
	//DOCENTE
	public Persona(int dni, String contrasenia) {
		this.dni = dni;
		this.contrasenia = contrasenia;
	}
	//ESTUDIANTE
	public Persona(String apellido, int dni, Carrera carrera, Nota primerParcial, Nota segundoParcial) {
		this.nombre = primerParcial.getNombre();
		this.apellido = apellido;
		this.dni = dni;
		this.carrera = carrera;
		this.parcial1 = primerParcial;
		this.parcial2 = segundoParcial;
	}
	
	/**
	 * Actualiza la nota del alumno a partir de una nota proporcionada.
	 * @param notaARecuperar	Nota para recuperar el parcial 1 o el parcial 2.
	 * @return true si fue posible actualizar la nota
	 * 
	 * Debe proporcionar el codigo necesario para que funcione correctamente.
	 * 
	 * */
	public boolean recuperarNota(Nota notaARecuperar) {
		// La nota solo puede recuperarse si es menor o igual a 6
		boolean seRecupera = false;
		if(parcial1.getValor() <= 6 && parcial1.getValor() > 0 && notaARecuperar.getValor() >= 4 && notaARecuperar.getValor() <= 10 && notaARecuperar.isEsPrimerParcial() == true) {
			parcial1.setValor(notaARecuperar.getValor());
			seRecupera = true;
		} else if (parcial2.getValor() <= 6 && parcial2.getValor() > 0 && notaARecuperar.getValor() >= 4 && notaARecuperar.getValor() <= 10 && notaARecuperar.isEsPrimerParcial() == false) {
			parcial2.setValor(notaARecuperar.getValor());
			seRecupera = true;
		}
		return seRecupera;
	}
	
	/**
	 * Indica la condicion de la persona frente a la materia
	 * 
	 * Debe proporcionar el codigo necesario para que funcione correctamente
	 * 
	 * - Si tiene 1 parcial con nota inferior a 4 la condicion final es DESAPROBADO.
	 * - Si tiene las dos notas entre 4 y 6 (inclusive ambos), la condicion final es CURSA.
	 * - Si ambas notas son mayores o iguales a 7, la condicion final es PROMOCIONA.
	 * 
	 * */
	public CondicionFinal obtenerCondicionFinal() { //revisar condiciones 
		
		if((parcial1.getValor() >= 7 && parcial2.getValor() >= 7) && (parcial1.getValor() <= 10 && parcial2.getValor() <= 10)) {
			return CondicionFinal.PROMOCIONA;
		} else if((parcial1.getValor() <= 3 || parcial2.getValor() <= 3) && (parcial1.getValor() > 0 && parcial2.getValor() > 0)) {
			return CondicionFinal.DESAPROBADO;
		} else if((parcial1.getValor() <= 7 || parcial2.getValor() <= 7) && (parcial1.getValor() > 3 && parcial2.getValor() > 3)){
			return CondicionFinal.CURSA;
		}
		return null;	
		
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

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Nota getParcial1() {
		return parcial1;
	}

	public void setParcial1(Nota parcial1) {
		this.parcial1 = parcial1;
	}

	public Nota getParcial2() {
		return parcial2;
	}

	public void setParcial2(Nota parcial2) {
		this.parcial2 = parcial2;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nCarrera: " + this.carrera + "\nSituacion: " + this.obtenerCondicionFinal();
	}
}
