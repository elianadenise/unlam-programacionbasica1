package preguntados;
//Estudiantes: Alonso Reyes, Ornella; Navarro, Eliana.

public class Preguntados {
	
	//ATRIBUTOS
	private String nombreJugador;
	private int puntos;
	private Respuesta entretenimientoUno [] = {new Respuesta("Santos, Medina, Ravenna, Lamponne", true), new Respuesta("Julio, Medina, Ravenna, Quique", false), new Respuesta("Santos, Fito, Laguzzi, Cosano", false), new Respuesta("Corina, Milazzo, Galván, Borges", false)};
	private Respuesta entretenimientoDos [] = {new Respuesta("Ricardo Darin", false), new Respuesta("Guillermo Francella", true), new Respuesta("Erica Rivas", false), new Respuesta("Maria Marull", false)};
	private Respuesta entretenimientoTres [] = {new Respuesta("Pepo", false), new Respuesta("Quintero", false), new Respuesta("Nik", false), new Respuesta("Quino", true)};
	private Respuesta entretenimientoCuatro [] = {new Respuesta("Pluto", false), new Respuesta("Betun", false), new Respuesta("Fatiga", true), new Respuesta("Chicho", false)};
	private Respuesta entretenimientoCinco [] = {new Respuesta("Roberto Musso.", false), new Respuesta("Adrian Dargelos.", false), new Respuesta("Carlos Alberto Solari", false), new Respuesta("Gustavo Cerati", true)};
	private Respuesta entretenimientoSeis [] = {new Respuesta("Dardo y Maria Elena", true), new Respuesta("Julian y Barbara", false), new Respuesta("Cacho y Beatriz", false), new Respuesta("Diego y Mariana", false)};
	private Respuesta entretenimientoSiete [] = {new Respuesta("Ivan de Pineda", false), new Respuesta("Marley", true), new Respuesta("Santiago del Moro", false), new Respuesta("Guido Kaczka", false)};
	private Respuesta entretenimientoOcho [] = {new Respuesta("Un cuento Chino", false), new Respuesta("El Secreto de sus Ojos", true), new Respuesta("El hijo de la Novia.", false), new Respuesta("La Odisea de los Giles", false)};
	private Respuesta entretenimientoNueve [] = {new Respuesta("Los Piojos", false), new Respuesta("Babasonicos", false), new Respuesta("El Cuarteto de Nos", true), new Respuesta("Los Redondos", false)};
	private Respuesta entretenimientoDiez [] = {new Respuesta("Doctor Doofenshmirtz", false), new Respuesta("Doctor Nefario", false), new Respuesta("Doctor Muerte", false), new Respuesta("Doctor Neurus", true)};
	
	private Respuesta geografiaUno [] = {new Respuesta("Neuquen", true), new Respuesta("Mendoza", false), new Respuesta("La Rioja", false), new Respuesta("Cordoba", false)};
	private Respuesta geografiaDos [] = {new Respuesta("Cerro Campanario", false), new Respuesta("Cerro Otto", true), new Respuesta("Cerro Catedral", false), new Respuesta("Cerro Leones", false)};
	private Respuesta geografiaTres [] = {new Respuesta("Rio Obi", false), new Respuesta("Rio Misisipi", false), new Respuesta("Rio Nilo", false), new Respuesta("Rio Amazonas", true)};
	private Respuesta geografiaCuatro [] = {new Respuesta("Estados Unidos", false), new Respuesta("Qatar", false), new Respuesta("Dubai", true), new Respuesta("China", false)};
	private Respuesta geografiaCinco [] = {new Respuesta("Asia", false), new Respuesta("Oceanía", false), new Respuesta("Europa", false), new Respuesta("América", true)};
	private Respuesta geografiaSeis [] = {new Respuesta("América del Sur", true), new Respuesta("América Central", false), new Respuesta("Africa", false), new Respuesta("Asia", false)};
	private Respuesta geografiaSiete [] = {new Respuesta("Meridiano de Ecuador", false), new Respuesta("Meridiano de Greenwich", true), new Respuesta("Meridiano Ártico", false), new Respuesta("Ninguna es correcta", false)};
	private Respuesta geografiaOcho [] = {new Respuesta("Asia", true), new Respuesta("América.", false), new Respuesta("África", false), new Respuesta("Antártida", false)};
	private Respuesta geografiaNueve [] = {new Respuesta("Emiratos", false), new Respuesta("Estrella", false), new Respuesta("Ecuador", true), new Respuesta("Escorpio", false)};
	private Respuesta geografiaDiez [] = {new Respuesta("Hemisferio Oriental", false), new Respuesta("Hemisferio Occidental", false), new Respuesta("Hemisferio Sur", false), new Respuesta("Hemisferio Norte", true)};
	
