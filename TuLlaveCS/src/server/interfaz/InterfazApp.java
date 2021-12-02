package server.interfaz;

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
		
		setTitle("Servidor");
		getContentPane( ).setLayout( null );

		// crear el panel transactions
		pnlTrans = new PanelTransactions();
		
		this.ctrl = ctrl;

		// conectar con el controlador
		ctrl.conectarPanel(pnlTrans);

		// definir tamanio del panel y agregarlo
		pnlTrans.setBounds(15, 15, 660, 365);
		getContentPane().add(pnlTrans);

		setSize(690, 430);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Util.centrarVentana(this);

	}

	public static void main(String[] args) throws IOException {
		InterfazApp frmMain = new InterfazApp(new Controlador());
		frmMain.setVisible(true);
	}
}
