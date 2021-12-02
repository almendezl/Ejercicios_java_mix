package controlador;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import com.google.gson.Gson;

import mundo.Mensaje;
import mundo.State;
import mundo.Rubik;
import mundo.SocketCubo;

public class Controlador {
	private Rubik cuboInicial;
	private boolean continuar;
	private LinkedHashMap<String, State> arbol;
	private String[] solucion;
	private String ip;
	private String llave;
	private SocketCubo socket;
	private Rubik copiaCubo;
	private String[] movimientosCubo;
	private String movimientoInicial;

	public Controlador() {
		movimientosCubo = new String[] { "H0", "1T", "0V","1V", "T1", "V1", "T0", "0H", "1H", "V0", "0T", "H1" };
		ip = "192.168.0.6";
		continuar = false;
		arbol = new LinkedHashMap<String, State>();
	}

	public void enviarSolucion() {
		Mensaje mensaje = new Mensaje(solucion, ip, 2);
		Gson Gmensaje = new Gson();
		socket.socket(Gmensaje.toJson(mensaje));
	}

	public void pasosDeSolucion(String padreLLa, String mov) {
		String keyS = padreLLa;
		String ruta = mov;
		while (!arbol.get(keyS).getPadre().equals(".")) {
			ruta = arbol.get(keyS).getmovimiento() + " " + ruta;
			keyS = arbol.get(keyS).getPadre();
		}
		solucion = ruta.split(" ");
	}

	public void comenzar() {
		arbol.put(cuboInicial.getKey(), new State(".", "-", cuboInicial));
		llave = cuboInicial.getKey();
		copiaCubo = cuboInicial.clone();
		movimientosCubo(movimientoInicial);
		arbol.put(copiaCubo.getKey(), new State(llave, movimientoInicial, copiaCubo));
		Queue<String> padres = new LinkedList<String>();
		padres.add(copiaCubo.getKey());
		while (!padres.isEmpty() && continuar == true) {
			String padreAux = padres.remove();
			for (int i = 0; i < movimientosCubo.length; i++) {
				copiaCubo = arbol.get(padreAux).getCubo().clone();
				movimientosCubo(movimientosCubo[i]);
				if (!arbol.containsKey(copiaCubo.getKey())) {
					arbol.put(copiaCubo.getKey(), new State(padreAux, movimientosCubo[i], copiaCubo));
					padres.add(copiaCubo.getKey());
				}
				if (copiaCubo.comprobarLlave() == true) {
					pasosDeSolucion(arbol.get(copiaCubo.getKey()).getPadre(), movimientosCubo[i]);
					enviarSolucion();
					reiniciar();
					return;
				}
			}
		}
	}

	public void movimientosCubo(String mov) {
		switch (mov.toUpperCase()) {
		case "H0":
			copiaCubo.hor(0);
			break;
		case "H1":
			copiaCubo.hor(1);
			break;
		case "V0":
			copiaCubo.ver(0);
			break;
		case "V1":
			copiaCubo.ver(1);
			break;
		case "T0":
			copiaCubo.tra(0);
			break;
		case "T1":
			copiaCubo.tra(1);
			break;
		case "0H":
			copiaCubo.nHor(0);
			break;
		case "1H":
			copiaCubo.nHor(1);
			break;
		case "0V":
			copiaCubo.nVer(0);
			break;
		case "1V":
			copiaCubo.nVer(1);
			break;
		case "0T":
			copiaCubo.nTra(0);
			break;
		case "1T":
			copiaCubo.nTra(1);
			break;
		}
	}

	public void ipAlServer() {
		socket = new SocketCubo(this);
		Mensaje mensaje = new Mensaje(ip, "Angie - Nicolas", 0);
		Gson Gmensaje = new Gson();
		socket.socket(Gmensaje.toJson(mensaje));
	}

	public void reiniciar() {
		cuboInicial = null;
		continuar = false;
		arbol = new LinkedHashMap<String, State>();
		copiaCubo = null;
		solucion = null;
		llave = null;
		movimientoInicial = null;
	}

	public Rubik getCuboRubik() {
		return cuboInicial;
	}

	public void setCuboRubik(Rubik cuboRubik) {
		this.cuboInicial = cuboRubik.clone();
	}

	public boolean isContinuar() {
		return continuar;
	}

	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}

	public Map<String, State> getTreeMap() {
		return arbol;
	}

	public void setMovInicial(String movInicial) {
		this.movimientoInicial = movInicial;
	}
}
