package contScore;

import java.util.ArrayList;
import java.util.Arrays;

public class ScoreBoard {
	private Equipo[] equipos;
	private ArrayList<Equipo> tablero;

	public ScoreBoard(Equipo equipos[]) {
		this.equipos = equipos;
		tablero = new ArrayList<Equipo>();
	}

	public void evaluar() {
		Arrays.sort(equipos);
		
		tablero.add(new Equipo (equipos[0].getEquipo(),0,0,""));
		int lista = 0;// posicion en la lista
		
		for (int i = 0; i < equipos.length; i++) {

			if (tablero.get(lista).getEquipo() == equipos[i].getEquipo()) {
				if (equipos[i].getLetra().equals("C") ){
					tablero.get(lista).setProblema(tablero.get(lista).getProblema() + 1);
					tablero.get(lista).setTiempo(tablero.get(lista).getTiempo() + equipos[i].getTiempo());
				}else if (equipos[i].getLetra().equals("I")) {
					tablero.get(lista).setTiempo(tablero.get(lista).getTiempo() + 20);
				}
			} else {
				lista++;
				tablero.add(equipos[i]);
			}
		}
	}

	public void ordenar() {
		Equipo aux[] = new Equipo[tablero.size()];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = tablero.get(i);
		}
		ordenar(aux);
		imprimir(aux);
	}

	private void ordenar(Equipo[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i].compareToF(a[j]) < 0) {
					Equipo aux = a[j];
					a[j] = a[i];
					a[i] = aux;
				}
			}
		}
	}

	public void imprimir(Equipo[] aux) {
		for (int i = 0; i < aux.length; i++) {
			System.out.println(aux[i].toString());
		}
	}

}
