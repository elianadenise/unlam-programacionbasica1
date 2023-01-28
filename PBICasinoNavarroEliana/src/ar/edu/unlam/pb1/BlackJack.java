package ar.edu.unlam.pb1;

public class BlackJack {
	private static Palo palosPosibles[] = Palo.values();
	private static Figura figurasPosibles[] = Figura.values();
	private static final int CANTIDAD_MAXIMA_CARTAS = 52;
	private static Carta cartasDisponibles[] = new Carta[CANTIDAD_MAXIMA_CARTAS];
	
	private Carta mazo[];
	private Carta cartasJugador[];
	private Carta cartasCrupier[];
	
	private int indiceMazo;

	public static void inicializarCartasDisponibles() {
		/*
		 * Se debe completar el array cartasDisponibles con cada una de las cartas que se puede tener.
		 * Para esto se recomienda por cada palo (palosPosibles) ir generando las (figurasPosibles) que puede tener cada uno.
		 * Tener presente que luego, las cartas se van a tener que ordenar por algún criterio, para eso se puede utilizar el atributo codigo de los objetos de tipo Carta.
		 */
		int indice = 0;
		int codigo = 1;
		for(int i = 0; i < palosPosibles.length; i++) {
			for(int j = 0; j < figurasPosibles.length; j++) {
				codigo++;
				cartasDisponibles[indice++] = new Carta(codigo, palosPosibles[i], figurasPosibles[j]);
			}
		}
	}
	
	public BlackJack() {
		/*
		 * Debe generar las condiciones para el correcto funcionamiento del juego.
		 *  
		 */	
		this.cartasCrupier = new Carta[52];
		this.cartasJugador = new Carta[52];
		this.mazo = new Carta[52];
		this.indiceMazo = 0;
	}
	
	public void ordenar() {
		/*
		 *  Se debe ordenar el mazo de cartas de manera ascendente.
		 */		
		Carta auxiliar = null;
		for(int i = 1; i < mazo.length; i++) {
			for(int j = 0; j < mazo.length-1; j++) {
				if(mazo[j] != null && mazo[j+1] != null) {
					if(mazo[j].getCodigo() > mazo[j+1].getCodigo()) {
						auxiliar = mazo[j];
						mazo[j] = mazo[j+1];
						mazo[j+1] = auxiliar;
					}
				}
			}
		}
		
	}
	
	public void mezclar() {
		/*
		 *  Se debe alterar el orden natural del mazo de manera que NO sea posible saber de antemano qué carta sigue a una carta determinada.
		 *  Si así lo deseara, el programador puede regenerar los objetos del mazo nuevamente (Vaciar las cartas que pudiera tener el mazo y luego ir completando en cada posición cada carta de manera aleatoria).
		 */
		for(int i = 0; i < cartasDisponibles.length; i++) {
			int posicion;
			Carta nueva = cartasDisponibles[i];
			if(this.seRepiteLaCarta(nueva) == false) {
				do {
					posicion = (int)(Math.random()*52);	
				} while(mazo[posicion] != null);
				mazo[posicion] = cartasDisponibles[i];
			}
		}
		
		
	}
	
	public boolean seRepiteLaCarta(Carta nueva) {
		boolean seRepite = false;
		for(int i = 0; i < mazo.length; i++) {
			if(mazo[i] != null && mazo[i].getCodigo() == nueva.getCodigo()) {
				seRepite = true;
				break;
			}
		}
		return seRepite;
	}
	
	
	public Carta siguiente() {
		/*
		 *  Determina la siguiente carta que corresponde al jugador y la devuelve a títuo informativo
		 */
		
		Carta siguiente = mazo[indiceMazo++];
		//siguiente = mazo[indiceMazo++];
		
		for(int i = 0; i < cartasJugador.length; i++) {
			if(cartasJugador[i] == null) {
				cartasJugador[i] = siguiente;
				break;
			}
		}
		return siguiente;
	}
	
	
	
	public boolean gano() {
		/*
		 * Evalúa las cartas obtenidas por el jugador contra las cartas del crupier y devuelve true si el jugador resultó ganador.
		 */
		boolean ganoJugador;
		int puntosJugador = 0;
		for(int i = 0; i < cartasJugador.length; i++) {
			if(cartasJugador[i] != null) {
				puntosJugador += cartasJugador[i].getValor();
			}
		}
		
		int puntosGrupier = 0;
		for(int i = 0; i < cartasCrupier.length; i++) {
			if(cartasCrupier[i] != null) {
				puntosGrupier += cartasCrupier[i].getValor();
			}
		}		
		
		if((21-puntosJugador) < (21-puntosGrupier)) {
			ganoJugador = true;
		} else {
			ganoJugador = false;
		}
		
		return ganoJugador;
	}
	
	public boolean perdio() {
		/*
		 * Devuelve true si el puntaje del jugador supera los 21 puntos.
		 */
		boolean perdio = false;
		int puntos = 0;
		for(int i = 0; i < cartasJugador.length; i++) {
			if(cartasJugador[i] != null) {
				puntos += cartasJugador[i].getValor();
			}
		}
		
		if(puntos > 21) {
			perdio = true;
		}
		/*
		if(puntos >= 17 && puntos <= 21) {
			perdio = false;
		} else if(puntos > 21) {
			perdio = true;
		} else {
			perdio = false;
		}*/
		
		return perdio;
	}
	
	public void jugarGrupier() {
		/*
		 * El juego del grupier consiste en ir sacando y guardando sus cartas mientras su puntaje sea menor a 17. Cuando el puntaje del grupier es 17 o más finaliza su juego.
		 */
		Carta grupier = null;
		int acumulado = 0;
		do {
			grupier = mazo[indiceMazo++];
			acumulado += grupier.getValor();
			for(int i = 0; i < cartasCrupier.length; i++) {
				if(cartasCrupier[i] == null) {
					cartasCrupier[i] = grupier;
					break;
				}
			}
		}while(acumulado <= 21);
		
		
	}
	
	public String toString() {
		/*
		 * Devuelve un String con las cartas del jugador y las cartas del crupier
		 */
		String jugador = "";
		for(int i = 0; i < cartasJugador.length; i++) {
			if(cartasJugador[i] != null) {
				jugador += "[" + (i+1) + "] " + cartasJugador[i] + "\n";
			}
		}
		
		String grupier = "";
		for(int i = 0; i < cartasCrupier.length; i++) {
			if(cartasCrupier[i] != null) {
				grupier += "[" + (i+1) + "] " + cartasCrupier[i] + "\n";
			}
		}
		
		return "Cartas Jugador: \n" + jugador + "\nCartas Grupier: \n" + grupier;
	}
}
