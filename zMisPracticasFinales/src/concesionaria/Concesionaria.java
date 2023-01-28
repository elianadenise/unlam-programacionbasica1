package concesionaria;

public class Concesionaria {

	//ATRIBUTOS
	private String nombre;
	private Vendedor vendedores[];
	private Auto autos[];
	
	//CONSTRUCTOR
	public Concesionaria(String nombre) {
		this.nombre = nombre;
		this.vendedores = new Vendedor[5];
		this.autos = new Auto[100];
	}
	
	//GETS&SETS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Vendedor[] getVendedores() {
		return vendedores;
	}

	public void setVendedores(Vendedor[] vendedores) {
		this.vendedores = vendedores;
	}

	public Auto[] getAutos() {
		return autos;
	}

	public void setAutos(Auto[] autos) {
		this.autos = autos;
	}
	
	//METODOS
	public boolean comprarAuto(Auto nuevo) {
		boolean seCompro = false;
		for(int i = 0; i < autos.length; i++) {
			if(autos[i] == null) {
				autos[i] = nuevo;
				seCompro = true;
				break;
			}
		}
		return seCompro;
	}
	
	public boolean agregarVendedor(Vendedor nuevo) {
		boolean seAgrego = false;
		for(int i = 0; i < vendedores.length; i++) {
			if(vendedores[i] == null) {
				vendedores[i] = nuevo;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}
	
	public boolean venderAuto(int identificador, int vendedor) {
		boolean seVendio = false;
		double comision = vendedores[vendedor].getComision();
		double precioVenta = 0.0;
		int autosVendidos = vendedores[vendedor].getAutosVendidos();
		if(autos[identificador - 1] != null) {
			precioVenta = autos[identificador - 1].getPrecioDeCompra() + autos[identificador - 1].getPrecioDeCompra()*0.50;
			comision += precioVenta*0.15;
			vendedores[vendedor].setComision(comision);
			autosVendidos++;
			vendedores[vendedor].setAutosVendidos(autosVendidos);
			autos[identificador - 1] = null;
			seVendio = true;
		}
		return seVendio;	
	}
	
	public Auto[] buscarPorPalabra(String palabra) {
		Auto buscados [] = new Auto[autos.length];
		int indice = 0;
		for(int i = 0; i < autos.length; i++) {
			if(autos[i] != null) {
				if(autos[i].getMarca().equals(palabra) || autos[i].getModelo().equals(palabra)) {
					buscados[indice++] = autos[i];
				}
			}
		}
		return buscados;
	}
	
	public 	String mostrarAutosDisponibles() {
		String autosDisponibles = "";
		for(int i = 0; i < autos.length; i++) {
			if(autos[i] != null) {
				autosDisponibles += "[" + (i+1) + "] " + autos[i].toString() + "\n----------" + "\n";
			}
		}
		return autosDisponibles;
	}
	
	public String mostrarVendedores() {
		String vendedoresActuales = "";
		for(int i = 0; i < vendedores.length; i++) {
			if(vendedores[i] != null) {
				vendedoresActuales += "[ " + i + " ]" + " Vendedor: " + vendedores[i].toString() + "\n----------" + "\n"; 
			}
		}
		return vendedoresActuales;
	}
	
	
}
