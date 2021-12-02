/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import interfaz.PanelGrilla;


/**
 *
 * @author docentes
 */
public class Controlador 
{ // Relaciones
     private PanelGrilla pnlMundo;
     
    
  // Atributos
    
     
  // Constructor  
     public Controlador()
     {         
     }
     
     public void conectar(PanelGrilla pnlMundo) 
     { this.pnlMundo = pnlMundo;
       
     }
     
     public void putCell(int x, int y, String cell)
     {  System.out.println("ctrl: (" + x + "," + y + ") " + cell);      
     }        

     
}
