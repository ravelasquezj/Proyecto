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
 * @author Rodrigo Vel�squez
 */
public class Interfaz extends JFrame {

	/**
	 * Calabozo en el cu�l se est� jugando.
	 */
	private Calabozo calabozo;

	/**
	 * Archivo del cu�l se obtienen las caracter�sticas del calabozo.
	 */
	private File archivoActual;

	/**
	 * Panel que contiene el estado del h�roe y las opciones del juego.
	 */
	private PanelArriba panelArriba;

	/**
	 * Panel que contiene las flechas de movimientos y acciones del h�roe.
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
	 * Ejecuta la aplicaci�n
	 */
	public static void main(String[] args) {
		Interfaz y = new Interfaz();
		y.setVisible(true);
	}

	/**
	 * M�todo encargado de cargar el archivo y de empezar el juego.
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
	 * M�todo encargado de reiniciar un nivel.
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
	 * M�todo encargado de dar el n�mero de filas del calabozo actual.
	 */
	public int setFilas() {
		return calabozo.setFilas();
	}

	/**
	 * M�todo encargado de dar el n�mero de columnas del calabozo actual.
	 */
	public int setColumnas() {
		return calabozo.setColumnas();
	}

	/**
	 * M�todo encargado de dar la matriz de casillas del calabozo.
	 */
	public Casilla[][] setMatrizCasillas() {
		Casilla[][] casillas = calabozo.setCasillas();
		return casillas;
	}

	/**
	 * M�todo encargado de dar el n�mero inicial de llaves del calabozo.
	 */
	public int setNumLlaves() {
		return calabozo.setNumLlaves();
	}

	/**
	 * M�todo encargado de dar el n�mero de llaves que tiene el h�roe.
	 */
	public int setNumLlavesCogidas() {
		return calabozo.setNumLlavesCogidas();
	}

	/**
	 * M�todo encargado de dar el n�mero de vidas del h�roe.
	 */
	public int setNumVidas() {
		return calabozo.setNumVidas();
	}

	/**
	 * M�todo encargado de dar el n�mero inicial de diablos.
	 */
	public int setNumDiablos() {
		return calabozo.setNumDiablos();
	}

	/**
	 * M�todo encargado de dar el n�mero de diablos matados por el h�roe.
	 */
	public int setNumDiablosMatados() {
		return calabozo.setNumDiablosMatados();
	}

	/**
	 * M�todo encargado de dar el n�mero inicial de espadas en el calabozo.
	 */
	public int setNumEspadas() {
		return calabozo.setNumEspadas();
	}

	/**
	 * M�todo encargado de dar el n�mero de espadas cogidas por el h�roe.
	 */
	public int setNumEspadasCogidas() {
		return calabozo.setNumEspadasCogidas();
	}

	/**
	 * M�todo encargado de dar el estado actual del juego.
	 */
	public int setEstadoJuego() {
		return calabozo.setEstadoJuego();
	}

	/**
	 * M�todo encargado de mover al h�roe seg�n la direcci�n que llega por
	 * par�metro.�
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
	 * M�todo encargado de hacer una acci�n dependiendo de qu� llega por
	 * par�metro.
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
	 * M�todo encargado de cambiar la imagen del h�roe por la de piso.
	 */
	public void cambiarCasilla() {
		calabozo.cambiarCasilla();
		actualizar();
	}

	/**
	 * M�todo encargado de actualizar las im�genes y los datos del juego.
	 */
	public void actualizar() {
		panelJuego.actualizar();
		panelArriba.setPanelEstado().setDatosJuego();
	}
}
