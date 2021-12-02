package client.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import client.controlador.Controlador;

public class PanelPay extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//atributos
	private JButton btnPay;
	private JRadioButton rbtn1, rbtn2;
	private ButtonGroup bg;
	//relaciones
	private Controlador ctrl;
	
	public PanelPay(Controlador ctrl) {
		
		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Pay")));//borde y titulo del panel
        //setLayout(null);
		//instanciar los componentes
		btnPay = new JButton("Pay");
		bg = new ButtonGroup();
		rbtn1 = new JRadioButton("Zonal");
		rbtn2 = new JRadioButton("Complementary/SITP");
		
		btnPay.addActionListener(this);
		btnPay.setEnabled(true);
		
		//agregar el controlador
		this.ctrl = ctrl;
		//agregar los radioButton al grupo
		bg.add(rbtn1);
		bg.add(rbtn2);
		//agregar los componentes al panel 
		add(rbtn1);
		add(rbtn2);
		add(btnPay);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnPay) {
			ctrl.pagar(rbtn1.isSelected()?0:(rbtn2.isSelected()?1:2));
		}
		
	}

}
