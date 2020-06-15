package quoc8;

import java.util.*;

public class demo {

	public static void main(String[] args) {
		CD[] listOfCD = new CD[3];
		listCD list = new listCD();
		Scanner objSc = new Scanner(System.in);

		int number, count = 0, sum, choose;
		String rep;

		do {

			System.out.println("1. Add a CD to list");
			System.out.println("2. Count number of CD on list");
			System.out.println("3. Sum all of CD's price");
			System.out.println("4. Sort down price");
			System.out.println("5. Sort up name");
			System.out.println("6. Output list");

			System.out.print("Your choose: ");
			choose = objSc.nextInt();
			System.out.println();
			switch (choose) {
			case 1: {
				list.addOneCD(listOfCD, count);
				count++;
				break;
			}
			case 2: {
				System.out.println("Number of CD: " + count);
				break;
			}
			case 3: {
				System.out.println("Sum all of CD's price: " + list.sumPriceCD(listOfCD, count));
				break;
			}
			case 4: {
				System.out.println("Sort down price: ");
				list.sortDownPrice(listOfCD, count);
				break;
			}
			case 5: {
				System.out.println("Sort up name: ");
				list.sortUpName(listOfCD, count);
				break;
			}
			case 6: {
				list.outputList(listOfCD, count);
				break;
			}
			default:
				System.out.println("Your choose not available!");
			}

			System.out.print("Do you want continued? (Y/N): ");
			objSc.nextLine();
			rep = objSc.nextLine();
			System.out.println();
		} while (rep.equalsIgnoreCase("Y"));

	}

}
