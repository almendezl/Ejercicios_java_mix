package controlador;

import java.util.Scanner;

import mundo.Cuadrado;
import mundo.Figura;
import mundo.Triangulo;

public class Controlador {
	static Scanner datos = new Scanner(System.in);
	public Controlador() {
		
	}
	public void iniciar() {
		
		System.out.println("Cantidad de figuras a crear: ");
		Figura figuras[] = new Figura[datos.nextInt()];
		for (int i = 0; i < figuras.length; i++) {
			System.out.println("Seleccione la figura: \n Triangulo \nCuadrado");
			int fig = datos.nextInt();
			if(fig == 1) {
				System.out.println("Ingrese la base:");
				double base = datos.nextDouble();
				System.out.println("Ingrese la altura:");
				double altura = datos.nextDouble();
				figuras[i] = new Triangulo(base, altura);
			}else {
				System.out.println("Ingrese la base:");
				double base = datos.nextDouble();
				System.out.println("Ingrese la altura:");
				double altura = datos.nextDouble();
				figuras[i] = new Cuadrado(base, altura);
			}
		}
		
		for (int i = 0; i < figuras.length; i++) {
			System.out.println(figuras[i].toString());
		}
	}
	
}
