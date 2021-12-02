/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crearUser.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import client.mundo.SaveDat;
import client.mundo.User;
import complementos.Conexiondb;

public class PanelUser extends JPanel implements ActionListener {// Atributos
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblName, lblLastName, lblUsrId, lblIdCard;
	private JTextField txtName, txtLastName, txtUsrId, txtIdCard;
	private JButton btnSave;
	private JCheckBox chkDB;
	private JLabel logo;

	public PanelUser() {
		// ..............................................( T, L, B, R
		// ).............................................
		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
		setLayout(null);

		// Instancia controles
		lblName = new JLabel("Name: ");
		lblName.setBounds(10, 10, 70, 20);
		txtName = new JTextField("");
		txtName.setBounds(80, 10, 250, 20);

		lblLastName = new JLabel("Last name: ");
		lblLastName.setBounds(10, 35, 70, 20);
		txtLastName = new JTextField("");
		txtLastName.setBounds(80, 35, 250, 20);

		lblUsrId = new JLabel("User Id: ");
		lblUsrId.setBounds(10, 60, 70, 20);
		txtUsrId = new JTextField("");
		txtUsrId.setBounds(80, 60, 80, 20);

		lblIdCard = new JLabel("Id card: ");
		lblIdCard.setBounds(10, 85, 70, 20);
		txtIdCard = new JTextField("");
		txtIdCard.setBounds(80, 85, 80, 20);

		chkDB = new JCheckBox(" Agregar a la B.D? ");
		chkDB.setBounds(7, 110, 150, 20);

		btnSave = new JButton("Save");
		btnSave.setBounds(10, 140, 80, 20);
		btnSave.addActionListener(this);
		
		ImageIcon img = new ImageIcon("data/user.png");
		logo = new JLabel();
		logo.setIcon(img);
		logo.setBounds(170, 60, 280, 100);

		// Agrega controles al panel
		add(lblName);
		add(txtName);
		add(lblLastName);
		add(txtLastName);
		add(lblUsrId);
		add(txtUsrId);
		add(lblIdCard);
		add(txtIdCard);
		add(chkDB);
		add(logo);
		add(btnSave);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Save")) {
			User user = new User(txtName.getText(), txtLastName.getText(), txtUsrId.getText(), txtIdCard.getText(), 0);
			SaveDat.saveDat(user);

			// guardar los datos en la db
			if (chkDB.isSelected()) {
				Conexiondb ob = new Conexiondb();
				// Query para la tabla users
				String query = "INSERT INTO " + "users (id, idCard, name, lastName, contZ, contC, prestamo, trasbordo)" + " VALUES(" + "'"
						+ txtUsrId.getText() + "', " + "'" + txtIdCard.getText() + "', " + "'" + txtName.getText()
						+ "', " + "'" + txtLastName.getText() + "',"+0+","+0+", "+0+", "+0+")";
				// Obtener la hora
				DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
				Date date = new Date();
				LocalDateTime d = LocalDateTime.now();

				// Query para la tabla transactions
				String query2 = "INSERT INTO transactions (idCard, id, TransactionType, vlrTransaction, date , time, balance) VALUES ("
						+ "'" + txtIdCard.getText() + "', " + "'" + txtUsrId.getText() + "', " + "'-', " + 0.0 + " , '"
						+ d.getDayOfMonth() + "/" + d.getMonth() + "/" + d.getYear() + "', '" + dateFormat.format(date)
						+ "'," + 0 + " )";

				ob.setValues(query);
				ob.setValues(query2);
			}
		}
	}
}
