package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Mundo.Casilla;

public class PanelOpciones extends JPanel implements ActionListener {
	public final static String CARGAR = "Cargar";
	public final static String REINICIAR = "Reiniciar";

	private Interfaz principal;
	private JButton butCargar;
	private JButton butReiniciar;

	public PanelOpciones(Interfaz pPrincipal) {
		principal = pPrincipal;
		setLayout(new GridLayout(2, 2));
		setPreferredSize(new Dimension(0, 70));
		TitledBorder border = BorderFactory.createTitledBorder("Options");
		border.setTitleColor(Color.BLACK);
		setBorder(border);

		butCargar = new JButton("Load");
		butCargar.setActionCommand(CARGAR);
		butCargar.addActionListener(this);
		butReiniciar = new JButton("Restart");
		butReiniciar.setActionCommand(REINICIAR);
		butReiniciar.addActionListener(this);

		add(butCargar);
		add(butReiniciar);

	}

	public void actionPerformed(ActionEvent e) {
		if (CARGAR.equals(e.getActionCommand())) {
			try {
				principal.cargar();
				principal.actualizar();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else if (REINICIAR.equals(e.getActionCommand())) {
			try {
				principal.reiniciar();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

	}
}
