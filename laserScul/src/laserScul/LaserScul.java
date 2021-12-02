package laserScul;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LaserScul {

	public static void main(String[] args) throws IOException{
		pc2Read();

	}
	public static void process(String vecTam[], String vec[]) {
		int ultimo = Integer.parseInt(vecTam[0]);
		int contador = 0;
		for (int i = 0; i < vec.length; i++) {
			int siguiente = Integer.parseInt(vec[i]);
			if(ultimo > siguiente) {
				contador += (ultimo - siguiente);
			}
			ultimo = siguiente;
		}
		
		System.out.println(contador);

	}

	public static void pc2Read() throws IOException {
		String line, vecTam[] = null, vec[] = null;
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			line = buffer.readLine();
			while(!line.equals("0 0") ) {
				vecTam = line.split(" ");
				if((line = buffer.readLine()).length() > 0) {
				 vec = line.split(" ");
				 process(vecTam, vec);
				}
				line = buffer.readLine();
			}
			
		}catch(NullPointerException e) {
			
		}
		buffer.close();
	}

}