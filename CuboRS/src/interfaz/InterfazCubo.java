package interfaz;

import java.util.Scanner;

import controlador.Controlador;

public class InterfazCubo {
	private Controlador ctrl;
	
	public InterfazCubo(Controlador ctrl) {
		this.ctrl = ctrl;
	}

	public static void main(String[] args) {
		InterfazCubo interfazCubo = new InterfazCubo(new Controlador());
		System.out.println("Ingrese 1 para enviar la ip al server y 2 para salir");
		Scanner datoScanner = new Scanner(System.in);
		int opcion = datoScanner.nextInt();
		
		if(opcion == 1) {
			interfazCubo.ctrl.ipAlServer();
		}else if (opcion == 2) {
			System.exit(0);
		}
	}
}
