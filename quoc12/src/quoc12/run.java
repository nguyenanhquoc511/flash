package quoc12;

import java.util.*;

public class run {

	public static void main(String[] args) {
		Scanner objSc = new Scanner(System.in);
		listDeal ld = new listDeal();
		ld.initList();

		int choose;
		do {
			System.out.println("0. Exit");
			System.out.println("1. Add a Gold Deal");
			System.out.println("2. Add a Money Deal");
			System.out.println("3. Find Unit Price Deal > 1000");
			System.out.println("4. Show all list Deal");
			System.out.print("Your choose: ");
			choose = objSc.nextInt();

			switch (choose) {
			case 1:
				ld.addDeal(choose);
				break;
			case 2:
				ld.addDeal(choose);
				break;
			case 3:
				ld.find();
				break;
			case 4:
				ld.showInfo();
			}

			System.out.println();
		} while (choose != 0);

	}

}
