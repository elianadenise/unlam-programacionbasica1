package locomotora;

public class Locomotora {

	private int idLocomotora;
	private String nombre;
	private int cantidadMaximaDeVagones;
	private Vagon formacion[];
	
	public Locomotora(int id, String nombre, int cantidadMaxima) {
		this.idLocomotora = id;
		this.nombre = nombre;
		this.cantidadMaximaDeVagones = cantidadMaxima;
		this.formacion = new Vagon[cantidadMaximaDeVagones];
	}
	
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
	
	public Vagon obtenerVagonDeMenorPesoDeCarga() {
		Vagon deMenorPeso = null;
		for(int i = 1; i < formacion.length; i++) {
			for(int j = 0; j < formacion.length-1; j++) {
				if(formacion[j] != null && formacion[j+1] != null) {
					if(formacion[j].getPesoDeCarga() > formacion[j+1].getPesoDeCarga()) {
						deMenorPeso = formacion[j+1];
					}
				}
			}
		}
		return deMenorPeso;
	}
	
	public double obtenerPesoPromedioPorMarca(MarcaVagon marca) {
		double peso = 0;
		int contador = 0;
		for(int i = 0; i < formacion.length; i++) {
			if(formacion[i] != null) {
				if(formacion[i].getMarca().equals(marca)) {
					peso += formacion[i].getPesoMaximoSoportado();
					contador++;
				}
			}
		}
		return (peso/contador);
	}
	
	public boolean editarNombreVagon(String idVagon, String idNuevo) {
		boolean seEdito = false;
		for(int i = 0; i < formacion.length; i++) {
			if(formacion[i] != null) {
				if(formacion[i].getIdVagon().equals(idVagon) && formacion[i].validarIdentificador(idNuevo)) {
					formacion[i].setIdVagon(idNuevo);
					seEdito = true;
				}
			}
		} 
		return seEdito;
	}
	
	public void ordenarVagonesPorId() {
		Vagon auxiliar = null;
		for(int i = 1; i < formacion.length; i++) {
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

	public Vagon[] getFormacion() {
		return formacion;
	}

	public void setFormacion(Vagon[] formacion) {
		this.formacion = formacion;
	}
	
	
}
