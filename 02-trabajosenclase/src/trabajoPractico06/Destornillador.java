package trabajoPractico06;
//TP 06 - ACT 02
public class Destornillador {

	//ATRIBUTOS
	private final char TIPO_DE_CABEZA;
	
	//CONSTRUCTOR
	public Destornillador(char tipoDeCabeza) {
		this.TIPO_DE_CABEZA = tipoDeCabeza;
	}

	//GETS&SETS
	public char getTIPO_DE_CABEZA() {
		return TIPO_DE_CABEZA;
	}
	
	//METODOS
	public void desatornillar(Tornillo tornillo) {
		if(this.TIPO_DE_CABEZA == tornillo.getTIPO_DE_CABEZA()) {
			while(tornillo.getPosicionActual() > 0) {
				tornillo.girar('A');
			}
		}
	}
	
	public void atornillar(Tornillo tornillo) {
		if(this.TIPO_DE_CABEZA == tornillo.getTIPO_DE_CABEZA()) {
			while(tornillo.getPosicionActual() < tornillo.getCANTIDAD_DE_ROSCA()) {
				tornillo.girar('H');
			}
		}
	}
	
	public void desatornillar(Tornillo tornillo, Tarugo tarugo) {
		if(this.TIPO_DE_CABEZA == tornillo.getTIPO_DE_CABEZA() && tornillo.getLONGITUD() == tarugo.getLONGITUD()) {
			while(tornillo.getPosicionActual() > 0) {
				tornillo.girar('A');
			}
		}
	}

	public void atornillar(Tornillo tornillo, Tarugo tarugo) {
		if(this.TIPO_DE_CABEZA == tornillo.getTIPO_DE_CABEZA()) {
			while(tornillo.getPosicionActual() < tornillo.getCANTIDAD_DE_ROSCA() && tornillo.getLONGITUD() == tarugo.getLONGITUD()) {
				tornillo.girar('H');
			}
		}
	}
	
}
