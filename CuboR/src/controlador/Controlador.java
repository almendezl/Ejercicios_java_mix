package controlador;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import com.google.gson.Gson;

import interfaz.PanelDatos;
import mundo.CSocket;
import mundo.Mensaje;
import mundo.State;
import mundo.Rubik;

public class Controlador {
	private Rubik cuboRubik;
	private boolean continuar;
	private LinkedHashMap<String, State> lhm;
	private CSocket socket;
	private Rubik copiaRubik;
	private final String[] mov;
	private String[] pasosSol;
	private String ip;
	private String llaveRoot;
	private String movInicial;
	private PanelDatos pnlDatos;

	public Controlador() {
		continuar = false;
		lhm = new LinkedHashMap<String, State>();
		mov = new String[] {  "1T","H0", "0V", "T1", "V1", "T0", "0H", "1H", "1V", "V0", "0T", "H1" };
	}

	// --------------------------------------------Enviar la ip al
	// server--------------------------------------------------
	public void enviarIp(String ip, String ipServer) {
		this.ip = ip;
		socket = new CSocket(this,ipServer);
		/** Mensaje Tipo 0 **/
		Mensaje mensaje = new Mensaje(ip, "Angie - Nicolas", 0);
		Gson Gmensaje = new Gson();
		socket.socket(Gmensaje.toJson(mensaje));
	}

	// --------------------------------------------Enviar la solucion al
	// server--------------------------------------------------
	public void envSolucion() { // enviar el mensaje con la solucion
		/** Mensaje Tipo 2 **/
		Mensaje mensaje = new Mensaje(pasosSol, ip, 2);
		Gson Gmensaje = new Gson();
		socket.socket(Gmensaje.toJson(mensaje));
	}

	// --------------------------------------------Buscar la ruta
	// solucion--------------------------------------------------
	public void rutaSolucion(String padreLLa, String mov) { // Concatenar los movimientos de la solucion
		String keyS = padreLLa;
		String ruta = mov;
		while (!lhm.get(keyS).getPadre().equals(".")) {
			ruta = lhm.get(keyS).getmovimiento() + " " + ruta;
			keyS = lhm.get(keyS).getPadre();
		}
		pasosSol = ruta.split(" ");
	}

	// --------------------------------------------Iniciar la busqueda de la
	// solucion--------------------------------------------------
	public void Iniciar() {
		
		lhm.put(cuboRubik.getKey(), new State(".", "-", cuboRubik));
		llaveRoot = cuboRubik.getKey();
		
		copiaRubik = cuboRubik.clone();
		ejecutarMov(movInicial);
		//System.out.println(copiaRubik.getKey());
		lhm.put(copiaRubik.getKey(), new State(llaveRoot, movInicial, copiaRubik));

		Queue<String> padres = new LinkedList<String>();
		padres.add(copiaRubik.getKey());

		while (!padres.isEmpty() && continuar == true) {
			String padreAux = padres.remove();
			for (int i = 0; i < mov.length; i++) {
				copiaRubik = lhm.get(padreAux).getCubo().clone();
				ejecutarMov(mov[i]);
				if (!lhm.containsKey(copiaRubik.getKey())) {
					lhm.put(copiaRubik.getKey(), new State(padreAux, mov[i], copiaRubik));
					padres.add(copiaRubik.getKey());
				}
				if (copiaRubik.comprobarLlave() == true) { // si encontro la solucion concatena y envia al server
					rutaSolucion(lhm.get(copiaRubik.getKey()).getPadre(), mov[i]);
					//System.out.println(Arrays.toString(pasosSol));
					envSolucion(); 		//Quitar comentario
					pnlDatos.setLblmensajes(Arrays.toString(pasosSol));
					limpiar();
					return;
				}
			}
		}
	}

	// --------------------------------------------Ejecutar el
	// movimiento--------------------------------------------------
	public void ejecutarMov(String mov) {
		// System.out.println("Entro a ejecutar movimiento");
		switch (mov.toUpperCase()) {
		case "H0":
			copiaRubik.hor(0);
			break;
		case "H1":
			copiaRubik.hor(1);
			break;
		case "V0":
			copiaRubik.ver(0);
			break;
		case "V1":
			copiaRubik.ver(1);
			break;
		case "T0":
			copiaRubik.tra(0);
			break;
		case "T1":
			copiaRubik.tra(1);
			break;
		case "0H":
			copiaRubik.nHor(0);
			break;
		case "1H":
			copiaRubik.nHor(1);
			break;
		case "0V":
			copiaRubik.nVer(0);
			break;
		case "1V":
			copiaRubik.nVer(1);
			break;
		case "0T":
			copiaRubik.nTra(0);
			break;
		case "1T":
			copiaRubik.nTra(1);
			break;
		}
	}

	// --------------------------------------------Reiniciar
	// todo--------------------------------------------------
	public void limpiar() {
		cuboRubik = null;
		continuar = false;
		lhm = new LinkedHashMap<String, State>();
		copiaRubik = null;
		pasosSol = null;
		llaveRoot = null;
		movInicial = null;
	}

	// --------------------------------------------Getters and
	// Setters--------------------------------------------------
	public Rubik getCuboRubik() {
		return cuboRubik;
	}

	public void setCuboRubik(Rubik cuboRubik) {
		this.cuboRubik = cuboRubik.clone();
	}

	public boolean isContinuar() {
		return continuar;
	}

	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}

	public Map<String, State> getTreeMap() {
		return lhm;
	}

	public void setMovInicial(String movInicial) {
		this.movInicial = movInicial;
	}

	public CSocket getSocket() {
		return socket;
	}

	public void setSocket(CSocket socket) {
		this.socket = socket;
	}
	public void conectar(PanelDatos pnlDatos) {
		this.pnlDatos = pnlDatos;
	}
	public PanelDatos getPanel() {
		return pnlDatos;
	}
}
