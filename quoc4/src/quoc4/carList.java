package quoc4;

public class carList {

	void inputCar(vehicle[] list, int number) {

		for (int i = 0; i < number; i++) {
			System.out.println();
			System.out.println("Please input Car " + (i + 1));
			list[i] = new vehicle();
			list[i].input();
			list[i].cash();
		}

	}

	void outputCar(vehicle[] list, int number) {
		for (int i = 0; i < number; i++) {
			System.out.println();
			list[i].output();
		}
	}

	void sort(vehicle[] list, int number) {
		for (int i = 0; i < number - 1; i++)
			for (int j = i + 1; j < number; j++)
				if (list[i].priceWithVAT > list[j].priceWithVAT) {
					vehicle tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
	}

	double sumOfCash(vehicle[] list, int number) {
		double tmp = 0;
		for (int i = 0; i < number; i++)
			tmp += list[i].priceWithVAT;
		return tmp;
	}

	int findLocMaxWithoutVAT(vehicle[] list, int number) {
		int location = 0;
		double max = list[0].priceWithoutVAT;
		for (int i = 1; i < number; i++)
			if (list[i].priceWithoutVAT > max) {
				max = list[i].priceWithoutVAT;
				location = i;
			}
		return location;
	}
}
