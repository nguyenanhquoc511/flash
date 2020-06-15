package quoc6;

import java.util.Scanner;

public class demo {
	
	String input1(String str) {
		String tmp;
		Scanner objSc = new Scanner(System.in);
		do {
			System.out.print("Input"+ str + ": ");
			tmp = objSc.nextLine();
			if(tmp.equals(""))
			System.out.println(str+" must not be empty, Try again!");
		} while(tmp.equals(""));
		return tmp;
	}
	
	double input2(String str) {
		double tmp;
		Scanner objSc = new Scanner(System.in);
		do {
			System.out.print("Input"+ str + ": ");
			tmp = objSc.nextDouble();
			if(tmp <= 0)
				System.out.println(str+" must > 0, Try again!");
		} while(tmp<=0);
		return tmp;
	}
	
	String input3(String str, s) {
		String tmp;
		Scanner objSc = new Scanner(System.in);
		do {
			System.out.print("Input"+ str + ": ");
			tmp = objSc.nextLine();
			if(tmp.equals(""))
			System.out.println(str+" must not be empty, Try again!");
		} while(tmp.equals(""));
		return tmp;
	}
	
	public static void main(String[] args) {
		demo k = new demo();
		String id, name, dateOfMan, due;
		double price;
		id = k.input1("ID");
		name = k.input1("Name");
		dateOfMan = k.input1("Day");
		price = k.input2("Price");
		
	}

}
