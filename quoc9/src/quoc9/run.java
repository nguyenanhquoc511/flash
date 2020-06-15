package quoc9;

import java.util.*;

public class run {

	public static void main(String[] args) {
		Scanner objSc = new Scanner(System.in);
		vehicle veh = new vehicle();
		car[] listOfCar = new car[10];
		CarList list = new CarList();
		int number;
		double maxCash;
		String name;

		System.out.print("Input number car: ");
		number = objSc.nextInt();

		list.inputCar(listOfCar, number);
		System.out.println();
		System.out.print("Output List Car Information: ");
		list.outputCar(listOfCar, number);

		list.sort(listOfCar, number);
		System.out.println();
		System.out.print("Output List Car Information after Sort : ");
		list.outputCar(listOfCar, number);

		System.out.println();
		System.out.println("Sum of Cash: " + list.sumOfCash(listOfCar, number));

		maxCash = list.maxPrice(listOfCar, number);
		System.out.println();
		System.out.println("The cars have the highest price without VAT: ");
		list.maxCash(listOfCar, number, maxCash);

		System.out.println();
		System.out.println("Find information car by name manufacturer: ");
		System.out.print("Input name Manufacturer: ");
		objSc.nextLine();
		name = objSc.nextLine();
		list.searchByName(listOfCar, number, name);
	}

}
