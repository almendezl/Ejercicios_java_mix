package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;




public class Panel_Subsist_Antenas extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//atributos
	private JLabel lblFrecuencia;
	private JTextField txtFrecuencia;
	
	private JLabel lblDiametro;
	private JTextField txtDiametro;
	
	private JLabel lblGanancia;
	private JLabel lblvlrGanancia;
	
	private JLabel lblEficiencia;
	private JTextField txtEficiencia;
	
	private JLabel lblAlfa;
	private JTextField txtAlfa;
	
	private JLabel lblArea;
	private JTextField txtArea;
	
	private JLabel lblPotencia;
	private JTextField txtPotencia;
	
	private JLabel lbltetha3db;
	private JLabel lblvlrtetha3db;
	
	private JLabel lblPire;
	private JLabel lblvlrPire;
	
	//botones
	private JButton btncalcular;
	private JButton btn_utilizarEnEnlace;
	
	public Panel_Subsist_Antenas() {
		
		//setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Antenas")));//borde y titulo del panel
		//setLayout(new BoxLayout());
		setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "Subsistema de antenas" ) ) );
        GridLayout gl = new GridLayout(10,2);
        gl.setVgap(20);
        gl.setHgap(5);
        setLayout(gl);
		
		//instanciar los componentes
		lblFrecuencia = new JLabel("Frecuencia (GHz)");
		txtFrecuencia = new JTextField(6); // nro de digitos
		
		lblDiametro = new JLabel("Diametro (m)");
		txtDiametro = new JTextField(6); // nro de digitos

		lblGanancia = new JLabel("Ganancia (dBi)");
		lblvlrGanancia = new JLabel("valor"); 
		
		lblEficiencia = new JLabel("Eficiencia (%)");
		txtEficiencia = new JTextField(6); // 
		
		lblAlfa = new JLabel("α (°)");
		txtAlfa = new JTextField(6); // nro de digitos
		
		lblArea = new JLabel("Area (m^2)");
		txtArea = new JTextField(6); // nro de digitos
		
		lbltetha3db = new JLabel("θ -3dB (dBi)");
		lblvlrtetha3db = new JLabel("valor");
		
		lblPotencia = new JLabel("Potencia (W)");
		txtPotencia = new JTextField(6); // nro de digitos
		
		lblPire = new JLabel("PIRE (dBi)");
		lblvlrPire = new JLabel("valor");
		
		
		btncalcular = new JButton("Calcular");
		btn_utilizarEnEnlace = new JButton("Reutilizar Valor");
		
		
		btn_utilizarEnEnlace.addActionListener(this);
		btn_utilizarEnEnlace.setEnabled(true);
		
		btncalcular.addActionListener(this);
		btncalcular.setEnabled(true);
		
		//agregar el controlador
		
		
		
		//agregar los componentes al panel 
		add(lblFrecuencia);
		add(txtFrecuencia);
		
		add(lblDiametro);
		add(txtDiametro);
		
		
		add(lblEficiencia);
		add(txtEficiencia);
		
		add(lblAlfa);
		add(txtAlfa);
		
		add(lblArea);
		add(txtArea);
		
		add(lblPotencia);
		add(txtPotencia);
		
		add(lbltetha3db);
		add(lblvlrtetha3db);

		add(lblGanancia);
		add(lblvlrGanancia);
		
		add(lblPire);
		add(lblvlrPire);
		
		add(btncalcular);
		add(btn_utilizarEnEnlace);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * -----------GET Y SET--------------------
	 */

	public JLabel getLblFrecuencia() {
		return lblFrecuencia;
	}
	public void setLblFrecuencia(JLabel lblFrecuencia) {
		this.lblFrecuencia = lblFrecuencia;
	}
	public JTextField getTxtFrecuencia() {
		return txtFrecuencia;
	}
	public void setTxtFrecuencia(JTextField txtFrecuencia) {
		this.txtFrecuencia = txtFrecuencia;
	}
	public JLabel getLblDiametro() {
		return lblDiametro;
	}
	public void setLblDiametro(JLabel lblDiametro) {
		this.lblDiametro = lblDiametro;
	}
	public JTextField getTxtDiametro() {
		return txtDiametro;
	}
	public void setTxtDiametro(JTextField txtDiametro) {
		this.txtDiametro = txtDiametro;
	}
	public JLabel getLblGanancia() {
		return lblGanancia;
	}
	public void setLblGanancia(JLabel lblGanancia) {
		this.lblGanancia = lblGanancia;
	}
	public JLabel getLblEficiencia() {
		return lblEficiencia;
	}
	public void setLblEficiencia(JLabel lblEficiencia) {
		this.lblEficiencia = lblEficiencia;
	}
	public JTextField getTxtEficiencia() {
		return txtEficiencia;
	}
	public void setTxtEficiencia(JTextField txtEficiencia) {
		this.txtEficiencia = txtEficiencia;
	}
	public JLabel getLblAlfa() {
		return lblAlfa;
	}
	public void setLblAlfa(JLabel lblAlfa) {
		this.lblAlfa = lblAlfa;
	}
	public JTextField getTxtAlfa() {
		return txtAlfa;
	}
	public void setTxtAlfa(JTextField txtAlfa) {
		this.txtAlfa = txtAlfa;
	}
	public JLabel getLblArea() {
		return lblArea;
	}
	public void setLblArea(JLabel lblArea) {
		this.lblArea = lblArea;
	}
	public JTextField getTxtArea() {
		return txtArea;
	}
	public void setTxtArea(JTextField txtArea) {
		this.txtArea = txtArea;
	}
	public JLabel getLbltetha3db() {
		return lbltetha3db;
	}
	public void setLbltetha3db(JLabel lbltetha3db) {
		this.lbltetha3db = lbltetha3db;
	}
	public JButton getBtncalcular() {
		return btncalcular;
	}
	public void setBtncalcular(JButton btncalcular) {
		this.btncalcular = btncalcular;
	}
	public JButton getBtn_utilizarEnEnlace() {
		return btn_utilizarEnEnlace;
	}
	public void setBtn_utilizarEnEnlace(JButton btn_utilizarEnEnlace) {
		this.btn_utilizarEnEnlace = btn_utilizarEnEnlace;
	}

	
}
