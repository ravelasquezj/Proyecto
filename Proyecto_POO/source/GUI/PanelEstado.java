package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panle que muestra el estado del héroe en el juego.
 */
public class PanelEstado extends JPanel {

	private Interfaz principal;

	private JLabel labVidas;

	private JTextField txtVidas;

	private JLabel labLlaves;

	private JTextField txtLlaves;

	private JLabel labEspadas;

	private JTextField txtEspadas;

	public PanelEstado(Interfaz pPrincipal) {
		principal = pPrincipal;

		setLayout(new GridLayout(1, 6));
		setPreferredSize(new Dimension(0, 45));
		TitledBorder border = BorderFactory.createTitledBorder("State");
		border.setTitleColor(Color.BLACK);
		setBorder(border);

		labVidas = new JLabel("Lifes");
		labLlaves = new JLabel("Keys");
		labEspadas = new JLabel("Swords");
		txtVidas = new JTextField("0");
		txtLlaves = new JTextField("0");
		txtEspadas = new JTextField("0");

		txtVidas.setEditable(false);
		txtLlaves.setEditable(false);
		txtEspadas.setEditable(false);

		add(labVidas);
		add(txtVidas);
		add(labLlaves);
		add(txtLlaves);
		add(labEspadas);
		add(txtEspadas);
	}

	public void setDatosJuego() {
		txtVidas.setText(principal.setNumVidas() + "");
		txtLlaves.setText(principal.setNumLlavesCogidas() + "");
		txtEspadas.setText(principal.setNumEspadasCogidas() + "");
	}
}
