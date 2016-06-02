package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Mundo.Casilla;

public class PanelJuego extends JPanel {
	private Interfaz principal;
	private JLabel[][] labels;

	public PanelJuego(Interfaz pPrincipal) {
		setPreferredSize(new Dimension(800, 800));

		principal = pPrincipal;

	}

	public void cargar() {
		removeAll();
		setLayout(new GridLayout(principal.setFilas(), principal.setColumnas()));
		labels = new JLabel[principal.setFilas()][principal.setColumnas()];

		for (int i = 0; i < principal.setFilas(); i++) {
			for (int j = 0; j < principal.setColumnas(); j++) {
				labels[i][j] = new JLabel();
				labels[i][j].setHorizontalAlignment(JLabel.CENTER);
				add(labels[i][j]);
			}
		}
	}

	public void actualizar() {
		for (int i = 0; i < principal.setFilas(); i++) {
			for (int j = 0; j < principal.setColumnas(); j++) {
				labels[i][j].setIcon(new ImageIcon(principal.setMatrizCasillas()[i][j].setImagenCasilla()));
			}
		}
	}
}
