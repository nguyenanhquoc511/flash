package quoc11;

import java.util.*;

public class TextBook extends Book {
	public String status;
	Scanner objSc = new Scanner(System.in);

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TextBook() {
		super();
		this.status = "";
	}

	public TextBook(String id, String pubDate, double unitPrice, int amount, String pubCompany, double price,
			String status) {
		super(id, pubDate, unitPrice, amount, pubCompany, price);
		this.status = status;
	}

	public void calPrice() {
		if (getStatus().equalsIgnoreCase("new"))
			super.price = super.unitPrice * super.amount;
		else
			super.price = super.unitPrice * super.amount * 50 / 100;
	}

	public void input() {
		super.input();
		System.out.print("Input Status (New/Old): ");
		this.status = objSc.nextLine();
	}

	public String toString() {
		return super.toString() + "\nStatus: " + getStatus();
	}
}
