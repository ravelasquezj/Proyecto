package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel que contiene los botones con los cuales el jugador realiza acciones.
 */
public class PanelAcciones extends JPanel implements ActionListener {

	public final static String acc_Arriba = "Arriba";

	public final static String acc_Abajo = "Abajo";

	public final static String acc_Derecha = "Derecha";

	public final static String acc_Izquierda = "Izquierda";

	private Interfaz principal;

	private JButton butArriba;

	private JButton butAbajo;

	private JButton butDerecha;

	private JButton butIzquierda;

	/**
	 * Construye el panel que tiene las acciones que puede hacer el héroe.
	 */
	public PanelAcciones(Interfaz pPrincipal) {
		principal = pPrincipal;
		setLayout(new GridLayout(3, 3));
		setPreferredSize(new Dimension(100, 145));
		TitledBorder border = BorderFactory.createTitledBorder("Actions");
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		butArriba = new JButton();
		butArriba.setActionCommand(acc_Arriba);
		butArriba.addActionListener(this);
		butArriba.setIcon(new ImageIcon("./utilidades/imagenes/arribaAcc.png"));
		butAbajo = new JButton();
		butAbajo.setActionCommand(acc_Abajo);
		butAbajo.addActionListener(this);
		butAbajo.setIcon(new ImageIcon("./utilidades/imagenes/abajoAcc.png"));
		butDerecha = new JButton();
		butDerecha.setActionCommand(acc_Derecha);
		butDerecha.addActionListener(this);
		butDerecha.setIcon(new ImageIcon("./utilidades/imagenes/derechaAcc.png"));
		butIzquierda = new JButton();
		butIzquierda.setActionCommand(acc_Izquierda);
		butIzquierda.addActionListener(this);
		butIzquierda.setIcon(new ImageIcon("./utilidades/imagenes/izquierdaAcc.png"));

		add(new JLabel(""));
		add(butArriba);
		add(new JLabel(""));
		add(butIzquierda);
		add(new JLabel(""));
		add(butDerecha);
		add(new JLabel(""));
		add(butAbajo);
		add(new JLabel(""));
	}

	/**
	 * Este método se ejecuta cuando se hace click sobre alguno de los botones.
	 */
	public void actionPerformed(ActionEvent e) {
		if (acc_Arriba.equals(e.getActionCommand())) {
			principal.hacerAccion(acc_Arriba);
		}
		if (acc_Abajo.equals(e.getActionCommand())) {
			principal.hacerAccion(acc_Abajo);
		}
		if (acc_Derecha.equals(e.getActionCommand())) {
			principal.hacerAccion(acc_Derecha);
		}
		if (acc_Izquierda.equals(e.getActionCommand())) {
			principal.hacerAccion(acc_Izquierda);
		}
	}
}
