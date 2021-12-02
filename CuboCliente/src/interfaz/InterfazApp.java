package interfaz;

import controlador.Controlador;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class InterfazApp {

    private Controlador ctrl;

    public InterfazApp(Controlador ctrl) {
        this.ctrl = ctrl;
    }

    public static void main(String[] args) {
        InterfazApp interfazCubo = new InterfazApp(new Controlador());
        System.out.println("Ingrese 1 para enviar la ip al server y 2 para salir");
        Scanner datoScanner = new Scanner(System.in);
        int opcion = datoScanner.nextInt();

        if (opcion == 1) {
            interfazCubo.ctrl.ipAlServer();
            System.out.println("envio ip al server");
            
        } else if (opcion == 2) {
            System.exit(0);
        }
    }
}
