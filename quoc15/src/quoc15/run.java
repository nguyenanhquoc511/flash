package quoc15;

import java.util.*;

public class run {

	public static void main(String[] args) {

		Scanner objSc = new Scanner(System.in);
		listE list = new listE();

		System.out.print("Input numbers Employee: ");
		int number = objSc.nextInt();
		employee[] listOfEmp = new employee[number + 1];

		list.inputList(listOfEmp, number);
		list.outputList(listOfEmp, number);

	}

}
