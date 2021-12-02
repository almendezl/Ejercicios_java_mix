import java.util.Scanner;

public class Rectangulo {

	public static void main(String[] args) {
		double base, altura, re;
		Scanner datoScanner = new Scanner(System.in);
		System.out.println("Ingrese el numero de la base");
		
		base = datoScanner.nextDouble();
		
		System.out.println("Ingrese el numero de la altura");
		altura = datoScanner.nextDouble();
		
		re=altura*base;
		
		System.out.println("el resultdo es "+re);
		
		
	}
	
	
}
