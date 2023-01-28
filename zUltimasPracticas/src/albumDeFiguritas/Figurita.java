package albumDeFiguritas;

public class Figurita {
	private String codigo;
	private char grupo;
	private String seleccion;
	private String nombreJugador;
	private double valor;
	
	public Figurita(String codigo) {
		this.codigo = codigo;
		this.grupo = '\0';
		this.seleccion = null;
		this.nombreJugador = null;
		this.valor = 0.0;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public char getGrupo() {
		return grupo;
	}

	public void setGrupo(char grupo) {
		this.grupo = grupo;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
