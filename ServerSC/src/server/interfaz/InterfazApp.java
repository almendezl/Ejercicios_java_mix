package server.interfaz;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;

import server.controlador.Controlador;
import server.interfaz.InterfazApp;
import util.Util;

public class InterfazApp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// relaciones
	private Controlador ctrl;
	private PanelTransactions pnlTrans;
        

	public InterfazApp(Controlador ctrl) {
		
		setTitle("Server");
		getContentPane( ).setLayout( null );

		// crear el panel transactions
		pnlTrans = new PanelTransactions();
		
		this.ctrl = ctrl;

		// conectar con el controlador
		ctrl.conectarPanel(pnlTrans);

		// definir tamanio del panel y agregarlo
		pnlTrans.setBounds(10, 10, 645, 450);
		pnlTrans.setBackground(Color.WHITE);
		getContentPane().add(pnlTrans);

		setSize(675, 510);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Util.centrarVentana(this);

	}

	public static void main(String[] args) throws IOException {
		InterfazApp frmMain = new InterfazApp(new Controlador());
		frmMain.setVisible(true);
	}
}
