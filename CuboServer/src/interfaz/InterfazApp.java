package interfaz;
import java.awt.*;
import javax.swing.*;
import controlador.*;
import util.Util;

/**
 * Interfaz principal de la aplicacion.
 */
public class InterfazApp extends JFrame
{   
 // Atributos de la clase.
    private Controlador ctrlControlador;
    private PanelCaras pnlIzquierdo, pnlFrontal, pnlDerecho;
    private PanelCaras pnlPosterior, pnlSuperior, pnlInferior;
    private PanelBotones pnlHorizontal, pnlTransversal, pnlVertical;
    private PanelSolucion pnlSolucion;
    private PanelExtensiones pnlExtensiones;
    private PanelPasos pnlPasos;
    private JMenuBar mbrAcerca;
    private JMenu mnuAcerca;
    private JMenuItem mitAcerca;
    private PanelClientes pnlCliente;
    
 // Constructor.
 /**
  *  Instancia los paneles de control de la aplicacion.
  *  @param ctrlControlador, referencia del controlador.
  */ 
    InterfazApp( Controlador ctrlControlador )  
    { setTitle( "Cubo de Erno Rubik 2*2*2   2D" );  
      getContentPane( ).setLayout( null );
   	
   // Integra el Controlador. 
      this.ctrlControlador = ctrlControlador;

   // Instancia controles de menu
      mbrAcerca = new JMenuBar( );
      mnuAcerca = new JMenu( );
      mitAcerca = new JMenuItem();
   	  
      mnuAcerca.setMnemonic( 'A' );
      mnuAcerca.setText( "Acerca de" );

      mitAcerca.setMnemonic( 'G' );
      mitAcerca.setText( "Preparado por: Giovanni Fajardo Utria." );
      
      mnuAcerca.add( mitAcerca );
      mbrAcerca.add( mnuAcerca );
      setJMenuBar( mbrAcerca );
      
   // Instancia los paneles-movimientos
      pnlHorizontal = new PanelBotones( this.ctrlControlador, 2, 1 );
      pnlHorizontal.setBounds( 39, 180, 30, 100 );
      pnlHorizontal.setToolTipText( " Horizontal " );
   	  
      pnlTransversal = new PanelBotones( this.ctrlControlador, 2, 1 );
      pnlTransversal.setBounds( 140, 79, 30, 100 );
      pnlTransversal.setToolTipText( " Transversal " );
   	  
      pnlVertical = new PanelBotones( this.ctrlControlador, 1, 2 );
      pnlVertical.setBounds( 171, 48, 100, 30 );   	  
      pnlVertical.setToolTipText( " Vertical " );
   	
   // Instancia los paneles-caras.    
      pnlSuperior = new PanelCaras(  );
      pnlSuperior.setBounds( 171, 79, 100, 100 );

      pnlIzquierdo = new PanelCaras(  );
      pnlIzquierdo.setBounds( 70, 180, 100, 100 );
      
      pnlFrontal = new PanelCaras(  );
      pnlFrontal.setBounds( 171, 180, 100, 100 );
      
      pnlDerecho = new PanelCaras(  );
      pnlDerecho.setBounds( 272, 180, 100, 100 );
      
      pnlPosterior = new PanelCaras(  );
      pnlPosterior.setBounds( 373, 180, 100, 100 );

      pnlInferior = new PanelCaras(  );
      pnlInferior.setBounds( 171, 281, 100, 100 );
  
   // Instancia panel de extensiones.
      pnlExtensiones = new PanelExtensiones( this.ctrlControlador );
      pnlExtensiones.setBounds( 39, 400, 435, 60 );
  
   // Instancia panel de solucion.
      pnlSolucion = new PanelSolucion();
      pnlSolucion.setBounds( 39, 460, 435, 60 );
      
   // Instancia panel de solucion.
      pnlPasos = new PanelPasos();
      pnlPasos.setBounds( 350, 48, 100, 100 );
      
      //Instancia del panel cliente
       pnlCliente = new PanelClientes();
      pnlCliente.setBounds( 480, 400, 150, 120 );
      
   // Organizar el panel principal.       
      getContentPane( ).add( pnlSuperior );
      getContentPane( ).add( pnlIzquierdo );
      getContentPane( ).add( pnlFrontal );
      getContentPane( ).add( pnlDerecho );
      getContentPane( ).add( pnlPosterior );
      getContentPane( ).add( pnlInferior );
      getContentPane( ).add( pnlHorizontal );
      getContentPane( ).add( pnlTransversal );
      getContentPane( ).add( pnlVertical );
      getContentPane( ).add( pnlExtensiones );
      getContentPane( ).add( pnlSolucion );
      getContentPane( ).add( pnlPasos );
      getContentPane( ).add( pnlCliente );
      
   // Conecta los objetos a controlar.   
      this.ctrlControlador.conectar( pnlIzquierdo, pnlFrontal, pnlDerecho, pnlPosterior, pnlSuperior, pnlInferior, pnlHorizontal, pnlTransversal, pnlVertical, pnlSolucion, pnlPasos, pnlCliente );
      
   // Establece atributos del frame.   
      setSize( 680, 620 );
      setResizable( false );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      Util.centrarVentana( this );
    }    

