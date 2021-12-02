/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crearUser.interfaz;


import javax.swing.JFrame;
import crearUser.win.Win;

public class InterfazUser extends JFrame
{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// Relaciones
    private PanelUser pnlUser;

    public InterfazUser()
    {// Configura layout  
        setTitle( "Registro de usuarios : TuLlave" );   
        getContentPane( ).setLayout( null );
      
     // Instancia los paneles  
        pnlUser = new PanelUser();
        pnlUser.setBounds(5, 10, 530, 190);
      
     // Organizar el panel principal 
        getContentPane( ).add( pnlUser);
      
        setSize( 350, 210 );      
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
     // Centrar ventana.
        Win.centrarVentana( this );       
    }   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    { InterfazUser interfazUser = new InterfazUser();
      interfazUser.setVisible(true);
        }
    
}
