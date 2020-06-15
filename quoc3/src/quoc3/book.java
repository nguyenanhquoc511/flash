package quoc3;

import java.util.*;

public class book {

	String title, author;
	int page;
	double price;

	book(String title, String author, int page, double price) {
		this.title = title;
		this.author = author;
		this.page = page;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	void updatePrice(double rate) {
		this.price += (this.price * rate);
	}

	String toAtring() {
		return ("Book { title = " + this.title + ", author = " + author + ", pages = " + String.valueOf(this.page)
				+ ", price = " + String.valueOf(this.price) + " }");
	}

}
