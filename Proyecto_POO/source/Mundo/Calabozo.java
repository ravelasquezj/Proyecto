package Mundo;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JLabel;

import GUI.PanelAcciones;
import GUI.PanelMovimientos;

/**
 * Esta clase representa el calabozo y conoce las casillas del juego
 */
public class Calabozo {

	public final static int continua_Juego = 0;

	public final static int juego_Ganado = 1;

	public final static int juego_Perdido = 2;

	private int[][] numerosParaImagenesJuego;

	/**
	 * Cada elemento de la matriz es una casilla que tiene una imagen
	 * determinada.
	 */
	private Casilla[][] casillasJuego;

	private int filas;

	private int columnas;

	private int numLlaves;

	private int numLlavesCogidas;

	private int numVidas;

	private int numDiablos;

	private int numDiablosMatados;

	private int numEspadas;

	private int numEspadasCogidas;

	private int cooXInicial;

	private int cooYInicial;

	private int cooXActual;

	private int cooYActual;

	private int estadoJuego;

	private boolean espadaRoja;

	private boolean espadaAzul;

	private boolean espadaAmarilla;

	private boolean llaveRoja;

	private boolean llaveAzul;

	private boolean llaveAmarilla;

	/**
	 * Construye un nuevo calabozo.
	 */
	public Calabozo() {
		estadoJuego = continua_Juego;
		cooXInicial = 0;
		cooYInicial = 0;
		numLlavesCogidas = 0;
		numVidas = 3;
		numDiablosMatados = 0;
		numEspadasCogidas = 0;
	}

