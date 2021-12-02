package client.interfaz;

import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelBalance extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblSaldo;
	
	public PanelBalance() {
		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Balance")));//borde y titulo del panel
        setLayout(new FlowLayout());//forma de organizar el panel
        
        //instanciar los labels
		lblSaldo = new JLabel("");
		
		//agregar el label
		lblSaldo.setFont(new Font("Dialog", 1, 36));
		add(lblSaldo);
	}

	public JLabel getLblSaldo() {
		return lblSaldo;
	}

	public void setLblSaldo(String saldo) {
		lblSaldo.setText(integerFormat(Integer.parseInt(saldo)));
	}
	public void setLblSaldo(int saldo) {
		lblSaldo.setText(integerFormat(saldo));
	}
	
	public String integerFormat(int i) { 
		DecimalFormat df = new DecimalFormat("$#,###.##"); 
		String s = df.format(i);
	return s;
	}

}
