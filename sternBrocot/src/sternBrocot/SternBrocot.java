package sternBrocot;

import java.util.Scanner;

public class SternBrocot {
	 public static boolean compare(int a, int b, int x, int y) {
		  if ((a+0.0)/b<(x+0.0)/y)
		   return true;
		  return false;
		 }

		  public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
		  while (true) {
		   int a = in.nextInt();
		   int b = in.nextInt();
		   if (a == 1 && b == 1)
		    break;
		   int x1 = 0, y1 = 1;
		   int x2 = 1, y2 = 0;
		   String res = "";
		   while (true) {
		    int c1 = x1 + x2, c2 = y1 + y2;    
		    if (a == c1 && b == c2)
		     break;
		    if (compare(a, b, c1, c2)) {// less than
		     res += "L";
		     x2 = c1;
		     y2 = c2;
		    } else {
		     res += "R";
		     x1 = c1;
		     y1 = c2;
		    }
		   }
		   System.out.println(res);
		  }

		  }

}
