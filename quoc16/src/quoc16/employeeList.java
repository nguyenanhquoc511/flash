package quoc16;

import java.util.*;

public class employeeList {
	Scanner objSc = new Scanner(System.in);

	public void inputEmloyee(employee[] list, int number) {
		int kind = 0;
		for (int i = 0; i < number; i++) {

			System.out.println();
			System.out.println("Input information employee " + (i + 1) + ": ");
			do {
				System.out.println("Kind employee (1: Regular / 2: Contract Staff): ");
				kind = objSc.nextInt();
				if (kind != 1 && kind != 2)
					System.out.println("Value not available, Try Again!!");
			} while (kind != 1 && kind != 2);

			if (kind == 1) {
				System.out.println("Input Regular employee: ");
				list[i] = new regularEmployee();
				list[i].kind = 1;
			} else {
				System.out.println("Input Contract Staff employee: ");
				list[i] = new contractStaff();
				list[i].kind = 2;
			}

			list[i].input();
			list[i].calculateSalary();
		}
	}

	public void outputEmloyee(employee[] list, int number) {
		for (int i = 0; i < number; i++) {
			System.out.println();
			System.out.println("Information employee " + (i + 1) + ": ");
			list[i].output();
		}
	}

	public void sort(employee[] list, int number) {
		for (int i = 0; i < number - 1; i++)
			for (int j = i + 1; j < number; j++)
				if (list[i].salary > list[j].salary) {
					employee tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
	}

	public float sumSalaryRE(employee[] list, int number) {
		float sum = 0;
		for (int i = 0; i < number; i++)
			if (list[i].kind == 1)
				sum += list[i].salary;
		return sum;
	}

	public float sumSalaryCS(employee[] list, int number) {
		float sum = 0;
		for (int i = 0; i < number; i++)
			if (list[i].kind == 2)
				sum += list[i].salary;
		return sum;
	}

	public void maxSalary(employee[] list, int number) {
		float max = list[0].salary;
		for (int i = 0; i < number; i++)
			if (list[i].salary > max)
				max = list[i].salary;

		for (int i = 0; i < number; i++)
			if (list[i].salary == max) {
				System.out.println();
				list[i].output();
			}
	}

	public void findByName(employee[] list, int number, String name) {
		boolean check = false;
		for (int i = 0; i < number; i++)
			if (list[i].name.equalsIgnoreCase(name)) {
				check = true;
				System.out.println();
				list[i].output();
			}
		if (!check)
			System.out.println("Can not Found!!");
	}

}
