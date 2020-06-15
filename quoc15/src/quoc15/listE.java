package quoc15;

import java.util.*;

public class listE {

	Scanner objSc = new Scanner(System.in);

	public void inputList(employee[] list, int number) {
		for (int i = 0; i < number; i++) {
			System.out.println();
			System.out.println("Input Employee " + (i + 1) + ": ");
			System.out.print("Name: ");
			String name = objSc.nextLine();
			System.out.print("Part Time or Full Time? (press: 1 or 2): ");
			int kindE = objSc.nextInt();

			if (kindE == 1) {
				System.out.print("Hours Work: ");
				int hours = objSc.nextInt();
				objSc.nextLine();
				list[i] = new parttimeE(name, hours);
				list[i].calSalary();
			} else {
				System.out.print("Employee or Boss? (press: 1 or 2): ");
				int tmp = objSc.nextInt();
				System.out.print("Input number days over time: ");
				int day = objSc.nextInt();
				objSc.nextLine();
				list[i] = new fulltimeE(name, day, tmp);
				list[i].calSalary();
			}
		}
	}

	public void outputList(employee[] list, int number) {
		for (int i = 0; i < number; i++) {
			System.out.println();
			System.out.println("Information Employee " + (i + 1) + ": ");
			list[i].showInfo();
		}
	}

}
