package quoc2;

public class listAccount {

	void inputList(account[] list, int number) {
		for (int i = 0; i < number; i++) {
			System.out.println();
			System.out.println("Input data account " + (i + 1));
			list[i] = new account();
			list[i].input();
		}
	}

	void outputList(account[] list, int number) {
		for (int i = 0; i < number; i++) {
			System.out.println();
			list[i].toPrint();
		}
	}

	// sap xep danh sach khach hang theo so tien cua ho
	void sort(account[] list, int number) {
		for (int i = 0; i < number - 1; i++)
			for (int j = i + 1; j < number; j++)
				if (list[i].money > list[j].money) {
					account tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
	}

	// tong tien khach hang cua ca ngan hang
	double sum(account[] list, int number) {
		double tmp = 0;
		for (int i = 0; i < number; i++)
			tmp += list[i].money;
		return tmp;
	}

	// kiem tra dang nhap
	boolean signIn(account[] list, int number, long id, String pass) {
		for (int i = 0; i < number; i++)
			if (list[i].id == id && list[i].password.equals(pass))
				return true;
		return false;
	}

	// tim khach hang bang ID
	void findId(account[] list, int number, long id) {
		boolean check = false;
		for (int i = 0; i < number; i++)
			if (list[i].id == id) {
				check = true;
				list[i].toPrint();
			}
		if (check == false)
			System.out.println("No matching results were found!");
	}

	// tim vi tri cua khach hang trong mang bang Id
	int findLocId(account[] list, int number, long id) {
		for (int i = 0; i < number; i++)
			if (list[i].id == id)
				return i;
		return -1;
	}

	// tim khach hang bang Ten
	void findName(account[] list, int number, String name) {
		boolean check = false;
		for (int i = 0; i < number; i++)
			if (list[i].name.equalsIgnoreCase(name)) {
				check = true;
				list[i].toPrint();
			}
		if (check == false)
			System.out.println("No matching results were found!");
	}

	//

}
