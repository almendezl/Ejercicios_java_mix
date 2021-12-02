package enlace_satelital;

import controlador.Controlador;
import mundo.Calculos;
import vista.InterfazApp;

public class Enlace_Satelital_Iniciar {

	public static void main(String[] args) {
		
		InterfazApp interfaz = new InterfazApp();
        Calculos calculos = new Calculos();
        Controlador controlador = new Controlador(calculos, interfaz);
        controlador.iniciar();
	}
}
