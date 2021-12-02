/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import interfaz.PanelGrilla;
import interfaz.PanelPistaH;
import interfaz.PanelPistaV;
import interfaz.PanelVidas;
import mundo.Nonograma;

public class Controlador{

    private PanelGrilla pnlGrilla;
    private Nonograma nonograma;
    private PanelVidas pnlVidas;
    private PanelPistaH pnlPH;
    private PanelPistaV pnlPV;

    
    // Constructor  
    public Controlador() {
        nonograma = new Nonograma(this);

    }

    public void conectar(PanelGrilla pnlGrilla, PanelVidas pnlVidas, PanelPistaH pnlPH, PanelPistaV pnlPV) {
        this.pnlGrilla = pnlGrilla;
        this.pnlVidas = pnlVidas;
        this.pnlPH = pnlPH;
        this.pnlPV = pnlPV;
        
    }

    public void quitarValor() {
        nonograma.quitarValor();
    }

    public void iniciar() {
        //inicia con los datos del archivo plano
        //enviar las pistas horizontales
        pnlPH.llenar(nonograma.getPistasH());
        //enviar las pistas verticales
        pnlPV.llenar(nonograma.getPistasV());
    }

    public PanelGrilla getPnlGrilla() {
        return pnlGrilla;
    }

    public void setPnlGrilla(PanelGrilla pnlGrilla) {
        this.pnlGrilla = pnlGrilla;
    }

    public Nonograma getNonograma() {
        return nonograma;
    }

    public void setNonograma(Nonograma nonograma) {
        this.nonograma = nonograma;
    }

    public PanelVidas getPnlVidas() {
        return pnlVidas;
    }

    public void setPnlVidas(PanelVidas pnlVidas) {
        this.pnlVidas = pnlVidas;
    }

    public PanelPistaH getPnlPH() {
        return pnlPH;
    }

    public void setPnlPH(PanelPistaH pnlPH) {
        this.pnlPH = pnlPH;
    }

    public PanelPistaV getPnlPV() {
        return pnlPV;
    }

    public void setPnlPV(PanelPistaV pnlPV) {
        this.pnlPV = pnlPV;
    }


}
