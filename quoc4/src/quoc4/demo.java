package quoc4;

import java.util.*;

public class demo {

	public static void main(String[] args) {
		Scanner objSc = new Scanner(System.in);
		vehicle[] listOfVeh = new vehicle[10];
		carList list = new carList();
		int number, location;
		double sumCash;

		System.out.print("Number Car: ");
		number = objSc.nextInt();

		list.inputCar(listOfVeh, number);
		System.out.println("Car List: ");
		list.outputCar(listOfVeh, number);

		System.out.println();
		System.out.println("Sort up (VAT): ");
		list.sort(listOfVeh, number);
		list.outputCar(listOfVeh, number);

		sumCash = list.sumOfCash(listOfVeh, number);
		System.out.println();
		System.out.println("Sum Cash: " + sumCash);

		location = list.findLocMaxWithoutVAT(listOfVeh, number);
		System.out.println();
		System.out.println("Max Without VAT: ");
		listOfVeh[location].output();

	}

}