	private Respuesta historiaUno [] = {new Respuesta("1492", true), new Respuesta("1353", false), new Respuesta("1503", false), new Respuesta("1810", false)};
	private Respuesta historiaDos [] = {new Respuesta("Justo Jose de Urquiza", false), new Respuesta("Bernardino Rivadavia", true), new Respuesta("Manuel Belgrano", false), new Respuesta("Juan Manuel de Rosas", false)};
	private Respuesta historiaTres [] = {new Respuesta("1955", false), new Respuesta("1976", false), new Respuesta("1939", false), new Respuesta("1930", true)};
	private Respuesta historiaCuatro [] = {new Respuesta("99 años", false), new Respuesta("97 años", false), new Respuesta("116 años", true), new Respuesta("100 años", false)};
	private Respuesta historiaCinco [] = {new Respuesta("1816", false), new Respuesta("1776", false), new Respuesta("1807", false), new Respuesta("1810", true)};
	private Respuesta historiaSeis [] = {new Respuesta("1969", true), new Respuesta("1980", false), new Respuesta("1959", false), new Respuesta("1970", false)};
	private Respuesta historiaSiete [] = {new Respuesta("1939", false), new Respuesta("1914", true), new Respuesta("1918", false), new Respuesta("1925", false)};
	private Respuesta historiaOcho [] = {new Respuesta("George Washington", true), new Respuesta("Abraham Lincoln", false), new Respuesta("Thomas Jefferson", false), new Respuesta("James Madison", false)};
	private Respuesta historiaNueve [] = {new Respuesta("Dioses", false), new Respuesta("Alcaldes", false), new Respuesta("Faraones", true), new Respuesta("Basileos", false)};
	private Respuesta historiaDiez [] = {new Respuesta("Alan Shepard", false), new Respuesta("Valentina Tereshkova", false), new Respuesta("Yuri Gagarin", false), new Respuesta("Neil Armstrong", true)};

	private Respuesta deporteUno [] = {new Respuesta("Hombros", true), new Respuesta("Glúteos", false), new Respuesta("Abdominales", false), new Respuesta("No es un ejercicio", false)};
	private Respuesta deporteDos [] = {new Respuesta("Si", true), new Respuesta("No", false), new Respuesta("Depende", false), new Respuesta("Ninguna es correcta", false)};
	private Respuesta deporteTres [] = {new Respuesta("3", false), new Respuesta("5", false), new Respuesta("9", false), new Respuesta("8", true)};
	private Respuesta deporteCuatro [] = {new Respuesta("Si", true), new Respuesta("No", false), new Respuesta("Depende", false), new Respuesta("No es un deporte", false)};
	private Respuesta deporteCinco [] = {new Respuesta(" Uruguay ", false), new Respuesta("Italia", false), new Respuesta("Argentina", false), new Respuesta("Francia ", true)};
	private Respuesta deporteSeis [] = {new Respuesta("Azul, rojo, amarillo, verde y negro", true), new Respuesta("Azul, rojo, amarillo, verde y violeta", false), new Respuesta("Indigo, rojo, morado, verde y negro", false), new Respuesta("Azul, rojo, amarillo, naranja y verde", false)};
	private Respuesta deporteSiete [] = {new Respuesta("Cada 3 años", false), new Respuesta("Cada 4 años", true), new Respuesta("Cada 2 años", false), new Respuesta("Cada 5 años", false)};
	private Respuesta deporteOcho [] = {new Respuesta("1 punto", true), new Respuesta("2 puntos", false), new Respuesta("3 puntos", false), new Respuesta("4 puntos", false)};
	private Respuesta deporteNueve [] = {new Respuesta("Tricolore", false), new Respuesta("Azteca", false), new Respuesta("Jabulani", true), new Respuesta("Telstar", false)};
	private Respuesta deporteDiez [] = {new Respuesta("Sentadilla ", false), new Respuesta("Estocadas", false), new Respuesta("Sillón de cuádriceps", false), new Respuesta("Dominadas", true)};
	
