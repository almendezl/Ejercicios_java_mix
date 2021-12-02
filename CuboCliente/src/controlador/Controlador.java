/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import mundo.Mensaje;
import mundo.Rubik;
import mundo.SocketCubo;
import mundo.State;

/**
 *
 * @author DANIELA
 */
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
		//System.out.println("Creado ctrl");
	}

	public void enviarSolucion() {
		Mensaje mensaje = new Mensaje(solucion, ip, 2);
		Gson Gmensaje = new Gson();
		socket.socket(Gmensaje.toJson(mensaje));
	}

	public void pasosDeSolucion(String padreLLa, String mov) {
		String keyS = padreLLa;
		String ruta = mov;
		while (!arbol.get(keyS).getFatherKey().equals(".")) {
			ruta = arbol.get(keyS).getMove()+ " " + ruta;
			keyS = arbol.get(keyS).getFatherKey();
		}
		//
		solucion = ruta.split(" ");
		//System.out.println(solucion.toString());
	}

	public void comenzar(Rubik cuboSocket) {
		this.cuboInicial = cuboSocket.clone();
		//System.out.println("recobe el clon");
		cuboInicial.generadorKey();
		
		arbol.put(cuboInicial.getKey(), new State(".", "-", cuboInicial));
                
		llave = cuboInicial.getKey();
        //System.out.println("obtuvo la llave");
        //System.out.println(llave);
		copiaCubo = cuboInicial.clone();
		movimientosCubo(movimientoInicial);
		copiaCubo.generadorKey();
		arbol.put(copiaCubo.getKey(), new State(llave, movimientoInicial, copiaCubo));
		Queue<String> padres = new LinkedList<String>();
		padres.add(copiaCubo.getKey());
		while (!padres.isEmpty() && continuar == true) {
			//System.out.println("While de busqueda");
			String padreAux = padres.remove();
			for (int i = 0; i < movimientosCubo.length; i++) {
				copiaCubo = arbol.get(padreAux).getRubik().clone();
				copiaCubo.generadorKey();
				movimientosCubo(movimientosCubo[i]);
				if (!arbol.containsKey(copiaCubo.getKey())) {
					arbol.put(copiaCubo.getKey(), new State(padreAux, movimientosCubo[i], copiaCubo));
					padres.add(copiaCubo.getKey());
				}
				if (copiaCubo.comprobarLlave() == true) {
                                   // System.out.println("Entro a comprobar la clave");
					pasosDeSolucion(arbol.get(copiaCubo.getKey()).getFatherKey(), movimientosCubo[i]);
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
			copiaCubo.horizontal(0);;
			break;
		case "H1":
			copiaCubo.horizontal(1);
			break;
		case "V0":
			copiaCubo.vertical(0);
			break;
		case "V1":
			copiaCubo.vertical(1);
			break;
		case "T0":
			copiaCubo.transversal(0);
			break;
		case "T1":
			copiaCubo.transversal(1);
			break;
		case "0H":
			copiaCubo.horizontalN(0);
			break;
		case "1H":
			copiaCubo.horizontalN(1);
			break;
		case "0V":
			copiaCubo.verticalN(0);
			break;
		case "1V":
			copiaCubo.verticalN(1);
			break;
		case "0T":
			copiaCubo.transversalN(0);
			break;
		case "1T":
			copiaCubo.transversalN(1);
			break;
		}
	}

	public void ipAlServer() {
            System.out.println("envio ip al server desde el metodo");
		socket = new SocketCubo(this);
		Mensaje mensaje = new Mensaje(ip, "Nicole", 0);
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
                //System.out.println(cuboRubik.getKey()+"llave set cubo");
               // System.out.println(cuboInicial.getKey()+"llave set cubo");
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
