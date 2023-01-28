package trabajoPractico03;

public class Alarma {

	//ATRIBUTOS
		private boolean sensorDeMovimiento;
		private boolean sensorDeContacto;
		private boolean sensorDeSonido;
		private boolean encendida;
		private int codigoDeSeguridad;
		
		//CONSTRUCTOR
		public Alarma (int codigoDeSeguridad) {
			this.codigoDeSeguridad = codigoDeSeguridad;
			
		}
		
		//GETS&SETS
		public int getCodigoDeSeguridad() {
			return codigoDeSeguridad;
		}

		public void setCodigoDeSeguridad(int codigoDeSeguridad) {
			this.codigoDeSeguridad = codigoDeSeguridad;
		}
		
		public boolean isSensorDeMovimiento() {
			return sensorDeMovimiento;
		}

		public void setSensorDeMovimiento(boolean sensorDeMovimiento) {
			this.sensorDeMovimiento = sensorDeMovimiento;
		}

		public boolean isSensorDeContacto() {
			return sensorDeContacto;
		}

		public void setSensorDeContacto(boolean sensorDeContacto) {
			this.sensorDeContacto = sensorDeContacto;
		}

		public boolean isSensorDeSonido() {
			return sensorDeSonido;
		}

		public void setSensorDeSonido(boolean sensorDeSonido) {
			this.sensorDeSonido = sensorDeSonido;
		}

		public boolean isEncendida() {
			return encendida;
		}

		public void setEncendida(boolean encendida) {
			this.encendida = encendida;
		}	
		
		//METODOS
		public void encender(int codigo) {
			if(this.codigoDeSeguridad == codigo) {
				this.encendida = true;
				this.sensorDeContacto = false;
				this.sensorDeMovimiento = false;
				this.sensorDeSonido = false;
			}
		}
		
		public void apagar(int codigo) {
			if(this.codigoDeSeguridad == codigo) {
				this.encendida = false;
				this.sensorDeContacto = false;
				this.sensorDeMovimiento = false;
				this.sensorDeSonido = false;
			}
		}
		
		public boolean activada() {
			boolean ruidoFuerte = false;
			if((this.encendida == true ) && ((this.sensorDeContacto) || (this.sensorDeMovimiento) || (this.sensorDeSonido))) {
				ruidoFuerte = true;
			}
			return ruidoFuerte;
		}	
	
}
