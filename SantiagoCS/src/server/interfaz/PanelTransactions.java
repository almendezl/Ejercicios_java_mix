package server.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import complementos.Conexiondb;

public class PanelTransactions extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	// relaciones

	// atributos
	private JComboBox<String> users;
	private JTextField txtUser;
	private JButton btnBuscar;
	private Conexiondb db;
	private ResultSet rs;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel dtm;

	public PanelTransactions() {

		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Transacciones")));
		setLayout(null);

		// crear El Jcombox
		users = new JComboBox<String>();
		users.setBounds(20, 20, 620, 50);

		// Crear la tabla y agregar las columnas
		crearTabla();
		
		// crear la conexion con la db
		db = new Conexiondb();

		//agregar la busqueda para mostrar 
		txtUser = new JTextField(30);
		txtUser.setBounds(20, 25, 500, 40);
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(535, 25, 100, 40);
		
		btnBuscar.addActionListener(this);
		add(txtUser);
		add(btnBuscar);
		add(scrollPane);
	}
public void crearTabla() {
	// Crear la tabla y agregar las columnas
			dtm = new DefaultTableModel();
			dtm.addColumn("Tipo"); dtm.addColumn("Valor"); dtm.addColumn("Fecha"); dtm.addColumn("Hora"); dtm.addColumn("Balance");
			table = new JTable(dtm);
		 scrollPane = new JScrollPane(table);
		 scrollPane.setBounds(20, 80, 620, 200);
}
	public void actualizarTabla(String id) {
        dtm.setRowCount(0);
		String query = "SELECT * FROM `transactions` WHERE `id` LIKE '" + id + "'";
		rs = db.getDatos(query);
		try {
			while (rs.next()) {
				dtm.addRow(new String[] {rs.getString("TransactionType"), rs.getString("vlrTransaction"),
						rs.getString("date"), rs.getString("time"), rs.getString("balance") });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al traer los datos");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnBuscar) {
				String item = txtUser.getText(); 
				actualizarTabla(item);	
			}
			
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
