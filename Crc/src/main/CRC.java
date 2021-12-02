package main;

import java.util.Scanner;
/**
 *

 *
 **/

public class CRC {
	
	static Scanner datos = new Scanner(System.in);
	static String m;
	static String trama;
	static String cola;
	static String p;
	static String FCS;
	
	public static void main(String[] args) {
		System.out.println(
				" **                            **\r\n" + 
				" ********************************\r\n" + 
				" *CODIGO DE REDUNDANCIA CICLICA \r\n" + 
				" ********************************\r\n" + 
				" **                            **");
		/*-----------------------------PEDIR DATOS-----------------------------*/
		
		System.out.println("Ingrese el mensaje");
		m= datos.next();
		System.out.println("Ingrese el patron");
		p = datos.next();
		
		if(m.length() < p.length()) {
			System.out.println("Revise los datos e intente de nuevo");
			System.exit(0);
		}
		trama = m;
		
		
		/*-----------------------------MULTIPLICAR EL MENSAJE POR 2^F-----------------------------*/
		
		for (int i = 0; i < p.length()-1; i++) {
			 trama += "0";
		}
		cola = trama.substring(p.length(), trama.length());	
		System.out.println("M = " + m);
		System.out.println("P = "+ p);
		System.out.println("T = "+trama);
		
		/*-----------------------------DIVIDIR LA TRAMA POR EL PATRON-----------------------------*/
		
		FCS = division(m.substring(0, p.length()));
		System.out.println("El FCS es: "+ FCS);
		
		/*-----------------------------PEGAR EL FCS AL MENSAJE-----------------------------*/
		
		String rectificar = m+FCS;
		
		/*-----------------------------DIVIDIR POR EL PATRON PARA VERIFICAR ERRORES-----------------------------*/
		
		cola = rectificar.substring(p.length(), rectificar.length());
		System.out.println(verificar(division(rectificar.substring(0, p.length())))? "No hay errores!!":"Si hay errores!!");
	}
	
	public static boolean verificar(String verificar) {
		System.out.println("El resultado de la verificacion es: "+ verificar);
		for (int i = 0; i < verificar.length(); i++) {
			if(verificar.charAt(0) != '0') {
				return false;
			}
		}
		return true;
	}
	public static String division(String aux2) {
		String aux = aux2;
		String salida = "";
		while(cola.length() > 0) {
			aux = reciduo(aux, aux.length());
			if(cola.length()-(p.length()-aux.length()) >= 0) {
				while(aux.length() < p.length()) {
					aux = pegar(aux);
				}
			}else if(cola.length()==1) {
				aux += cola;
				cola = "";
			}
		}
		if(aux.length() == p.length()) {
			aux = reciduo(aux, aux.length());
			salida = aux;
		}
		if(aux.length() == p.length()-1)
			salida = aux;
		else
			salida = agregar(aux);
		return salida;		
	}
	public static String agregar(String aux) {//completa la longitud del FCS
		String var="";
		for(int i = 0; i <((p.length()-1)-aux.length());i++ ) {
			var += "0";
		}
		return var+aux;
	}
	public static String pegar(String aux) { //pega de la cola
		aux += String.valueOf(cola.charAt(0)); //pegar el primero de la caloa para comppletar la canditad de datos para poder dividir 
		cola = cola.substring(1, cola.length());
		return aux;
	}
	public static String reciduo(String aux, int length) {
		String reciduo ="";
		for (int j = 0; j < length; j++) {
			if(aux.charAt(j) == p.charAt(j)) {
				reciduo += "0";
			}else {
				reciduo += "1";
			}
		}
		reciduo = correr(reciduo);
		return reciduo;
	}
	public static String correr(String aux) {//quita los ceros de la izquierda
		String salida = "";
		for (int i = 0; i < aux.length(); i++) {
			if(aux.charAt(i) == '1' ) {
				salida = aux.substring(i, aux.length());
				break;
			}
		}
		return salida;
	}
}