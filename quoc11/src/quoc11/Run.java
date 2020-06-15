package quoc11;

import java.util.*;

public class Run {

	public static void main(String[] args) {
		Scanner objSc = new Scanner(System.in);
		BookList booklist = new BookList();
		booklist.booklist();

		int choose;
		String pubCompany;

		do {

			System.out.println("0. Exit");
			System.out.println("1. Add a Text Book");
			System.out.println("2. Add a Reference Book");
			System.out.println("3. Find information book by publication company");
			System.out.println("4. Show all Book");
			System.out.println();
			System.out.print("Your choose: ");
			choose = objSc.nextInt();

			switch (choose) {
			case 1:
				booklist.AddBooks(choose);
				break;
			case 2:
				booklist.AddBooks(choose);
				break;
			case 3: {
				System.out.print("Input Publication Company: ");
				objSc.nextLine();
				pubCompany = objSc.nextLine();
				booklist.find(pubCompany);
				break;
			}
			case 4:
				booklist.showInfo();
			}
			System.out.println();

		} while (choose != 0);
	}

}
