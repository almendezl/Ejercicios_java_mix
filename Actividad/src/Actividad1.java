import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Actividad1 extends JFrame implements ActionListener{
	
	JLabel lblNumero1;
	JLabel lblNumero2;
	JTextField txtnumero1;
	JTextField txtnumero2;
	JButton btnLimpiar;
	JButton btnCalcular;
	
	JLabel lblSuma;
	JLabel lblResta;
	JLabel lblMultiplicacion;
	JLabel lblDivision;
	
	JLabel lblRtaSuma;
	JLabel lblRtaResta;
	JLabel lblRtaMultiplicacion;
	JLabel lblRtaDivision;
	
	public void iniciar() {
		// TODO Auto-generated constructor stub
		
        //setLayout(new FlowLayout());
		
		//crear el panel
		JPanel c1 = new JPanel();
		JPanel c2 = new JPanel();
		JPanel c3 = new JPanel();
		
		//instanciar
		lblNumero1 = new JLabel("Primer numero: ");
		lblNumero2 = new JLabel("Segundo numero: ");
		txtnumero1 = new JTextField(10);
		txtnumero2 = new JTextField(10);
		lblNumero1.setForeground(new Color(5,95,118));
		lblNumero2.setForeground(new Color(5,95,118));
		
		c1.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Operandos")));

		c1.add(lblNumero1);
		c1.add(txtnumero1);
		c1.add(lblNumero2);
		c1.add(txtnumero2);
		c1.setBounds(10, 10, 400, 90);
		c1.setLayout(new GridLayout(2, 2));
		c1.setBackground(Color.white);
		
		lblSuma = new JLabel("Suma:");		
		lblResta = new JLabel("Resta:");
		lblMultiplicacion = new JLabel("Multiplicacion:");
		lblDivision = new JLabel("Division:");
		lblSuma.setForeground(new Color(5,95,118));
		lblResta.setForeground(new Color(5,95,118));
		lblMultiplicacion.setForeground(new Color(5,95,118));
		lblDivision.setForeground(new Color(5,95,118));
		
		lblRtaSuma = new JLabel("");
		lblRtaResta = new JLabel("");
		lblRtaMultiplicacion = new JLabel("");
		lblRtaDivision = new JLabel("");
		
		c2.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Resultados")));
        c2.setLayout(new GridLayout(4, 2));
        c2.setBackground(Color.white);
		
		c2.add(lblSuma); c2.add(lblRtaSuma);
		c2.add(lblResta); c2.add(lblRtaResta);
		c2.add(lblMultiplicacion); c2.add(lblRtaMultiplicacion);
		c2.add(lblDivision); c2.add(lblRtaDivision);
		
		c2.setBounds(10, 110, 400, 90);
		
		btnLimpiar = new JButton("Limpiar");
		btnCalcular = new JButton("Calcular");
		
		btnCalcular.addActionListener(this);
		//btnCalcular.setBackground(Color.GRAY);
		btnLimpiar.addActionListener(this);
		
		//c3.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
		
		c3.add(btnLimpiar);
		c3.add(btnCalcular);
		c3.setBounds(10, 210, 400, 40);
		c3.setBackground(Color.white);
		
		Container c = getContentPane();
        c.setLayout(null);
        setBounds(350, 180, 440, 305);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Operaciones");
        setVisible(true);
        setBackground(Color.white);
        c.setBackground(Color.white);
        
        c.add(c1);
        c.add(c2);
        c.add(c3);
		
	}
	
	public static void main(String[] args) {
		Actividad1 actividad = new Actividad1();
		actividad.iniciar();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnLimpiar) {
			
			txtnumero1.setText("");
			txtnumero2.setText("");
			lblRtaSuma.setText("");
			lblRtaResta.setText("");
			lblRtaMultiplicacion.setText("");
			lblRtaDivision.setText("");
			
			
		}else {
			
			lblRtaSuma.setText((Double.parseDouble(txtnumero1.getText())+ Double.parseDouble(txtnumero2.getText())+ "") );
			lblRtaResta.setText((Double.parseDouble(txtnumero1.getText())- Double.parseDouble(txtnumero2.getText())+ "") );
			lblRtaMultiplicacion.setText((Double.parseDouble(txtnumero1.getText())* Double.parseDouble(txtnumero2.getText())+ "") );
			lblRtaDivision.setText((Double.parseDouble(txtnumero1.getText()) / Double.parseDouble(txtnumero2.getText())+ "") );
			
		}
		
	}
	
	

}
