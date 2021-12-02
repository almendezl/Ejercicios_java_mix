package controlador;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import com.google.gson.Gson;

import mundo.CSocket;
import mundo.Mensaje;
import mundo.State;
import mundo.Rubik;

public class Controlador {
	private Rubik rubik;
	private boolean continuar;
	private final String[] movimientos;
	private String[] solucion;
	private String ip;
	private String llavePadre;
	private String movInicial;
	private LinkedHashMap<String, State> mapa;
	private CSocket socket;
	private Rubik copiaRubik;
	

	public Controlador() {
		ip = "192.168.1.59";
		continuar = false;
		movimientos = new String[] { "H0","H1", "1T", "0V","V0", "T1", "V1", "T0", "0H", "1H", "1V", "0T"};
		mapa = new LinkedHashMap<String, State>();
		
	}

	public void ip() {
		socket = new CSocket(this);
		Mensaje mensaje = new Mensaje(ip, "Daniel", 0);
		Gson Gmensaje = new Gson();
		socket.socket(Gmensaje.toJson(mensaje));
	}

	public void solucion() {
		Mensaje mensaje = new Mensaje(solucion, ip, 2);
		Gson Gmensaje = new Gson();
		socket.socket(Gmensaje.toJson(mensaje));
	}

	public void pasos(String padreLLa, String mov) { 
		String keyS = padreLLa;
		String ruta = mov;
		while (!mapa.get(keyS).getPadre().equals(".")) {
			ruta = mapa.get(keyS).getmovimiento() + " " + ruta;
			keyS = mapa.get(keyS).getPadre();
		}
		solucion = ruta.split(" ");
	}

	public void buscar() {
		
		mapa.put(rubik.getKey(), new State(".", "-", rubik));
		llavePadre = rubik.getKey();
		
		copiaRubik = rubik.clone();
		moverCubo(movInicial);
		mapa.put(copiaRubik.getKey(), new State(llavePadre, movInicial, copiaRubik));

		Queue<String> padres = new LinkedList<String>();
		padres.add(copiaRubik.getKey());

		while (!padres.isEmpty() && continuar == true) {
			String padreAux = padres.remove();
			for (int i = 0; i < movimientos.length; i++) {
				copiaRubik = mapa.get(padreAux).getCubo().clone();
				moverCubo(movimientos[i]);
				if (!mapa.containsKey(copiaRubik.getKey())) {
					mapa.put(copiaRubik.getKey(), new State(padreAux, movimientos[i], copiaRubik));
					padres.add(copiaRubik.getKey());
				}
				if (copiaRubik.comprobarLlave() == true) {
					pasos(mapa.get(copiaRubik.getKey()).getPadre(), movimientos[i]);
					solucion(); 
					borrar();
					return;
				}
			}
		}
	}


	public void moverCubo(String mov) {
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

	public void borrar() {
		rubik = null;
		continuar = false;
		mapa = new LinkedHashMap<String, State>();
		copiaRubik = null;
		solucion = null;
		llavePadre = null;
		movInicial = null;
	}

	public Rubik getCuboRubik() {
		return rubik;
	}

	public void setCuboRubik(Rubik cuboRubik) {
		this.rubik = cuboRubik.clone();
	}

	public boolean isContinuar() {
		return continuar;
	}

	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}

	public Map<String, State> getTreeMap() {
		return mapa;
	}

	public void setMovInicial(String movInicial) {
		this.movInicial = movInicial;
	}
}
