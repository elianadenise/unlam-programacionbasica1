package ensalada;

public class Pedido {
	private String nombreDelCliente;
	private Ensalada[] ensaladas;
	
	public Pedido(String nombreCliente, int cantidadMaximaDeEnsaldas) {
		this.nombreDelCliente = nombreCliente;
		this.ensaladas = new Ensalada[cantidadMaximaDeEnsaldas];
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
	
	public String toString() {
		String ensaladasAcumuladas = "";
		for(int i = 0; i < ensaladas.length; i++) {
			if(ensaladas[i] != null) {
				ensaladasAcumuladas += "[" + (i+1) + "] " + ensaladas[i].getNombreDeLaEnsalada();
			}
		}
		return "Pedido a nombre de: " + this.nombreDelCliente + "\n" + ensaladasAcumuladas;
	}
}
