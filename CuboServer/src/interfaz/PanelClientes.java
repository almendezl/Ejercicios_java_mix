/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Nicole
 */
public class PanelClientes extends JPanel {

    private JLabel lblIp;
    private JLabel lblName;
    private JTextField txtmov;
    private JButton btnEnviar;

    public PanelClientes() {
        // ..............................................( T, L, B, R ).............................................
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder(" Cliente ")));
        setLayout(new GridLayout(4,1));

        // Integra el controlador
        //this.ctrl = ctrl;          
        // Instancia atributos de la clase   
        lblIp = new JLabel("IP: ");
        lblName = new JLabel("Nombre: ");
        txtmov = new JTextField(4);
        btnEnviar = new JButton("Enviar");

        // Agrega los atributos al panel   
        add(lblIp);
        add(lblName);
        add(txtmov);
        add(btnEnviar);

    }

    public JLabel getLblIp() {
        return lblIp;
    }

    public void setLblIp(JLabel lblIp) {
        this.lblIp = lblIp;
    }

    public JLabel getLblName() {
        return lblName;
    }

    public void setLblName(JLabel lblName) {
        this.lblName = lblName;
    }

    public JTextField getTxtmov() {
        return txtmov;
    }

    public void setTxtmov(JTextField txtmov) {
        this.txtmov = txtmov;
    }

    public JButton getBtnEnviar() {
        return btnEnviar;
    }

    public void setBtnEnviar(JButton btnEnviar) {
        this.btnEnviar = btnEnviar;
    }
    
    
}