	private Respuesta arteUno [] = {new Respuesta("Gotico", true), new Respuesta("Academicista", false), new Respuesta("Romanico", false), new Respuesta("Romantico", false)};
	private Respuesta arteDos [] = {new Respuesta("Tutankamon", false), new Respuesta("Akhenaton", true), new Respuesta("Amenofis III", false), new Respuesta("Ramses II", false)};
	private Respuesta arteTres [] = {new Respuesta("Impresionismo", false), new Respuesta("Dadaismo", false), new Respuesta("Fauvismo", false), new Respuesta("Cubismo", true)};
	private Respuesta arteCuatro [] = {new Respuesta("Raffaello Sanzio", false), new Respuesta("Michelangelo Buonarroti", false), new Respuesta("Leonardo Da Vinci", true), new Respuesta("Donatello", false)};
	private Respuesta arteCinco [] = {new Respuesta("Pablo Picasso", false), new Respuesta("Emilio Pettoruti", false), new Respuesta("Banksy", false), new Respuesta("Andy Warhol", true)};
	private Respuesta arteSeis [] = {new Respuesta("Neogótico", true), new Respuesta("Barroco", false), new Respuesta("Romanico", false), new Respuesta("Arquitectura de los Ingenieros", false)};
	private Respuesta arteSiete [] = {new Respuesta("Dórico", false), new Respuesta("Toscano", true), new Respuesta("Jonico", false), new Respuesta("Corintio", false)};
	private Respuesta arteOcho [] = {new Respuesta("El Bosco", true), new Respuesta("El Greco", false), new Respuesta("Caravaggio", false), new Respuesta("Rembrandt", false)};
	private Respuesta arteNueve [] = {new Respuesta("Museo del Louvre", false), new Respuesta("Museo Britanico", false), new Respuesta("Museo del Prado", true), new Respuesta("Museo Metropolitano de Arte", false)};
	private Respuesta arteDiez [] = {new Respuesta("Salvador Dali", false), new Respuesta("Maria Marta Minujin", false), new Respuesta("Pablo Picasso", false), new Respuesta("Marcel Duchamp", true)};
	
	private Respuesta cienciaUno[] = {new Respuesta("William Anderson", false), new Respuesta("James Watson", false), new Respuesta("Gregor Mendel", true), new Respuesta("Ninguno", false)};
	private Respuesta cienciaDos[] = {new Respuesta("50", false), new Respuesta("10", false), new Respuesta("6", false), new Respuesta("32", true)};
	private Respuesta cienciaTres[] = {new Respuesta("Una cadena de aminoacidos", true), new Respuesta("Una comida", false), new Respuesta("Un gen", false), new Respuesta("Ninguna es correcta", false)};
	private Respuesta cienciaCuatro[] = {new Respuesta("Mitocondria", false), new Respuesta("Lisosoma", false), new Respuesta("Nucleolo", false), new Respuesta("Ribosoma", true)};
	private Respuesta cienciaCinco[] = {new Respuesta("Oxigeno", false), new Respuesta("Metal", false), new Respuesta("Hidrogeno", false), new Respuesta("Agua", true)};
	private Respuesta cienciaSeis[] = {new Respuesta("Especie de rinoceronte", false), new Respuesta("Cirugia", true), new Respuesta("Ejercicio", false), new Respuesta("Animal", false)};
	private Respuesta cienciaSiete[] = {new Respuesta("Enzima", true), new Respuesta("Cisteina", false), new Respuesta("Alanna", false), new Respuesta("Glicina", false)};
	private Respuesta cienciaOcho[] = {new Respuesta("Sistema nervioso neuronal y cerebral", false), new Respuesta("Sistema nervioso cabezal y pensante", false), new Respuesta("Sistema nervioso central y periférico", true), new Respuesta("Ninguna es correcta", false)};
	private Respuesta cienciaNueve[] = {new Respuesta("Lactosa", false), new Respuesta("Lactasa", true), new Respuesta("Lipasa", false), new Respuesta("No hay una enzima que se dedique a eso", false)};
	private Respuesta cienciaDiez[] = {new Respuesta("El cerebro", true), new Respuesta("El intestino", false), new Respuesta("El corazon", false), new Respuesta("Medula espinal", false)};
	
