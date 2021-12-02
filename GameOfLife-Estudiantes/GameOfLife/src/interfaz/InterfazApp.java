package interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import controlador.Controlador;
import util.Util;


public class InterfazApp extends JFrame
{   
 // Relaciones
    private PanelGrilla pnlMundo;
    
    private Controlador ctrl;

 // Atributos   
    private JMenuBar mbrOpciones;
    private JMenu mnuAcerca;
    private JMenuItem mitAcerca;
    
 // Constructor
    public InterfazApp( Controlador ctrl ) 
    { setTitle( "Game of Life" );  
      getContentPane( ).setLayout( null );
   
   // Enlaza el controlador	  
      this.ctrl = ctrl;
   	  
   // Instancia controles de menu
      mbrOpciones = new JMenuBar( );

   // Acerca de..
      mnuAcerca = new JMenu( );
      mnuAcerca.setMnemonic( 'A' );   	  
      mnuAcerca.setText( "About" );

      mitAcerca = new JMenuItem();
      mitAcerca.setMnemonic( 'G' );
      mitAcerca.setText( "Author: Giovanni Fajardo Utria." );
      
      mnuAcerca.add( mitAcerca );
      mbrOpciones.add( mnuAcerca );
                 
      setJMenuBar( mbrOpciones );          
      
   // Instancia los paneles    
      pnlMundo = new PanelGrilla( ctrl );
      pnlMundo.setBounds( 10, 10, 730, 490  );

     
   // Organizar el panel principal 
      getContentPane( ).add( pnlMundo );
      
      
   // Conecta controlador a los paneles   
      ctrl.conectar(pnlMundo);
      
      setSize( 915, 555);     
      setResizable( false );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
      Util.centrarVentana( this );
    }    
    
//  Ejecucion.		
    public static void main( String args[] )
    { InterfazApp frmMain = new InterfazApp( new Controlador() );
      frmMain.setVisible( true );	  
    }    
		
}