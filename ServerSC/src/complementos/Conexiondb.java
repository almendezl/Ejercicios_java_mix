package complementos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexiondb {
	// atributos
	private static Connection conn;
	private Statement st;
	private ResultSet rs;

	// constantes
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "";
	private static final String url = "jdbc:mysql://localhost:3307/usuarios";

	public Conexiondb() {
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password); // establecer la conexion
			st = conn.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha establecido la conexion");
		}
	}

	public ResultSet getDatos(String query) {
		try {
			rs = st.executeQuery(query);
			return rs;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la extraccion de datos");
			return null;
		}
	}

	public void setValues(String query) {
		try {
			st.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al enviar datos");
		}
	}
	public int consultan(String id, String op)  {
		try {
			ResultSet rst  = getDatos("SELECT * FROM `users` WHERE id = '"+id+"'" );
			// Recorrido y procesamiento del resultset 	    
			String val= "";
			while ( rst.next()) {
				//System.out.print( rst.getString( "idCard" ) + " " );
				//System.out.print( rst.getString( "name" ) + " " );
				//System.out.print( rst.getString( "lastName" ) + " ");
				//System.out.print( rst.getString( "id" ) + " ");
				//System.out.print( rst.getString( "contZ" ) + " ");
				if(op.equals("Z")) {
				val = rst.getString("contZ");
				}else if(op.equals("C")) {
					val = rst.getString("contC");
				}else if(op.equals("t")) {
					val = rst.getString("trasbordo");
				}else if(op.equals("p")){
					val = rst.getString("prestamo");
				}
			}
			rst.close();
			return Integer.parseInt(val);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Error en la extraccion");
		}
		 	return -1;
	}
	public void update(String id,String op, int val) {
		try {
			if(op.equals("Z")) {
			setValues("UPDATE `users` SET `contZ` = '"+val+"' WHERE `users`.`id` = '"+id+"'");
			}else if(op.equals("C")){
				setValues("UPDATE `users` SET `contC` = '"+val+"' WHERE `users`.`id` = '"+id+"'");
			}else if(op.equals("t")) {
				setValues("UPDATE `users` SET `trasbordo` = '"+val+"' WHERE `users`.`id` = '"+id+"'");
			}else if(op.equals("p")) {
				setValues("UPDATE `users` SET `prestamo` = '"+val+"' WHERE `users`.`id` = '"+id+"'");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
