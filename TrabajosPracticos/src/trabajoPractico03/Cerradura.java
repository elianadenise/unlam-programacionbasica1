package trabajoPractico03;
//TP 3 - ACT 8
public class Cerradura {
	
	private int claveDeApertura;
	private int cantidadDeFallosParaBloqueo;
	private boolean estaAbierta;
	private boolean estaBloqueada;

	
	//CONSTRUCTOR
	public Cerradura(int claveDeApertura) {
		this.claveDeApertura = claveDeApertura;
		this.cantidadDeFallosParaBloqueo = 0;
		this.estaAbierta = false;
		this.estaBloqueada = false;
	}
	
	//GETS&SETS
	public int getClaveDeApertura() {
		return claveDeApertura;
	}

	public void setClaveDeApertura(int claveDeApertura) {
		this.claveDeApertura = claveDeApertura;
	}

	public int getCantidadDeFallosParaBloqueo() {
		return cantidadDeFallosParaBloqueo;
	}
	
	public void setCantidadDeFallosParaBloqueo(int cantidadDeFallosParaBloqueo) {
		this.cantidadDeFallosParaBloqueo = cantidadDeFallosParaBloqueo;
	}
	
	public boolean isEstaAbierta() {
		return estaAbierta;
	}

	public boolean isEstaBloqueada() {
		return estaBloqueada;
	}


	//METODOS
	public boolean abrir(int clave) {
		if(this.claveDeApertura == clave && this.estaBloqueada == false) {
			this.estaAbierta = true;	
		}
		return this.estaAbierta;
	}

	public boolean cerrar(int clave) {
		if(this.claveDeApertura != clave){
			this.cantidadDeFallosParaBloqueo++;
			this.estaAbierta = false;
		}
		return this.estaAbierta;
	}
	
	/*	
	public void cerrar() {
		this.estaAbierta = false;;
	}
	*/
	
	public boolean estaAbierta(int clave) { 
		if((this.claveDeApertura == clave) && (this.cantidadDeFallosParaBloqueo <= 2)) {
			this.estaAbierta = true;
			this.cantidadDeFallosParaBloqueo = 0;
		}
		return this.estaAbierta;
	}
	
	public boolean fueBloqueada(int clave) { 
		if((this.cantidadDeFallosParaBloqueo >= 2) && (this.claveDeApertura != clave)) {
			this.estaBloqueada = true;
		} 
		return this.estaBloqueada;
	}
}
