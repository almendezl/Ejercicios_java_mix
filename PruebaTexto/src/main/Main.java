package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("C:/prueba.txt");
		 BufferedReader buffer = new BufferedReader(file);
		 
		 String line = buffer.readLine();
		 System.out.println(line);
	}
}
