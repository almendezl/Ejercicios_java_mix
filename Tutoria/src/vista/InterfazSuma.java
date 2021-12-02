package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Controlador;

public class InterfazSuma extends JPanel{
	
	private JTextField txtNumero1;
	private JTextField txtNumero2;
	private JButton btnSumar;
	private JLabel lblResultado;
	
	private Controlador ctrl;
	
	public InterfazSuma(Controlador ctrl) {
		setLayout(new GridLayout(2,2));
		
		txtNumero1 = new JTextField();
		txtNumero2 = new JTextField();
		btnSumar = new JButton("Sumar");
		lblResultado = new JLabel("El resultado es: ");
		
		// conectamos el controlador
		
		this.ctrl = ctrl;
		
		add(txtNumero1);
		add(txtNumero2);
		add(btnSumar);
		add(lblResultado);
		
		
	}

	public JTextField getTxtNumero1() {
		return txtNumero1;
	}

	public void setTxtNumero1(JTextField txtNumero1) {
		this.txtNumero1 = txtNumero1;
	}

	public JTextField getTxtNumero2() {
		return txtNumero2;
	}

	public void setTxtNumero2(JTextField txtNumero2) {
		this.txtNumero2 = txtNumero2;
	}

	public JButton getBtnSumar() {
		return btnSumar;
	}

	public void setBtnSumar(JButton btnSumar) {
		this.btnSumar = btnSumar;
	}

	public JLabel getLblResultado() {
		return lblResultado;
	}

	public void setLblResultado(JLabel lblResultado) {
		this.lblResultado = lblResultado;
	}

	public Controlador getCtrl() {
		return ctrl;
	}

	public void setCtrl(Controlador ctrl) {
		this.ctrl = ctrl;
	}
	
	
	

}
