package server.controlador;

import java.io.IOException;

import server.interfaz.PanelTransactions;
import server.mundo.SocketServer;

public class Controlador {

	// relaciones
	private PanelTransactions pnlTrans;
	private SocketServer socketS;

	public Controlador() throws IOException {
		socketS = new SocketServer(this);
	}

	public void conectarPanel(PanelTransactions pnlTrans) {
		this.pnlTrans = pnlTrans;
	}
	
	public void actPnlTr(String id) {
		pnlTrans.actualizarTabla(id);
	}
	public int obtRow() {
		return pnlTrans.obtRowCount();
	}
	public Object obtValueTab(int i, int j) {
		return pnlTrans.obtValTable(i, j);
	}

}
