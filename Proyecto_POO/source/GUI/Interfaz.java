package GUI;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Mundo.Calabozo;
import Mundo.Casilla;

/**
 * Clase principal de la interfaz del calabozo.
 * 
 * @author Rodrigo Velásquez
 */
public class Interfaz extends JFrame {

	/**
	 * Calabozo en el cuál se está jugando.
	 */
	private Calabozo calabozo;

	/**
	 * Archivo del cuál se obtienen las características del calabozo.
	 */
	private File archivoActual;

	/**
	 * Panel que contiene el estado del héroe y las opciones del juego.
	 */
	private PanelArriba panelArriba;

	/**
	 * Panel que contiene las flechas de movimientos y acciones del héroe.
	 */
	private PanelInteraccion panelInteraccion;

	/**
	 * Panel donde se muestra el calabozo.
	 */
	private PanelJuego panelJuego;

	/**
	 * Construye la interfaz del juego.
	 */
	public Interfaz() {
		setTitle("Dungeon");
		setSize(700, 700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panelArriba = new PanelArriba(this);
		panelInteraccion = new PanelInteraccion(this);
		panelJuego = new PanelJuego(this);
		add(panelJuego, BorderLayout.CENTER);
		add(panelInteraccion, BorderLayout.EAST);
		add(panelArriba, BorderLayout.NORTH);
	}

	/**
	 * Ejecuta la aplicación
	 */
	public static void main(String[] args) {
		Interfaz y = new Interfaz();
		y.setVisible(true);
	}

	/**
	 * Método encargado de cargar el archivo y de empezar el juego.
	 */
	public void cargar() {
		try {
			JFileChooser fileChooser = new JFileChooser("./utilidades");
			fileChooser.setDialogTitle("Load Game");
			int resultado = fileChooser.showOpenDialog(this);
			if (resultado == JFileChooser.APPROVE_OPTION) {
				archivoActual = fileChooser.getSelectedFile();
				calabozo = new Calabozo();
				calabozo.cargar1(archivoActual);
				panelJuego.cargar();
				panelJuego.actualizar();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Método encargado de reiniciar un nivel.
	 */
	public void reiniciar() {
		try {
			calabozo = new Calabozo();
			calabozo.cargar1(archivoActual);
			panelJuego.cargar();
			panelJuego.actualizar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Método encargado de dar el número de filas del calabozo actual.
	 */
	public int setFilas() {
		return calabozo.setFilas();
	}

	/**
	 * Método encargado de dar el número de columnas del calabozo actual.
	 */
	public int setColumnas() {
		return calabozo.setColumnas();
	}

	/**
	 * Método encargado de dar la matriz de casillas del calabozo.
	 */
	public Casilla[][] setMatrizCasillas() {
		Casilla[][] casillas = calabozo.setCasillas();
		return casillas;
	}

	/**
	 * Método encargado de dar el número inicial de llaves del calabozo.
	 */
	public int setNumLlaves() {
		return calabozo.setNumLlaves();
	}

	/**
	 * Método encargado de dar el número de llaves que tiene el héroe.
	 */
	public int setNumLlavesCogidas() {
		return calabozo.setNumLlavesCogidas();
	}

	/**
	 * Método encargado de dar el número de vidas del héroe.
	 */
	public int setNumVidas() {
		return calabozo.setNumVidas();
	}

	/**
	 * Método encargado de dar el número inicial de diablos.
	 */
	public int setNumDiablos() {
		return calabozo.setNumDiablos();
	}

	/**
	 * Método encargado de dar el número de diablos matados por el héroe.
	 */
	public int setNumDiablosMatados() {
		return calabozo.setNumDiablosMatados();
	}

	/**
	 * Método encargado de dar el número inicial de espadas en el calabozo.
	 */
	public int setNumEspadas() {
		return calabozo.setNumEspadas();
	}

	/**
	 * Método encargado de dar el número de espadas cogidas por el héroe.
	 */
	public int setNumEspadasCogidas() {
		return calabozo.setNumEspadasCogidas();
	}

	/**
	 * Método encargado de dar el estado actual del juego.
	 */
	public int setEstadoJuego() {
		return calabozo.setEstadoJuego();
	}

	/**
	 * Método encargado de mover al héroe según la dirección que llega por
	 * parámetro.¿
	 */
	public void moverHeroe(String pDireccion) {
		try {
			calabozo.moverHeroe(pDireccion);
			actualizar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Método encargado de hacer una acción dependiendo de qué llega por
	 * parámetro.
	 */
	public void hacerAccion(String pDireccion) {
		try {
			calabozo.hacerAccion(pDireccion);
			actualizar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Método encargado de cambiar la imagen del héroe por la de piso.
	 */
	public void cambiarCasilla() {
		calabozo.cambiarCasilla();
		actualizar();
	}

	/**
	 * Método encargado de actualizar las imágenes y los datos del juego.
	 */
	public void actualizar() {
		panelJuego.actualizar();
		panelArriba.setPanelEstado().setDatosJuego();
	}
}
