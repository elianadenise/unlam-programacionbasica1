package trabajoPractico03;

import trabajoPractico02.Persona;

public class Ascensor {

	private final int PISO_MAXIMO;
	private final int PISO_MINIMO;
	private final double PESO_MAXIMO;
	private final int CAPACIDAD_MAXIMA;
	private boolean puertaAbierta;
	private boolean sobrecarga;
	private int pisoActual;
	private int pisoDeseado;
	private double pesoActual;
	private int capacidadActual;
	
	public Ascensor(int capacidadMaxima, double pesoMaximo) {
		this.CAPACIDAD_MAXIMA = capacidadMaxima;
		this.PESO_MAXIMO = pesoMaximo;
		this.PISO_MAXIMO = 6;
		this.PISO_MINIMO = 0;
		this.puertaAbierta = false;
		this.sobrecarga = false;
		this.pesoActual = 0;
		this.capacidadActual = 0;
		this.pisoActual = 0;
	}
	
	
	public int getPisoDeseado() {
		return pisoDeseado;
	}

	public void setPisoDeseado(int pisoDeseado) {
		this.pisoDeseado = pisoDeseado;
	}

	public int getPISO_MAXIMO() {
		return PISO_MAXIMO;
	}

	public int getPISO_MINIMO() {
		return PISO_MINIMO;
	}

	public double getPESO_MAXIMO() {
		return PESO_MAXIMO;
	}

	public int getCAPACIDAD_MAXIMA() {
		return CAPACIDAD_MAXIMA;
	}

	public boolean isPuertaAbierta() {
		return puertaAbierta;
	}

	public boolean isSobrecarga() {
		return sobrecarga;
	}

	public int getPisoActual() {
		return pisoActual;
	}

	public double getPesoActual() {
		return pesoActual;
	}

	public int getCapacidadActual() {
		return capacidadActual;
	}
	
	//METODOS
	
	public void ingresar (Persona queSube) {
		if((queSube.getPeso() < this.PESO_MAXIMO) && (this.capacidadActual < this.CAPACIDAD_MAXIMA) && (this.puertaAbierta = true)) {
			this.capacidadActual++;
			this.pesoActual += queSube.getPeso();
		}
	}
	
	public void ingresar (double peso) {
		if((peso < this.PESO_MAXIMO) && (this.capacidadActual < this.CAPACIDAD_MAXIMA) && (this.puertaAbierta = true)) {
			this.capacidadActual++;
			this.pesoActual += peso;
		}
	}
	
	public void salir (Persona queBaja) {
		if(this.puertaAbierta == true) {
			this.capacidadActual--;
			this.pesoActual -= queBaja.getPeso();
		}
	}
	
	public void salir (double peso) {
		if(this.puertaAbierta == true) {
			this.capacidadActual--;
			this.pesoActual -= peso;
		}
	}
	
	public boolean abrirPuerta() {
		if(this.puertaAbierta == false) {
			this.puertaAbierta = true;
		}
		return this.puertaAbierta;
	}
	
	public boolean cerrarPuerta() {
		if(this.puertaAbierta == true) {
			this.puertaAbierta = false;
		}
		return this.puertaAbierta;
	}
	
	public void subir() {
		if((this.pisoActual < this.PISO_MAXIMO) && (this.capacidadActual < this.CAPACIDAD_MAXIMA) && (this.pesoActual < this.PESO_MAXIMO) && (this.puertaAbierta == false)) {
			this.pisoActual++;
		}
	}
	
	public void bajar() {
		if((this.pisoActual > this.PISO_MINIMO) &&  (this.capacidadActual < this.CAPACIDAD_MAXIMA) && (this.pesoActual < this.PESO_MAXIMO) && (this.puertaAbierta == false)) {
			this.pisoActual--;
		}
	}	
	
	//TP 06 -ACT 01
	public void irAlPiso(int pisoDeseado) {
		if(this.pisoActual > pisoDeseado) {
			while(this.pisoActual > pisoDeseado) {
				this.pisoActual--;
			}
		} else if(this.pisoActual < pisoDeseado) {
			while(this.pisoActual < pisoDeseado) {
				this.pisoActual++;
			}
		}
	}
	//el de orne
	public void irAlPisoDos(int pisoDeseado) {
		if ((this.pisoActual < this.PISO_MAXIMO) && (this.puertaAbierta == false) && (this.capacidadActual < this.CAPACIDAD_MAXIMA)) {
			while(pisoDeseado != this.pisoActual) {
				this.pisoActual++;
			}
		} else if ((this.pisoActual > this.PISO_MINIMO) && (this.puertaAbierta == false) && (this.capacidadActual > this.CAPACIDAD_MAXIMA)) {
			while(pisoDeseado != this.pisoActual) {
				this.pisoActual--;
			}
		}
	}
	
}