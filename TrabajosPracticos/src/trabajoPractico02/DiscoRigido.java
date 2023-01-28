package trabajoPractico02;
//Estudiante Eliana Navarro
//TP 2 - ACT 9
public class DiscoRigido {
	//ATRIBUTOS
	private double tamanio;
	private final double CAPACIDAD_DVD = 4.5D;
	private final double CAPACIDAD_BLUE_RAY = 15D;
	
	//METODOS
	public DiscoRigido(double tamanio) {
		this.tamanio =tamanio;
	}
	
	public double cantidadDvd() {
		double dvdEnTB = this.CAPACIDAD_DVD*0.001;
		double resultado = Math.round(this.tamanio / dvdEnTB); //TP 3 - ACT 3
		return resultado;
	}
	
	public double cantidadBlueRay() {
		double blueRayEnTB = this.CAPACIDAD_BLUE_RAY*0.001;
		double resultado = Math.round(this.tamanio / blueRayEnTB); //TP 3 - ACT 3
		return resultado;
	}
	
}
