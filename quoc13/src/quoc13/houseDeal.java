package quoc13;

import java.util.*;

public class houseDeal extends deal {
	Scanner objSc = new Scanner(System.in);
	private String address;
	private int kindHouse;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getKindHouse() {
		return kindHouse;
	}

	public boolean setKindHouse(int kindHouse) {
		if (kindHouse < 1 || kindHouse > 2) {
			System.out.println("Value not available: ");
			return false;
		}
		this.kindHouse = kindHouse;
		return true;
	}

	public houseDeal() {
		super();
		this.address = "";
		this.kindHouse = 0;
	}

	public houseDeal(String id, String day, float sqard, double unitPrice, double price, String address,
			int kindHouse) {
		super(id, day, sqard, unitPrice, price);
		this.address = address;
		this.kindHouse = kindHouse;
	}

	public void input() {
		super.input();
		System.out.print("Input Address: ");
		this.address = objSc.nextLine();
		int tmp;
		do {
			System.out.print("Input Kind House (1.Nomal / 2.VIP): ");
			tmp = objSc.nextInt();
		} while (!setKindHouse(tmp));
	}

	public String kindH(int kindHouse) {
		if (kindHouse == 1)
			return "Nomal";
		else
			return "VIP";

	}

	public double calPrice(int kindHouse) {
		if (kindHouse == 1)
			return super.price = super.unitPrice * super.sqard * 90 / 100;
		else
			return super.price = super.unitPrice * super.sqard;
	}

	public String toString() {
		return "House deal: " + super.toString() + "\nKind House: " + kindH(this.kindHouse) + "\nAddress: "
				+ this.address + "\nPrice: " + String.valueOf(super.price);
	}
}
