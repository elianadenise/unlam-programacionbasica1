package trabajoPractico03;
//dada la clase triangulo, determinar e informar que tipo de
//triangulo es? usar condicional.
public class Triangulo {
	//ATRIBUTOS
	private double lado1;
	private double lado2;
	private double lado3;

	//METODOS
	public Triangulo(double lado1, double lado2, double lado3) {
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}
	
	
	public boolean equilatero() {
		boolean resultado = (lado1 == lado2 && lado1 == lado3 && lado2 == lado3);
		return resultado;
	}
	
	public boolean escaleno() {
		boolean resultado = (lado1 != lado2 && lado1 != lado3 && lado2 != lado3);
		return resultado;
	}
	
	public boolean isosceles() {
		boolean resultado = (lado1 == lado2 || lado2 == lado3 || lado1 == lado3);
		return resultado;
	}
	
}
