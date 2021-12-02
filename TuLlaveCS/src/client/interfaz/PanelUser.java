package client.interfaz;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelUser extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//atributos
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblCedula;
	private JLabel lblNroTarjeta;
	
	//relaciones
	
	public PanelUser() {
		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Usuario")));//borde y titulo del panel
        setLayout(null);//forma de organizar el panel
        
        //instanciar los labels
		lblNombre = new JLabel("");
		lblNombre.setBounds(120, 15, 150, 30);
		lblApellido = new JLabel("");
		lblApellido.setBounds(250, 15, 150, 30);
		lblCedula = new JLabel("");
		lblCedula.setBounds(390, 15, 100, 30);
		lblNroTarjeta = new JLabel("");
		lblNroTarjeta.setBounds(490, 15, 150, 30);
		
		//agregar los componentes al panel
		add(lblNombre);
		add(lblApellido);
		add(lblCedula);
		add(lblNroTarjeta);
	}
        public void actualizarPanel(String nombre, String apellido, String cedula, String nroT){
            lblNombre.setText(nombre);
            lblApellido.setText(apellido);
            lblCedula.setText(cedula);
            lblNroTarjeta.setText(nroT);
        }

}
