package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


public class Panel_Bandas_frecuencia extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JRadioButton rbtn1, rbtn2, rbtn3, rbtn4, rbtn5, rbtn6;
	private ButtonGroup bg;
	private JTextField txtvlrFrec;
	
	public Panel_Bandas_frecuencia() {
		setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "Bandas de Frecuencia" ) ) );
		
        
		bg = new ButtonGroup();
		rbtn1 = new JRadioButton("Banda C: 6 - 4 GHz");
		rbtn2 = new JRadioButton("Banda X : 8 - 7 GHz");
		rbtn3 = new JRadioButton("Banda Ku: 14 - 12 GHz");
		rbtn4 = new JRadioButton("Banda Ka: 30 - 20 GHz");
		rbtn5 = new JRadioButton("Banda Q/V: 50 - 40 GHz");
		rbtn6 = new JRadioButton("Otro");
		txtvlrFrec = new JTextField(6);
		txtvlrFrec.setVisible(false);
		
		
		//agregar los radioButton al grupo
		bg.add(rbtn1);
		bg.add(rbtn2);
		bg.add(rbtn3);
		bg.add(rbtn4);
		bg.add(rbtn5);
		bg.add(rbtn6);
				
		//agregar los componentes al panel 
		add(rbtn1);
		add(rbtn2);
		add(rbtn3);
		add(rbtn4);
		add(rbtn5);
		add(rbtn6);
		add(txtvlrFrec);
	 
	}

	public JRadioButton getRbtn1() {
		return rbtn1;
	}

	public void setRbtn1(JRadioButton rbtn1) {
		this.rbtn1 = rbtn1;
	}

	public JRadioButton getRbtn2() {
		return rbtn2;
	}

	public void setRbtn2(JRadioButton rbtn2) {
		this.rbtn2 = rbtn2;
	}

	public JRadioButton getRbtn3() {
		return rbtn3;
	}

	public void setRbtn3(JRadioButton rbtn3) {
		this.rbtn3 = rbtn3;
	}

	public JRadioButton getRbtn4() {
		return rbtn4;
	}

	public void setRbtn4(JRadioButton rbtn4) {
		this.rbtn4 = rbtn4;
	}

	public JRadioButton getRbtn5() {
		return rbtn5;
	}

	public void setRbtn5(JRadioButton rbtn5) {
		this.rbtn5 = rbtn5;
	}

	public JRadioButton getRbtn6() {
		return rbtn6;
	}

	public void setRbtn6(JRadioButton rbtn6) {
		this.rbtn6 = rbtn6;
	}

	public ButtonGroup getBg() {
		return bg;
	}

	public void setBg(ButtonGroup bg) {
		this.bg = bg;
	}

	public JTextField getTxtvlrFrec() {
		return txtvlrFrec;
	}

	public void setTxtvlrFrec(JTextField txtvlrFrec) {
		this.txtvlrFrec = txtvlrFrec;
	}


}
