package trabajoPractico02;
//Estudiante Eliana Navarro
//TP 2 - ACT 5
//TP 3 - ACT 1
public class Calculadora {

	//ATRIBUTOS
	private double operador1;
	private double operador2;
		
	//CONSTRUCTOR
	public Calculadora() {
			
	}
		
	public Calculadora(double operador1, double operador2) {
		this.operador1 = operador1;
		this.operador2 = operador2;
	}
		
	//GETS&SETS
	public double getOperador1() {
		return operador1;
	}

	public void setOperador1(double operador1) {
		this.operador1 = operador1;
	}

	public double getOperador2() {
		return operador2;
	}

	public void setOperador2(double operador2) {
		this.operador2 = operador2;
	}
		
	//METODOS
	public double sumar() {
		double suma = this.operador1 + this.operador2;
			
		return suma;
	}

	public double restar() {
		double restar = this.operador1 - this.operador2;
		
		return restar;
	}
	
	public double multiplicar() {
		double multiplicar = this.operador1 * this.operador2;
		
		return multiplicar;
	}
	
	//TP 03 - ACT 02
	
	public double dividir() { //preguntar que onda con esto
		double dividir = 0.0;
		if(this.operador2 != 0.0) {
			dividir = this.operador1 / this.operador2;
		}
		return dividir;
	}
	
	//TP 03 - ACT 01
	public boolean esPositivo() {
		boolean resultado;
		resultado = (this.operador1 > 0.0 && this.operador2 > 0.0);
		return resultado;
	}
	
	//TP 05 - ACT 02
	public double potencia(double base, double exponente) {
		double resultado = 1;
		for(int i = 0; i < exponente; i++) {
			resultado *= base;
		}
		return resultado;
	}
	
	//TP 05 - ACT 03
	public double sumatoria(int limite) { //funciona!!! <3
		double resultado = 0.0;
		for(int i = 0; i <= limite; i++) {
			resultado += i;
		}
		return resultado;	
	}
	
	//TP 05 - ACT 04
	public double sumatoria(int limiteInferior, int limiteSuperior) { //funciona!!! <3
		double resultado = 0.0;
		for(int i = limiteInferior; i <= limiteSuperior; i++) {
			resultado += i;
		}
		return resultado;	
	}
	
	//TP 05 - ACT 05
	public double productoria(int limite) {
		double resultado = 0.0;
		for(int i = 1; i <= limite; i++) {
			resultado *= i;
		}
		return resultado;
	}
	
	//TP 05 - ACT 06
	public double productoria(int limiteInferior, int limiteSuperior) {
		double resultado = 0.0;
		for(int i = limiteInferior; i <= limiteSuperior; i++) {
			resultado *= i;
		}
		return resultado;
	}
	
	//TP 05 - ACT 07
	public String contarDivisores(int numero) {
		String resultado = "";
		for(int i = 1; i <= numero; i++) {
			if((numero % i) == 0) {
				if(!resultado.equals("")) {
					resultado += ",";
				}
				resultado += i;
			}
		}
		return resultado;
	}
	
	//TP 06 - ACT 01
	public int factorial(int numero) {
        int resultado = 1;
        int factoriales = 1;
        do {
            resultado *= (factoriales++); 
        } while (factoriales <= numero);
        return resultado;
    }
	
}