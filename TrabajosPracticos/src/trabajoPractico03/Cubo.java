package trabajoPractico03;
//TP 3 - ACT 7
public class Cubo {

	//ATRIBUTOS
	private float longitudLado;
	
	//CONSTRUCTOR
	public Cubo(float lado) {
		this.longitudLado = lado;
	}
	
	//GETS&SETS 
	public float getLongitudLado() {
		return longitudLado;
	}

	public void setLongitudLado(float longitudLado) {
		this.longitudLado = longitudLado;
	}
	
	//METODOS
	public float superficieCara() {
		float superficie = 0.0F;
		if(this.longitudLado > 0.0) {
			superficie = (float) (6 * Math.pow(this.longitudLado,2));
		}
		return superficie;
		
	}
	
	public float volumen() {
		float volumen = 0.0F;
		if(this.longitudLado > 0.0) {
			volumen = (float) Math.pow(this.longitudLado, 3);
		}
		return volumen;
	}
	
}
