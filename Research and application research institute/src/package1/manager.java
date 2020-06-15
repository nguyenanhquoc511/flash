package package1;

import java.util.*;

public class manager {
	int countP = 0, number = 100;
	person[] list = new person[number];
	Scanner objSc = new Scanner(System.in);

	public void initList() {
		for (int i = countP; i < number; i++)
			list[i] = new person();
	}

	public void add(int choose) {
		if (countP > number) {
			System.out.println("List full!");
			System.out.println("Auto updating List + 50% empty...");
			number += number * 50 / 100;
			// person[] list = new person[number];
			System.out.println("update complete!");
		} else {
			if (choose == 1) {
				list[countP] = new student();
				list[countP].input();

			} else if (choose == 2) {
				list[countP] = new employee();
				list[countP].input();

			} else {
				list[countP] = new customer();
				list[countP].input();

			}
			countP++;
		}
		System.out.println();
	}

	public void sortByName() {
		for (int i = 0; i < countP - 1; i++)
			for (int j = i + 1; j < countP; j++)
				if (list[i].name.compareToIgnoreCase(list[j].name) > 0) {
					person tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
	}

	public int find(String name) {
		for (int i = 0; i < countP; i++)
			if (list[i].name.equalsIgnoreCase(name))
				return i;
		return -1;
	}

	public void delete(int location) {
		for (int i = location; i < countP - 1; i++)
			list[i] = list[i + 1];
		countP--;
	}

	public void deleteByName(String name) {
		while (find(name) != -1)
			delete(find(name));
	}
	
	public void showInfo() {
		for(int i = 0; i < countP; i++) {
			System.out.println();
			System.out.println("Information person "+(i+1)+": ");
			System.out.println(list[i].toString());
		}
	}

}
