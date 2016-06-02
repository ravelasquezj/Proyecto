package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Mundo.Calabozo;

public class PanelMovimientos extends JPanel implements ActionListener {
	public final static String ARRIBA = "Arriba";
	public final static String ABAJO = "Abajo";
	public final static String DERECHA = "Derecha";
	public final static String IZQUIERDA = "Izquierda";

	private Interfaz principal;
	private JButton butArriba;
	private JButton butAbajo;
	private JButton butDerecha;
	private JButton butIzquierda;

	public PanelMovimientos(Interfaz pPrincipal) {
		principal = pPrincipal;
		setLayout(new GridLayout(3, 3));
		setPreferredSize(new Dimension(100, 145));
		TitledBorder border = BorderFactory.createTitledBorder("Movements");
		border.setTitleColor(Color.BLACK);
		setBorder(border);

		butArriba = new JButton();
		butArriba.setActionCommand(ARRIBA);
		butArriba.addActionListener(this);
		butArriba.setIcon(new ImageIcon("./utilidades/imagenes/arriba.png"));
		butAbajo = new JButton();
		butAbajo.setActionCommand(ABAJO);
		butAbajo.addActionListener(this);
		butAbajo.setIcon(new ImageIcon("./utilidades/imagenes/abajo.png"));
		butDerecha = new JButton();
		butDerecha.setActionCommand(DERECHA);
		butDerecha.addActionListener(this);
		butDerecha.setIcon(new ImageIcon("./utilidades/imagenes/derecha.png"));
		butIzquierda = new JButton();
		butIzquierda.setActionCommand(IZQUIERDA);
		butIzquierda.addActionListener(this);
		butIzquierda.setIcon(new ImageIcon("./utilidades/imagenes/izquierda.png"));

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

	public void actionPerformed(ActionEvent e) {
		if (ARRIBA.equals(e.getActionCommand())) {
			if (principal.setEstadoJuego() == Calabozo.continua_Juego) {
				principal.moverHeroe(ARRIBA);
			} else if (principal.setEstadoJuego() == Calabozo.juego_Ganado
					|| principal.setEstadoJuego() == Calabozo.juego_Perdido) {
				principal.cambiarCasilla();
			}
		} else if (DERECHA.equals(e.getActionCommand())) {
			if (principal.setEstadoJuego() == Calabozo.continua_Juego) {
				principal.moverHeroe(DERECHA);
			} else if (principal.setEstadoJuego() == Calabozo.juego_Ganado
					|| principal.setEstadoJuego() == Calabozo.juego_Perdido) {
				principal.cambiarCasilla();
			}
		} else if (IZQUIERDA.equals(e.getActionCommand())) {
			if (principal.setEstadoJuego() == Calabozo.continua_Juego) {
				principal.moverHeroe(IZQUIERDA);
			} else if (principal.setEstadoJuego() == Calabozo.juego_Ganado
					|| principal.setEstadoJuego() == Calabozo.juego_Perdido) {
				principal.cambiarCasilla();
			}
		} else if (ABAJO.equals(e.getActionCommand())) {
			if (principal.setEstadoJuego() == Calabozo.continua_Juego) {
				principal.moverHeroe(ABAJO);
			} else if (principal.setEstadoJuego() == Calabozo.juego_Ganado
					|| principal.setEstadoJuego() == Calabozo.juego_Perdido) {
				principal.cambiarCasilla();
			}
		}
	}
}
