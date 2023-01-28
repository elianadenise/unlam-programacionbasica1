package locomotora;

public class Locomotora {

	//ATRIBUTOS
	private static int idLocomotora = 0;//para no tener que generarlo yo we
	private String nombre;
	private int cantidadMaximaDeVagones;
	private Vagon[] formacion;
	
	//CONSTRUCTORES
	public Locomotora(String nombre, int cantidadMaximaVagones) {
		this.nombre = nombre;
		this.cantidadMaximaDeVagones = cantidadMaximaVagones;
		this.formacion = new Vagon[this.cantidadMaximaDeVagones];
		Locomotora.idLocomotora++;
	}
	
	//GETS&SETS
	public static int getIdLocomotora() {
		return idLocomotora;
	}

	public static void setIdLocomotora(int idLocomotora) {
		Locomotora.idLocomotora = idLocomotora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadMaximaDeVagones() {
		return cantidadMaximaDeVagones;
	}

	public void setCantidadMaximaDeVagones(int cantidadMaximaDeVagones) {
		this.cantidadMaximaDeVagones = cantidadMaximaDeVagones;
	}

	public Vagon[] getFormacion() {
		return formacion;
	}

	public void setFormacion(Vagon[] formacion) {
		this.formacion = formacion;
	}
	
	//METODOS
	public boolean agregarVagon(Vagon nuevo) {
		boolean seAgrego = false;
		for(int i = 0; i < formacion.length; i++) {
			if(formacion[i] == null) {
				formacion[i] = nuevo;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}

	public Vagon obtenerVagonDeMenorPeso() {//FUNCIONA pero si vuelvo a elegir la opcion me da null
		Vagon deMenorPeso = null;
		for(int i = 0; i < formacion.length; i++) {
			/*if(deMenorPeso != null && formacion[i] != null) {
				deMenorPeso = formacion[i];
			}
			if(deMenorPeso != null && formacion[i] != null && formacion[i].getPesoDeCarga() < formacion[i+1].getPesoDeCarga()) {
				deMenorPeso = formacion[i];
			}*/
			
			
			for(int j = 0; j < formacion.length-1; j++) {
				if(formacion[j] != null && formacion[j+1] != null) {
					if(formacion[j].getPesoDeCarga() < formacion[j+1].getPesoDeCarga()) {
						deMenorPeso = formacion[j];
						formacion[j] = formacion[j+1];
						formacion[j+1] = deMenorPeso;
					} else {
						deMenorPeso = formacion[j+1]; //BUENO, ahora funciona pero raro igual
					}
				}
				
			}
		}
		return deMenorPeso;
	}
	
	public double obtenerPesoPromerdioDeVagonesParaLaMarca(MarcaVagon marca) {
		double pesoPromedio = 0.0;
		int contador = 0;
		for(int i = 0; i < formacion.length; i++) {
			if(formacion[i] != null) {
				if(formacion[i].getMarca().equals(marca)) {
					pesoPromedio += formacion[i].getPesoDeCarga();
					contador++;
				}
			}
			
		}
		
		return (pesoPromedio / contador);
	}
	
	public boolean editarNombreDeVagon(String idVagon, String nuevoNombre) {
		boolean seCambio = false;
		for(int i = 0; i < formacion.length; i++) {
			if(formacion[i] != null && formacion[i].getIdVagon().equals(idVagon)) {
				if(formacion[i].validarIdentificador(nuevoNombre)) {
					formacion[i].setIdVagon(nuevoNombre);
					seCambio = true;
				}
			}
		}
		return seCambio;
	}
	
	public void ordenarVagonesPorIdVagon() {
		Vagon auxiliar = null;
		for(int i = 0; i < formacion.length; i++) {
			for(int j = 0; j < formacion.length-1; j++) {
				if(formacion[j] != null && formacion[j+1] != null) {
					if(formacion[j].getIdVagon().compareTo(formacion[j+1].getIdVagon()) > 0) {
					auxiliar = formacion[j];
					formacion[j] = formacion[j+1];
					formacion[j+1] = auxiliar;
					}
				}
				
			}
		}
	}
	
	public int contadorDeVagonesDisponibles() {
		int contador = 0;
		for(int i = 0; i < formacion.length; i++) {
			if(formacion[i] == null) {
				contador++;
			}
		}
		return contador;
	}
	
	public int contadorVagonesAgregados() {
		int contador = 0;
		for(int i = 0; i < formacion.length; i++) {
			if(formacion[i] != null) {
				contador++;
			}
		}
		return contador;
	}
	
}
