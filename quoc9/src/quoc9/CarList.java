package quoc9;

import java.util.*;

public class CarList {

	public void inputCar(car[] list, int number) {
		Scanner objSc = new Scanner(System.in);
		for (int i = 0; i < number; i++) {
			System.out.println();
			System.out.println("Input information car " + (i + 1) + ": ");
			list[i] = new car();
			list[i].input();
		}
	}

	public void outputCar(car[] list, int number) {
		for (int i = 0; i < number; i++) {
			System.out.println();
			System.out.println("Information car " + (i + 1) + ": ");
			list[i].output();
		}
	}

	public void sort(car[] list, int number) {
		for (int i = 0; i < number - 1; i++)
			for (int j = i + 1; j < number; j++)
				if (list[i].priceWithVAT > list[j].priceWithVAT) {
					car tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
	}

	public double sumOfCash(car[] list, int number) {
		double tmp = 0;
		for (int i = 0; i < number; i++)
			tmp += list[i].cash();
		return tmp;
	}

	public double maxPrice(car[] list, int number) {
		double max = 0;
		for (int i = 0; i < number; i++)
			if (list[i].priceWithoutVAT > max)
				max = list[i].priceWithoutVAT;
		return max;
	}

	public void maxCash(car[] list, int number, double maxPrice) {
		for (int i = 0; i < number; i++)
			if (list[i].priceWithoutVAT == maxPrice)
				list[i].output();
	}

	public void searchByName(car[] list, int number, String name) {
		for (int i = 0; i < number; i++)
			if (list[i].manufacturer.equalsIgnoreCase(name))
				list[i].output();
	}
}
