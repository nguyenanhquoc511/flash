package quoc11;

import java.util.Scanner;

public class BookList {

	Book[] bk = new Book[100];
	int[] tick = new int[100];

	Scanner objSc = new Scanner(System.in);
	int countBooks;

	public void booklist() {
		countBooks = 0;
		for (int i = 0; i < 100; i++) {
			bk[i] = new Book();
			tick[i] = 0;
		}
	}

	public void AddBooks(int choose) {
		if (countBooks > 100)
			System.out.println("Not enough empty! ");
		else {
			if (choose == 1) {
				System.out.println("Add Text Book: ");
				TextBook TB = new TextBook();
				TB.input();
				TB.calPrice();
				bk[countBooks] = TB;
				tick[countBooks] = 1;
			} else {
				System.out.println("Add Reference Book: ");
				ReferenceBook RB = new ReferenceBook();
				RB.input();
				RB.calPrice();
				bk[countBooks] = RB;
				tick[countBooks] = 2;
			}
			countBooks++;
		}
	}

	public double sumPriceTB() {
		int sumTB = 0;
		for (int i = 0; i < countBooks; i++)
			if (tick[i] == 1)
				sumTB += bk[i].price;
		return sumTB;
	}

	public double sumPriceRB() {
		int sumRB = 0;
		for (int i = 0; i < countBooks; i++)
			if (tick[i] == 2)
				sumRB += bk[i].price;
		return sumRB;
	}

	public double averageUPR() {
		int count = 0;
		double sum = 0;
		for (int i = 0; i < countBooks; i++)
			if (tick[i] == 2) {
				count++;
				sum += bk[i].unitPrice;
			}
		return sum / count;
	}

	public void find(String pubCompany) {
		boolean check = false;
		for (int i = 0; i < countBooks; i++)
			if (bk[i].pubCompany.equalsIgnoreCase(pubCompany)) {
				check = true;
				System.out.println();
				System.out.println(bk[i].toString());
			}
		if (!check)
			System.out.println("Can not found!! ");
	}

	public void showInfo() {
		System.out.println();
		System.out.println("Show Information List Books: ");
		for (int i = 0; i < countBooks; i++) {
			System.out.println();
			System.out.println("Book " + (i + 1));
			System.out.println(bk[i].toString());
		}
		System.out.println();
		System.out.println("Sum Pice of Text Book: " + sumPriceTB());
		System.out.println();
		System.out.println("Sum Pice of Reference Book: " + sumPriceRB());
		System.out.println();
		System.out.println("Average Unit Price of Reference Book: " + averageUPR());
	}

}