	private Pregunta categoriaEntretenimiento[] = {new Pregunta("Quiénes son los personajes principales en Los Simuladores?", entretenimientoUno, Categoria.ENTRETENIMIENTO), new Pregunta("Cuál de estos actores no participa en Relatos Salvajes?", entretenimientoDos, Categoria.ENTRETENIMIENTO), new Pregunta("Quién es el autor de Mafalda? ", entretenimientoTres, Categoria.ENTRETENIMIENTO), new Pregunta("Cómo se llama el perro de Casados con Hijos?", entretenimientoCuatro, Categoria.ENTRETENIMIENTO), new Pregunta("Quién es el vocalista de Soda Stereo?", entretenimientoCinco, Categoria.ENTRETENIMIENTO), new Pregunta("Cómo se llaman los vecinos de Casados con Hijos?", entretenimientoSeis, Categoria.ENTRETENIMIENTO),new Pregunta("Quién fue el conductor del Muro Infernal?", entretenimientoSiete, Categoria.ENTRETENIMIENTO), new Pregunta("Cuál película fue protagonizada por Darin que a su vez fue premiada por un Oscar?", entretenimientoOcho, Categoria.ENTRETENIMIENTO), new Pregunta("Cuál de estas bandas no es de Argentina?", entretenimientoNueve, Categoria.ENTRETENIMIENTO), new Pregunta("Quién era el enemigo principal de Hijitus?", entretenimientoDiez, Categoria.ENTRETENIMIENTO)};
	
	private Pregunta categoriaGeografia[] = {new Pregunta("En qué provincia Argentina se encuentra principalmente Vaca Muerta?", geografiaUno, Categoria.GEOGRAFIA), new Pregunta("En cuál cerro de Bariloche se encuentra una confitería giratoria?", geografiaDos, Categoria.GEOGRAFIA), new Pregunta("Cuál es el río más largo del mundo en cuanto a su longitud?", geografiaTres, Categoria.GEOGRAFIA), new Pregunta("En qué país se encuentra “The World”, el archipiélago artificial con forma de mundo?", geografiaCuatro, Categoria.GEOGRAFIA), new Pregunta("En qué continente se encuentra el país Groenlandia?", geografiaCinco, Categoria.GEOGRAFIA), new Pregunta("En qué continente se encuentra el desierto más seco del mundo?", geografiaSeis, Categoria.GEOGRAFIA),new Pregunta("Cómo se llama el Meridiano de Origen?", geografiaSiete, Categoria.GEOGRAFIA), new Pregunta("Cuál es el continente más extenso del mundo?", geografiaOcho, Categoria.GEOGRAFIA), new Pregunta("Cómo se llama el el círculo máximo perpendicular al eje de rotación del planeta Tierra.​?", geografiaNueve, Categoria.GEOGRAFIA), new Pregunta("En qué Hemisferio es visible durante todo el año la constelación Osa Mayor?", geografiaDiez, Categoria.GEOGRAFIA)};
	
