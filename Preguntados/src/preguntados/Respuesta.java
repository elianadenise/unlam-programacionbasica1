package preguntados;
//Estudiantes: Alonso Reyes, Ornella; Navarro, Eliana.

public class Respuesta {

	//ATRIBUTOS
	private String respuesta;
	private boolean correcta;
	
	//CONSTRUCTOR
	public Respuesta(String respuesta, boolean opcion) {
		this.respuesta = respuesta;
		this.correcta = opcion;
	}
	
	//GETS
	public String getRespuesta() {
		return respuesta;
	}

	public boolean isCorrecta() {
		return correcta;
	}
	
	//METODOS
	public String toString() {
		return respuesta;
	}
	
}
