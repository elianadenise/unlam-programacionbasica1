package trabajoPractico02;
//Estudiante Eliana Navarro
//ACT 7, 8 & 13
public class Circulo {

	//ATRIBUTOS
	private double radio;
	
	//METODOS
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double perimetro(double radio) {
		double perimetro = 2 * Math.PI * radio;
		return perimetro;
	}
	
}