	private Pregunta categoriaCiencia[] = {new Pregunta("Quien fue el padre de la genetica moderna?", cienciaUno, Categoria.CIENCIA), new Pregunta("Cuántos huesos posee la extremidad superior?", cienciaDos, Categoria.CIENCIA), new Pregunta("¿Que es una proteína?", cienciaTres, Categoria.CIENCIA), new Pregunta("Que organelo es el encargado de la sintesis de proteina?", cienciaCuatro, Categoria.CIENCIA), new Pregunta("Qué significa H2O?", cienciaCinco, Categoria.CIENCIA), new Pregunta("Que es una Rinoplastia?", cienciaSeis, Categoria.CIENCIA),new Pregunta("Qué proteína se encarga de descomponer los alimentos que ingerimos para que el cuerpo pueda usar sus nutrientes?", cienciaSiete, Categoria.CIENCIA), new Pregunta("Cuáles son las partes centrales que conforman el sistema nervioso?", cienciaOcho, Categoria.CIENCIA), new Pregunta("Qué enzima se encarga de descomponer la lactosa?", cienciaNueve, Categoria.CIENCIA), new Pregunta("Qué órgano del cuerpo humano consume más energía?", cienciaDiez, Categoria.CIENCIA)};
	
	private Pregunta categoriaHistoria[] = {new Pregunta("En qué año comenzaron las invasiones europeas en el continente hasta el momento conocido como Abya Yala (actual América)?", historiaUno, Categoria.HISTORIA), new Pregunta("Quién fue el primer presidente argentino?", historiaDos, Categoria.HISTORIA), new Pregunta("En qué año se llevó a cabo el primer golpe militar en la República Argentina comandado por José Félix Uriburu?", historiaTres, Categoria.HISTORIA), new Pregunta("Cuántos años duró la Guerra de los Cien Años?", historiaCuatro, Categoria.HISTORIA), new Pregunta("En qué año fue la Revolución de Mayo?", historiaCinco, Categoria.HISTORIA), new Pregunta("En qué año llegó el ser humano a la Luna?", historiaSeis, Categoria.HISTORIA),new Pregunta("En qué año comenzó la Primera Guerra Mundial?", historiaSiete, Categoria.HISTORIA), new Pregunta("Quién fue el primer presidente de Estados Unidos?", historiaOcho, Categoria.HISTORIA), new Pregunta("Cómo se llamaban los gobernantes del antiguo Egipto?", historiaNueve, Categoria.HISTORIA), new Pregunta("Quién fue la primera persona que viajó al espacio?", historiaDiez, Categoria.HISTORIA)};
	
	private Pregunta categoriaDeporte[] = {new Pregunta("El ejercicio “Press militar”, en qué músculo está enfocado?", deporteUno, Categoria.DEPORTE), new Pregunta("El ejercicio cardiovascular sirve para ganar masa muscular?", deporteDos, Categoria.DEPORTE), new Pregunta("El jugador Marcos Acuña de la selección Argentina, que numero tiene?", deporteTres, Categoria.DEPORTE), new Pregunta("El Roller Derby es un deporte de contacto?", deporteCuatro, Categoria.DEPORTE), new Pregunta("Qué país gano el mundial 2018?", deporteCinco, Categoria.DEPORTE), new Pregunta("Cuáles son los cinco colores del anillo de los Juegos Olímpicos?", deporteSeis, Categoria.DEPORTE),new Pregunta("Cada cuántos años se realizan los Juegos Olímpicos?", deporteSiete, Categoria.DEPORTE), new Pregunta("Cuántos puntos vale un tiro libre en baloncesto?", deporteOcho, Categoria.DEPORTE), new Pregunta("Qué nombre tenía la pelota del mundial 2010?", deporteNueve, Categoria.DEPORTE), new Pregunta("Cual de estos no pertenece a un ejercicio de tren inferior?", deporteDiez, Categoria.DEPORTE)};
	
