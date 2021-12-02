import java.util.Scanner;

public class Palindromo {

	public static void main(String[] args) {
		String palabra, comprobacion = "";
		System.out.println("Ingrese la palabra");
		Scanner datoScanner = new Scanner(System.in);
		palabra = datoScanner.next();
		
		for (int i = 0; i < palabra.length(); i++) {
			comprobacion = palabra.charAt(i)+comprobacion;
			
		}
		if(palabra.equals(comprobacion)) {
			System.out.println("Si es un palindromo!!!");
		}else {
			System.out.println("No es un palindromo!!!");
		}
	}

}
