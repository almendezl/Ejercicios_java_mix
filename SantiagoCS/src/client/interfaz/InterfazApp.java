package client.interfaz;

import util.Util;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import client.controlador.Controlador;

public class InterfazApp extends JFrame {

	private static final long serialVersionUID = 1L;
	// relaciones
	private PanelPay pnlPay;
	private PanelSet pnlSet;
	private PanelBalance pnlBalance;
	private PanelUser pnlUser;
	private Controlador ctrl;

	// atributos
	private JLabel logo;

	public InterfazApp(Controlador ctrl){
		setTitle("Tu Llave");
		getContentPane().setLayout(null);

		// enlazar controlador
		this.ctrl = ctrl;

		// instanciar los paneles
		pnlPay = new PanelPay(ctrl);
		pnlSet = new PanelSet(ctrl);
		pnlBalance = new PanelBalance();
		pnlUser = new PanelUser();
		ImageIcon img = new ImageIcon("data/tullave.png");
		logo = new JLabel();
		logo.setIcon(img);

		// conectar el controlador con los paneles
		ctrl.conectarPaneles(pnlBalance, pnlUser);

		// actualizar el panel user y balance
		ctrl.actPaneles();

		logo.setBounds(130, 10, 400, 120);
		pnlBalance.setBounds(20, 140, 300, 80);
		pnlSet.setBounds(350, 140, 300, 80);
		pnlPay.setBounds (20, 220, 630, 80);
		pnlUser.setBounds(20, 300, 630, 60);
		

		getContentPane().add(logo);
		getContentPane().add(pnlBalance);
		getContentPane().add(pnlSet);
		getContentPane().add(pnlPay);
		getContentPane().add(pnlUser);

		setSize(675, 410);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Util.centrarVentana(this);

	}

	public static void main(String args[]) {
		InterfazApp frmMain = new InterfazApp(new Controlador());
		frmMain.setVisible(true);
	}

}
