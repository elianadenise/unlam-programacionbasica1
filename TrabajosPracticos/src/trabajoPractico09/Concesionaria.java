package trabajoPractico09;

public class Concesionaria {

	//ATRIBUTOS
	private String marcas[] = {"Chevrolet", "Fiat", "Ford", "BMW", "Renault"};
	private String modelos[] = {"Onix", "500", "autitoFord", "autitoBMW", "autitoRenault"};
	private int precios[] = {300000, 50000, 400000, 40000, 900000};
	//private String marcas[];
	//private String modelos[];
	//private int precio[];
	private String vendedor;
	private String autoConsultado;
	private int comision;
	private byte autosVendidos;
	
	//CONSTRUCTOR
	public Concesionaria(String vendedor, byte codigo) {
		this.vendedor = vendedor;
		this.autoConsultado = seleccionarAuto(codigo);
		this.autosVendidos = 0;
		this.comision = 0;
		
	}
	
	public Concesionaria(String vendedor) {//en caso de que quiera ver otra cosa
		this.vendedor = vendedor;
		this.autosVendidos = 0;
		this.comision = 0;
	}
	
	//GETS&SETS
	public String getVendedor() {
		return vendedor;
	}

	public String getAutoConsultado() {
		return autoConsultado;
	}
	
	public int getComision() {
		return comision;
	}

	public byte getAutosVendidos() {
		return autosVendidos;
	}
	
	public String[] getMarcas() {
		return marcas;
	}

	public String[] getModelos() {
		return modelos;
	}

	public int[] getPrecios() {
		return precios;
	}

	public void setMarcas(String[] marcas) {
		this.marcas = marcas;
	}

	//METODOS
	public String seleccionarAuto(byte codigo) {
		return "Marca: " + marcas[codigo] +";\nModelo: " + modelos[codigo] + ";\nPrecio: " + precios[codigo];
	}

	public String mostrarVehiculosDisponibles() {//mostrar esto al profe
		for(int i = 0; i < marcas.length; i++) {
			for(int j = 0; j < modelos.length; j++) {
				autoConsultado = (i+1) + " " + marcas[i] + " " + modelos[j];
			}
		}
		return autoConsultado; //solo muestra el ultimo
	}
	
	public void venderAuto(byte codigo) {
		this.autosVendidos++;
		this.comision = (precios[codigo] * 15) / 100;
		//marcas.remove(codigo);
		//consultar por eliminacion desde clase
	}
	
	public String buscarPorMarca(String marca) {
		String enPantalla = null;
		for(int i = 0; i < marcas.length; i++) {
			if(marca.equalsIgnoreCase(marcas[i]) == true) {
				enPantalla = "Marca seleccionada: " + marcas[i] + "; Modelo: " + modelos[i] + "; Precio: " + precios[i];
			}
		}
		return enPantalla;
	}
	
	public String buscarPorModelo(String marca) {
		String enPantalla = null;
		for(int i = 0; i < modelos.length; i++) {
			if(marca.equalsIgnoreCase(modelos[i]) == true) {
				enPantalla = "Modelo seleccionado: " + modelos[i] + "; Marca: " + marcas[i] + "; Precio: " + precios[i];
			}
		}
		return enPantalla;
	}
	
}
