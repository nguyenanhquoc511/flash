package quoc11;

import java.util.*;

public class Book {

	public String id, pubDate, pubCompany;
	public double unitPrice, price;
	public int amount;

	Scanner objSc = new Scanner(System.in);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getPubCompany() {
		return pubCompany;
	}

	public void setPubCompany(String pubCompany) {
		this.pubCompany = pubCompany;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Book() {
		this.id = "";
		this.pubDate = "";
		this.pubCompany = "";
		this.amount = 0;
		this.unitPrice = 0;
		this.price = 0;
	}

	public Book(String id, String pubDate, double unitPrice, int amount, String pubCompany, double price) {
		this.id = id;
		this.pubDate = pubDate;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.pubCompany = pubCompany;
		this.price = price;
	}

	public void calPrice() {
		this.price = 0;
	}

	public void input() {
		System.out.print("Input ID: ");
		this.id = objSc.nextLine();
		System.out.print("Input Pubication Date: ");
		this.pubDate = objSc.nextLine();
		System.out.print("Input Unit Price: ");
		this.unitPrice = objSc.nextDouble();
		System.out.print("Input Amount: ");
		this.amount = objSc.nextInt();
		objSc.nextLine();
		System.out.print("Input Publication Company: ");
		this.pubCompany = objSc.nextLine();
	}

	public String toString() {
		return "ID: " + getId() + "\nPublication Date: " + getPubDate() + "\nUnit Price: "
				+ String.valueOf(getUnitPrice()) + "\nAmount: " + String.valueOf(getAmount())
				+ "\nPublication Company: " + getPubCompany();
	}
}
