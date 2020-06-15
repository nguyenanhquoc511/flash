package quoc8;

import java.util.*;

public class listCD {

	boolean checkId(CD[] list, int count, int id) {
		for (int i = 0; i < count; i++)
			if (list[i].getId() == id || id <= 0)
				return false;
		return true;
	}

	void addOneCD(CD[] list, int count) {
		Scanner objSc = new Scanner(System.in);
		int id, numberSong;
		String name, singer;
		double price;

		if (count < list.length) {
			list[count] = new CD();
			do {
				System.out.print("Input Id: ");
				id = objSc.nextInt();
				if (!checkId(list, count + 1, id))
					System.out.println("Id not available, try again! ");
			} while (!checkId(list, count + 1, id));
			list[count].setId(id);

			System.out.print("Input Name: ");
			objSc.nextLine();
			name = objSc.nextLine();
			list[count].setName(name);

			System.out.print("Input Singer: ");
			singer = objSc.nextLine();
			list[count].setSinger(singer);

			do {
				System.out.print("Input number Song: ");
				numberSong = objSc.nextInt();
			} while (!list[count].setNumber(numberSong));
			list[count].setNumber(numberSong);

			do {
				System.out.print("Input price: ");
				price = objSc.nextDouble();
			} while (!list[count].setPrice(price));
			list[count].setPrice(price);

		} else
			System.out.println("Not enough empty!!");
	}

	double sumPriceCD(CD[] list, int count) {
		double tmp = 0;
		for (int i = 0; i < count; i++)
			tmp += list[i].getPrice();
		return tmp;
	}

	void sortDownPrice(CD[] list, int count) {
		for (int i = 0; i < count - 1; i++)
			for (int j = i + 1; j < count; j++)
				if (list[i].getPrice() < list[j].getPrice()) {
					CD tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
	}

	void sortUpName(CD[] list, int count) {
		for (int i = 0; i < count - 1; i++)
			for (int j = i + 1; j < count; j++)
				if (list[i].getName().compareToIgnoreCase(list[j].getName()) > 0) {
					CD tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
	}

	void outputList(CD[] list, int count) {
		for (int i = 0; i < count; i++)
			System.out.println(list[i].toString());
	}
}
