package interfaz;

import javax.swing.JOptionPane;

import controlador.Controlador;

public class InterfazCubo {
	private Controlador ctrl;
	
	public InterfazCubo(Controlador ctrl) {
		this.ctrl = ctrl;
	}

	public static void main(String[] args) {

		InterfazCubo intCubo = new InterfazCubo(new Controlador());
		
		String opcionString = (String) JOptionPane.showInputDialog(null, "Ingrese: \n 0 para enviar la ip al server \n 1 para salir"); 
		if(opcionString.equals("0")) {
			intCubo.ctrl.ip();
			JOptionPane.showMessageDialog(null, "La ip fue enviada al servidor con exito");
		}else if (opcionString.equals("1")) {
			System.exit(0);
		}else {
			JOptionPane.showMessageDialog(null, "Opcion invalida");
		}
	}
}
