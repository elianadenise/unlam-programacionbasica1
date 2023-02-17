package trabajoPractico09;

public class ConcesionariaUno {

	//ATRIBUTOS
	//composicion - Concesionaria contiene a clase Autito
	private String nombre;
	private Autito flota[];
	private Autito autosVendidos[];
	private VendedorConcesionaria vendedores[];
	private int cantidadDeAutosVendidos;
	private final int CANTIDAD_MAXIMA = 100;
	private final int CANTIDAD_VENDEDORES = 20;
    
	//CONSTRUCTOR aca se intancia la flota, es comun hacer eso en composicion
	public ConcesionariaUno() {
		flota = new Autito[CANTIDAD_MAXIMA];
		autosVendidos = new Autito[CANTIDAD_MAXIMA];
		vendedores = new VendedorConcesionaria[CANTIDAD_VENDEDORES];
		this.cantidadDeAutosVendidos = 0;
	}

	//GETS&SETS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
	//METODOS
	public boolean comprarAuto(Autito nuevo) {
		for(int i = 0; i < flota.length; i++) {
			if(flota[i] == null) {
				flota[i] = nuevo;
				return true; //si lo guardo bien en un espacio del array
			}
		}
		return false; //si no puede guardar
	}
    
	public 	String mostrarAutosDisponibles() {
		String autosDisponibles = "";
		for(int i = 0; i < flota.length; i++) {
			if(flota[i] != null) {
				autosDisponibles += "[" + (i+1) + "] " + flota[i].toString() + "\n";
			}
		}
		return autosDisponibles;
	}
	
	public boolean agregarVendedores(VendedorConcesionaria nuevo) {
		for(int i = 0; i < vendedores.length; i++) {
			if(vendedores[i] == null) {
				vendedores [i] = nuevo;
				return true;
			}
		}
		return false;
	}
	
	public String mostrarVendedores() {
		String vendedoresActuales = "";
		for(int i = 0; i < vendedores.length; i++) {
			if(vendedores[i] != null) {
				vendedoresActuales += "[ " + i + " ]" + " Vendedor: " + vendedores.toString() + "\n"; 
			}
		}
		return vendedoresActuales;
	}
	
	public boolean venderAuto(int codigoDeAuto, int paraComisionar) {
		boolean sePudoVender = false;
		int codigoFinal = codigoDeAuto - 1;
		double comisionar = 0.0;
	    if(codigoFinal< flota.length && flota[codigoFinal] != null) {
	    	comisionar += flota[codigoFinal].getPrecio() * vendedores[paraComisionar].getComision();
	    	vendedores[paraComisionar].setComisionesAcumuladas(comisionar);
	    	autosVendidos[cantidadDeAutosVendidos++] = flota[codigoDeAuto];
	    	flota[codigoFinal] = null;
	    	sePudoVender = true;
	    }
		return sePudoVender;
		
	    //paraComisionar.comisionar();
    	
    	//-ELIMINAR ELEMENTO DEL ARRAY- LIMPIEZA DE UN ARRAY -
    	/*for(int i = 0; i < flota.length; i++) {
    		if(i == codigoDeAuto) {
    			flota [i] = null;
    		}
    	}*/
    }
	
	public double cantidadComisionada(int paraComisionar) {
		double comision = vendedores[paraComisionar].getComisionesAcumuladas();
		return comision;
	}
	
	public int consultarStock() {
		int vehiculosEnStock = 0;
		for(int i = 0; i < flota.length; i++) {
    		if(flota [i] != null) {
    			vehiculosEnStock++;
    		}
    	}
		return vehiculosEnStock;
	}
	
	public String buscar(String palabra) {
		String resultados = "";
		for(int i = 0; i < flota.length; i++) {
			if(flota[i] != null && (flota[i].getPatente().equalsIgnoreCase(palabra) || flota[i].getMarca().equalsIgnoreCase(palabra) || flota[i].getModelo().equalsIgnoreCase(palabra))) {
				resultados += "[" + (i+1) + "] " + flota[i].toString() + "\n";
			}
		}
		return resultados;
	}
    
	public double sumaAsegurada() {
		double sumaAsegurada = 0.0;
		for(int i = 0; i < flota.length; i++) {
			if(flota[i] != null) {
				sumaAsegurada += flota[i].getPrecio();
			}
		}
		return sumaAsegurada;
	}
	
}
