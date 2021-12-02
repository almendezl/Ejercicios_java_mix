/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.*;
import controlador.Controlador;

public class PanelGrilla extends JPanel {


    private static final String NEGRO = "data/negro.gif";
    private static final String X = "data/xn.gif";

    // Atributos de la clase 		
    private JLabel lblMundo[][];
    private ImageIcon imgNegro;
    private ImageIcon imgX;

    // Relaciones   
    private Controlador controlador;

    public PanelGrilla(Controlador controlador) {
        setLayout(new GridLayout(10, 10));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.imgNegro = new ImageIcon(NEGRO);
        this.imgX = new ImageIcon(X);

        //enlazar con el controlador
        this.controlador = controlador;
        // Instancia atributos de la clase 
        lblMundo = new JLabel[10][10];

        // Agrega los atributos al panel   
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                lblMundo[i][j] = new JLabel("");
                lblMundo[i][j].setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
                lblMundo[i][j].setHorizontalAlignment(JLabel.CENTER);
                lblMundo[i][j].setVerticalAlignment(JLabel.CENTER);
                lblMundo[i][j].setEnabled(true);
                lblMundo[i][j].addMouseListener(new LabelClicMouse(i, j, lblMundo[i][j], controlador, this));
                add(lblMundo[i][j]);
            }
        }

    }

    public void reiniciar() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                lblMundo[i][j].setIcon(null);

            }
        }
    }

    public void cambiarValorCelda(int i, int j, String valor) {
        if (valor.equals("0")) {
            lblMundo[i][j].setIcon(imgNegro);
        } else {
            lblMundo[i][j].setIcon(imgX);
        }
    }

}

class LabelClicMouse extends MouseAdapter {

    private static final String NEGRO = "data/negro.gif";
    private static final String X = "data/xn.gif";

    private JLabel label;
    private Controlador ctrl;
    private int x, y;
    private ImageIcon imgNegro;
    private ImageIcon imgX;
    private PanelGrilla pnlMundo;

    public LabelClicMouse(int x, int y, JLabel label, Controlador ctrl, PanelGrilla pnlMundo) {
        this.label = label;
        this.ctrl = ctrl;
        this.x = x;
        this.y = y;
        this.imgNegro = new ImageIcon(NEGRO);
        this.imgX = new ImageIcon(X);
        this.pnlMundo = pnlMundo;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        if (evento.isShiftDown()) {
            if (evento.isMetaDown()) // Shif+Boton derecho    	                
            {
            } else // Shift+Boton Izquierdo
            {
            }
        } else {
            if (evento.isMetaDown()) // boton derecho del raton 
            {
                if ((label.getText()).equals("") && label.getIcon() == null) {
                    label.setIcon(imgNegro);
                    ctrl.getNonograma().jugar(x, y, "0");

                } else if (label.getIcon() != null) {
                    label.setIcon(null);
                    ctrl.quitarValor();

                } else {
                }
            } else {
                if (evento.isAltDown()) // boton medio del raton
                {
                } else // boton izquierdo 
                {
                    if ((label.getText()).equals("") && label.getIcon() == null) {

                        label.setIcon(imgX);
                        ctrl.getNonograma().jugar(x, y, "X");

                    } else if (label.getIcon() != null) {
                        label.setIcon(null);
                        ctrl.quitarValor();

                    } else {
                    }
                }
            }
        }
    }
}
