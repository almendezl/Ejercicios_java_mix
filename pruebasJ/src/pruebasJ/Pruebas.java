package pruebasJ;

import java.lang.invoke.ConstantCallSite;
import java.util.zip.Inflater;

public class Pruebas {
	

	public static void main(String[] args) {
		
		int ts[] = {};
		System.out.println(ts.length);
		//System.out.println(computeClosestToZero(ts));
		System.out.println(""+exists(ts, 10));
		
		String string = "hola \n hole";
		String array[]= string.split("\n");
		System.out.println(2>>1);
		int i = 0;
		System.out.println(i+++ "Este");
		System.out.println(computeCheckDigit("39847"));
		int num[]= {1,6,4,8,2};
		System.out.println(findSmallestInterval(num));
	}
	public static int computeClosestToZero(int[] ts) {
		if (ts.length == 0) {
			return 0;
		}
		int cercano;
		cercano = Math.abs(0-Math.abs(ts[0]));
		String signo = 0-ts[0] < 0 ?"+": "-";
		
		int iguales = 0;
		//System.out.println(cercano);
        for (int i = 1; i < ts.length; i++) {
			int aux = Math.abs(0-Math.abs(ts[i]));
			String signoaux = 0-ts[i] < 0 ?"+": "-";
			//System.out.println(signoaux);
			if (aux < cercano) {
				cercano = aux;
				signo = signoaux;
			}else if (aux == cercano ) {
				
				iguales ++;
				if (!signo.equals(signoaux) && iguales >0) {
					signo = "+";
				}
			}
			//System.out.println(signo);
			
		}
        cercano = signo.equals("-")? cercano *-1: cercano;
        
        return cercano;
    }
	static boolean exists(int[] ints, int k) {
		try {
			if (ints == null) {
	            return false;

	        } else if (ints.length >= 0) {
	        	 int mid;
	        	 int ini = 0;
	        	 int fin = ints.length-1;
	             do{
	                 mid = (ini +fin)/2;
	                 if(ints[mid] == k){
	                     return true;
	                 }else if(ints[mid] > k){
	                     fin = mid - 1;
	                 }else{
	                     ini = mid+1;
	                 }
	             }while(ini <= fin);
	             return false;
	            

	        } 
	        return false;
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			return false;
		}
        
    }
	
	public static int computeCheckDigit(String identificationNumber) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
		String rta = "";
        if (identificationNumber.length()<= 12 && identificationNumber.length()>=1) {
        	int sumap = 0;
        	int sumai = 0;
        	for (int i = 0; i < identificationNumber.length(); i++) {
				if (i%2==0) {
					sumap += Character.getNumericValue(identificationNumber.charAt(i));
				}else {
					sumai += Character.getNumericValue(identificationNumber.charAt(i));
				}
				
			}
        	 rta +=(sumap*3+sumai);
        	// System.out.println(rta);
        	 //System.out.println(rta.charAt(rta.length()-1));
        	 
        }
        if (Character.getNumericValue(rta.charAt(rta.length()-1)) == 0) {
        	return 0;
        }
        return 10-Character.getNumericValue(rta.charAt(rta.length()-1));
    }
	
	public static int findSmallestInterval(int[] numbers) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
        if (numbers.length>=2 && numbers.length<=100000) {
        	//System.out.println("entro");
        	int salida = 0;
        	int menor= 0;
        	menor = Math.abs(numbers[0]-numbers[1]);
			salida = menor;
        	for (int i = 0; i < numbers.length; i++) {
        		
				for (int j = i+1; j < numbers.length; j++) {
					menor = Math.abs(numbers[i]-numbers[j]);
					
					//System.out.println(i);
					//int aux = Math.abs(numbers[i]-numbers[j]);
					//System.out.println(aux);
					if ( menor<salida) {
						salida = menor;
						//System.out.println(menor+"es menor");
					}
					
					
				}
			}
        	System.out.println(salida);
        	return salida;
        }
        return 0;
    }
}
