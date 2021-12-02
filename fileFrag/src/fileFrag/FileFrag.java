package fileFrag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileFrag {

	public static void main(String[] args)  throws IOException{
		pc2Read();
	}
	public static void process(String vec[]) {
	    String max1 = "";
        String max2 = "";
        for (int i = 1; i < vec.length; i++) { //escoger los dos mayores
            if (vec[i].length() <= max1.length()) {
                if (vec[i].length() > max2.length()) {
                    max2 = vec[i];
                }
            } else {
                max1 = vec[i];
            }
        }

        for (int i = 0; i < max1.length(); i++) {
            if (max1.substring(i, i + 1).equals(max2.substring(0, 1))) { //si son iguales
                int p = 1;
                int m = i + 1;
                if (m < (max1.length()) && p < (max2.length())) {
                    while (max1.substring(m, m + 1).equals(max2.substring(p, p + 1))) { 
                        if (m == (max1.length() - 1)) {
                            max1 += max2.substring(p + 1, max2.length());
                            System.out.println(max1);
                            return;
                        }
                        m++;
                        p++;
                    }
                } else {
                    max1 += max2.substring(p, max2.length());
                }
            }
        }
        System.out.println(max1);

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
