package albumDeFiguritas;

public class Album {
	private static String selecciones[] = {"Qatar", "Ecuador", "Senegal", "Paises Bajos", "Inglaterra", "Ir�n", "EEUU", "Gales", "Argentina", "Arabia Saudita", "M�xico", "Polonia", "Francia", "Australia", "Dinamarca", "Tunez", "Espa�a", "Costa Rica", "Alemania", "Jap�n", "B�lgica", "Canad�", "Marruecos", "Croacia", "Brasil", "Serbia", "Suiza", "Camer�n", "Portugal", "Ghana", "Uruguay", "Corea del Sur"};
	private static Figurita figuritasDisponibles[] = new Figurita[704];
	private Figurita figuritasActuales[];
	
	public Album() {
		/*
		 * El constructor debe generar las condiciones necesaias para garantizar el correcto funcionamiento de la app
		 */
		this.figuritasActuales = new Figurita[704];
	}
	
	public static void inicializarCodigosDeFiguritas() {
		/*
		 * Por cada pa�s debe generar 22 c�digos de manera autom�tica por ejemplo QAT1, URU12, COS10
		 */
		int indice = 0;
		for(int i = 0; i < selecciones.length; i++) {
			if(selecciones[i] != null) {
				String seleccion = selecciones[i].substring(0, 3);
				for(int j = 1; j < 23; j++) {
					String codigo = seleccion + (j);
					Figurita nueva = new Figurita(codigo.toUpperCase());
					figuritasDisponibles[indice++] = nueva;
				}
			}
		}
	}
	
	public static void actualizarDatosFigurita(String codigo, char grupo, String nombreJugador, double valor) {
		/*
		 * En funci�n del c�digo de figurita, se deben actualizar los datos de la misma en figuritasDisponibles 
		 */
		for(int i = 0; i < figuritasDisponibles.length; i++) {
			if(figuritasDisponibles[i] != null) {
				if(figuritasDisponibles[i].getCodigo().equals(codigo)) {
					figuritasDisponibles[i].setGrupo(grupo);
					figuritasDisponibles[i].setNombreJugador(nombreJugador);
					figuritasDisponibles[i].setValor(valor);
				}
			}
		}
	}
	
	public static Figurita getFigurita(String codigo) {
		/*
		 * En funci�n del c�digo de figurita, devuelve la figurita de figuritasDisponibles
		 */
		Figurita buscada = null;
		for(int i = 0; i < figuritasDisponibles.length; i++) {
			if(figuritasDisponibles[i] != null && figuritasDisponibles[i].getCodigo().equals(codigo)) {
				buscada = figuritasDisponibles[i];
			}
		}
		return buscada;
	}
	
	public Figurita[] comprarSobre() {
		/*
		 * Se debe calcular y devolver 5 c�digos de figurita de manera aleatoria.
		 */
		Figurita sobre[] = new Figurita[5];
		for(int i = 0; i < sobre.length; i++) {
			if(sobre[i] == null) {
				sobre[i] = figuritasDisponibles[(int)(Math.random()*704)];
			}
		}		
		return sobre;
	}
	
	public void agregarFigurita(Figurita nueva) {
		/*
		 * Agrega una nueva figurita al array figuritasActuales
		 */
		boolean laTengo = this.tengoLaFigurita(nueva);
		for(int i = 0; i < figuritasActuales.length; i++) {
			if(figuritasActuales[i] == null && laTengo == false) {
				figuritasActuales[i] = nueva;
			}
		}
	}
	
	public boolean tengoLaFigurita(Figurita nueva) {
		boolean late = false;
		for(int i = 0; i < figuritasActuales.length; i++) {
			if(figuritasActuales[i] != null && figuritasActuales[i].getCodigo().equals(nueva.getCodigo())) {
				late = true;
				break;
			}
		}
		return late;
	}
	
	public void ordenarFiguritasActuales() {
		/*
		 * Debe ordenar el array figuritasActuales
		 */
		Figurita auxiliar = null;
		for(int i = 1; i < figuritasActuales.length; i++) {
			for(int j = 0; i < figuritasActuales.length - 1; j++) {
				if(figuritasActuales[j] != null && figuritasActuales[j+1] != null && figuritasActuales[j].getCodigo().compareTo(figuritasActuales[j+1].getCodigo()) > 0) {
					auxiliar = figuritasActuales[j];
					figuritasActuales[j] = figuritasActuales[j+1];
					figuritasActuales[j+1] =auxiliar;
				}
			}
		}
	}
	
	public boolean elAlbumEstaCompleto() {
		/*
		 * Debe verificar que todas las figuritas disponibles est�n presentes al menos una vez en las figuritas actuales 
		 */		
		boolean estaCompleto = false;
		if(this.calcularPorcentajeCompletado() == 100) {
			estaCompleto = true;
		}
		return estaCompleto;
	}
	
	public double calcularPorcentajeCompletado() {
		/*
		 * Debe calcular el porcentaje de figuritas del album que est� completo. Para esto se debe basar en la informaci�n de las figuritasDisponibles en relaci�n a las figuritasActuales que se tiene en el album.
		 */
		int figuritasContadas = 0;
		for(int i = 0; i < figuritasActuales.length; i++) {
			if(figuritasActuales[i] != null) {
				figuritasContadas++;
			}
		}
		
		double calculo = (figuritasContadas*100)/(figuritasDisponibles.length);
		
		return calculo;
	}

	public static Figurita[] getFiguritasDisponibles() {
		return figuritasDisponibles;
	}

	public static void setFiguritasDisponibles(Figurita[] figuritasDisponibles) {
		Album.figuritasDisponibles = figuritasDisponibles;
	}

	public Figurita[] getFiguritasActuales() {
		return figuritasActuales;
	}

	public void setFiguritasActuales(Figurita[] figuritasActuales) {
		this.figuritasActuales = figuritasActuales;
	}
	
}
