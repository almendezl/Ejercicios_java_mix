/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import controlador.Controlador;
import mundo.Mensaje;

public class SocketCubo implements Runnable {

    // Relaciones
    private Controlador ctrl;

    /* Constructor */
    public SocketCubo(Controlador ctrl) {
        // conectar el controlador
        this.ctrl = ctrl;
        Thread treadListener = new Thread(this);
        treadListener.start();

    }

    /* Client:Data >> Socket >> Server */
    public void socket(String msg) {
        try {

            Socket client = new Socket("192.168.0.6", 5000); // portSend 5000
            DataOutputStream outBuffer = new DataOutputStream(client.getOutputStream());

            outBuffer.writeUTF(msg);
            client.close();

        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Client: socket(1) : UnknownHostException: " + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Client: socket(2) : IOException: " + e.getMessage());
        }
    }

    @Override
    /* Client: Listen */
    public void run() {
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream inDataBuffer;

        try {
            serverSocket = new ServerSocket(5050); // portListen 5050

            while (true) {
                socket = serverSocket.accept();
                inDataBuffer = new DataInputStream(socket.getInputStream());
                String msg = inDataBuffer.readUTF();
                //System.out.println(msg + "el json");
                Gson gson = new Gson();
                Mensaje mensaje = (Mensaje)gson.fromJson(msg, Mensaje.class);
                
                //System.out.println(mensaje.toString());
                //System.out.println(mensaje.getCuboRubik().getKey());
                mensaje.getCuboRubik().generadorKey();
                System.out.println(mensaje.getCuboRubik().getKey());
                
                if (mensaje.getOpcion() == 3) {
                    ctrl.setContinuar(false);
                    ctrl.reiniciar();
                } else if (mensaje.getOpcion() == 1) {
                	//mensaje.getCuboRubik().generadorKey();
                    //System.out.println(mensaje.getCuboRubik().getKey()+ "llave del cubo desde el socket");
                    
                    //ctrl.getCuboRubik(). .generadorKey()
                    Rubik cubollRubik= mensaje.getCuboRubik();
                    //System.out.println(cubollRubik.generadorKey()+"llave del clon");
                    ctrl.setCuboRubik(cubollRubik );
                    //System.out.println(mensaje.getMovimiento());
                    ctrl.setMovInicial(mensaje.getMovimiento());
                    ctrl.setContinuar(true);
                    ctrl.comenzar(cubollRubik);
                }

                socket.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Client run() : IOException: " + e.getMessage());
        }
    }
}
