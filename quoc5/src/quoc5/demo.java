package quoc5;
import java.util.*;
public class demo {

	public static void main(String[] args) {
		Scanner objSc = new Scanner(System.in);
		int numerator, denominator;
		
		System.out.println("Input Fist rational:");
		System.out.print("Input numerator: ");
		numerator = objSc.nextInt();
		System.out.print("Input denominator: ");
		denominator = objSc.nextInt();
		rational rat1 = new rational(numerator, denominator);
		
		System.out.println("Input second rational:");
		System.out.print("Input numerator: ");
		numerator = objSc.nextInt();
		System.out.print("Input denominator: ");
		denominator = objSc.nextInt();
		rational rat2 = new rational(numerator, denominator);
		
		rat1.redure();
		rat1.output();
		rat2.redure();
		rat2.output();
		rat1.add(rat2);
		rat1.output();
		rat1.subtract(rat2);
		rat1.output();
		rat1.multiply(rat2);
		rat1.output();
		rat1.divide(rat2);
		rat1.output();
		rat1.compare(rat2);
	}

}
