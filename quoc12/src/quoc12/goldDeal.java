package quoc12;

import java.util.*;

public class goldDeal extends deal {

	Scanner objSc = new Scanner(System.in);

	private String kind;

	protected String getKind() {
		return kind;
	}

	protected void setKind(String kind) {
		this.kind = kind;
	}

	protected goldDeal() {
		super();
		this.kind = "";
	}

	protected goldDeal(int id, int amount, String day, double unitPrice, double price, String kind) {
		super(id, amount, day, unitPrice, price);
		this.kind = kind;
	}

	public double calPrice() {
		return this.price = this.unitPrice * this.amount;
	}

	public void input() {
		super.input();
		System.out.print("Input Kind: ");
		this.kind = objSc.nextLine();
	}

	public String toString() {
		return "\nGold Deal: " + super.toString() + "\nKind of Gold: " + getKind() + "\nPrice: "
				+ String.valueOf(this.price);
	}

}
