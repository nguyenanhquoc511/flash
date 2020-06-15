 package quoc14;

import java.util.*;

public class run {

	public static void main(String[] args) {
		Scanner objSc = new Scanner(System.in);
		regularEmployee[] listOfEmp = new regularEmployee[100];
		employeeList list = new employeeList();
		int number, choose;
		double maxSal;

		System.out.print("Input number employee: ");
		number = objSc.nextInt();
		list.inputEmployee(listOfEmp, number);

		do {
			System.out.println();
			System.out.println("<===================================>");
			System.out.println("|0. Exit                            |");
			System.out.println("|1. Show Information Employee List  |");
			System.out.println("|2. Sort Employee List              |");
			System.out.println("|3. Sum of Salary's Employee List   |");
			System.out.println("|4. Show Information Max Salary     |");
			System.out.println("<===================================>");
			System.out.print  ("            Your choose: ");
			choose = objSc.nextInt();

			switch (choose) {
			case 1:
				list.outputEmployee(listOfEmp, number);
				break;
			case 2: {
				list.sort(listOfEmp, number);
				list.outputEmployee(listOfEmp, number);
				break;
			}
			case 3:
				list.sumOfSalary();
				break;
			case 4: {
				maxSal = list.findMaxSal(listOfEmp, number);
				list.maxSalary(listOfEmp, number, maxSal);
				break;
			}
			default:
				System.out.println("Value not Available!!");
			}
			System.out.println();

		} while (choose != 0);
	}

}
