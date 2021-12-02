import java.text.DecimalFormat;
import java.util.Scanner;

public class RGB {
	static Scanner datoScanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			//System.out.println();
			System.out.println();
			System.out.println("ingrese el porcentaje");
			System.out.println();
			
			double valor = datoScanner.nextDouble();
			//System.out.println(valor);
			double var = 1-valor/100;
			System.out.println("porcentaje  sumar "+ var);
			System.out.println();
			DecimalFormat df = new DecimalFormat("#0.000");
			 //System.out.println(df.format(number));
			
			double rojo, verde, azul, amarillo, turquesa, morado;
			rojo = 0.3+0.59*var+0.11*var;
			verde = 0.3*var+0.59+0.11*var;
			azul = 0.3*var+0.59*var+0.11;
			amarillo = 0.3+0.59+0.11*var;
			turquesa = 0.3*var+0.59+0.11;
			morado = 0.3+0.59*var+0.11;
			
			System.out.println("Rojo     \t" + df.format(rojo));
			System.out.println("Verde    \t" + df.format(verde));
			System.out.println("Azul     \t" + df.format(azul));
			System.out.println("Amarillo \t" + df.format(amarillo));
			System.out.println("Turquesa \t" + df.format(turquesa));
			System.out.println("Morado   \t" + df.format(morado));
			
			
			
		}
		
	}

}
