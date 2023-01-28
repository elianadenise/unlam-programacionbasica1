package subsidio;

public class Direccion {
	private String localidad;
	private String calle;
	private Integer numero;

	public Direccion(String localidad, String calle, Integer numero) {
		// TODO Auto-generated constructor stub
		this.localidad= localidad;
		this.calle= calle;
		this.numero= numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Object getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Object getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Direccion [localidad=" + localidad + ", calle=" + calle + ", numero=" + numero + "]";
	}

}
