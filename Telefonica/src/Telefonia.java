

public class Telefonia {

	public static void main(String[] args) {
		/**
		 * -------------ERLANG B
		 */
		
		int A = 24;
		int N = 36;
		
		
		//sumatoria
		double sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += ((A^i)/factorial(i));
		}
		System.out.println(sum);
		double P = ((A^N)/factorial(N))/(sum);
		
		System.out.println(P);
	}
	
	
	public static int factorial( int val) {
		int fac= 1;
		for (int i = 1; i <= val; i++) {
			fac*=i;
		}
		System.out.println(fac);
		return fac;
	}
}
