package ensalada;

public class Ingrediente {
	private String nombre;
	private double precio;
	private Origen origen;
	
	public Ingrediente(String nombre, double precio, Origen origen) {
		this.nombre = nombre;
		this.precio = precio;
		this.origen = origen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Origen getOrigen() {
		return origen;
	}

	public void setOrigen(Origen origen) {
		this.origen = origen;
	}

	public String toString() {
		return "Nombre: " + this.nombre + "; Origen: " + this.origen + "; Precio: $" + this.precio;
	}
}
