/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.*;
import javax.swing.*;

import controlador.Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazApp extends JFrame  implements ActionListener{

    // Relaciones
    private PanelGrilla pnlMundo;
    private PanelVidas pnlVidas;
    private PanelPistaH pnlPH;
    private PanelPistaV pnlPV;

    private Controlador ctrl;

    // Atributos   
    private JMenuBar mbrOpciones;
    private JMenu mnuAcerca;
    private JMenuItem mitAcerca;
    private JTextField txtarchivo;
    private JButton btnarchivo;

    // Constructor
    public InterfazApp(Controlador ctrl) {
        setTitle("Nonograma");
        getContentPane().setLayout(null);
        setBackground(Color.WHITE);
        setBounds(350, 180, 550, 600);

        // Enlaza el controlador	  
        this.ctrl = ctrl;
        txtarchivo = new JTextField(1);
        txtarchivo.setBounds(10, 10, 20, 20);
        txtarchivo.setText("0");
        
        btnarchivo = new JButton("Guardar");
        btnarchivo.setBounds(30, 10, 80, 20);
        btnarchivo.addActionListener(this);
        
        
        // Instancia la Grilla
        pnlMundo = new PanelGrilla(ctrl);
        pnlMundo.setBounds(120, 150, 350, 350);
        pnlMundo.setBackground(Color.WHITE);

        //Instancias el panel de vidas
        pnlVidas = new PanelVidas(ctrl);
        pnlVidas.setBounds(240, 10, 140, 40);
        pnlVidas.setBackground(Color.WHITE);
        pnlVidas.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        //Instancias el panel de pistas horizontales
        pnlPH = new PanelPistaH(ctrl);
        pnlPH.setBounds(120, 58, 350, 90);
        pnlPH.setBackground(new Color(102, 205, 170));
        pnlPH.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        //pnlPH.setBackground(Color.WHITE);

        //Instancias el panel de pistas horizontales
        pnlPV = new PanelPistaV(ctrl);
        pnlPV.setBounds(24, 150, 95, 350);
        pnlPV.setBackground(new Color(102, 205, 170));
        pnlPV.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        getContentPane().setBackground(Color.WHITE);
        // Organizar el panel principal 
        getContentPane().add(txtarchivo);
        getContentPane().add(btnarchivo);
        getContentPane().add(pnlMundo);
        getContentPane().add(pnlVidas);
        getContentPane().add(pnlPH);
        getContentPane().add(pnlPV);

        // Conecta controlador a los paneles   
        ctrl.conectar(pnlMundo, pnlVidas, pnlPH, pnlPV);


        setSize(550, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String args[]) {
        InterfazApp iApp = new InterfazApp(new Controlador());
        iApp.setVisible(true);

    }

    public JTextField getTxtarchivo() {
        return txtarchivo;
    }

    public void setTxtarchivo(JTextField txtarchivo) {
        this.txtarchivo = txtarchivo;
    }

    public JButton getBtnarchivo() {
        return btnarchivo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == getBtnarchivo()){ //cuando se oprime el boton guardar se cargan los datos del archivo
            ctrl.getNonograma().llenarMatriz(txtarchivo.getText());
            ctrl.iniciar();
            
        }
    }

}
