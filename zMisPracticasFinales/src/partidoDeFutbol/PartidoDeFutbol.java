package partidoDeFutbol;

public class PartidoDeFutbol {
	private EquipoDeFutbol local;
	private EquipoDeFutbol visitante;
	private Evento goles[];
	private Evento amonestados[];
	private Evento expulsados[];
	private int cantidadDeAmonestados;
	
	public PartidoDeFutbol(EquipoDeFutbol local, EquipoDeFutbol visitante) {
		this.local = local;
		this.visitante = visitante;
		this.goles = new Evento[20];
		this.amonestados = new Evento[20];
		this.expulsados = new Evento[10];
		this.cantidadDeAmonestados = 0;
	}
	
	/*
	 * Se debe marcar un nuevo Gol 
	 * Dependiendo del autor (seg�n al equipo que pertenezca) y del tipo (si es a favor o en contra) se sabr� a quien contabilizarlo
	 */
	public void marcar(Evento gol) {
	for(int i = 0; i < goles.length; i++) {
		if(goles[i] == null) {
			goles[i] = gol;
		}
	}
	}
	
	/*
	 * Se registra un nuevo amonestado en el partido. 
	 * Si el mismo ya pose�a una amonestaci�n previa, se lo debe expulsar. 
	 * El m�todo devuelve la cantidad de amonestaciones del jugador. 
	 * Los valores posibles de retorno son:
	 * 1 - Si no ten�a amonestaci�n previa o 
	 * 2 - Si ya pose�a una amonestaci�n previa y termina siendo expulsado
	 * 
	 */
	public int amonestar(Evento amonestado) {
		int amonestaciones = 0;
		if(this.estaAmonestado(amonestado.getAutor())) {
			Evento expulsion = new Evento(amonestado.getMinuto(), amonestado.getAutor(), TipoDeEvento.EXPULSION);
			this.expulsar(expulsion);
			amonestaciones = 2;
		} else {
			amonestados[cantidadDeAmonestados++] = amonestado;
			amonestaciones = 1;
		}
		
		return amonestaciones;
	}
	
	public boolean estaAmonestado(Jugador jugador) {
		boolean estaAmonestado = false;
		for(int i = 0; i < amonestados.length; i++) {
			if(amonestados[i] != null) {
				if(amonestados[i].getAutor().equals(jugador)) {
					estaAmonestado = true;
				}
			}
		}
		return estaAmonestado;
	}
	
	
	/*
	 * Se registra un nuevo expulsado en el partido. 
	 */
	public void expulsar(Evento expulsado) {
		for(int i = 0; i < expulsados.length; i++) {
			if(expulsados[i] == null) {
				expulsados[i] = expulsado;
			}
		}

	}
	
	/*
	 * Se cuentan la cantidad de goles por equipo (Se debe considerar si el gol result� a favor o en contra), y devuelve el equipo ganador (Si hubo un empate retorna null) 
	 */
	public EquipoDeFutbol getGanador() {
		int golesLocal = 0;
		int golesVisitante = 0;
		for(int i = 0; i < goles.length; i++) {
			if(goles[i] != null) {
				if(local.buscar(goles[i].getAutor().getNumero()) != null && goles[i].getTipo().equals(TipoDeEvento.GOL_A_FAVOR)) {
					golesLocal++;					
				} else if(local.buscar(goles[i].getAutor().getNumero()) != null && goles[i].getTipo().equals(TipoDeEvento.GOL_EN_CONTRA)) {
					golesVisitante++;
				} else if (visitante.buscar(goles[i].getAutor().getNumero()) != null && goles[i].getTipo().equals(TipoDeEvento.GOL_A_FAVOR)) {
					golesVisitante++;
				} else if (local.buscar(goles[i].getAutor().getNumero()) != null && goles[i].getTipo().equals(TipoDeEvento.GOL_EN_CONTRA)) {
					golesLocal++;
				}
			}
		}
		
		if(golesLocal > golesVisitante) {
			return local;
		} else if(golesLocal < golesVisitante) {
			return visitante;
		} else {
			return null;
		}
	}
	
	/*
	 * El m�todo toString debe describir el ESTADO del partido (Equipos que se enfrentan, los goles realizados, los amonestado y expulsados).
	 */
	public String toString() {
		String golesAc = "";
		for(int i = 0; i < goles.length; i++) {
			if(goles[i] != null) {
				golesAc += "[" + (i+1) +"] " + goles[i] + "\n";
			}
		}
		
		String amonestadosAc = "";
		for(int i = 0; i < amonestados.length; i++) {
			if(amonestados[i] != null) {
				amonestadosAc += "[" + (i+1) +"] " + amonestados[i] + "\n";
			}
		}
		
		String expulsadosAc = "";
		for(int i = 0; i < expulsados.length; i++) {
			if(expulsados[i] != null) {
				expulsadosAc += "[" + (i+1) +"] " + expulsados[i] + "\n";
			}
		}
		
		return this.local.getNombre() + " vs. " + this.visitante.getNombre() +"\n" + "Goles: \n" + golesAc + "Amonestados\n" + amonestadosAc + "Expulsados\n" + expulsadosAc;
	}

	public EquipoDeFutbol getLocal() {
		return local;
	}

	public EquipoDeFutbol getVisitante() {
		return visitante;
	}
}
