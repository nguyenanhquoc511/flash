package quoc16;

import java.util.*;

public class run {

	public static void main(String[] args) {

		Scanner objSc = new Scanner(System.in);
		employeeList list = new employeeList();
		employee[] listOfEmp = new employee[10];

		int kind, number, choose;
		String name;

		System.out.print("Input number salary: ");
		number = objSc.nextInt();
		list.inputEmloyee(listOfEmp, number);

		do {
			System.out.println();
			System.out.println("0. Exit");
			System.out.println("1. Show information list employee");
			System.out.println("2. Sum Salary Regular employee");
			System.out.println("3. Sum Salary Contract Staff");
			System.out.println("4. Sort list by Salary");
			System.out.println("5. Find By Name: ");
			System.out.println();
			System.out.print("Your choose: ");
			choose = objSc.nextInt();

			switch (choose) {
			case 1:
				list.outputEmloyee(listOfEmp, number);
				break;
			case 2:
				System.out.print("Sum Salary Regular employee: " + list.sumSalaryRE(listOfEmp, number));
				break;
			case 3:
				System.out.print("Sum Salary Contract Staff: " + list.sumSalaryCS(listOfEmp, number));
				break;
			case 4:
				System.out.println("Sort list by Salary");
				list.sort(listOfEmp, number);
				list.outputEmloyee(listOfEmp, number);
				break;
			case 5:
				System.out.println("Find By Name: ");
				System.out.print("Input name: ");
				objSc.nextLine();
				name = objSc.nextLine();
				list.findByName(listOfEmp, number, name);
				break;
			default:
				System.out.println("Value not available, Try again!!");

			}

			System.out.println();
		} while (choose != 0);

	}

}
