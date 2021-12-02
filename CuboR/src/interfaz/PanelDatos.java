package interfaz;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import util.Util;

public class PanelDatos extends JFrame implements ActionListener {
	private JTextField txtIpServer;
	private JTextField txtIpCliente;
	private JLabel lblmensajes;
	private Controlador ctrl;
	private JButton btnIniciar;
	private JLabel lblIpServer;
	private JLabel lblIpCliente;

	public PanelDatos(Controlador ctrl) {
		setTitle("Cubo Rubick 2x2x2 - Cliente");
		
		JPanel pnl= new JPanel();
		pnl.setBorder((Border) new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new TitledBorder("Entrada de datos")));
		pnl.setLayout(null);
		pnl.setSize(250,250);

		// Enlaza el controlador
		this.ctrl = ctrl;
		this.ctrl.conectar(this);

		lblIpServer = new JLabel("Ip Server");
		lblIpServer.setBounds(30,70,150,30);
		lblIpServer.setFont(new Font("Dialog", 5, 16));
		
		lblIpCliente = new JLabel("Ip Client");
		lblIpCliente.setBounds(30,30,150,30);
		lblIpCliente.setFont(new Font("Dialog", 5, 16));
		
		txtIpCliente = new JTextField(15);
		txtIpCliente.setBounds(100,30,130,30);
		txtIpCliente.setFont(new Font("Dialog", 8, 16));
		
		txtIpServer = new JTextField(15);
		txtIpServer.setBounds(100,70,130,30);
		txtIpServer.setFont(new Font("Dialog", 8, 16));
		
		lblmensajes = new JLabel("");
		lblmensajes.setBounds(40,120, 300,30);
		lblmensajes.setFont(new Font("Dialog", 8, 16));
		
		btnIniciar = new JButton("Run");
		btnIniciar.setBounds(260, 40,100,50);
		btnIniciar.addActionListener(this);

		getContentPane().add(pnl);
		pnl.add(lblIpCliente);
		pnl.add(lblIpServer);
		pnl.add(txtIpCliente);
		pnl.add(txtIpServer);
		pnl.add(lblmensajes);
		pnl.add(btnIniciar);

		setSize(400, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Util.centrarVentana(this);
	}
//-------------------INICIO DEL PROGRAMA--------------------
		
	public static void main(String args[]) {
		PanelDatos frmMain = new PanelDatos(new Controlador());
		frmMain.setVisible(true);
	}

	public String getTxtIpServer() {
		return txtIpServer.getText();
	}

	public void setTxtIpServer(String txtIpServer) {
		this.txtIpServer.setText(txtIpServer);
	}

	public String getTxtIpCliente() {
		return txtIpCliente.getText();
	}

	public void setTxtIpCliente(String txtIpCliente) {
		this.txtIpCliente.setText(txtIpCliente);
	}

	public String getLblmensajes() {
		return lblmensajes.getText();
	}

	public void setLblmensajes(String lblmensajes) {
		this.lblmensajes.setText(lblmensajes);
	}

	public Controlador getCtrl() {
		return ctrl;
	}

	public void setCtrl(Controlador ctrl) {
		this.ctrl = ctrl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== btnIniciar) {
			ctrl.enviarIp(txtIpCliente.getText(), txtIpServer.getText());
			setLblmensajes("Se envio la ip al server");
		}
		
	}
	
	
}
