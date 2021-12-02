package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import controlador.Controlador;
 
public class PanelGrilla extends JPanel
{
 // Constantes
    private static final String BLOCK = "data/Block.gif";
    
 // Atributos de la clase 		
    private JLabel lblMundo[][];
    private ImageIcon imgCell;
    //private ImageIcon imgBlock;
        
 // Relaciones   
    private Controlador controlador;
    /**
     * Constructor
     */    
    public PanelGrilla( Controlador controlador) 
    {   	
    // ..............................................( T, L, B, R ).............................................
       setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
       setLayout( new GridLayout(35, 35) );
    
       this.imgCell = new ImageIcon( BLOCK );
       
    // Enlaza el Controlador y el Panle de Simulación
       this.controlador = controlador;
       
              
    // Instancia atributos de la clase   
       lblMundo = new JLabel[35][35];
              
    // Agrega los atributos al panel   
       for(int i=0;i<35;i++)
    	for(int j=0;j<35;j++)
    	{ lblMundo[i][j] = new JLabel( "" );
    	  lblMundo[i][j].setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
    	  lblMundo[i][j].setHorizontalAlignment( JLabel.CENTER );
    	  lblMundo[i][j].setVerticalAlignment( JLabel.CENTER );
    	  lblMundo[i][j].setEnabled( true );
    	  lblMundo[i][j].addMouseListener( new LabelClicMouse( i, j, lblMundo[i][j], controlador, this ) );
    	  add(lblMundo[i][j]);    	  
        }       
    }

    public void removeLabelClicMouse()
    { for(int i=0;i<35;i++)
       for(int j=0;j<35;j++)
       {   lblMundo[i][j].removeMouseListener( lblMundo[i][j].getMouseListeners()[0] );
       }	
    }
    
}

/**
 * Controlador de eventos del Mouse
 * @author Giovanni Fajardo Utria
 */
class LabelClicMouse extends MouseAdapter 
{  
   private static final String BLOCK = "data/Block.gif";
   
   private JLabel label;
   private Controlador ctrl;
   private int x, y;
   private ImageIcon imgCell;
   private PanelGrilla pnlMundo;
   
   public LabelClicMouse( int x, int y, JLabel label, Controlador ctrl, PanelGrilla pnlMundo )
   { this.label = label;
     this.ctrl = ctrl;
     this.x = x; this.y = y;
     this.imgCell = new ImageIcon( BLOCK );
     this.pnlMundo = pnlMundo;
   }	
   
   public void mouseClicked(MouseEvent evento)
   {
       if (evento.isShiftDown())
       {   if (evento.isMetaDown())	// Shif+Boton derecho    	                
	       {  
	       }
	       else // Shift+Boton Izquierdo
           {	 
           }
       }
       else 
       { if (evento.isMetaDown())  // boton derecho del raton - Pone celulas o Quita celulas
         {   if ((label.getText()).equals( "" ) && label.getIcon() == null)
             {    label.setIcon( imgCell ); System.out.println("Ponen celula: LabelClicMouse(" + x + "," + y + ")" ); 
                  ctrl.putCell( x, y, "C");
                  
             }
             else
             if (label.getIcon() != null)
             {   label.setIcon( null ); System.out.println("Quitar celula: LabelClicMouse(" + x + "," + y + ")" ); 
                 ctrl.putCell( x, y, "-");
                 
             }      
             else
             {                
             }    
         }
        else
        { if ( evento.isAltDown() )  // boton medio del raton
          {    
          }
          else  // boton izquierdo 
          {           
          }
        }
      }
   }   
}