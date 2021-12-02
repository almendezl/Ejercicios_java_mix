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

public class PanelPistaV extends JPanel {

    private JLabel[][] lblPistasV;

    private Controlador controlador;

    public PanelPistaV(Controlador controlador) {

        setLayout(new GridLayout(10, 5));

        // Enlaza el Controlador y el Panel
        this.controlador = controlador;

        lblPistasV = new JLabel[10][5];
        llenar();

    }

    public void llenar() {
        //atributos de los label
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                
                lblPistasV[i][j] = new JLabel("");
                lblPistasV[i][j].setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
                lblPistasV[i][j].setHorizontalAlignment(JLabel.CENTER);
                lblPistasV[i][j].setVerticalAlignment(JLabel.CENTER);
                lblPistasV[i][j].setEnabled(true);
                lblPistasV[i][j].setBorder(BorderFactory.createLineBorder(new Color(102, 205, 170)));
                add(lblPistasV[i][j]);
            }
        }
    }

    public void llenar(String pistasV[][]) {
        //atributos de los label
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                String pista = pistasV[i][j];
                lblPistasV[i][j].setText(pista.equals("0") ? "" : pista);

            }
        }
    }

}
