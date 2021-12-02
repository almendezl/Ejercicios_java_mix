package cliente.interfaz;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelConversacion extends JPanel {
	
	private JTextArea lblConversacion;
	private JScrollPane scrollPane;

	public PanelConversacion() {
		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Conversacion")));//borde y titulo del panel
        setLayout(new GridLayout(1,1));//forma de organizar el panel
        
        //instanciar los labels
		lblConversacion = new JTextArea(10,12);
		scrollPane = new JScrollPane(lblConversacion);
		
		//agregar el label
		lblConversacion.setFont(new Font("Dialog", 1, 12));
		
		add(scrollPane);
		
	}

	public JTextArea getLblConversacion() {
		return lblConversacion;
	}

	public void setLblConversacion(JTextArea lblConversacion) {
		this.lblConversacion = lblConversacion;
	}
}
