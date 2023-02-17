package trabajoPractico03;
//TP 03 - ACT 6
//TP 06 - ACT 5
public class Cuenta {

	//ATRIBUTOS
	private String titular;
	private double saldoActual;
	private double saldoInicial;
	private double extraccionPorHacker = 10;
	
	//CONSTRUCTORES
	public Cuenta(String titular) {
		this.titular = titular;
	}
	
	public Cuenta(String titular, double saldoInicial) {
		this.titular = titular;
		this.saldoInicial = saldoInicial;
		this.saldoActual = saldoInicial;
	}
	
	//GETS&SETS
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldo) {
		this.saldoActual = saldo;
	}
	
	//METODOS
	public void depositar(double cantidad) {
		this.saldoActual += cantidad;
	}
	
	public void retirar(double cantidad) {
		if(this.saldoActual > cantidad) {
			this.saldoActual -= cantidad;
		}
	}
	
	public String toString() {
		return ("La titular de la cuenta es " + this.titular + " y su saldo es " + this.saldoActual); //puse + saldo para probar
	}
	
	//TP 06 - ACT 5
	public void soyUnaHackerEncubierta() {//me lo saca todo de una porque es un while, si quiero que sea de a poco seria con un if
		while(this.saldoActual > (this.saldoInicial/2)) {
			this.saldoActual -= this.extraccionPorHacker;
		}
	}
}
