package cliente.interfaz;

import javax.swing.JFrame;

import cliente.controlador.Controlador;


public class InterfazApp extends JFrame{
	
	private Controlador ctrl;
	private PanelConversacion pnlConversacion;
	private PanelEnviar pnlEnviar;
	
	
	public InterfazApp(Controlador ctrl){
		setTitle("Cliente");
		getContentPane().setLayout(null);

		// enlazar controlador
		this.ctrl = ctrl;

		// instanciar los paneles
		pnlConversacion = new PanelConversacion();
		pnlEnviar = new PanelEnviar(this.ctrl);
		
		
		pnlConversacion.setBounds(20, 20, 250, 350);
		pnlEnviar.setBounds(20, 370, 250, 120);
		
		//agregar los paneles
		getContentPane().add(pnlConversacion);
		getContentPane().add(pnlEnviar);
		
		//conectar los paneles con el controlador
		ctrl.conectarPaneles(pnlEnviar, pnlConversacion);
		
		setSize(310, 550);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		InterfazApp iApp = new InterfazApp(new Controlador());
		iApp.setVisible(true);
		//a penas se abre el cliente envia el mensaje de que esta activo
		iApp.ctrl.enviardato("ACTIVO "+ iApp.ctrl.getDir().getCliente());

	}
}
