import java.util.Scanner;

public class RaizCuadratica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a, b, c;
		double raiz1, raiz2;
		
		Scanner datoScanner = new Scanner(System.in);
		System.out.println("A continuacion ingrese el valor de a:");
		a = datoScanner.nextDouble();
		System.out.println("A continuacion ingrese el valor de b:");
		b = datoScanner.nextDouble();
		System.out.println("A continuacion ingrese el valor de c:");
		c = datoScanner.nextDouble();
		
		if((4*a*c)> (b*b)) {
			System.out.println("Las raices son imaginarias");
		}else if (a>0 || a<0){
			double temp = (b*b)-4*a*c;
			raiz1 = -b+ Math.pow(temp, 0.5);
			raiz1 = raiz1/(2*a);
			
			raiz2 = ((-b)-(Math.pow(temp, 0.5)))/(2*a);
			System.out.println("La primera raiz es: "+ raiz1);
			System.out.println("La segunda raiz es: "+ raiz2);
		}
		
//2x^2+9x+10 = 0
	}

}