	private Pregunta categoriaArte[] = {new Pregunta("Qué tipo de arte predominó en la Edad Media europea?", arteUno, Categoria.ARTE), new Pregunta("Qué faraón fue el impulsor del periodo naturalista en el arte egipcio?", arteDos, Categoria.ARTE), new Pregunta("A qué movimiento artístico pertenece el argentino Emilio Pettoruti?", arteTres, Categoria.ARTE), new Pregunta("Quién pintó la obra conocida como La Gioconda o Monalisa?", arteCuatro, Categoria.ARTE), new Pregunta("Con qué artista internacional colaboró Maria Marta Minujin?", arteCinco, Categoria.ARTE), new Pregunta("A qué estilo arquitectónico pertenece la Basílica de Luján?", arteSeis, Categoria.ARTE),new Pregunta("Cuál de estos no pertenece a un orden artístico griego clásico?", arteSiete, Categoria.ARTE), new Pregunta("Quién pintó el cuadro El jardín de las delicias?", arteOcho, Categoria.ARTE), new Pregunta("En qué museo se encuentra el cuadro “Las Meninas” de Diego Velazquez?", arteNueve, Categoria.ARTE), new Pregunta("Qué artista expuso un orinal con el título 'La fuente'?", arteDiez, Categoria.ARTE)};
	
	private Pregunta coronas[];
	
	//CONSTRUCTOR
	public Preguntados(String nombreJugador) {
		this.nombreJugador = nombreJugador;
		this.coronas = new Pregunta[6];
		this.puntos = 0;
	}
	
	//GETS
	public int getPuntos() {
		return puntos;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public Pregunta[] getCategoriaEntretenimiento() {
		return categoriaEntretenimiento;
	}
	
	public Pregunta[] getCategoriaGeografia() {
		return categoriaGeografia;
	}

	public Pregunta[] getCategoriaHistoria() {
		return categoriaHistoria;
	}

	public Pregunta[] getCategoriaDeporte() {
		return categoriaDeporte;
	}

	public Pregunta[] getCategoriaArte() {
		return categoriaArte;
	}

	public Pregunta[] getCoronas() {
		return coronas;
	}
	
	public Pregunta[] getCategoriaCiencia() {
		return categoriaCiencia;
	}

	//METODOS
	public Pregunta preguntaPorCategoria(Pregunta categoria[]) {
		Pregunta seleccionada =  null;
			seleccionada = categoria[(int)(Math.random()*10)];
		return seleccionada;
	}
	
	public Pregunta mostrarPregunta(Pregunta categoria[]) {
		Pregunta seleccionada = null;
		if(!categoriaGanada(seleccionada)) {
			seleccionada = categoria[(int)(Math.random()*60)];
		}
		return seleccionada;
	}
	
	public boolean agregarACoronas(Pregunta ganada) {
		boolean seAgrego = false;
		for(int i = 0; i < coronas.length; i++) {
			if(coronas[i] == null && this.categoriaGanada(ganada) == false) {
				coronas[i] = ganada;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}
	
	public int contarPuntos() {
		int puntosAcumulados = 0;
		for(int i = 0; i < coronas.length; i++) {
			if(coronas[i] != null) {
				puntosAcumulados++;
			}
		}
		return puntosAcumulados;
	}
	
	public boolean categoriaGanada(Pregunta ganada) {
		boolean coronaFueGanada = false;
		for(int i = 0; i < coronas.length; i++) {
			if(coronas[i] != null && coronas[i].getCategoria().equals(ganada.getCategoria())) {
				coronaFueGanada =  true;
				break;
			}
		}
		return coronaFueGanada;
	}
	
	public boolean gano() {
		boolean gano = false;
		if(this.puntos >= 6) {
			gano = true;
		} else if(this.puntos < 6) {
			gano = false;
		}
		return gano;
	}

	public String toString() {
		String coronasGanadas = "";
		for(int i = 0; i<coronas.length; i++) {
			if(coronas[i] != null) {
				coronasGanadas += "[" + (i+1) + "]" + coronas[i].getCategoria() + "\n";
			}
		} return "El jugador " + this.nombreJugador + " tiene las coronas: \n" + coronasGanadas;
	}
	
}
