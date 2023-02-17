package subsidio;

public class Usuario {
	private String nombre;
	private Direccion direccion;
	private Double sueldo;
	private long dni = 0;
	private String rol = "";
	private Subsidio [] subsidios;

	public Usuario(String nombre, Direccion direccion, Double sueldo) {
		this.nombre= nombre;
		this.direccion=direccion;
		this.sueldo=sueldo;
		this.subsidios = new Subsidio[3];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public boolean agregarSubsidio (Subsidio subsidio) {
		boolean seAgrego = false;
		for(int i = 0; i < subsidios.length; i++) {
			if(subsidios[i] == null) {
				subsidios[i] = subsidio;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}

	public Subsidio buscarSubsidioPorIdentificador(int identificador) {
		Subsidio buscado = null;
		for(int i = 0; i < subsidios.length; i++) {
			if(subsidios[i] != null) {
				if(subsidios[i].getIdentificador() == identificador) {
					buscado = subsidios[i];
				}
			}
		}
		return buscado;
	}
	
	
}
