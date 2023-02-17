package trabajoPractico02;

//Estudiante Eliana Navarro
//ACT 3 & 4

public class Coche {

	//ATRIBUTOS
	private final int ANIO_ACTUAL; //si quiero meterlo en el

	private static int cantidadCoches = 0; //estatico en todos los elementos del objeto
	
	private String marca;
	private String modelo;
	private int anioDeFabricacion;
	private int kilometrosActuales;
	private double precio;
	private String color;
	private boolean esManual;
	private int velocidad;
	private int aceleracion;
	private double velocidadMaxima;
	
	//CONSTRUCTORES
	public Coche() {
		this.ANIO_ACTUAL = 2022;
		Coche.cantidadCoches++; 
	}
	//COCHE NUEVO
	public Coche(String marca, String modelo, double precio, String color, int velocidad) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio =precio;
		this.color = color;
		this.velocidad = velocidad;
		this.esManual = false;
		this.ANIO_ACTUAL = 2022;
		this.anioDeFabricacion = this.ANIO_ACTUAL;
		Coche.cantidadCoches++; 
	}
	

	//COCHE USADO
	public Coche(String marca, String modelo, int kilometros, int anioDeFabricacion, double precio, String color, int velocidad) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.color = color;
		this.velocidad = velocidad;
		this.kilometrosActuales = kilometros;
		this.anioDeFabricacion = anioDeFabricacion;
		this.esManual = true;
		this.ANIO_ACTUAL = 2022;
		Coche.cantidadCoches++;  //no es this porque se va modificando adentro del objeto
	}
	
	//CALCULO TIEMPO DE ACELERACION
	public Coche(String marca, int aceleracion, double velocidadMaxima) {
		this.marca = marca;
		this.aceleracion = aceleracion;
		this.velocidadMaxima = velocidadMaxima;
		this.ANIO_ACTUAL = 2022;
		Coche.cantidadCoches++;
	}
	
	//GETS&SETS
	public static int getCantidadCoches() {
		return cantidadCoches;
	}

	public static void setCantidadCoches(int cantidadCoches) {
		Coche.cantidadCoches = cantidadCoches;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnioDeFabricacion() {
		return anioDeFabricacion;
	}

	public void setAnioDeFabricacion(int anioDeFabricacion) {
		this.anioDeFabricacion = anioDeFabricacion;
	}

	public int getKilometrosActuales() {
		return kilometrosActuales;
	}

	public void setKilometrosActuales(int kilometrosActuales) {
		this.kilometrosActuales = kilometrosActuales;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	//METODOS
	public int calcularAntiguedad() {
		int antiguedad = this.ANIO_ACTUAL - this.anioDeFabricacion;
		
		return antiguedad;
	}

	public int aumentarKilometros() {
		int kilometrosRecorridos =+ kilometrosActuales;
		
		return kilometrosRecorridos;
	}
	
	public double alcanzarVelocidadMaxima() {
		double velocidadInicial = 0;
		double tiempoEnSegundos = 0.0;
		while(velocidadInicial <= this.velocidadMaxima) {
			velocidadInicial++;
			tiempoEnSegundos = this.velocidadMaxima / this.aceleracion;
		}
		return tiempoEnSegundos;
	}
	
}
