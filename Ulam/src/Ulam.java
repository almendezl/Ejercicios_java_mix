import java.util.Scanner;

public class Ulam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;
		Scanner datoScanner = new Scanner(System.in);
		System.out.println("Ingrese el numero: ");
		numero = datoScanner.nextInt();
		if(numero>0) {
			
			while(numero != 1) {
				//System.out.println(numero);
				if(numero%2 == 0) {
					numero = numero/2;
				}else {
					numero = numero*3+1;
				}
				System.out.print(numero +" ");
			}
			
		}else {
			System.out.println("Por favor verifique el dato ingresado!!!");
		}

	}

}
