package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Panel que contiene los p�neles del estado del h�roe y las opciones del juego.
 */
public class PanelArriba extends JPanel {

	private PanelEstado panelEstado;

	private PanelOpciones panelOpciones;

	/**
	 * Construye el panel de arriba.
	 */
	public PanelArriba(Interfaz pPrincipal) {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(310, 130));

		panelEstado = new PanelEstado(pPrincipal);
		panelOpciones = new PanelOpciones(pPrincipal);

		add(panelEstado, BorderLayout.NORTH);
		add(panelOpciones, BorderLayout.SOUTH);
	}

	/**
	 * M�todo encargado de dar el panel del estado del h�roe.
	 */
	public PanelEstado setPanelEstado() {
		return panelEstado;
	}
}
