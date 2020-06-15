package quoc14;

import java.util.*;

public class employeeList {

	Scanner objSc = new Scanner(System.in);
	double sumSal = 0;

	public void inputEmployee(regularEmployee[] list, int number) {
		for (int i = 0; i < number; i++) {
			System.out.println();
			System.out.println("Input Employee " + (i + 1) + ": ");
			list[i] = new regularEmployee();
			list[i].input();
			sumSal += list[i].calSalary();
		}
	}

	public void outputEmployee(regularEmployee[] list, int number) {
		for (int i = 0; i < number; i++) {
			System.out.println();
			System.out.println("Information Employee " + (i + 1) + ": ");
			list[i].output();
		}
	}

	public void sort(regularEmployee[] list, int number) {
		for (int i = 0; i < number - 1; i++)
			for (int j = i + 1; j < number; j++)
				if (list[i].salary > list[j].salary) {
					regularEmployee tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
	}

	public void sumOfSalary() {
		System.out.println("Sum Of Salary: " + sumSal);
	}

	public double findMaxSal(regularEmployee[] list, int number) {
		double max = 0;
		for (int i = 0; i < number; i++)
			if (list[i].salary > max)
				max = list[i].salary;
		return max;
	}

	public void maxSalary(regularEmployee[] list, int number, double maxSal) {
		for (int i = 0; i < number; i++)
			if (list[i].salary == maxSal)
				list[i].output();
	}

}
