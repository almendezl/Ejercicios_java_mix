package vista;

import java.awt.Container;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class InterfazApp extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel_Apuntamiento_Antenas pnl_Apuntamiento_Antenas;
	private Panel_Bandas_frecuencia pnl_Bandas_frecuencia;
	private Panel_Subsist_Antenas pnl_subsistema_Antenas;
	private Panel_Enlace_Completo pnl_Enlace_Completo;
	

	public InterfazApp(){
		
		Container c = getContentPane();
        c.setLayout(null);
        setBounds(350, 180, 1300, 910);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	
        //instanciar los paneles
        pnl_Apuntamiento_Antenas = new Panel_Apuntamiento_Antenas();
        pnl_Bandas_frecuencia = new Panel_Bandas_frecuencia();
        pnl_Enlace_Completo = new Panel_Enlace_Completo();
        pnl_subsistema_Antenas = new Panel_Subsist_Antenas();
        
		
		
		
		pnl_subsistema_Antenas.setBounds (20, 10, 370, 400);
		pnl_Bandas_frecuencia.setBounds(20, 420, 370, 120);
		pnl_Apuntamiento_Antenas.setBounds(20, 550, 370, 300);
		pnl_Enlace_Completo.setBounds(400, 10, 860, 840);

		
		c.add(pnl_Bandas_frecuencia);
		c.add(pnl_subsistema_Antenas);
		c.add(pnl_Apuntamiento_Antenas);
		c.add(pnl_Enlace_Completo);
		
		

	}


	public Panel_Apuntamiento_Antenas getPnl_Apuntamiento_Antenas() {
		return pnl_Apuntamiento_Antenas;
	}


	public void setPnl_Apuntamiento_Antenas(Panel_Apuntamiento_Antenas pnl_Apuntamiento_Antenas) {
		this.pnl_Apuntamiento_Antenas = pnl_Apuntamiento_Antenas;
	}


	public Panel_Bandas_frecuencia getPnl_Bandas_frecuencia() {
		return pnl_Bandas_frecuencia;
	}


	public void setPnl_Bandas_frecuencia(Panel_Bandas_frecuencia pnl_Bandas_frecuencia) {
		this.pnl_Bandas_frecuencia = pnl_Bandas_frecuencia;
	}


	public Panel_Subsist_Antenas getPnl_subsistema_Antenas() {
		return pnl_subsistema_Antenas;
	}


	public void setPnl_subsistema_Antenas(Panel_Subsist_Antenas pnl_subsistema_Antenas) {
		this.pnl_subsistema_Antenas = pnl_subsistema_Antenas;
	}


	public Panel_Enlace_Completo getPnl_Enlace_Completo() {
		return pnl_Enlace_Completo;
	}


	public void setPnl_Enlace_Completo(Panel_Enlace_Completo pnl_Enlace_Completo) {
		this.pnl_Enlace_Completo = pnl_Enlace_Completo;
	}
	
	
}
