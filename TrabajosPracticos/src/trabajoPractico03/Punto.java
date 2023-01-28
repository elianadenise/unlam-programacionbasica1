package trabajoPractico03;
//TP 3 - ACT 5
public class Punto {

	//ATRIBUTOS
	private float coordenadaX;
	private float coordenadaY;
	private final float ORIGEN = 0.0F;
	
	//CONSTRUCTORES
	public Punto(float coordenadaX,float coordenadaY) {
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	//GETS&SETS
	public float getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(float coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public float getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(float coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
	//METODOS - codigo profesores
	public boolean sobreEjeX() { //si una coordY se encuentra sobre ejeX, por ende su coord es 0
		if(this.coordenadaY == this.ORIGEN) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean sobreEjeY() { //otra porma de escribir el metodo
		boolean resultado = false; //esta es la mejor forma segun los profes
		if(this.coordenadaX == this.ORIGEN) {
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}
	
	public boolean enPuntoDeOrigen() {
		if(sobreEjeX() && sobreEjeY()) {
			return true;
		}
		return false;
	}
	
	/* esta es otra forma valida
	public boolean enPuntoDeOrigen() {
		return sobreEjeX() && sobreEjeY();
	}
	*/
}
