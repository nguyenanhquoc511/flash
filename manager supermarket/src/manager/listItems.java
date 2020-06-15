
package manager;

public class listItems {

	function F = new function();
	items[] its = new items[100];

	private int count = 0;

	public void inputItems(int choose) {
		if (choose == 1) {
			its[count] = new foodItems();
			do {
				System.out.print("\nAdd Food Items: \n");
				its[count].input();
			} while (!F.checkId(its, count, its[count].getId()));
		} else if (choose == 2) {
			its[count] = new electricalItems();
			do {
				System.out.print("\nAdd Electrical Items: \n");
				its[count].input();
			} while (!F.checkId(its, count, its[count].getId()));
		}

		else {
			its[count] = new crockeryItems();
			do {
				System.out.print("\nAdd Crokery Items: \n");
				its[count].input();
			} while (!F.checkId(its, count, its[count].getId()));
		}
		System.out.println("\n Add Successful!");
		count++;
	}

	public void showInfo() {
		for (int i = 0; i < count; i++) {
			System.out.println();
			System.out.println("Items " + (i + 1) + ": " + its[i].toString());
		}
	}

}
