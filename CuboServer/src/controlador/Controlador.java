package controlador;

import com.google.gson.Gson;
import java.awt.Color;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JTextField;

import interfaz.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mundo.*;

/**
 * Realiza la conexion entre la interfaz y el mundo del problema.
 */
public class Controlador implements ActionListener {
	// Objetos controlables de la interfaz

	private PanelCaras pnlIzquierdo, pnlFrontal, pnlDerecho;
	private PanelCaras pnlPosterior, pnlSuperior, pnlInferior;
	private PanelBotones pnlHorizontal, pnlTransversal, pnlVertical;
	private PanelSolucion pnlSolucion;
	private PanelPasos pnlPasos;
	private SocketServer socketServer;
	private PanelClientes pnlCliente;

	// Clase del mundo
	Rubik rubik;

	// Constructor
	/**
	 * Constructor por defecto. Crea la instancia del mundo.
	 */
	public Controlador() { // Instanciar la clase principal del modelo
		this.rubik = new Rubik();
	}

	public void abrirSocket() {
		socketServer = new SocketServer(this);
	}

	/**
	 * Recibe las referencias de los objetos a controlar de la interfaz.
	 *
	 * @param pnlIzquierdo   cara izquierda
	 * @param pnlFrontal     cara frontal
	 * @param pnlDerecho     cara derecha
	 * @param pnlPosterior   cara posterior
	 * @param pnlSuperior    cara superior
	 * @param pnlInferior    cara inferior
	 *
	 * @param pnlHorizontal  grupo de botones para realizar los movimientos
	 *                       horizontales
	 * @param pnlTransversal grupo de botones para realizar los movimientos
	 *                       transversales
	 * @param pnlVertical    grupo de botones para realizar los movimientos
	 *                       verticales
	 */
	public void conectar(PanelCaras pnlIzquierdo, PanelCaras pnlFrontal, PanelCaras pnlDerecho, PanelCaras pnlPosterior,
			PanelCaras pnlSuperior, PanelCaras pnlInferior, PanelBotones pnlHorizontal, PanelBotones pnlTransversal,
			PanelBotones pnlVertical, PanelSolucion pnlSolucion, PanelPasos pnlPasos, PanelClientes pnlCliente) {
		// Paneles de caras
		this.pnlIzquierdo = pnlIzquierdo;
		this.pnlFrontal = pnlFrontal;
		this.pnlDerecho = pnlDerecho;
		this.pnlPosterior = pnlPosterior;
		this.pnlSuperior = pnlSuperior;
		this.pnlInferior = pnlInferior;
		this.pnlCliente = pnlCliente;

		// Visualiza las caras
		this.visualizar(this.rubik);
		//System.out.println(this.rubik.key());

		// Panel Solucion
		this.pnlSolucion = pnlSolucion;

		// Panel Paso a paso
		this.pnlPasos = pnlPasos;

		// Paneles de botones
		this.pnlHorizontal = pnlHorizontal;
		this.pnlTransversal = pnlTransversal;
		this.pnlVertical = pnlVertical;

		this.pnlCliente.getBtnEnviar().addActionListener(this);
	}

