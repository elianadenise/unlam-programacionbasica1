package trabajoPractico03;
//TP 3 - ACT 4
public class Nota {

	//ATRIBUTOS
	private float valor;
	
	//CONSTRUCTORES
	public Nota(float valorInicial) {
		this.valor = valorInicial;
	}
	
	//GETS&SETS
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	//METODOS
	public boolean aprobado() {
		boolean resultado;
		resultado = (valor >= 4);
		return resultado;
	}
	
	public void recuperar(float nuevoValor) { //esto no se si esta bien, flashe
		if(nuevoValor >= 4) {
			this.valor = nuevoValor;
		}
	}
	
	/*public int cantidadDeEstudiantesPromocionados() {
		Nota nueva = new Nota(float valorInicial);
		
		int cantidadDeEstudiantesPromocionados = 0;
		if(this.valor > 7) {
			cantidadDeEstudiantesPromocionados++;
		}
		return cantidadDeEstudiantesPromocionados;
	}*/
}
