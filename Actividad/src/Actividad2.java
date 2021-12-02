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

public class Actividad2 extends JFrame implements ActionListener{

	JLabel lblNumero1;
	JTextField txtnumero1;
	JButton btnLimpiar;
	JButton btnCalcular;
	
	JLabel lblRaiz;
	JLabel lblCuadrado;
	JLabel lblBinario;
	
	JLabel lblRtaRaiz;
	JLabel lblRtaCuadrado;
	JLabel lblRtaBinario;
	
	public void iniciar() {
		// TODO Auto-generated constructor stub
		
        //setLayout(new FlowLayout());
		
		//crear el panel
		JPanel c1 = new JPanel();
		JPanel c2 = new JPanel();
		JPanel c3 = new JPanel();
		
		//instanciar
		lblNumero1 = new JLabel("Numero: ");
		txtnumero1 = new JTextField(10);
		lblNumero1.setForeground(new Color(5,95,118));
		
		c1.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Operandos")));

		c1.add(lblNumero1);
		c1.add(txtnumero1);
		c1.setBounds(10, 10, 400, 90);
		c1.setLayout(new GridLayout(2, 2));
		c1.setBackground(Color.white);
		
		lblRaiz = new JLabel("Raiz cuadrada:");		
		lblCuadrado = new JLabel("Cuadrado:");
		lblBinario = new JLabel("Binario:");
		
		lblRaiz.setForeground(new Color(5,95,118));
		lblCuadrado.setForeground(new Color(5,95,118));
		lblBinario.setForeground(new Color(5,95,118));
		
		lblRtaRaiz = new JLabel("");
		lblRtaCuadrado = new JLabel("");
		lblRtaBinario = new JLabel("");
		
		c2.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Resultados")));
        c2.setLayout(new GridLayout(3, 2));
        c2.setBackground(Color.white);
		
		c2.add(lblRaiz); c2.add(lblRtaRaiz);
		c2.add(lblCuadrado); c2.add(lblRtaCuadrado);
		c2.add(lblBinario); c2.add(lblRtaBinario);
		
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
		Actividad2 actividad = new Actividad2();
		actividad.iniciar();
	}
	
	public String binario(int numero) {
		String binarioString = "";
		
		int aux =  numero;
		while(aux/2 != 0) {
			
			binarioString = aux%2 + binarioString;
			aux = aux/2;
		}
		binarioString = aux%2 + binarioString;
		return binarioString;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnLimpiar) {
			
			txtnumero1.setText("");
			lblRtaRaiz.setText("");
			lblRtaCuadrado.setText("");
			lblRtaBinario.setText("");
			
			
		}else {
			
			lblRtaRaiz.setText((Math.sqrt(Double.parseDouble(txtnumero1.getText()))+ "") );
			lblRtaCuadrado.setText(Math.pow(Double.parseDouble(txtnumero1.getText()), 2) +"");
			lblRtaBinario.setText(binario(Integer.parseInt(txtnumero1.getText())) );
			
		}
	}
}
