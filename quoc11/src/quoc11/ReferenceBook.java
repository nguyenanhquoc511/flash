package quoc11;

import java.util.Scanner;

public class ReferenceBook extends Book {
	public double VAT;
	Scanner objSc = new Scanner(System.in);

	public double getVAT() {
		return VAT;
	}

	public void setVAT(double vAT) {
		VAT = vAT;
	}

	public ReferenceBook() {
		super();
		this.VAT = 0;
	}

	public ReferenceBook(String id, String pubDate, double unitPrice, int amount, String pubCompany, double price,
			double VAT) {
		super(id, pubDate, unitPrice, amount, pubCompany, price);
		this.VAT = VAT;
	}

	public void calPrice() {
		super.price = super.unitPrice * super.amount + getVAT();
	}

	public void input() {
		super.input();
		System.out.print("Input VAT: ");
		this.VAT = objSc.nextDouble();
	}

	public String toString() {
		return super.toString() + "\nVAT: " + getVAT();
	}

}
