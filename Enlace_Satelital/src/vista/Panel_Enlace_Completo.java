package vista;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Panel_Enlace_Completo extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Panel_Enlace_Completo() {
		setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "Enlace Satelital" ) ) );
		setLayout(null);
		
		//graficar(getGraphics());
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLUE);
		//satelite
		g.fillRect(20, 100, 70, 30);
		g.fillRect(100, 100, 70, 30);
		
		//ET 1
		g.fillRect(20, 500, 70, 30);
		
		//ET 2
		g.fillRect(300, 500, 70, 30);
		g.fillRect(450, 500, 70, 30);
		
		g.setColor(Color.BLACK);
		//para estacion terrena
		int x[]={250,200,300};
		int y[]={450,530,530};
		g.drawPolygon(x,y,3);
		
		//el arco
		 g.drawArc(220, 300, 100, 100, 500, 180);
		  //g.fillArc(80, 140, 150, 150, 180, 250);
		
		
	}
}
