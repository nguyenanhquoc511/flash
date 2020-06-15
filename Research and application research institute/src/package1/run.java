package package1;

import java.util.*;

public class run {

	public static void main(String[] args) {
		Scanner objSc = new Scanner(System.in);
		manager MG = new manager();
		int choose;
		String name;

		do {

			System.out.println();
			System.out.println("0.Exit");
			System.out.println("1.Add a student");
			System.out.println("2.Add a employee");
			System.out.println("3.Add a customer");
			System.out.println("4.Show Information");
			System.out.println("5.Sort by Name");
			System.out.println("6.Delete by Name");
			System.out.println();
			System.out.print("Your choose: ");
			choose = objSc.nextInt();
			objSc.nextLine();

			switch (choose) {
			case 1:
				MG.add(choose);
				break;
			case 2:
				MG.add(choose);
				break;
			case 3:
				MG.add(choose);
				break;
			case 4:
				MG.showInfo();
				break;
			case 5: {
				MG.sortByName();
				MG.showInfo();
				break;
			}
			case 6: {
				System.out.print("Input Name: ");
				name = objSc.nextLine();
				MG.deleteByName(name);
				MG.showInfo();
				break;
			}
			default:
				System.out.println("Value not available, try again!!");
			}
			System.out.println();
		} while (choose != 0);
	}

}
