package cliente.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import cliente.controlador.Controlador;

public class PanelEnviar extends JPanel implements ActionListener{

	private JTextArea txtMensaje;
	private JButton btnEnviar;
	private Controlador ctrl;
	private JScrollPane scrollPane;

	public PanelEnviar(Controlador ctrl) {
		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Enviar mensaje")));// borde y titulo
																										// del panel
		// setLayout(new FlowLayout());//forma de organizar el panel
		setLayout(new GridLayout(2,1));
		// instanciar
		txtMensaje = new JTextArea(20,8);
		scrollPane = new JScrollPane(txtMensaje);
		
		btnEnviar = new JButton("Enviar");
		
		btnEnviar.addActionListener(this);
		btnEnviar.setEnabled(true);
		// agregar el controlador
		this.ctrl = ctrl;

		// agregar el label

		add(scrollPane);
		add(btnEnviar);

	}

	
	public JTextArea getTxtMensaje() {
		return txtMensaje;
	}


	public void setTxtMensaje(JTextArea txtMensaje) {
		this.txtMensaje = txtMensaje;
	}


	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public void setBtnEnviar(JButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnEnviar) {
			ctrl.enviardato(txtMensaje.getText());
		}
	}

}
