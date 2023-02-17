package AlbumDeFiguritas;

public class Album {
private static String selecciones[] = {"Qatar", "Ecuador", "Senegal", "Paises Bajos", "Inglaterra", "Irán", "EEUU", "Gales", "Argentina", "Arabia Saudita", "México", "Polonia", "Francia", "Australia", "Dinamarca", "Tunez", "España", "Costa Rica", "Alemania", "Japón", "Bélgica", "Canadá", "Marruecos", "Croacia", "Brasil", "Serbia", "Suiza", "Camerún", "Portugal", "Ghana", "Uruguay", "Corea del Sur"};
    
    private static Figurita figuritasDisponibles[] = new Figurita[704]; //static forma parte de la clase. Son todas las figuritas que se pueden comprar 
    private Figurita figuritasActuales[];//mi album por eso no es static, puedo tener figuritas repetidas por eso no es la misma cantidad que FDisponibles
    
    public Album() {
        /*
         * El constructor debe generar las condiciones necesaias para garantizar el correcto funcionamiento de la app
         */
        figuritasActuales = new Figurita[2000]; //2000 porque puedo tener repetidas entonces bueno bueno
        
        
    }
    
    public static void inicializarCodigosDeFiguritas() {
        /*
         * Por cada país debe generar 22 códigos de manera automática por ejemplo QAT1, URU12, COS10
         */
        int posicionEnFiguritasDisponibles = 0; //para movernos dentro del array de figuritasDisponibles
        for(int i = 0; i < selecciones.length; i++) {
            String caracterPais = (selecciones[i].substring(0,3)).toUpperCase();
            for(int j = 1; j < 23; j++) {//del 1 al 22
                String codigoFigurita = caracterPais + j;
                figuritasDisponibles[posicionEnFiguritasDisponibles++] = new Figurita(codigoFigurita, selecciones[i]);//se crea con el constructor de la figurita
                //figuritasDisponibles[posicionEnFiguritasDisponibles++].setCodigo(); no se necesita porque se setea directo con el constructor al CREAR UNA FIGURITA, creando no es mas null. 
                //SE TIENE QUE CREAR OBJETO CON NEW PARA QUE DEJE DE SER NULL
                figuritasDisponibles[posicionEnFiguritasDisponibles-1].setSeleccion(selecciones[i]);
            }
            
        }
        
        /*
        int numeroDeFigurita = 0;
        String codigoFigurita = "";
        String caracterPais = "";
        for(int i = 0; i < figuritasDisponibles.length; i++) {
            if(figuritasDisponibles[i] ==null) {
                for(int j = 0; j < selecciones.length; j++) {
                caracterPais = (selecciones[j].substring(2)).toUpperCase();
                do {
                    numeroDeFigurita++;
                    codigoFigurita = caracterPais + numeroDeFigurita;
                } while (numeroDeFigurita <= 22);
                
                figuritasDisponibles[i].setCodigo(codigoFigurita);
            }
            }
        }*/
    }
    
    public static void actualizarDatosFigurita(String codigo, char grupo, String nombreJugador, double valor) {
        /*
         * En función del código de figurita, se deben actualizar los datos de la misma en figuritasDisponibles 
         */
        
        for(int i = 0
        		; i < figuritasDisponibles.length; i++) {
            if(figuritasDisponibles[i].getCodigo().equalsIgnoreCase(codigo)) {
                figuritasDisponibles[i].setGrupo(grupo);
                figuritasDisponibles[i].setNombreJugador(nombreJugador);
                figuritasDisponibles[i].setValor(valor);
            }
        }
        
        
    }
    
    public static Figurita getFigurita(String codigo) {
        /*
         * En función del código de figurita, devuelve la figurita de figuritasDisponibles
         */
        for(int i = 0; i < figuritasDisponibles.length; i++) {
            if(figuritasDisponibles[i].getCodigo().equals(codigo)) {
                return figuritasDisponibles[i];
            }
        }
        
        return null;
    }
    
    public Figurita[] comprarSobre() {
        /*
         * Se debe calcular y devolver 5 códigos de figurita de manera aleatoria.
         */
        Figurita sobre[] = new Figurita[5];
        
        for(int i = 0; i < sobre.length; i++) {
        	int posicion =(int)(Math.random()*704);
            sobre[i] = figuritasDisponibles[posicion];
        }
        
        
        return sobre;
    }
    
    public void agregarFigurita(Figurita nueva) {
        /*
         * Agrega una nueva figurita al array figuritasActuales
         */
        for(int i = 0; i < figuritasActuales.length; i++) {
            if(figuritasActuales[i] == null) {
                figuritasActuales[i] = nueva;
                break;
            }
        }        
    }
    
    public void ordenarFiguritasActuales() {
		/*
		 * Debe ordenar el array figuritasActuales
		 */
    	for (int i = 0; i < figuritasActuales.length; i++) {
			for (int j = 1; j < figuritasActuales.length - 1; j++) {
				if (figuritasActuales[j] != null && figuritasActuales[j + 1] != null && figuritasActuales[j].getCodigo().compareTo(figuritasActuales[j + 1].getCodigo()) > 0) {
					Figurita guardarTemporalmente = figuritasActuales[j];
					figuritasActuales[j] = figuritasActuales[j + 1];
					figuritasActuales [j + 1] = guardarTemporalmente;
				}
			}
		}	
	}
    
    public boolean elAlbumEstaCompleto() {
        /*
         * Debe verificar que todas las figuritas disponibles estén presentes al menos una vez en las figuritas actuales 
         */        
        
        if(calcularPorcentajeCompletado() == 100) {
            return true;
        }
        return false;
    }

    public double calcularPorcentajeCompletado() {
        /*
         * Debe calcular el porcentaje de figuritas del album que está completo. Para esto se debe basar en la información de las figuritasDisponibles en relación a las figuritasActuales que se tiene en el album.
         */
    	int figuritasSinRepetir = 0;
		double porcentaje = 0.0;
		for(int i=0; i<figuritasDisponibles.length; i++) {
			for(int j=0; j<figuritasActuales.length; j++) {
				if(figuritasActuales[j] != null && figuritasDisponibles[i] != null && figuritasDisponibles[i].getCodigo().equals(figuritasActuales[j].getCodigo())) {
					figuritasSinRepetir++;
					i++;
				}
			}
		}
		porcentaje = (double)figuritasSinRepetir*100/figuritasDisponibles.length;
		return porcentaje;
    }
    
    public String toString() {
    	String resultado = "";
		for(int i = 0; i<figuritasActuales.length; i++) {
			if(figuritasActuales[i] != null) {
			resultado += figuritasActuales[i].toString() + "\n";
			}
		}
		return resultado;
    }
}
