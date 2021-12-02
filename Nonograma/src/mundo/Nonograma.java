/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import controlador.Controlador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class Nonograma {

    private Controlador ctrl;

    private String matrixNono[][];
    private int vidas;
    private String pistasV[][];
    private String pistasH[][];
    int contador;

    public Nonograma(Controlador ctrl) {

        matrixNono = new String[10][10];
        pistasV = new String[10][5];
        pistasH = new String[5][10];
        vidas = 3;
        contador = 0;
        this.ctrl = ctrl;
        

    }

    public void jugar(int i, int j, String valor) { // revisar

        //System.out.println("Se comparo " + valor + " y " + matrixNono[i][j]);
        if (vidas >= 1 && contador < 100) {
            if (valor.equals(matrixNono[i][j])) {

                contador++;
                //System.out.println("contador "+contador);
                if (contador == 100) {
                    JOptionPane.showMessageDialog(null, "Felicidades. Gano!!!");
                    //System.out.println("Ha ganado");
                }
                //System.out.println("contador " + contador);
                //System.out.println("vidas " + vidas);

            } else {
                contador++;
                vidas--;
                //System.out.println("contador " + contador);
                //System.out.println("vidas " + vidas);
                ctrl.getPnlVidas().perdioVida(0, vidas);
                if (vidas == 0) {
                    JOptionPane.showMessageDialog(null, "Ha perdido!!!, vuelva a intentarlo");
                    //System.out.println("HA PERDIDO");
                    reiniciar();
                    return;

                }
                ctrl.getPnlGrilla().cambiarValorCelda(i, j, matrixNono[i][j]);
            }
        }

    }

    public void reiniciar() {

        ctrl.getPnlVidas().reiniciar();
        ctrl.getPnlGrilla().reiniciar();
        vidas = 3;
        contador = 0;
    }

    public void quitarValor() {

        contador--;
    }

    public void llenarMatriz(String valArchivo) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
           // System.out.println(valArchivo);
            archivo = new File("data/nono"+valArchivo+".in");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero para las pistas horizontales
            for (int i = 0; i < 5; i++) {
                String linea[] = br.readLine().split(" ");
                for (int j = 0; j < 10; j++) {
                    pistasH[i][j] = linea[j];
                }
            }
            // Lectura del fichero para las pistas verticales
            for (int i = 0; i < 10; i++) {
                String linea[] = br.readLine().split(" ");
                for (int j = 0; j < 5; j++) {
                    pistasV[i][j] = linea[j];
                }
            }

            // Lectura del fichero para las pistas verticales
            for (int i = 0; i < 10; i++) {
                String linea[] = br.readLine().split(" ");
                for (int j = 0; j < 10; j++) {
                    matrixNono[i][j] = linea[j];
                    //System.out.print(matrixNono[i][j] + " ");
                }
                //System.out.println("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public Controlador getCtrl() {
        return ctrl;
    }

    public void setCtrl(Controlador ctrl) {
        this.ctrl = ctrl;
    }

    public String[][] getMatrixNono() {
        return matrixNono;
    }

    public void setMatrixNono(String[][] matrixNono) {
        this.matrixNono = matrixNono;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public String[][] getPistasV() {
        return pistasV;
    }

    public void setPistasV(String[][] pistasV) {
        this.pistasV = pistasV;
    }

    public String[][] getPistasH() {
        return pistasH;
    }

    public void setPistasH(String[][] pistasH) {
        this.pistasH = pistasH;
    }

}
