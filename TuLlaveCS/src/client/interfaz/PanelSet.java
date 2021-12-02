package client.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import client.controlador.Controlador;

public class PanelSet extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// atributos
	private JLabel lblRecharge;
	private JTextField txtCantidad;
	private JButton btnRecargar;

	// relaciones
	private Controlador ctrl;

	public PanelSet(Controlador ctrl) {

		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Recargas")));// borde y titulo del
																									// panel

		// instanciar los componentes
		lblRecharge = new JLabel("Recargar: ");
		txtCantidad = new JTextField(6); // nro de digitos
		btnRecargar = new JButton("R");

		btnRecargar.addActionListener(this);
		btnRecargar.setEnabled(true);

		this.ctrl = ctrl;
		// ubicar los compontes en el panel

		lblRecharge.setBounds(10, 300, 100, 100);

		// agregal los componentes al panel
		add(lblRecharge);
		add(txtCantidad);
		add(btnRecargar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRecargar) {
			try {
				String cant = txtCantidad.getText();
				if (ctrl.obTuLlave().getUser().getSaldo() < 0) {
					if (Integer.parseInt(cant) >= ctrl.obTuLlave().getUser().getSaldo() + 2400 && cant.length() <= 10) {
					}
				}else if (Integer.parseInt(cant) >= 2400 && cant.length() <= 10) {
						ctrl.recargar(txtCantidad.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Verifique el saldo ingresado");
					}
				
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Verifique el valor a recargar");
			}
		}
	}
}
