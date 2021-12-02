package posNumSys;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PosNumSys {

	public static void main(String[] args)  throws IOException{
		pc2Read();
	}
	public static void process(String vec[]) {
		switch(vec[0]) {
		case "8":
			System.out.println(octal(vec[1], vec[2]));
			break;
		case "2":
			System.out.println(binario(vec[1], vec[2]));
			break;
		case "5":
			System.out.println(cinco(vec[1], vec[2]));
			break;
		case "7":
			System.out.println(siete(vec[1], vec[2]));
			break;
		case "10":
			System.out.println(decimal(Integer.parseInt(vec[1]), Integer.parseInt(vec[2])));
			break;
		default:
			break;
		}
	}
	
	public static void pc2Read() throws IOException {
		String line, vec[] = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(!(line = buffer.readLine()).isEmpty()) {
				vec = line.split(" ");
				process(vec);
			}
		}catch(NullPointerException e) {
			
		}
		buffer.close();
	}
	
	public static int binario(String num1, String num2) {
		return decBase(decimal(convDec(num1, 2), convDec(num2, 2)), 2);
	}
	public static int cinco(String num1, String num2) {
		return decBase(decimal(convDec(num1, 5), convDec(num2, 5)), 5);
	}
	public static int octal(String num1, String num2) {
		return decBase(decimal(convDec(num1, 8), convDec(num2, 8)), 8);
	}
	public static int siete(String num1, String num2) {
		return decBase(decimal(convDec(num1, 7), convDec(num2, 7)), 7);
	}
	public static int decimal(int num1, int num2) {
		return num1+num2;
	}
	public static int convDec(String num, int base) {
		int aux = Integer.parseInt(num);
		int salida= 0;
		for(int i = 0;i<num.length();i++) {
			salida += aux%10*Math.pow(base, i);
			aux = aux/10;
		}
		return salida;
	}
	public static int decBase(int num, int base) {
		int i =0;
		int salida = 0;
		 do{
	            salida = (int)(num % base * Math.pow(10, i) + salida);
	            num = num / base;
	            i++;  
	            }while(num > 0);
		return salida;
	}
}