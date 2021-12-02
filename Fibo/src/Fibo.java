
public class Fibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Fibo iterativo "+fibo(5));
		System.out.println("Fibo recursivo "+fiboRecursivo(5));
	}
	
	//0 1 1 2 3 5
/**
 * Iterativa
 */
static int fibo(int numero) {
	int inicio = 0, siguiente = 1, rta = 0;
	for (int i = 1; i < numero; i++) {
		rta = inicio + siguiente;
		inicio = siguiente;
		siguiente = rta;
	}
	return rta; 
}
	
/**
 * Recursiva
 */

static int fiboRecursivo(int numero) {
	if(numero > 1) {
		return fiboRecursivo(numero-1)+fiboRecursivo(numero-2);
	}else {
		if(numero == 1) return 1;
		else return 0;
	}
}
}
