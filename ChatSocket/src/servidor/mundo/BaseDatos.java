package servidor.mundo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gson.Gson;

import complementos.Mensaje;
import servidor.controlador.Controlador;

public class BaseDatos {
	// atributos
	private static Connection conn;
	private Statement st;
	private ResultSet rs;
	private Controlador ctrl;

	// constantes
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "";
	private static final String url = "jdbc:mysql://localhost:3306/chat";

	public BaseDatos(Controlador ctrl) {
		this.ctrl = ctrl;
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password); // establecer la conexion
			st = conn.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			ctrl.actualizarPnlExc("No se ha establecido la conexion con la DB");
		}
	}

	public ResultSet getDatos(String query) {
		try {
			rs = st.executeQuery(query);
			System.out.println("entro a ejecutar el qry");
			return rs;

		} catch (Exception e) {
			ctrl.actualizarPnlExc("Error en la extraccion de datos-getdato");
			return null;
		}
	}

	public void setValues(String query) {
		try {
			st.executeUpdate(query);
		} catch (Exception e) {
			ctrl.actualizarPnlExc("Error al enviar datos a la DB");
		}
	}

	public String traerIp(String nick) {
		try {
			ResultSet rst = getDatos("SELECT * FROM `usuarios` WHERE nick = '" + nick + "'");
			String val = "";
			if (rst.next()) { // si ya esta en la db
				val = rst.getString("ip");
			} else {
				val = "";
			}

			return val;
		} catch (Exception e) {
			// TODO: handle exception
			ctrl.actualizarPnlExc("Error en la extraccion de ipDestino");
		}
		return "-1";
	}
	

	public void consultaUsuario(String nick, String ip) { //arreglar porque todo no va aqui
		try {
			ResultSet rst = getDatos("SELECT * FROM `usuarios` WHERE nick = '" + nick + "'");
			// Revisa si el usuario esta en la db
			String val = "";
			if (rst.next()) { // si ya esta en la db
				val = rst.getString("ip");
				rst.close();
				
				if (!val.equals(ip)) {// revisa que la ip sea la misma, sino la actualiza
					// actualiza la nueva ip en la db
					setValues("UPDATE `usuarios` SET `ip` = '" + ip + "' WHERE `usuarios`.`nick` = '" + nick + "'");
				}

			} else {// si no esta en la db, lo agrega
				String query = "INSERT INTO usuarios (nick, ip) VALUES (" + "'" + nick + "', '" + ip + "' )";
				setValues(query);
			}
			// verifica si tiene mensajes en la deb y se los envia
			rst = getDatos("SELECT * FROM `mensajes` WHERE nick = '" + nick + "'");
			while(rst.next()) {
				Mensaje msj = new Mensaje(rst.getString("origen"),rst.getString("mensaje"), nick );
				Gson gson = new Gson();
				ctrl.getSocketS().socket(gson.toJson(msj).toString(), ip);
			}
			//como ya le envio los datos que estaban en la db, entonces se borran
			String query = "DELETE FROM `mensajes` WHERE `nick` = '" + nick + "'";
			setValues(query);

			

		} catch (Exception e) {
			// TODO: handle exception
			ctrl.actualizarPnlExc("Error en la extraccion de datos- consulta");
		}
	}
	
	public void guardaMensaje(String mensaje, String destino, String origen) {
		String query = "INSERT INTO mensajes (nick, mensaje, origen) VALUES (" + "'" + destino + "', '" + mensaje + "', '" + origen + "' )";
		setValues(query);
	}
	
	public void consultaMensajes() {
		
	}

}
