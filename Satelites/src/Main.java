
public class Main {

	public static void main(String[] args) {
		//datos de tx
		double Temperatura_AntenaTX = 30;
		double Pérdida_línea_conector = 0.8;
		double Ganancia_Máxima_AntenaTX = 52;
		double DesapuntamientoTX = 0.1;
		double Latitud_TX = 34.36; 
		double Longitud_TX = 58.23;
		double Altura_kmTX = 0.1;
		double Potencia_saturación_HPA = 150;
		double BO_salida = 3;
		
		//datos del sat
		double Potencia_amplificador = 40;
		double Pérdida_antena_receptor = 1;
		double Ganancia_Máxima_AntenaSat =38;
		double Desapuntamiento_hacia_ET = 0.2;
		double theta_3DB =3;  
		double LongitudSat = 55.5;
		double Factor_ruido_rx = 3;
		double Pérdidas_HPA_antena = 1;

		//datos de rx
		double Temperatura_LNA_RX= 120;
		double Temperatura_AntenaRX = 30;
		double Pérdida_conectorRX = 0.5;
		double Ganancia_Maxima_RX = 50;
		double Desapuntamiento_antenaRX = 0.1;
		double Latitud_RX = 19.433;
		double Longitud_RX = 99.133;
		double Altura_kmRX = 2.24;

		//ENLACE DE SUBIDA
		int h= 42164;
		int re = 6378;
		double l = Latitud_TX;
		System.out.println(l);
		
		double delthaL = LongitudSat-Longitud_TX;
		System.out.println(delthaL);
		double c = Math.cos(l*Math.PI/180)*Math.cos(delthaL*Math.PI/180); //entra en rad y retorna en grados
		System.out.println(c);
		double thetaprima = Math.acos(c)*180/3.14; //entra en grados y sale en rad
		System.out.println(thetaprima);
		double theta = Math.atan((c-re/h)/Math.sin(thetaprima*Math.PI/180))*180/3.14;
		System.out.println(theta);
		

	}

}
