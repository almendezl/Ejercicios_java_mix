package steps;

import java.util.Stack;

public class Steps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static void process(String vec[]) {
	
	int total = Integer.parseInt(vec[1]) - Integer.parseInt(vec[0]);
	if (total == 1 && total == 2 && total == 3) {
		System.out.println(total); return;}

	Stack <Integer> p = new Stack<Integer>();
	Stack <Integer> p2 = new Stack<Integer>();	
	
	total -= 2; //le resta las dos puntas
	
	for(int i = 0; i <(total/2); i++) { //llenar las pilas
		p.add(1);
	}
	for(int i = (total/2); i <total; i++) {
		p2.add(1);
	}
	
	int step = 2;
	while(true) {
		
	}
	
}
}