	// --------------------------------------------------------------
	// Implementacion de los metodos de la clase controladora
	// --------------------------------------------------------------
	/**
	 * Realiza la conversion visual del mundo tridimensional,a formato
	 * bidimensional.
	 */
	public void visualizar(Rubik rubik) {
		ArrayList cara;
		int l;

		this.rubik = rubik;
		cara = pnlIzquierdo.getCara();
		l = 0;
		for (int i = 0; i < 2; i++) {
			for (int k = 1; k >= 0; k--) {
				((JTextField) cara.get(l++)).setBackground(rubik.cubo(i, 0, k).getIzquierda());
			}
		}

		cara = pnlFrontal.getCara();
		l = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				((JTextField) cara.get(l++)).setBackground(rubik.cubo(i, j, 0).getFrontal());
			}
		}

		cara = pnlDerecho.getCara();
		l = 0;
		for (int i = 0; i < 2; i++) {
			for (int k = 0; k < 2; k++) {
				((JTextField) cara.get(l++)).setBackground(rubik.cubo(i, 1, k).getDerecha());
			}
		}

		cara = pnlPosterior.getCara();
		l = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j >= 0; j--) {
				((JTextField) cara.get(l++)).setBackground(rubik.cubo(i, j, 1).getPosterior());
			}
		}

		cara = pnlSuperior.getCara();
		l = 0;
		for (int k = 1; k >= 0; k--) {
			for (int j = 0; j < 2; j++) {
				((JTextField) cara.get(l++)).setBackground(rubik.cubo(0, j, k).getSuperior());
			}
		}

		cara = pnlInferior.getCara();
		l = 0;
		for (int k = 0; k < 2; k++) {
			for (int j = 0; j < 2; j++) {
				((JTextField) cara.get(l++)).setBackground(rubik.cubo(1, j, k).getInferior());
			}
		}
	}

	// --------------------------------------------------------------
	// Implementacion de los requerimientos de usuario
	// --------------------------------------------------------------
	/**
	 * Invoca los metodos del mundo que realizan los requerimientos.
	 *
	 * @param quePanel identifica el tipo de movimiento horizonal, transversal o
	 *                 vertical.
	 * @param disco    disco sobre el cual se debe ejecutar el movimiento.
	 */
	public void movimiento(PanelBotones quePanel, int disco) {
		if (pnlHorizontal == quePanel) {
			rubik.horizontal(disco);
		} else if (pnlVertical == quePanel) {
			rubik.vertical(disco);
		} else {
			if (disco == 0) {
				rubik.transversal(1);
			} else {
				rubik.transversal(0);
			}
		}
		this.visualizar(this.rubik);
	}

	/**
	 * Visualiza la solucion
	 */
	public void setSolve(String lst) {
		pnlSolucion.setSolve(lst);
	}

	/**
	 * Visualiza la solucion paso a paso
	 *
	 * @throws IOException
	 */
	public void setStep(String step) {
		pnlPasos.setStep(step);
	}

	/**
	 * Metodo para cargar un estado inicial del cubo desde un archivo de objetos en
	 * disco
	 */
	public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/rubik.dat"));

		try {
			this.rubik = (Rubik) in.readObject();
			this.visualizar(this.rubik);
		} catch (EOFException e) {
		}
		in.close();
	}

	/**
	 * Metodo para guardar el estado actual del cubo desde un archivo de objetos en
	 * disco
	 */
	public void save() throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/rubik.dat"));
		out.writeObject(this.rubik);
		out.close();
	}

	/**
	 * Metodo para solucionar el cubo de Erno Rubik de 2*2
	 */
	public void solve(boolean negState) {
		Execution exe = new Execution(this, this.rubik, negState);
		exe.start();
	}

	public PanelCaras getPnlIzquierdo() {
		return pnlIzquierdo;
	}

	public void setPnlIzquierdo(PanelCaras pnlIzquierdo) {
		this.pnlIzquierdo = pnlIzquierdo;
	}

	public PanelCaras getPnlFrontal() {
		return pnlFrontal;
	}

	public void setPnlFrontal(PanelCaras pnlFrontal) {
		this.pnlFrontal = pnlFrontal;
	}

	public PanelCaras getPnlDerecho() {
		return pnlDerecho;
	}

	public void setPnlDerecho(PanelCaras pnlDerecho) {
		this.pnlDerecho = pnlDerecho;
	}

	public PanelCaras getPnlPosterior() {
		return pnlPosterior;
	}

	public void setPnlPosterior(PanelCaras pnlPosterior) {
		this.pnlPosterior = pnlPosterior;
	}

	public PanelCaras getPnlSuperior() {
		return pnlSuperior;
	}

	public void setPnlSuperior(PanelCaras pnlSuperior) {
		this.pnlSuperior = pnlSuperior;
	}

	public PanelCaras getPnlInferior() {
		return pnlInferior;
	}

	public void setPnlInferior(PanelCaras pnlInferior) {
		this.pnlInferior = pnlInferior;
	}

	public PanelBotones getPnlHorizontal() {
		return pnlHorizontal;
	}

	public void setPnlHorizontal(PanelBotones pnlHorizontal) {
		this.pnlHorizontal = pnlHorizontal;
	}

	public PanelBotones getPnlTransversal() {
		return pnlTransversal;
	}

	public void setPnlTransversal(PanelBotones pnlTransversal) {
		this.pnlTransversal = pnlTransversal;
	}

	public PanelBotones getPnlVertical() {
		return pnlVertical;
	}

	public void setPnlVertical(PanelBotones pnlVertical) {
		this.pnlVertical = pnlVertical;
	}

	public PanelSolucion getPnlSolucion() {
		return pnlSolucion;
	}

	public void setPnlSolucion(PanelSolucion pnlSolucion) {
		this.pnlSolucion = pnlSolucion;
	}

	public PanelPasos getPnlPasos() {
		return pnlPasos;
	}

	public void setPnlPasos(PanelPasos pnlPasos) {
		this.pnlPasos = pnlPasos;
	}

	public SocketServer getSocketServer() {
		return socketServer;
	}

	public void setSocketServer(SocketServer socketServer) {
		this.socketServer = socketServer;
	}

	public PanelClientes getPnlCliente() {
		return pnlCliente;
	}

	public void setPnlCliente(PanelClientes pnlCliente) {
		this.pnlCliente = pnlCliente;
	}

	public Rubik getRubik() {
		return rubik;
	}

	public void setRubik(Rubik rubik) {
		this.rubik = rubik;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pnlCliente.getBtnEnviar()) {
			//System.out.println("Click btn enviar a cliente");
			// Envia el mensaje al cliente con la rama
			//System.out.println(this.rubik.key() + " llave enviada desde el boton");
			Mensaje mensaje = new Mensaje(this.rubik, pnlCliente.getTxtmov().getText(), 1);
			mensaje.setOpcion(1);
			//System.out.println(mensaje.toString());
			Gson Gmensaje = new Gson();
			SocketServer.socket(Gmensaje.toJson(mensaje));
			System.out.println("Mensaje enviado al cliente");

			// rubik.generadorKey();
		}

	}

}