	/**
	 * Crea una matriz de casillas que contiene los datos ordenados según lo
	 * especificado en el archivo de entrada.
	 */
	public void cargar1(File pArchivo) throws Exception {
		FileInputStream puente1 = new FileInputStream(pArchivo);
		Properties properties1 = new Properties();
		properties1.load(puente1);
		puente1.close();
		filas = Integer.parseInt(properties1.getProperty("filas"));
		columnas = Integer.parseInt(properties1.getProperty("columnas"));
		numerosParaImagenesJuego = null;
		numerosParaImagenesJuego = new int[filas][columnas];
		casillasJuego = new Casilla[filas][columnas];
		numDiablos = Integer.parseInt(properties1.getProperty("numDiablos"));
		for (int i = 0; i < filas; i++) {
			String renglon = properties1.getProperty("fila" + i);
			String[] arregloRenglon = renglon.split("-");
			for (int j = 0; j < arregloRenglon.length; j++) {
				String valor = arregloRenglon[j];
				int numeroParaImagen = Integer.parseInt(valor);
				numerosParaImagenesJuego[i][j] = numeroParaImagen;
			}
		}
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				int numero = numerosParaImagenesJuego[i][j];
				if (numero == 1) {
					casillasJuego[i][j] = new Casilla(Casilla.muro, i, j);
				} else if (numero == 2) {
					casillasJuego[i][j] = new Casilla(Casilla.piso, i, j);
				} else if (numero == 3) {
					casillasJuego[i][j] = new Casilla(Casilla.llaveRoja, i, j);
				} else if (numero == 4) {
					casillasJuego[i][j] = new Casilla(Casilla.llaveAzul, i, j);
				} else if (numero == 5) {
					casillasJuego[i][j] = new Casilla(Casilla.llaveAmarilla, i, j);
				} else if (numero == 6) {
					casillasJuego[i][j] = new Casilla(Casilla.puertaRoja, i, j);
				} else if (numero == 7) {
					casillasJuego[i][j] = new Casilla(Casilla.puertaAzul, i, j);
				} else if (numero == 8) {
					casillasJuego[i][j] = new Casilla(Casilla.puertaAmarilla, i, j);
				} else if (numero == 9) {
					casillasJuego[i][j] = new Casilla(Casilla.puertaSalida, i, j);
				} else if (numero == 10) {
					casillasJuego[i][j] = new Casilla(Casilla.diabloRojo, i, j);
				} else if (numero == 11) {
					casillasJuego[i][j] = new Casilla(Casilla.diabloAzul, i, j);
				} else if (numero == 12) {
					casillasJuego[i][j] = new Casilla(Casilla.diabloAmarillo, i, j);
				} else if (numero == 13) {
					casillasJuego[i][j] = new Casilla(Casilla.armaRoja, i, j);
				} else if (numero == 14) {
					casillasJuego[i][j] = new Casilla(Casilla.armaAzul, i, j);
				} else if (numero == 15) {
					casillasJuego[i][j] = new Casilla(Casilla.armaAmarilla, i, j);
				}
			}
		}
		cooXInicial = Integer.parseInt(properties1.getProperty("heroe.posX"));
		cooYInicial = Integer.parseInt(properties1.getProperty("heroe.posY"));
		cooXActual = cooXInicial;
		cooYActual = cooYInicial;
		casillasJuego[cooXInicial][cooYInicial].cambiarImagen(Casilla.heroe);
	}

	public Casilla[][] setCasillas() {
		return casillasJuego;
	}

	public int setFilas() {
		return filas;
	}

	public int setColumnas() {
		return columnas;
	}

	public int setNumLlaves() {
		return numLlaves;
	}

	public int setNumLlavesCogidas() {
		return numLlavesCogidas;
	}

	public int setNumVidas() {
		return numVidas;
	}

	public int setNumDiablos() {
		return numDiablos;
	}

	public int setNumDiablosMatados() {
		return numDiablosMatados;
	}

	public int setNumEspadas() {
		return numEspadas;
	}

	public int setNumEspadasCogidas() {
		return numEspadasCogidas;
	}

	public int setcooXInicial() {
		return cooXInicial;
	}

	public int setcooYInicial() {
		return cooYInicial;
	}

	public int setcooXActual() {
		return cooXActual;
	}

	public int setcooYActual() {
		return cooYActual;
	}

	public int setEstadoJuego() {
		return estadoJuego;
	}

	/**
	 * Cambia las coordenadas del héroe según la dirección que le llega por
	 * parámetro.
	 * 
	 * pDireccion: Dirección en la cual se mueve el héroe.
	 */
	public void moverHeroe(String pDireccion) throws Exception {
		if (PanelMovimientos.ARRIBA.equals(pDireccion)) {
			if (cooXActual > 0 && casillasJuego[cooXActual - 1][cooYActual].esPiso()) {
				casillasJuego[cooXActual - 1][cooYActual] = new Casilla(Casilla.heroe, cooXActual - 1, cooYActual);
				casillasJuego[cooXActual][cooYActual] = new Casilla(Casilla.piso, cooXActual, cooYActual);
				cooXActual--;
			} else {
				throw new Exception("Movimiento inválido.");
			}

		} else if (PanelMovimientos.IZQUIERDA.equals(pDireccion)) {
			if (cooYActual > 0 && casillasJuego[cooXActual][cooYActual - 1].esPiso()) {
				casillasJuego[cooXActual][cooYActual - 1] = new Casilla(Casilla.heroe, cooXActual, cooYActual - 1);
				casillasJuego[cooXActual][cooYActual] = new Casilla(Casilla.piso, cooXActual, cooYActual);
				cooYActual--;
			} else {
				throw new Exception("Movimiento inválido.");
			}
		} else if (PanelMovimientos.DERECHA.equals(pDireccion)) {
			if (cooYActual < (columnas - 1) && casillasJuego[cooXActual][cooYActual + 1].esPiso()) {
				casillasJuego[cooXActual][cooYActual + 1] = new Casilla(Casilla.heroe, cooXActual, cooYActual + 1);
				casillasJuego[cooXActual][cooYActual] = new Casilla(Casilla.piso, cooXActual, cooYActual);
				cooYActual++;
			} else {
				throw new Exception("Movimiento inválido.");
			}
		} else if (PanelMovimientos.ABAJO.equals(pDireccion)) {
			if (cooXActual < (filas - 1) && casillasJuego[cooXActual + 1][cooYActual].esPiso()) {
				casillasJuego[cooXActual + 1][cooYActual] = new Casilla(Casilla.heroe, cooXActual + 1, cooYActual);
				casillasJuego[cooXActual][cooYActual] = new Casilla(Casilla.piso, cooXActual, cooYActual);
				cooXActual++;
			} else {
				throw new Exception("Movimiento inválido.");
			}
		}

		perderVidaSiHayDiablos();
	}

	/**
	 * Hace una acción de acuerdo con la dirección que llega por parámetro.
	 * 
	 * pDireccion Dirección en la que se quiere hacer la acción.
	 */
	public void hacerAccion(String pDireccion) throws Exception {
		if (PanelAcciones.acc_Arriba.equals(pDireccion)) {
			if (cooXActual > 0 && casillasJuego[cooXActual - 1][cooYActual].permiteAccion()) {
				ejecutarAccion(cooXActual - 1, cooYActual);
			} else {
				throw new Exception("No hay una acción válida.");
			}
		} else if (PanelAcciones.acc_Izquierda.equals(pDireccion)) {
			if (cooYActual > 0 && casillasJuego[cooXActual][cooYActual - 1].permiteAccion()) {
				ejecutarAccion(cooXActual, cooYActual - 1);
			} else {
				throw new Exception("No hay una acción válida.");
			}
		} else if (PanelAcciones.acc_Derecha.equals(pDireccion)) {
			if (cooYActual < (columnas - 1) && casillasJuego[cooXActual][cooYActual + 1].permiteAccion()) {
				ejecutarAccion(cooXActual, cooYActual + 1);
			} else {
				throw new Exception("No hay una acción válida.");
			}
		} else if (PanelAcciones.acc_Abajo.equals(pDireccion)) {
			if (cooXActual < (filas - 1) && casillasJuego[cooXActual + 1][cooYActual].permiteAccion()) {
				ejecutarAccion(cooXActual + 1, cooYActual);
			} else {
				throw new Exception("No hay una acción válida.");
			}
		}
	}

	/**
	 * Método encargado de ejecutar una acción.
	 * 
	 * pFilaActual: Coordenada en x de la casilla en la cual se quiere ejecutar
	 * la acción. pColumnaActual: Coordenada en y de la casilla en la cual se
	 * quiere ejecutar una acción.
	 */
	public void ejecutarAccion(int pFilaActual, int pColumnaActual) throws Exception {
		if (casillasJuego[pFilaActual][pColumnaActual].esDiablo()) {
			if (puedeDerrotarDiablo(casillasJuego[pFilaActual][pColumnaActual].setImagenCasilla())) {
				casillasJuego[pFilaActual][pColumnaActual] = new Casilla(Casilla.piso, cooXActual, cooYActual);
				numDiablosMatados++;
			} else {
				perderVida();
			}
		} else if (casillasJuego[pFilaActual][pColumnaActual].sePuedeGuardar()) {
			guardarObjeto(casillasJuego[pFilaActual][pColumnaActual].setImagenCasilla());
			casillasJuego[pFilaActual][pColumnaActual] = new Casilla(Casilla.piso, cooXActual, cooYActual);
		} else if (casillasJuego[pFilaActual][pColumnaActual].esPuertaNormal()
				&& puedeAbrirPuerta(casillasJuego[pFilaActual][pColumnaActual].setImagenCasilla())) {
			casillasJuego[pFilaActual][pColumnaActual] = new Casilla(Casilla.piso, cooXActual, cooYActual);
		} else if (casillasJuego[pFilaActual][pColumnaActual].setImagenCasilla().equals(Casilla.puertaSalida)
				&& numLlavesCogidas == 3) {
			casillasJuego[pFilaActual][pColumnaActual] = new Casilla(Casilla.piso, cooXActual, cooYActual);
			estadoJuego = juego_Ganado;
			throw new Exception(
					"Felicidades, haz ganado! \n Mataste " + numDiablosMatados + "/" + numDiablos + " demonios.");
		}
	}

	/**
	 * Método encargado de decir si se puede o no abrir una puerta normal.
	 * 
	 * pPuerta: Ruta de la imagen de la puerta que se quiere abrir.
	 */
	public boolean puedeAbrirPuerta(String pPuerta) {
		boolean puede = false;
		if (pPuerta.equals(Casilla.puertaAmarilla) && llaveAmarilla) {
			puede = true;
		}
		if (pPuerta.equals(Casilla.puertaAzul) && llaveAzul) {
			puede = true;
		}
		if (pPuerta.equals(Casilla.puertaRoja) && llaveRoja) {
			puede = true;
		}
		return puede;
	}

	/**
	 * Método encargado de guardar un objeto.
	 * 
	 * pImagenCasilla: Imagen de el objeto que se quiere guardar.
	 */
	public void guardarObjeto(String pImagenCasilla) {
		if (pImagenCasilla.equals(Casilla.armaAmarilla)) {
			espadaAmarilla = true;
			numEspadasCogidas++;
		} else if (pImagenCasilla.equals(Casilla.armaAzul)) {
			espadaAzul = true;
			numEspadasCogidas++;
		} else if (pImagenCasilla.equals(Casilla.armaRoja)) {
			espadaRoja = true;
			numEspadasCogidas++;
		} else if (pImagenCasilla.equals(Casilla.llaveAmarilla)) {
			llaveAmarilla = true;
			numLlavesCogidas++;
		} else if (pImagenCasilla.equals(Casilla.llaveRoja)) {
			llaveRoja = true;
			numLlavesCogidas++;
		} else if (pImagenCasilla.equals(Casilla.llaveAzul)) {
			llaveAzul = true;
			numLlavesCogidas++;
		}
	}

	/**
	 * Método encargado de restar una vida en caso de moverse a una de las ocho
	 * casillas cercanas a un demonio y no tener la espada del color del
	 * demonio.
	 */
	public void perderVidaSiHayDiablos() throws Exception {
		if (cooXActual > 0) {
			if (casillasJuego[cooXActual - 1][cooYActual].esDiablo()
					&& !puedeDerrotarDiablo(casillasJuego[cooXActual - 1][cooYActual].setImagenCasilla())) {
				perderVida();
			}
			if (cooYActual > 0 && casillasJuego[cooXActual - 1][cooYActual - 1].esDiablo()
					&& !puedeDerrotarDiablo(casillasJuego[cooXActual - 1][cooYActual - 1].setImagenCasilla())) {
				perderVida();
			}
			if (cooYActual < (columnas - 1) && casillasJuego[cooXActual - 1][cooYActual + 1].esDiablo()
					&& !puedeDerrotarDiablo(casillasJuego[cooXActual - 1][cooYActual + 1].setImagenCasilla())) {
				perderVida();
			}
		}
		if (cooXActual < (filas - 1)) {
			if (casillasJuego[cooXActual + 1][cooYActual].esDiablo()
					&& !puedeDerrotarDiablo(casillasJuego[cooXActual + 1][cooYActual].setImagenCasilla())) {
				perderVida();
			}
			if (cooYActual > 0 && casillasJuego[cooXActual + 1][cooYActual - 1].esDiablo()
					&& !puedeDerrotarDiablo(casillasJuego[cooXActual + 1][cooYActual - 1].setImagenCasilla())) {
				perderVida();
			}
			if (cooYActual < (columnas - 1) && casillasJuego[cooXActual + 1][cooYActual + 1].esDiablo()
					&& !puedeDerrotarDiablo(casillasJuego[cooXActual + 1][cooYActual + 1].setImagenCasilla())) {
				perderVida();
			}
		}
		if (cooYActual > 0 && casillasJuego[cooXActual][cooYActual - 1].esDiablo()
				&& !puedeDerrotarDiablo(casillasJuego[cooXActual][cooYActual - 1].setImagenCasilla())) {
			perderVida();
		}
		if (cooYActual < (columnas - 1) && casillasJuego[cooXActual][cooYActual + 1].esDiablo()
				&& !puedeDerrotarDiablo(casillasJuego[cooXActual][cooYActual + 1].setImagenCasilla())) {
			perderVida();
		}
	}

	/**
	 * Método encargado de perder una vida.
	 */
	public void perderVida() throws Exception {
		numVidas--;
		if (numVidas == 0) {
			estadoJuego = juego_Perdido;
			throw new Exception("Lo sentimos, usted ha perdido.");
		}
	}

	/**
	 * Método que indica si se puede o no derrotar un demonio. <br>
	 * 
	 * pCasilla: Imagen de la casilla en la cual se encuentra el demonio.
	 */
	public boolean puedeDerrotarDiablo(String pCasilla) {
		boolean puede = false;
		if (pCasilla.equals(Casilla.diabloAmarillo) && espadaAmarilla) {
			puede = true;
		}
		if (pCasilla.equals(Casilla.diabloAzul) && espadaAzul) {
			puede = true;
		}
		if (pCasilla.equals(Casilla.diabloRojo) && espadaRoja) {
			puede = true;
		}
		return puede;
	}

	/**
	 * Método encargado de crear y asignar una casilla con la imagen del piso en
	 * la posición actual del héroe.
	 */
	public void cambiarCasilla() {
		casillasJuego[cooXActual][cooYActual] = new Casilla(Casilla.piso, cooXActual, cooYActual);
	}
}
