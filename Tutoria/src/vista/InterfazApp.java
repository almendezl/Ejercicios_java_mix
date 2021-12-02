package vista;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controlador.Controlador;

public class InterfazApp extends JFrame implements ActionListener{
	
	private Controlador ctrl;
	private InterfazSuma pnlSuma;
	
	public InterfazApp(Controlador ctrl) {
		setTitle("Suma");
        getContentPane().setLayout(null);
        setBounds(350, 180, 550, 600);

        // Enlaza el controlador	  
        this.ctrl = ctrl;
		pnlSuma = new InterfazSuma(this.ctrl);
		pnlSuma.setBounds(10,10,200,400);
		
		getContentPane().add(pnlSuma);
		
		setSize(550, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String args[]) {
        InterfazApp iApp = new InterfazApp(new Controlador());
        iApp.setVisible(true);

    }

}
