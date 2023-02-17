package ensalada;

import java.util.Arrays;

public class Ensalada {
	private String nombreDeLaEnsalada;
	private Ingrediente ingredientes[] ;
	
	public Ensalada(String nombre, int cantidadMaximaDeIngredientes) {
		this.nombreDeLaEnsalada = nombre;
		this.ingredientes = new Ingrediente[cantidadMaximaDeIngredientes];

	}
	
	public double getPrecio() {
		double precio = 0.0;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null) {
				precio += ingredientes[i].getPrecio();
			}
		}
		return precio;
	}

	public boolean agregarIngrediente(Ingrediente nuevo) {
		/*
		 * Incorpora un nuevo ingrediente a la ensalada
		 */
		boolean seAgrego = false;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] == null) {
				ingredientes[i] = nuevo;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}
	
	public boolean esAptoCeliaco() {
		/*
		 * Devuelve true si ning�n ingrediente es de origen TACC.
		 */
		boolean esApto = true;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null && ingredientes[i].getOrigen().equals(Origen.TACC)) {
				esApto = false;
				break;
			}
		}
		return esApto;
	}
	
	public boolean esAptoVegetariano() {
		/*
		 * Devuelve true si ning�n ingrediente es de origen ANIMAL
		 */
		boolean esApto = true;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null && ingredientes[i].getOrigen().equals(Origen.ANIMAL)) {
				esApto = false;
				break;
			}
		}
		return esApto;
	}
	
	public boolean esAptoVegano() {
		/*
		 * Devuelve true si ning�n ingrediente es de origen ANIMAL ni LECHE ni HUEVO
		 */
		boolean esApto = true;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null && (ingredientes[i].getOrigen().equals(Origen.ANIMAL) || ingredientes[i].getOrigen().equals(Origen.HUEVO) || ingredientes[i].getOrigen().equals(Origen.LECHE))) {
				esApto = false;
				break;
			}
		}
		return esApto;
	}

	public String toString() {
		/*
		 * Devuelve un String con el nombre de la ensalada y el detalle de los ingredientes que la componen
		 */
		String ingredientesAcumulados = "";
		for(int i = 0; i < ingredientes.length; i++){
			if(ingredientes[i] != null) {
				ingredientesAcumulados += ingredientes[i].getNombre() + ", ";
			}
		}
		
		return "Ensalada: " + this.nombreDeLaEnsalada + " (" + ingredientesAcumulados + ")" + "; Precio: $" + this.getPrecio();
	}

	public String getNombreDeLaEnsalada() {
		return nombreDeLaEnsalada;
	}

	public void setNombreDeLaEnsalada(String nombreDeLaEnsalada) {
		this.nombreDeLaEnsalada = nombreDeLaEnsalada;
	}
	
	
}
