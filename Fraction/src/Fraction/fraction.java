package Fraction;

import java.util.*;

public class fraction {
	Scanner objSc = new Scanner(System.in);
	public int numerator, denominator;

	public int UCLN(int a, int b) {

		while (b > 0) {
			a = a % b;
			int tmp = a;
			a = b;
			b = tmp;
		}

		return a;
	}

	public void input() {
		
		System.out.print("Enter Numerator: ");
		numerator = objSc.nextInt();
		do {
			System.out.print("Enter Denominator: ");
			denominator = objSc.nextInt();
			if(denominator == 0)
				System.out.println("Denominator can not = 0, try again!");
		} while (denominator == 0);
	}
	
	public void show(fraction k) {
		System.out.println(k.numerator + "/" + k.denominator);
	}

	public void add(fraction k) {
		int num, deno, UC;
		num = this.numerator * k.denominator + this.denominator * k.numerator;
		deno = this.denominator * k.denominator;
		UC = UCLN(num, deno);

		System.out.println(this.numerator + "/" + this.denominator + " + " + k.numerator + "/" + k.denominator + " = "
				+ num/UC + "/" + deno/UC +" = "+(float)num/deno);
	}

	public void sub(fraction k) {
		int num, deno, UC;
		num = this.numerator * k.denominator - this.denominator * k.numerator;
		deno = this.denominator * k.denominator;
		UC = UCLN(num, deno);
		System.out.println(UC);
		System.out.println(this.numerator + "/" + this.denominator + " - " + k.numerator + "/" + k.denominator + " = "
				+ num + "/" + deno+" = "+(float)num/deno);
	}

	public void mul(fraction k) {
		int num, deno, UC;
		num = this.numerator * k.numerator;
		deno = this.denominator * k.denominator;
		UC = UCLN(num, deno);

		System.out.println(this.numerator + "/" + this.denominator + " * " + k.numerator + "/" + k.denominator + " = "
				+ num/UC + "/" + deno/UC+" = "+(float)num/deno);
	}

	public void div(fraction k) {
		int num, deno, UC;
		num = this.numerator * k.denominator;
		deno = this.denominator * k.numerator;
		UC = UCLN(num, deno);

		System.out.println(this.numerator + "/" + this.denominator + " : " + k.numerator + "/" + k.denominator + " = "
				+ num/UC + "/" + deno/UC+" = "+(float)num/deno);
	}
}
