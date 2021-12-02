/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Mundo.*;
import java.util.Scanner;

/**
 *
 * @author SG702-03
 */
public class InterfazApp {

    public static void main(String[] args) {

        String modoJuego;
        int nroTableros;
        Balotera balotera = new Balotera();

        System.out.println("Bienvenido al\t B \tI \tN \tG \tO \n \n");
        Scanner datos = new Scanner(System.in);
        System.out.println("Indique el numero de tableros a jugar: ");
        nroTableros = datos.nextInt();
        Tablero tableros[] = new Tablero[nroTableros];
        System.out.println("Seleccione el modo de juego: \nf ->para full \nn ->para modo N \nz ->para modo Z \no ->para modo O");
        modoJuego = datos.next();

        for (int i = 0; i < tableros.length; i++) {
            tableros[i] = new Tablero(modoJuego);
            System.out.println("Tablero numero: " + (i + 1));
            System.out.println(tableros[i].toString());
        }
        boolean repetir;
        do {
            Balota balota = new Balota();
            repetir = true;
            for (int i = 0; i < tableros.length; i++) {
                
                tableros[i].buscarBalota(balota);
                balotera.taparBalotera(balota);
                if (tableros[i].getTapado() == 25) {
                    System.out.println("Gano el tablero #: " + (i + 1));
                    repetir = false;
                    break;
                } else {
                    repetir = true;
                }
            }
        } while (repetir);

        System.out.println(balotera.toString());
        for (int i = 0; i < tableros.length; i++) {
            System.out.println("Tablero numero: " + (i + 1));
            System.out.println(tableros[i].toString());
        }

    }

}
