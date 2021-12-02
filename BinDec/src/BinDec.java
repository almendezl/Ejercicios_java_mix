import java.util.Scanner;

public class BinDec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String binarioString;
		int decimal = 0;
		
		System.out.println("Ingrese el numero binario a convertir:");
		Scanner datoScanner = new Scanner(System.in);
		binarioString = datoScanner.next();
		
		for (int i = 0; i < binarioString.length(); i++) {
			if(binarioString.charAt(i) == '1') {
				decimal += Math.pow(2, i);
			} else if (binarioString.charAt(i) != '0') {
				System.out.println("revise el numero binario ingresado"); System.exit(0);
			}
		}
		System.out.println(decimal);
	}

}
