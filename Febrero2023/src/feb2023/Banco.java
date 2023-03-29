package feb2023;

public class Banco {

	private Persona [] cuentas;
	
	// CONSTRUCTOR
	public Banco(int numero) {
		this.cuentas = new Persona[numero];
	}
	
	
	public Persona[] getCuentas() {
		return cuentas;
	}

	public void setCuentas(Persona[] cuentas) {
		this.cuentas = cuentas;
	}



	// METODOS
	// 1. Alta nueva persona
	public boolean altaNuevaPersona(Persona persona) {
		boolean seRegistro = false;
		for(int i = 0; i < cuentas.length-1; i++) {
			if(cuentas[i] == null) {
				cuentas[i] = persona;
				seRegistro = true;
				break;
			}
		}
		return seRegistro;
	}
	
	// 2. Consulta persona con mayor saldo
	public Persona personaConMayorSaldo() {
		Persona buscada = null;
		for(int i = 0; i < cuentas.length-1; i++) {
			if(cuentas[i] != null && cuentas[i-1] != null && cuentas[i].getSaldo() > cuentas[i-1].getSaldo()) {
				buscada = cuentas[i];
			}
		}
		return buscada;
	}
	
	
	// 4. Cargar saldo a cuenta de una persona
	public boolean cargarSaldoEnCuenta(int dni, float monto) {
		for(int i = 0; i < cuentas.length-1; i++) {
			if(cuentas[i].getDni() == dni && cuentas[i] != null) {
				cuentas[i].setSaldo(cuentas[i].getSaldo() + monto);
				return true;
			}
		}
		return false;
	}
	
	// 5. INGRESO AL CAJERO(DNI Y CONTRASENIA)
	public boolean iniciarSesion(int dni, String contrasenia) {
		for (int i = 0; i < cuentas.length-1; i++) {
			if(cuentas[i].getDni() == dni && cuentas[i].getContrasenia().equals(contrasenia)) {
				return true;
			}
		}
		return false;
	}
	
	// 5.1. Depositar
	public float depositar(float monto, int dni) {
		float dato = 0;
		for(int i = 0; i < cuentas.length-1; i++) {
			if(cuentas[i].getDni() == dni) {
				cuentas[i].setSaldo(cuentas[i].getSaldo() + monto);
				dato = cuentas[i].getSaldo();
			}
		}
		return dato;
	}
	
	// 5.2. Extraer
	public float extraer(float monto, int dni) {
		float dato = 0;
		for(int i = 0; i < cuentas.length-1; i++) {
			if(cuentas[i].getDni() == dni && cuentas[i].getSaldo() > monto) {
				cuentas[i].setSaldo(cuentas[i].getSaldo() - monto);
				dato = cuentas[i].getSaldo();
			}
		}
		return dato;
	}
	
	// 5.3. Consultar saldo
	public float consultarSaldo(int dni) {
		for(int i = 0; i < cuentas.length-1; i++) {
			if(cuentas[i].getDni() == dni) {
				return cuentas[i].getSaldo();
			}
		}
		return 0;
	}
	
	// 5.4. Transferir
	public boolean transferir(int dniEx, int dniTransferir, float monto) {
		for(int i = 0; i < cuentas.length-1; i++) {
			if(cuentas[i] != null && cuentas[i].getDni() == dniEx && cuentas[i].getSaldo() > monto) {
				cuentas[i].setSaldo(cuentas[i].getSaldo() - monto);
				for (int j = 0; j < cuentas.length-1; j++) {
					if(cuentas[j] != null && cuentas[j].getDni() == dniTransferir) {
						cuentas[j].setSaldo(cuentas[j].getSaldo() + monto);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	// 5.5. Cambiar contrasenia
	public boolean cambiarContrasenia(int dni, String contraseniaAnterior, String contraseniaNueva, String contraseniaNuevaDos) {
		for(int i = 0; i < cuentas.length-1; i++) {
			if(cuentas[i].getDni() == dni && cuentas[i].getContrasenia().equals(contraseniaAnterior) && contraseniaNueva.equals(contraseniaNuevaDos) && !contraseniaAnterior.equals(contraseniaNueva)) {
				cuentas[i].setContrasenia(contraseniaNueva);
				return true;
			}
		}
		return false;
	}
		
}