    //  Ejecucion.

 /**
  *  Inicia la ejecucion de la aplicacion.
  *  Instancia el controlador y posteriormente la interfaz.
  */  		
     public static void main(String args[])
     { InterfazApp frmMain = new InterfazApp( new Controlador( ) );
       frmMain.setVisible( true );
       frmMain.ctrlControlador.abrirSocket();
       
     }
    public Controlador getCtrlControlador() {
        return ctrlControlador;
    }

    public void setCtrlControlador(Controlador ctrlControlador) {
        this.ctrlControlador = ctrlControlador;
    }

    public PanelCaras getPnlIzquierdo() {
        return pnlIzquierdo;
    }

    public void setPnlIzquierdo(PanelCaras pnlIzquierdo) {
        this.pnlIzquierdo = pnlIzquierdo;
    }

    public PanelCaras getPnlFrontal() {
        return pnlFrontal;
    }

    public void setPnlFrontal(PanelCaras pnlFrontal) {
        this.pnlFrontal = pnlFrontal;
    }

    public PanelCaras getPnlDerecho() {
        return pnlDerecho;
    }

    public void setPnlDerecho(PanelCaras pnlDerecho) {
        this.pnlDerecho = pnlDerecho;
    }

    public PanelCaras getPnlPosterior() {
        return pnlPosterior;
    }

    public void setPnlPosterior(PanelCaras pnlPosterior) {
        this.pnlPosterior = pnlPosterior;
    }

    public PanelCaras getPnlSuperior() {
        return pnlSuperior;
    }

    public void setPnlSuperior(PanelCaras pnlSuperior) {
        this.pnlSuperior = pnlSuperior;
    }

    public PanelCaras getPnlInferior() {
        return pnlInferior;
    }

    public void setPnlInferior(PanelCaras pnlInferior) {
        this.pnlInferior = pnlInferior;
    }

    public PanelBotones getPnlHorizontal() {
        return pnlHorizontal;
    }

    public void setPnlHorizontal(PanelBotones pnlHorizontal) {
        this.pnlHorizontal = pnlHorizontal;
    }

    public PanelBotones getPnlTransversal() {
        return pnlTransversal;
    }

    public void setPnlTransversal(PanelBotones pnlTransversal) {
        this.pnlTransversal = pnlTransversal;
    }

    public PanelBotones getPnlVertical() {
        return pnlVertical;
    }

    public void setPnlVertical(PanelBotones pnlVertical) {
        this.pnlVertical = pnlVertical;
    }

    public PanelSolucion getPnlSolucion() {
        return pnlSolucion;
    }

    public void setPnlSolucion(PanelSolucion pnlSolucion) {
        this.pnlSolucion = pnlSolucion;
    }

    public PanelExtensiones getPnlExtensiones() {
        return pnlExtensiones;
    }

    public void setPnlExtensiones(PanelExtensiones pnlExtensiones) {
        this.pnlExtensiones = pnlExtensiones;
    }

    public PanelPasos getPnlPasos() {
        return pnlPasos;
    }

    public void setPnlPasos(PanelPasos pnlPasos) {
        this.pnlPasos = pnlPasos;
    }

    public JMenuBar getMbrAcerca() {
        return mbrAcerca;
    }

    public void setMbrAcerca(JMenuBar mbrAcerca) {
        this.mbrAcerca = mbrAcerca;
    }

    public JMenu getMnuAcerca() {
        return mnuAcerca;
    }

    public void setMnuAcerca(JMenu mnuAcerca) {
        this.mnuAcerca = mnuAcerca;
    }

    public JMenuItem getMitAcerca() {
        return mitAcerca;
    }

    public void setMitAcerca(JMenuItem mitAcerca) {
        this.mitAcerca = mitAcerca;
    }

    public PanelClientes getPnlCliente() {
        return pnlCliente;
    }

    public void setPnlCliente(PanelClientes pnlCliente) {
        this.pnlCliente = pnlCliente;
    }


		
}