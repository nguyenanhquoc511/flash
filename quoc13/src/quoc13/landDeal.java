package quoc13;

import java.util.*;

public class landDeal extends deal {
	Scanner objSc = new Scanner(System.in);
	private int kindLand;

	public int getKindLand() {
		return kindLand;
	}

	public boolean setKindLand(int kindLand) {
		if (kindLand < 1 || kindLand > 3) {
			System.out.println("Value not available: ");
			return false;
		}
		this.kindLand = kindLand;
		return true;
	}

	public landDeal() {
		super();
		this.kindLand = 0;
	}

	public landDeal(String id, String day, float sqard, double unitPrice, double price, int kindLand) {
		super(id, day, sqard, unitPrice, price);
		this.kindLand = kindLand;
	}

	public void input() {
		super.input();
		int tmp;
		do {
			System.out.print("Input Kind Land (1.A / 2.B / 3.C): ");
			tmp = objSc.nextInt();
		} while (!setKindLand(tmp));
	}

	public char kindL(int kindLand) {
		if (kindLand == 1)
			return 'A';
		else if (kindLand == 2)
			return 'B';
		else
			return 'C';
	}

	public double calPrice(int kindLand) {
		if (kindLand == 1)
			return super.price = super.unitPrice * super.sqard * 1.5;
		else
			return super.price = super.unitPrice * super.sqard;
	}

	public String toString() {
		return "Land deal: " + super.toString() + "\nKind land: " + kindL(this.kindLand) + "\nPrice: "
				+ String.valueOf(super.price);
	}
}
