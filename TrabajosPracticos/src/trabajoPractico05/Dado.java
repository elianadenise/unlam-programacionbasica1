package trabajoPractico05;

public class Dado {

	//ATRIBUTOS
	private int tirarDados;
	private boolean hanSidoLanzados;
	
	//CONSTRUCTOR
	public Dado() {
		this.tirarDados = 0;
		this.hanSidoLanzados = false;
	}
	//GETS&SETS
	public int getTirarDados() {
		return tirarDados;
	}

	public void setTirarDados(int tirarDados) {
		this.tirarDados = tirarDados;
	}
	
	public boolean isHanSidoLanzados() {
		return hanSidoLanzados;
	}
	public void setHanSidoLanzados(boolean hanSidoLanzados) {
		this.hanSidoLanzados = hanSidoLanzados;
	}
	
	//METODOS
	public void tirarDados() {
		for(this.tirarDados = 0; this.tirarDados <= 4; tirarDados++) { //revisar esto
			this.hanSidoLanzados = true;
		}
	}

	
}
