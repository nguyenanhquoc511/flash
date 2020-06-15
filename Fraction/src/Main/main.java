package Main;

import java.util.*;
import Fraction.fraction;

public class main {
	Scanner objSc = new Scanner(System.in);
	
	public void inputTwoFraction() {
		System.out.println("Input Two Fraction: ");
		System.out.println("Input Fraction 1: ");
		fraction fr1 = new fraction(); 
		fr1.input();
		System.out.println("\nInput Fraction 2: ");
		fraction fr2 = new fraction(); 
		fr2.input();
	}
	
	public void addTwoFraction() {
		System.out.println("Add two fractions");
		System.out.println("Input Two Fraction: ");
		System.out.println("Input Fraction 1: ");
		fraction fr1 = new fraction(); 
		fr1.input();
		System.out.println("\nInput Fraction 2: ");
		fraction fr2 = new fraction(); 
		fr2.input();
		fr1.add(fr2);
	}
	
	public void subTwoFraction() {
		System.out.println("Subtract two fractions");
		System.out.println("Input Two Fraction: ");
		System.out.println("Input Fraction 1: ");
		fraction fr1 = new fraction(); 
		fr1.input();
		System.out.println("\nInput Fraction 2: ");
		fraction fr2 = new fraction(); 
		fr2.input();
		fr1.sub(fr2);
	}
	
	public void mulTwoFraction() {
		System.out.println("Multiply two fractions");
		System.out.println("Input Two Fraction: ");
		System.out.println("Input Fraction 1: ");
		fraction fr1 = new fraction(); 
		fr1.input();
		System.out.println("\nInput Fraction 2: ");
		fraction fr2 = new fraction(); 
		fr2.input();
		fr1.mul(fr2);
	}
	
	public void divTwoFraction() {
		System.out.println("Divide two fractions");
		System.out.println("Input Two Fraction: ");
		System.out.println("Input Fraction 1: ");
		fraction fr1 = new fraction(); 
		fr1.input();
		System.out.println("\nInput Fraction 2: ");
		fraction fr2 = new fraction(); 
		fr2.input();
		fr1.div(fr2);
	}


	public static void main(String[] args) {
		Scanner objSc = new Scanner(System.in);
		int choose, con;
		main a = new main();
		
		
		do {
			System.out.println("\n1.Add two fractions\n2.Subtract two fractions\n3.Multiply two fractions\n4.Divide two fractions\n\nYour Choose: ");
			choose = objSc.nextInt();
			switch(choose) {
			case 1: a.addTwoFraction();
					break;
			case 2: a.subTwoFraction();
					break;
			case 3: a.mulTwoFraction();
					break;
			case 4: a.divTwoFraction();
					break;		
			default : System.out.println("Choose not available !");
			}
			do {
				System.out.println("Press 1 to continue, 0 to exit ! : ");
				con = objSc.nextInt();
				if(con < 0 || con > 1)
					System.out.println("Choose not available !");
			}while (con < 0 || con > 1);
		} while (con == 1);
		
	}
}




