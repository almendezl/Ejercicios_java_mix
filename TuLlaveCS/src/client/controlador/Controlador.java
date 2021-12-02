package client.controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JOptionPane;

import client.interfaz.PanelBalance;
import client.interfaz.PanelUser;
import client.mundo.SaveDat;
import client.mundo.TuLlave;
import complementos.Transaction;

public class Controlador {
	// relaciones
	private PanelBalance pnlBalance;
	private PanelUser pnlUser;
	private TuLlave tuLlave;
	private Transaction tran;

	// constantes
	private final int ZON = 2400;
	private final int COM = 2200;

	// Obtener la fecha y hora
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();
	LocalDateTime d = LocalDateTime.now();

	public Controlador() {
		tuLlave = new TuLlave(this);
	}

	public void conectarPaneles(PanelBalance pnlBalance, PanelUser pnlUser) {
		this.pnlBalance = pnlBalance;
		this.pnlUser = pnlUser;
	}

	public void actPaneles() {
		pnlUser.actualizarPanel(tuLlave.getUser().getNombre(), tuLlave.getUser().getApellido(),
				tuLlave.getUser().getCedula(), tuLlave.getUser().getIdTarjeta());
		pnlBalance.setLblSaldo(tuLlave.getUser().getSaldo() + "");

	}

	public void recargar(String valor) {
		int val = Integer.parseInt(valor);
		tran = new Transaction("R", tuLlave.getUser().getCedula(), tuLlave.getUser().getIdTarjeta(), val,
				d.getDayOfMonth() + "/" + d.getMonth() + "/" + d.getYear(), "" + dateFormat.format(date),
				tuLlave.getUser().getSaldo() + val);

		// enviar los datos al server
		socket("0", tran);
	}

	public void actDatRecarga() {
		// actualizar los datos en la tarjeta
		tuLlave.getUser().setSaldo(tran.getBalance());
		SaveDat.saveDat(tuLlave.getUser());
		pnlBalance.setLblSaldo(tuLlave.getUser().getSaldo());

		SaveDat.saveDat(tuLlave.getUser()); // guardar el archivo dat
	}

	public void actPago(String op) {
		// actualizar datos en tarjeta
		switch (op) {
		case "p1":
			tuLlave.getUser().setSaldo(tuLlave.getUser().getSaldo()-(ZON-COM) );
			break;
		case "p2":
			tuLlave.getUser().setSaldo(tuLlave.getUser().getSaldo() - ZON);
			break;
		case "p4": case "p6":
			tuLlave.getUser().setSaldo(tuLlave.getUser().getSaldo() - COM);
			break;
		default:
			break;
		}
		SaveDat.saveDat(tuLlave.getUser());
		pnlBalance.setLblSaldo(tuLlave.getUser().getSaldo());
		SaveDat.saveDat(tuLlave.getUser()); // guardar el archivo dat
	}

	public void pagar(int op) {
		if (op == 0) {// pago zonal
			tran = new Transaction("Z", tuLlave.getUser().getCedula(), tuLlave.getUser().getIdTarjeta(), ZON,
					d.getDayOfMonth() + "/" + d.getMonth() + "/" + d.getYear(), dateFormat.format(date),
					tuLlave.getUser().getSaldo());
			socket("2", tran);
		} else if (op == 1) {// pago complementario
			socket("3",
					new Transaction("C", tuLlave.getUser().getCedula(), tuLlave.getUser().getIdTarjeta(), COM,
							d.getDayOfMonth() + "/" + d.getMonth() + "/" + d.getYear(), dateFormat.format(date),
							tuLlave.getUser().getSaldo()));
		} else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de pago");
		}
	}
	public TuLlave obTuLlave() {
		return tuLlave;
	}

	public void socket(String msg, Transaction reg) {
		tuLlave.envSocket(msg, reg);
	}
}