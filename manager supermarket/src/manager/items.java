package manager;

import java.util.*;

public abstract class items {

	Scanner objSc = new Scanner(System.in);

	private String id, name;
	private int amountLeft;
	private double unitPrice;

	public String getId() {
		return id;
	}

	public boolean setId(String id) {
		if (id.equalsIgnoreCase("")) {
			System.out.println("Can not empty, try again!!");
			return false;
		}
		this.id = id;
		return true;
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if (name.equalsIgnoreCase("")) {
			System.out.println("Can not empty, try again!!");
			return false;
		}
		this.name = name;
		return true;
	}

	public int getAmountLeft() {
		return amountLeft;
	}

	public boolean setAmountLeft(int amountLeft) {
		if (amountLeft < 0) {
			System.out.println("Can not < 0, try again!!");
			return false;
		}
		this.amountLeft = amountLeft;
		return true;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public boolean setUnitPrice(double unitPrice) {
		if (unitPrice <= 0) {
			System.out.println("Can not <= 0, try again!!");
			return false;
		}
		this.unitPrice = unitPrice;
		return true;
	}

	public items() {
		this.id = null;
		this.name = null;
		this.amountLeft = 0;
		this.unitPrice = 0;
	}

	public items(String id, String name, int amountLeft, double unitPrice) {
		this.id = id;
		this.name = name;
		this.amountLeft = amountLeft;
		this.unitPrice = unitPrice;
	}

	public void input() {
		String tmp;
		int tmp1;
		double tmp2;

		do {
			objSc.nextLine();
			System.out.print("Input ID: ");
			tmp = objSc.nextLine();
		} while (!setId(tmp));

		do {
			System.out.print("Input Name: ");
			tmp = objSc.nextLine();
		} while (!setName(tmp));

		do {
			System.out.print("Input Amount Left: ");
			tmp1 = objSc.nextInt();
		} while (!setAmountLeft(tmp1));

		do {
			System.out.print("Input Unit Price: ");
			tmp2 = objSc.nextDouble();
		} while (!setUnitPrice(tmp2));
	}

	public String toString() {
		return "\nID: " + this.id + "\nName: " + this.name + "\nAmount Left: " + String.valueOf(this.amountLeft)
				+ "\nUnit Price: " + String.valueOf(this.unitPrice) + "\nVAT: " + String.valueOf(calPriceVAT())
				+ "\nEvaluate: " + evaluate();
	}

	public abstract double calPriceVAT();

	public abstract String evaluate();

}
