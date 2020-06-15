package quoc3;

import java.util.*;

public class demo {

	public static void main(String[] args) {
		String title, author;
		int page;
		double price, rate;
		Scanner objSc = new Scanner(System.in);

		System.out.println("Please input the title of book: ");
		title = objSc.nextLine();
		System.out.println("book's author: ");
		author = objSc.nextLine();
		System.out.println("book's total pages: ");
		page = objSc.nextInt();
		System.out.println("book's price: ");
		price = objSc.nextDouble();

		book bk = new book(title, author, page, price);

		System.out.println("The book's information: " + bk.toAtring());
		System.out.println("How much discount? ");
		rate = objSc.nextDouble();
		bk.updatePrice(rate);
		System.out.println("After update, The book's information: " + bk.toAtring());
	}

}
