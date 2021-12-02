package server.interfaz;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import complementos.Conexiondb;

public class PanelTransactions extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	// relaciones

	// atributos
	private JComboBox<String> users;
	private Conexiondb db;
	private ResultSet rs;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel dtm;
	private Button btnLimpiar;
	private JLabel logo;

	public PanelTransactions() {

		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
		setLayout(null);

		// crear el logo
		ImageIcon img = new ImageIcon("data/bog.jpg");
		logo = new JLabel();
		logo.setIcon(img);
		logo.setBounds(10, 10, 620, 140);

		// crear El Jcombox
		users = new JComboBox<String>();
		users.setBounds(10, 160, 430, 40);

		// Crear la tabla y agregar las columnas
		crearTabla();
		// crear la conexion con la db
		db = new Conexiondb();
		String query = "SELECT * FROM users";
		rs = db.getDatos(query);

		// agregar los usuarios de la db al jcombox
		try {
			while (rs.next()) {
				String user = rs.getString("id") + " " + " \t" + " " + rs.getString("idCard") + " " + "\t" + " "
						+ rs.getString("Name") + " " + "\t" + " " + rs.getString("lastName");
				users.addItem(user);
			}
			// mostrar las transacciones del primer usuario
			actualizarTabla((users.getItemAt(0).split(" "))[0]);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la extraccion de datos");
		}
			
		users.addActionListener(this);
		// btn Limpiar
		btnLimpiar = new Button("Limpiar Registros");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(450, 160, 180, 40);
		btnLimpiar.setBackground(new Color(54, 190, 193));
		btnLimpiar.setFont(new Font("Dialog", 1, 16));

		add(logo);
		add(users);
		add(scrollPane);
		add(btnLimpiar);
	}

	public void crearTabla() {
		// Crear la tabla y agregar las columnas
		dtm = new DefaultTableModel();
		dtm.addColumn("Tipo");
		dtm.addColumn("Valor");
		dtm.addColumn("Fecha");
		dtm.addColumn("Hora");
		dtm.addColumn("Balance");
		table = new JTable(dtm);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 210, 620, 230);
	}

	public void actualizarTabla(String id) {
		dtm.setRowCount(0);
		String query = "SELECT * FROM `transactions` WHERE `id` LIKE '" + id + "'";
		rs = db.getDatos(query);
		try {
			while (rs.next()) {
				dtm.addRow(new String[] { rs.getString("TransactionType"), rs.getString("vlrTransaction"),
						rs.getString("date"), rs.getString("time"), rs.getString("balance") });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al traer los datos");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String item = (users.getSelectedItem().toString().split(" "))[0];

			if (e.getSource() == btnLimpiar) {
				String query = "DELETE FROM `transactions` WHERE `id` LIKE '" + item
						+ "' AND `TransactionType` NOT LIKE '-'";
				db = new Conexiondb();
				db.setValues(query);
				db.update(item, "C", 0);
				db.update(item, "Z", 0);
				db.update(item, "t", 0);
				db.update(item, "p", 0);
				
			}
			actualizarTabla(item);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error al seleccionar usuario");
		}
	}

	public Object obtValTable(int i, int j) {
		return dtm.getValueAt(i, j);
	}

	public int obtRowCount() {
		return dtm.getRowCount();
	}
}
