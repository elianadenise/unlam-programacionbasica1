package ensalada;

import java.util.Arrays;

public class Ensalada {
	private String nombreDeLaEnsalada;
	private Ingrediente ingredientes[] ;
	private double precio=0.0;
	
	//CONSTRUCTOR
	public Ensalada(String nombreEnsalada, int CANTIDAD_MAX_INGREDIENTES) {
		this.nombreDeLaEnsalada = nombreEnsalada;
		this.ingredientes = new Ingrediente[CANTIDAD_MAX_INGREDIENTES];
		this.precio = 0.0;
	}
	
	public double getPrecio() {
		double importe = 0.0;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null) {
				importe += ingredientes[i].getPrecio();
			}
		}
		this.precio = importe;
		return precio;
	}

	public String getNombreDeLaEnsalada() {
		return nombreDeLaEnsalada;
	}

	public void setNombreDeLaEnsalada(String nombreDeLaEnsalada) {
		this.nombreDeLaEnsalada = nombreDeLaEnsalada;
	}

	public boolean agregarIngrediente(Ingrediente nuevo) {
		/*
		 * Incorpora un nuevo ingrediente a la ensalada
		 */
		boolean fueAgregado = false;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] == null) {
				ingredientes[i] = nuevo;
				fueAgregado = true;
				break;
			}
		}
		return fueAgregado;		
	}
	
	public boolean esAptoCeliaco() {
		/*
		 * Devuelve true si ning�n ingrediente es de origen TACC.
		 */
		boolean esApto = true;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null) {
				if(!ingredientes[i].getOrigen().equals(Origen.TACC)) {
					esApto = false;
				}
			}
		}
		return esApto;
		/*
		boolean esApto = false;
		int cantidadDeIngredientes = 0;
		int cantidadDeIngredientesAptos = 0;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null) {
				cantidadDeIngredientes++;
				if(!ingredientes[i].getOrigen().equals(Origen.TACC)) {
					cantidadDeIngredientesAptos++;
					if(cantidadDeIngredientes == cantidadDeIngredientesAptos) {
						esApto = true;
					}
				}
			}
		}
		
		return esApto;*/
	}
	
	public boolean esAptoVegetariano() {
		/*
		 * Devuelve true si ning�n ingrediente es de origen ANIMAL
		 */
		boolean esApto = true;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null) {
				if(!ingredientes[i].getOrigen().equals(Origen.ANIMAL)) {
					esApto = false;
				}
			}
		}
		return esApto;
		
		/*
		boolean esApto = false;
		int cantidadDeIngredientes = 0;
		int cantidadDeIngredientesAptos = 0;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null) {
				cantidadDeIngredientes++;
				if(!ingredientes[i].getOrigen().equals(Origen.ANIMAL)) {
					cantidadDeIngredientesAptos++;
					if(cantidadDeIngredientes == cantidadDeIngredientesAptos) {
						esApto = true;
					}
				}
			}
		}
		
		return esApto;*/
	}
	
	public boolean esAptoVegano() {
		/*
		 * Devuelve true si ning�n ingrediente es de origen ANIMAL ni LECHE ni HUEVO
		 */
		boolean esApto = true;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null) {
				if(!ingredientes[i].getOrigen().equals(Origen.LECHE) && !ingredientes[i].getOrigen().equals(Origen.HUEVO) && !ingredientes[i].getOrigen().equals(Origen.ANIMAL)) {
					esApto = false;
				}
			}
		}
		return esApto;
		
		/*
		boolean esApto = false;
		int cantidadDeIngredientes = 0;
		int cantidadDeIngredientesAptos = 0;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null) {
				cantidadDeIngredientes++;
				if(ingredientes[i].getOrigen().equals(Origen.VEGETAL) || ingredientes[i].getOrigen().equals(Origen.TACC)) {
					cantidadDeIngredientesAptos++;
					if(cantidadDeIngredientes == cantidadDeIngredientesAptos) {
						esApto = true;
					}
				}
			}
		}
		
		return esApto;*/
	}

	public String toString() {
		/*
		 * Devuelve un String con el nombre de la ensalada y el detalle de los ingredientes que la componen
		 */
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null) {
				return this.nombreDeLaEnsalada + "; Ingrediente n" + (i+1) + ": " + ingredientes[i];//se anexa el toString de ingrediente
			}
		}
		
		return "";
	}

	public String toString2() {
		return "Ensalada [nombreDeLaEnsalada=" + nombreDeLaEnsalada + ", ingredientes=" + Arrays.toString(ingredientes)
				+ "]";
	}
}
