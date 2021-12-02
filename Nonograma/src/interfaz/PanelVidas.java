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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelVidas extends JPanel {

    private static final String VIDA = "data/vida.gif";
    private static final String VIDAP = "data/vidaPerd.gif";
    private ImageIcon imgV;
    private ImageIcon imgVP;
    private JLabel lblVidas[][];

    private Controlador controlador;

    public PanelVidas(Controlador controlador) {

        setLayout(new GridLayout(1, 3));

        this.imgV = new ImageIcon(VIDA);
        this.imgVP = new ImageIcon(VIDAP);

        // Enlaza el Controlador y el Panle de SimulaciÃ³n
        this.controlador = controlador;

        lblVidas = new JLabel[1][3];
        lblVidas = new JLabel[1][3];
        //atributos de los label
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 3; j++) {
                lblVidas[i][j] = new JLabel("");
                lblVidas[i][j].setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
                lblVidas[i][j].setHorizontalAlignment(JLabel.CENTER);
                lblVidas[i][j].setVerticalAlignment(JLabel.CENTER);
                lblVidas[i][j].setEnabled(true);
                lblVidas[i][j].setIcon(imgV);
                lblVidas[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                add(lblVidas[i][j]);
            }
        }
        

    }
    
    public void perdioVida(int i, int j){
        lblVidas[i][j].setIcon(imgVP);
    }
    
    public void reiniciar(){
         for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 3; j++) {
                lblVidas[i][j].setIcon(imgV);
            }
         }
        
    }

}
