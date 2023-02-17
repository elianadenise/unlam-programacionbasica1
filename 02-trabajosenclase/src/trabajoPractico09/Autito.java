package trabajoPractico09;

public class Autito {

	//ATRIBUTOS
    private String marca;
    private String modelo;
    private String patente;
    private int anio;
    private int kilometrosActuales;
    private double precio;    
    
    //CONSTRUCTORES
    public Autito() {
    	this.marca = "";
    	this.modelo = "";
    	this.patente = "";
    	this.anio = 0;
    	this.kilometrosActuales =0;
    	this.precio = 0.0;
    }
    
    public Autito(String marca, String modelo, String patente, int anio, int kilometrosActuales, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.anio = anio;
        this.kilometrosActuales = kilometrosActuales;
        this.precio = precio;
    }
    
    //GETS&SETS
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

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
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
    
    //METODOS
    public boolean esCeroKm() {
        if(this.kilometrosActuales == 0) {
            return true;
        }
        return false;
    }
	
    public String toString() {
    	return this.marca + ", " + this.modelo + ".";
    }
    
}
