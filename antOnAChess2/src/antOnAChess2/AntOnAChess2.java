package antOnAChess2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AntOnAChess2 {
	
	public static void main(String[] args)  throws IOException{
		pc2Read();
	}
	
	public static void process(String vec[]) {
		int num = Integer.parseInt(vec[0]);
		if (num == 1) {
			System.out.println("1 1");
			return;
		}
		int fila = 1;
		int diagonal = 1;
		
		while (!(num >= (diagonal - fila + 1) && num <= (diagonal + fila - 1) )) {
			//System.out.println("entro");
			fila++;
			diagonal = fila * fila - fila + 1;
		}
		if (num == diagonal) {
			System.out.println(fila + " " + fila);
			return;
		}
		if (fila % 2 == 0) {
			if (num < diagonal) {
				System.out.println((fila-(diagonal-num)) +" "+ fila);
			} else {
				System.out.println(fila+" "+ (fila - (num-diagonal)));
			}
		} else {
			if (num < diagonal) {
				System.out.println(fila +" "+ (fila - (diagonal - num)) );
			} else {
				System.out.println((fila - (num - diagonal)) +" "+ fila);
			}
		}
	}
	
	public static void pc2Read() throws IOException {
		String line, vec[] = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(!(line = buffer.readLine()).equals("0")) {
				vec = line.split(" ");
				process(vec);
			}
		}catch(NullPointerException e) {
			
		}
		buffer.close();
	}
}
