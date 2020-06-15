package quoc13;

import java.util.*;

public class run {

	public static void main(String[] args) {
		Scanner objSc = new Scanner(System.in);
		listDeal list = new listDeal();
		list.initList();

		int choose;
		String tmp;

		do {
			System.out.println("0. Exit");
			System.out.println("1. Add a land deal");
			System.out.println("2. Add a house deal");
			System.out.println("3. Show all deal");
			System.out.println("4. Average Price land deal");
			System.out.println("5. find deal by month and year");
			System.out.print("Your choose: ");
			choose = objSc.nextInt();

			switch (choose) {
			case 1:
				list.addDeal(choose);
				break;
			case 2:
				list.addDeal(choose);
				break;
			case 3:
				list.showInfo();
				break;
			case 4:
				list.averageLD();
				break;
			case 5: {
				System.out.print("Input month and year (mm/yyyy): ");
				objSc.nextLine();
				tmp = objSc.nextLine();
				list.findDealByMY(tmp);
				break;
			}
			default:
				System.out.println("Value not available!");
			}
			System.out.println();
		} while (choose != 0);
	}

}
