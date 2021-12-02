package shiftRoL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShiftRoL {
	public static void main(String[] args) throws IOException {
		pc2Read();
	}

	public static void process(String vec[]) {
		int corr = Integer.parseInt(vec[0]);
		String vec2[] = new String[vec.length - 1];

		for (int i = 1; i < vec.length; i++) {
			if (i + corr - 1 >= 0 && i + corr - 1 < vec2.length) {
				vec2[i + corr - 1] = vec[i];
			} else {
				if (i + corr - 1 >= vec2.length) {
					vec2[i + corr - 1 - vec2.length] = vec[i];
				} else if (i + corr-1 < 0) {
					vec2[i + corr-1 + vec2.length] = vec[i];
				}
			}
		}
		imprimir(vec2);

	}

	public static void imprimir(String vec[]) {
		for (int i = 0; i < vec.length; i++) {
			if (i == vec.length - 1)
				System.out.println(vec[i]);
			else
				System.out.print(vec[i] + ",");
		}
	}

	public static void pc2Read() throws IOException {
		String line, vec[] = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (!(line = buffer.readLine()).isEmpty()) {
				vec = line.split(" ");
				process(vec);
			}
		} catch (NullPointerException e) {

		}
		buffer.close();
	}
}
