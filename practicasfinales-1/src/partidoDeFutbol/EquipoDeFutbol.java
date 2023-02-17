package partidoDeFutbol;

public class EquipoDeFutbol {
	private String nombre;
	private Jugador jugadores[];
	
	public EquipoDeFutbol(String nombre) {
		this.nombre = nombre;
		this.jugadores = new Jugador[5];
	}

	/*
	 * La capacidad m�xima de un equipo es 5. No se permiten jugadores repetidos (ya sea el n�mero o nombre del jugador)
	 * Se retorna el resultado de la operaci�n
	 */
	public boolean agregarJugador(Jugador nuevo) {
		boolean seAgrego = false;
		for(int i = 0; i < jugadores.length; i++) {
			if(jugadores[i] == null) {
				jugadores[i] = nuevo;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}
	
	/*
	 * Permite buscar un jugador por su numero. 
	 * 
	 */
	public Jugador buscar(int numero) {
		Jugador buscado = null;
		for(int i = 0; i < jugadores.length; i++) {
			if(jugadores[i] != null && jugadores[i].getNumero() == numero) {
				buscado = jugadores[i];
			}
		}
		return buscado;
	}
	
	/*
	 * Permite buscar un jugador por su nombre. 
	 * 
	 */
	public Jugador buscar(String nombre) {
		Jugador buscado = null;
		for(int i = 0; i < jugadores.length; i++) {
			if(jugadores[i] != null && jugadores[i].getNombre().equals(nombre)) {
				buscado = jugadores[i];
			}
		}
		return buscado;
	}
	

	/*
	 * Calcula el valor del equipo. 
	 * 
	 */
	public double calcularLaEdadPromedioDelEquipo() {
		double sumatoria = 0.0;
		int contador = 0;
		for(int i = 0; i < jugadores.length; i++) {
			if(jugadores[i] != null) {
				sumatoria += jugadores[i].getEdad();
				contador++;
			}
		}
		return (sumatoria/contador);
	}
	
	/*
	 * Calcula el valor del equipo
	 * 
	 */
	public double calcularElValorDelEquipo() {
		double valor = 0.0;
		for(int i = 0; i < jugadores.length; i++) {
			if(jugadores[i] != null) {
				valor += jugadores[i].getPrecio();
			}
		}
		return valor;
	}
	
	public String toString() {
		return this.nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Jugador[] getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}
}
