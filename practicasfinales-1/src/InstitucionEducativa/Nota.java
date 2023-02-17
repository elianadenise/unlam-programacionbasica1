package InstitucionEducativa;

public class Nota {
	private String nombre;
	private Double valor;
	private Boolean esPrimerParcial;
	
	//para usar con nota de recuperatorio
	public Nota(double nota) {
		this.valor = nota;
	}
	
	public Nota(String nombre, Double valor, Boolean esPrimerParcial) {
		this.nombre = nombre;
		this.valor = valor;
		this.esPrimerParcial = esPrimerParcial;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public boolean isEsPrimerParcial() {
		return esPrimerParcial;
	}
	public void setEsPrimerParcial(boolean esPrimerParcial) {
		this.esPrimerParcial = esPrimerParcial;
	}
	
	@Override
	public String toString() {
		return "Nota [nombre=" + nombre + ", valor=" + valor + ", esPrimerParcial=" + esPrimerParcial + "]";
	}
}
