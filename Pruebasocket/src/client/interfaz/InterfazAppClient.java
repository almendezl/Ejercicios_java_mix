package client.interfaz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import client.controlador.Controlador;


public class InterfazAppClient
{
  /* Relaciones */
   private Controlador ctrl;
   
   public InterfazAppClient(Controlador ctrl)
   { this.ctrl = ctrl;
     ctrl.socket("Hello server...");	
   }
	
   public static void main(String[] args) 
   { new InterfazAppClient(new Controlador()); 
   }
}
