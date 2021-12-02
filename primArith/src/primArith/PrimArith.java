package primArith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimArith {

	
	public static void main(String[] args)  throws IOException{
		pc2Read();
	}
	public static void process(String vec[]) {
		int contador = 0;
		int suma1 = Integer.parseInt(vec[0])%10+Integer.parseInt(vec[1])%10;
		contador = suma1 >=10? ++contador: contador;
		int suma2 = Integer.parseInt(vec[0])/10%10 + Integer.parseInt(vec[1])/10%10;
		suma2 = contador>0? suma2++: suma2;
		contador = suma2 >=10? ++contador: contador;
		int suma3 = Integer.parseInt(vec[0])/10/10%10 + Integer.parseInt(vec[1])/10/10%10;
		suma3 = contador>1? suma3++: suma3;
		contador = suma3 >= 10? ++contador: contador;
		
		if(contador == 0) {
			System.out.println("No carry operation.");
		}else if (contador == 1){
			System.out.println(contador+" carry operation.");
		}else {
			System.out.println(contador+" carry operations.");
		}
		
	}
	
	public static void pc2Read() throws IOException {
		String line, vec[] = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(!(line = buffer.readLine()).equals("0 0")) {
				vec = line.split(" ");
				process(vec);
			}
		}catch(NullPointerException e) {
			
		}
		buffer.close();
	}
}
