package vista;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Panel_Apuntamiento_Antenas extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblElevacion;
	private JLabel lblVlrElevacion;
	private JLabel lblAzimud;
	private JLabel lblVlrAzimud;
	private JLabel lblLatitudET;
	private JTextField txtLatitudET;
	private JLabel lblLongitudET;
	private JTextField txtLongitudET;
	private JLabel lblLatitudSat;
	private JTextField txtLatitudSat;
	private JLabel lblRangoS;
	private JLabel lblVlrRangoS;
	
	private JRadioButton rbtn1, rbtn2, rbtn3, rbtn4;
	private ButtonGroup bg;
	
	private JButton btnCalcular;
	private JButton btnEnlaceSub;
	private JButton btnEnlaceBaj;
	
	public Panel_Apuntamiento_Antenas() {
		setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "Apuntamiento de Antena" ) ) );
		 GridLayout gl = new GridLayout(10,2);
	        gl.setVgap(3);
	        gl.setHgap(3);
	        setLayout(gl);
	        
		lblElevacion = new JLabel("θ (°)");
		lblVlrElevacion = new JLabel("valor");
		lblAzimud = new JLabel("Φ (°)");
		lblVlrAzimud = new JLabel("valor");
		lblLatitudET = new JLabel("Latitud ET");
		txtLatitudET = new JTextField(10);
		lblLongitudET = new JLabel("Longitud ET");
		txtLongitudET = new JTextField(10);
		lblLatitudSat = new JLabel("Latitud Satelite");
		txtLatitudSat = new JTextField(10);
		lblRangoS = new JLabel("Rango S (Km)");
		lblVlrRangoS = new JLabel("valor");
		
		btnCalcular = new JButton("Calcular");
		btnEnlaceSub = new JButton("Enviar a enlace subida");
		btnEnlaceBaj = new JButton("Enviar a enlace bajada");
		
		bg = new ButtonGroup();
		rbtn1 = new JRadioButton("ET esta en N y al O del SAT");
		rbtn2 = new JRadioButton("ET esta en N y al E del SAT");
		rbtn3 = new JRadioButton("ET esta en S y al E del SAT");
		rbtn4 = new JRadioButton("ET esta en S y al O del SAT");
		//agregar los radioButton al grupo
		bg.add(rbtn1);
		bg.add(rbtn2);
		bg.add(rbtn3);
		bg.add(rbtn4);
				
		add(lblLatitudET);
		add(txtLatitudET);
		add(lblLongitudET);
		add(txtLongitudET);
		add(lblLatitudSat);
		add(txtLatitudSat);
		
		add(rbtn1);
		add(rbtn2);
		add(rbtn3);
		add(rbtn4);
		
		add(lblRangoS);
		add(lblVlrRangoS);
		add(lblElevacion);
		add(lblVlrElevacion);
		add(lblAzimud);
		add(lblVlrAzimud);
		
		add(btnCalcular);
		add(btnEnlaceSub);
		add(btnEnlaceBaj);
	}

	public JLabel getLblElevacion() {
		return lblElevacion;
	}

	public void setLblElevacion(JLabel lblElevacion) {
		this.lblElevacion = lblElevacion;
	}

	public JLabel getLblVlrElevacion() {
		return lblVlrElevacion;
	}

	public void setLblVlrElevacion(JLabel lblVlrElevacion) {
		this.lblVlrElevacion = lblVlrElevacion;
	}

	public JLabel getLblAzimud() {
		return lblAzimud;
	}

	public void setLblAzimud(JLabel lblAzimud) {
		this.lblAzimud = lblAzimud;
	}

	public JLabel getLblVlrAzimud() {
		return lblVlrAzimud;
	}

	public void setLblVlrAzimud(JLabel lblVlrAzimud) {
		this.lblVlrAzimud = lblVlrAzimud;
	}

	public JLabel getLblLatitudET() {
		return lblLatitudET;
	}

	public void setLblLatitudET(JLabel lblLatitudET) {
		this.lblLatitudET = lblLatitudET;
	}

	public JTextField getTxtLatitudET() {
		return txtLatitudET;
	}

	public void setTxtLatitudET(JTextField txtLatitudET) {
		this.txtLatitudET = txtLatitudET;
	}

	public JLabel getLblLongitudET() {
		return lblLongitudET;
	}

	public void setLblLongitudET(JLabel lblLongitudET) {
		this.lblLongitudET = lblLongitudET;
	}

	public JTextField getTxtLongitudET() {
		return txtLongitudET;
	}

	public void setTxtLongitudET(JTextField txtLongitudET) {
		this.txtLongitudET = txtLongitudET;
	}

	public JLabel getLblLatitudSat() {
		return lblLatitudSat;
	}

	public void setLblLatitudSat(JLabel lblLatitudSat) {
		this.lblLatitudSat = lblLatitudSat;
	}

	public JTextField getTxtLatitudSat() {
		return txtLatitudSat;
	}

	public void setTxtLatitudSat(JTextField txtLatitudSat) {
		this.txtLatitudSat = txtLatitudSat;
	}

	public JLabel getLblRangoS() {
		return lblRangoS;
	}

	public void setLblRangoS(JLabel lblRangoS) {
		this.lblRangoS = lblRangoS;
	}

	public JLabel getLblVlrRangoS() {
		return lblVlrRangoS;
	}

	public void setLblVlrRangoS(JLabel lblVlrRangoS) {
		this.lblVlrRangoS = lblVlrRangoS;
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

	public ButtonGroup getBg() {
		return bg;
	}

	public void setBg(ButtonGroup bg) {
		this.bg = bg;
	}

	public JButton getBtnCalcular() {
		return btnCalcular;
	}

	public void setBtnCalcular(JButton btnCalcular) {
		this.btnCalcular = btnCalcular;
	}

	public JButton getBtnEnlaceSub() {
		return btnEnlaceSub;
	}

	public void setBtnEnlaceSub(JButton btnEnlaceSub) {
		this.btnEnlaceSub = btnEnlaceSub;
	}

	public JButton getBtnEnlaceBaj() {
		return btnEnlaceBaj;
	}

	public void setBtnEnlaceBaj(JButton btnEnlaceBaj) {
		this.btnEnlaceBaj = btnEnlaceBaj;
	}

	
	
}
