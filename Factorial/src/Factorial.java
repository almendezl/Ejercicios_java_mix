
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorialRecursivo(5));
	}
	
	static int factorialRecursivo(int numero) {
		if(numero>1) {
			return numero*factorialRecursivo(numero-1);
		}else {
			return 1;
		}
	}

}
