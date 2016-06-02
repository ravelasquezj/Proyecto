package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class PanelInteraccion extends JPanel {
	private PanelMovimientos panelMovimientos;
	private PanelAcciones panelAcciones;

	public PanelInteraccion(Interfaz pPrincipal) {
		setLayout(new GridLayout(4, 1));
		setPreferredSize(new Dimension(170, 130));

		panelMovimientos = new PanelMovimientos(pPrincipal);
		panelAcciones = new PanelAcciones(pPrincipal);

		add(panelMovimientos);
		add(panelAcciones);
	}
}
