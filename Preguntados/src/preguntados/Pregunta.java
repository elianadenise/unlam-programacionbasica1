package preguntados;
//Estudiantes: Alonso Reyes, Ornella; Navarro, Eliana.

public class Pregunta {

	//ATRIBUTOS
	private String pregunta;
	private Respuesta posibles[];
	private Categoria categoria;
	
	//CONSTRUCTOR
	public Pregunta(String pregunta, Respuesta posibles[], Categoria categoria) {
		this.pregunta = pregunta;
		this.posibles = posibles;
		this.categoria = categoria;		
	}
	
	public Pregunta(String pregunta, Categoria categoria) {
		this.pregunta = pregunta;
		this.categoria = categoria;
		this.posibles = new Respuesta[4];
	}
	
	//GETS
	public String getPregunta() {
		return pregunta;
	}
	
	public Respuesta[] getPosibles() {
		return posibles;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	//METODOS
	public String toString() {
		String respuestas = "";
		for(int i = 0; i < posibles.length; i++) {
			if(posibles[i] != null) {
				respuestas += "[" + (i+1) + "] " + posibles[i] + "\n";
			}
		}
		
		return this.pregunta + "\n" + respuestas;
	}
}
