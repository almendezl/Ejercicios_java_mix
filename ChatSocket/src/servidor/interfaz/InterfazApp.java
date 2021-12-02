package servidor.interfaz;


import javax.swing.JFrame;

import servidor.interfaz.InterfazApp;
import servidor.controlador.Controlador;



public class InterfazApp extends JFrame{
	
	private Controlador ctrl;
	private PanelConversacion pnlConversacion;
	private PanelErrores pnlErrores;
	
	
	public InterfazApp(Controlador ctrl){
		setTitle("Servidor");
		getContentPane().setLayout(null);

		// enlazar controlador
		this.ctrl = ctrl;

		// instanciar los paneles
		pnlConversacion = new PanelConversacion();
		pnlErrores = new PanelErrores();
		
		
		pnlConversacion.setBounds(20, 20, 300, 250);
		pnlErrores.setBounds(20, 270, 300, 250);
		
		
		//agregar los paneles
		getContentPane().add(pnlConversacion);
		getContentPane().add(pnlErrores);
		
		//conectar los paneles con el ctrl
		ctrl.conectarPaneles(pnlErrores, pnlConversacion);
		setSize(360, 590);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		InterfazApp iApp = new InterfazApp(new Controlador());
		iApp.setVisible(true);
	}
}
