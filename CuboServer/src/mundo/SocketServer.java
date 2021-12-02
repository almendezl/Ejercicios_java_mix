/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import com.google.gson.Gson;
import controlador.Controlador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angie
 */
public class SocketServer implements Runnable {

    private static Controlador ctrl;
    private static String ipDestino;

    public SocketServer(Controlador ctrl) {
        this.ctrl = ctrl;
        Thread treadListener = new Thread(this);
        treadListener.start();
        ipDestino = "";

    }

    /* Server:Data >> Socket >> Client */
    public static void socket(String msg) {
        try {
            System.out.println(ipDestino);
            //System.out.println(msg +"el json");
            //System.out.println(msg.toString());
            Socket server = new Socket(ipDestino, 5050); // portSend 5050
            DataOutputStream outBuffer = new DataOutputStream(server.getOutputStream());
            outBuffer.writeUTF(msg);
            server.close();

        } catch (UnknownHostException e) {
            System.out.println("Server : socket() : UnknownHostException: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Server : socket() : IOException: " + e.getMessage());

        }
    }

    /* Server: Listen */
    @Override
    public void run() {
        System.out.println("inicio el hilo");
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream inDataBuffer;

        try {
            serverSocket = new ServerSocket(5000); // portListen 5000

            while (true) {
               // System.out.println("llego algo");
                socket = serverSocket.accept();
                inDataBuffer = new DataInputStream(socket.getInputStream());
                String msg = inDataBuffer.readUTF();
                Gson gson = new Gson();
                Mensaje mensaje = gson.fromJson(msg, Mensaje.class);
               // System.out.println(mensaje.toString());
                if (mensaje.getOpcion() == 0) {
                    ctrl.getPnlCliente().getLblIp().setText(ctrl.getPnlCliente().getLblIp().getText()+ mensaje.getIp());
                    ctrl.getPnlCliente().getLblName().setText(ctrl.getPnlCliente().getLblName().getText()+ mensaje.getGrupo());
                    ipDestino = mensaje.getIp();

                } else if (mensaje.getOpcion() == 2) {
                    System.out.println("Llego la solucion del cliente");
                    int val = mensaje.getSolucion().length;
                    String sol = "";
                    for (int i = 0; i < val; i++) {
                        
                        sol+= mensaje.getSolucion()[i];
                        
                    }
                    System.out.println(sol);
                    ctrl.getPnlSolucion().setSolve(sol);
                    Execution exe = new Execution(this.ctrl, ctrl.getRubik(), true);
                    exe.setRubik(ctrl.getRubik());
                    exe.setLst(sol);
                    
                    exe.start();
                    ctrl.setSolve(sol);
                    //System.out.println(msg);
                    //ctrl.recibirdato(msg);
                }
                socket.close();
            }

        } catch (IOException e) {
            System.out.println("Error");
        }

    }
}
