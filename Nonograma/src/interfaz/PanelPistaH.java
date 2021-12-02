/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import controlador.Controlador;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelPistaH extends JPanel {

    private JLabel[][] lblPistasH;

    private Controlador controlador;

    public PanelPistaH(Controlador controlador) {
                setLayout(new GridLayout(5, 10));

        // Enlaza el Controlador y el Panel
        this.controlador = controlador;

        lblPistasH = new JLabel[5][10];

        llenar();

    }
    
    public void llenar (String pistasH[][]){
        //atributos de los label
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                String pista = pistasH[i][j];
                lblPistasH[i][j].setText(pista.equals("0")?"":pista);
               
            }
        }
    }
     public void llenar (){
        //atributos de los label
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                
                lblPistasH[i][j] = new JLabel("");
                lblPistasH[i][j].setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
                lblPistasH[i][j].setHorizontalAlignment(JLabel.CENTER);
                lblPistasH[i][j].setVerticalAlignment(JLabel.CENTER);
                lblPistasH[i][j].setEnabled(true);
                lblPistasH[i][j].setBorder(BorderFactory.createLineBorder(new Color(102, 205, 170)));
                add(lblPistasH[i][j]);
            }
        }
    }

}
