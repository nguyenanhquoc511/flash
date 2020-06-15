package manager;

import java.util.*;

public class electricalItems extends items {

	Scanner objSc = new Scanner(System.in);
	private int guaranteeTime, wattage;

	public int getGuaranteeTime() {
		return guaranteeTime;
	}

	public boolean setGuaranteeTime(int guaranteeTime) {
		if (guaranteeTime < 0) {
			System.out.println("Can not < 0, Try again!!");
			return false;
		}
		this.guaranteeTime = guaranteeTime;
		return true;
	}

	public int getWattage() {
		return wattage;
	}

	public boolean setWattage(int wattage) {
		if (guaranteeTime < 0) {
			System.out.println("Can not <= 0, Try again!!");
			return false;
		}
		this.wattage = wattage;
		return true;
	}

	public electricalItems() {
		super();
		this.guaranteeTime = 0;
		this.wattage = 0;
	}

	public electricalItems(String id, String name, int amountLeft, double unitPrice, int guaranteeTime, int wattage) {
		super(id, name, amountLeft, unitPrice);
		this.guaranteeTime = guaranteeTime;
		this.wattage = wattage;
	}

	public void input() {
		int tmp;
		super.input();
		do {
			System.out.print("Input Guarantee Time: ");
			tmp = objSc.nextInt();
		} while (!setGuaranteeTime(tmp));

		do {
			System.out.print("Input Wattage: ");
			tmp = objSc.nextInt();
		} while (!setWattage(tmp));
	}

	public String toString() {
		return "Electrical Items" + super.toString() + "\nGuarantee Time: " + String.valueOf(this.guaranteeTime)
				+ "\nWattage: " + String.valueOf(this.wattage);
	}

	public double calPriceVAT() {
		return super.getUnitPrice() * 10 / 100;
	}

	public String evaluate() {
		return "Coming soon...";
	}
}
