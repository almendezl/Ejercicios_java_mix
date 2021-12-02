package contScore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ContScore {
	public static void main(String[] args)  throws IOException{
		pc2Read();
	}
	public static void process(String vec[]) {
		Equipo equipos[] = new Equipo[vec.length];
		ScoreBoard score;
		for (int i = 0; i < vec.length; i++) {
			String aux [] = vec[i].split(" ");
			equipos[i] = new Equipo (Integer.parseInt(aux[0]), Integer.parseInt(aux[1]),
					Integer.parseInt(aux[2]), aux[3]);
		}
		score = new ScoreBoard(equipos);
		score.evaluar();
		score.ordenar();
	}
	public static void pc2Read() throws IOException {
		String line, vec[] = null, p="";
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(buffer.readLine()); //casos de prueba
			for(int i = 0; i < n; i++ ) {
				while(!(line = buffer.readLine()).isEmpty()) {
					p+=line+"\n";
				}
				vec = p.split("\n");
				process(vec);
			}
		}catch(NullPointerException e) {
			
		}
		buffer.close();
	}
}