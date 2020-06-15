package quoc12;

import java.util.*;

public class deal {

	Scanner objSc = new Scanner(System.in);

	protected int id, amount;
	protected String day;
	protected double unitPrice, price;

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected int getAmount() {
		return amount;
	}

	protected void setAmount(int amount) {
		this.amount = amount;
	}

	protected String getDay() {
		return day;
	}

	protected void setDay(String day) {
		this.day = day;
	}

	protected double getUnitPrice() {
		return unitPrice;
	}

	protected void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	protected double getPrice() {
		return price;
	}

	protected void setPrice(double price) {
		this.price = price;
	}

	protected deal() {
		this.id = 0;
		this.amount = 0;
		this.day = "";
		this.unitPrice = 0;
		this.price = 0;
	}

	protected deal(int id, int amount, String day, double unitPrice, double price) {
		this.id = id;
		this.amount = amount;
		this.day = day;
		this.unitPrice = unitPrice;
		this.price = price;
	}

	protected void input() {
		System.out.print("Input ID deal: ");
		this.id = objSc.nextInt();
		System.out.print("Input Amount deal: ");
		this.amount = objSc.nextInt();
		System.out.print("Input day deal: ");
		objSc.nextLine();
		this.day = objSc.nextLine();
		System.out.print("Input Unit Price deal: ");
		this.unitPrice = objSc.nextInt();
	}

	public String toString() {
		return "\nID : " + String.valueOf(getId()) + "\nAmount: " + String.valueOf(getAmount()) + "\nDay: " + getDay()
				+ "\nUnit Price: " + String.valueOf(getUnitPrice());
	}
}
