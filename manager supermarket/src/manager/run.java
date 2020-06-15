package manager;

import java.util.*;

public class run {

	public static void main(String[] args) {

		Scanner objSc = new Scanner(System.in);
		listItems list = new listItems();
		int choose, kind;

		do {
			
			System.out.println("\n0.Exit");
			System.out.println("1. Add a Items");
			System.out.println("2. Show Infomation");
			System.out.println();
			System.out.print("Your choose: ");
			choose = objSc.nextInt();

			switch (choose) {
			case 1:
				System.out.print(
						"\nChoose Kind of Items: \n1.Food Items \n2.Electrical Items \n3.Crokey Items \n\nYour choose: ");
				kind = objSc.nextInt();
				list.inputItems(kind);
				break;
			case 2:
				System.out.println();
				list.showInfo();
				break;
			default:
				System.out.println("Value not available, Try again!!");
			}
		} while (choose != 0);

	}

}
