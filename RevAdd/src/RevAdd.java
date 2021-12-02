import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RevAdd {
	public static void main(String[] args)  throws IOException{
		pc2Read();
	}
	public static void process(String vec[]) {
		
	}
	public static int reversa(int num) {

	}
	
	public static void pc2Read() throws IOException {
		String line, vec[] = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(buffer.readLine()); //casos de prueba
			for(int i = 0; i < n; i++ ) {
				while(!(line = buffer.readLine()).isEmpty()) {
					vec[i] = buffer.readLine();
				}
				process(vec);
			}
			
			
		}catch(NullPointerException e) {
			
		}
		buffer.close();
	}
}
