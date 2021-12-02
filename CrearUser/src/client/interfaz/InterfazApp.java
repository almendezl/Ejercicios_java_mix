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
	private JLabel logo2;

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
		ImageIcon img = new ImageIcon("data/Tullave.jpg");
		logo = new JLabel();
		logo.setIcon(img);
		
		ImageIcon img2 = new ImageIcon("data/bogota.jpg");
		logo2 = new JLabel();
		logo2.setIcon(img2);

		// conectar el controlador con los paneles
		ctrl.conectarPaneles(pnlBalance, pnlUser);

		// actualizar el panel user y balance
		ctrl.actPaneles();

		pnlBalance.setBounds(10, 160, 400, 105);
		pnlSet.setBounds(10, 270, 325, 70);
		pnlPay.setBounds(335, 270, 330, 70);
		pnlUser.setBounds(10, 340, 655, 70);
		logo.setBounds(430, 160, 280, 110);
		logo2.setBounds(10,10,650, 150);

		getContentPane().add(logo2);
		getContentPane().add(pnlBalance);
		getContentPane().add(logo);
		getContentPane().add(pnlSet);
		getContentPane().add(pnlPay);
		getContentPane().add(pnlUser);

		setSize(680, 455);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Util.centrarVentana(this);

	}

	public static void main(String args[]) {
		InterfazApp frmMain = new InterfazApp(new Controlador());
		frmMain.setVisible(true);
	}

}
