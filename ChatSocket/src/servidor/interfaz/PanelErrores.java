package servidor.interfaz;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelErrores extends JPanel{
	
	private JTextArea lblErrores;
	private JScrollPane scrollPane;

	public PanelErrores() {
		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Excepciones")));//borde y titulo del panel
		setLayout(new GridLayout(1,1));//forma de organizar el panel
        
		 //instanciar los labels
		lblErrores = new JTextArea(10,12);
		scrollPane = new JScrollPane(lblErrores);
		
		
		//agregar el label
		lblErrores.setFont(new Font("Dialog", 1, 12));
		
		
		add(scrollPane);
		
	}

	public JTextArea getLblErrores() {
		return lblErrores;
	}

	public void setLblErrores(JTextArea lblErrores) {
		this.lblErrores = lblErrores;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}


	

}
