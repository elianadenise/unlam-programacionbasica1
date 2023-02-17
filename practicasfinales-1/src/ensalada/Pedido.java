package ensalada;


public class Pedido {
	private String nombreDelCliente;
	private Ensalada[] ensaladas;
	
	//CONSTRUCTOR
	public Pedido(String nombreDelCliente, int CANTIDAD_MAXIMA) {
		this.nombreDelCliente = nombreDelCliente;
		this.ensaladas = new Ensalada[CANTIDAD_MAXIMA];
	}
	
	public boolean agregarNuevaEnsalada(Ensalada nueva) {
		/*
		 * Se incorpora una nueva ensalada a la lista del pedido actual
		 */
		boolean seAgrego = false;
		for(int i = 0; i < ensaladas.length; i++) {
			if(ensaladas[i] == null) {
				ensaladas[i] = nueva;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}
	
	public double getImporte() {
		/*
		 * Calcula el importe en funci�n del precio de cada ingrediente
		 */
		double importe = 0.0;
		for(int i = 0; i < ensaladas.length; i++) {
			if(ensaladas[i] != null) {
				importe += ensaladas[i].getPrecio();
			}
		}
		return importe;
	}
}
