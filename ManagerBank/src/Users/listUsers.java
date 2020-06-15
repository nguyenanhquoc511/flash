package Users;

import Deals.Deal;

public class listUsers {

	public int countUsers;
	public Users[] listOfUsers = new Users[100];

	public void initList() {
		countUsers = 0;
		for (int i = 0; i < 100; i++)
			listOfUsers[i] = new Users();
	}

	public boolean addUsers(Users u) {
		if (countUsers > 100) {
			System.out.println("Not enought Empty!!");
			return false;
		} else {
			listOfUsers[countUsers] = u;
			System.out.println("Add users to list successful!!");
			countUsers++;
			return true;
		}
	}

	public void showList() {
		for (int i = 0; i < countUsers; i++) {
			System.out.println("\nInformation Users " + (i + 1) + ": ");
			System.out.println(listOfUsers[i].toString());
		}
	}

	public boolean checkId(long id, int kind) {
		for (int i = 0; i < countUsers; i++)
			if (listOfUsers[i].getId() == id && listOfUsers[i].getKind() == kind)
				return true;
		System.out.println("ID not Found !");
		return false;
	}
	

	public void findByIdCus(long id) {
		boolean check = false;
		for (int i = 0; i < countUsers; i++)
			if (listOfUsers[i].id == id && listOfUsers[i].getKind() == 1) {
				System.out.println(listOfUsers[i].toString() + "\n");
				check = true;
			}
		if (!check)
			System.out.println("Find not Found!");
	}

	public int findById(long id) {
		for (int i = 0; i < countUsers; i++)
			if (listOfUsers[i].id == id)
				return i;
		return -1;
	}

	public void findByNameCus(String name) {
		boolean check = false;
		for (int i = 0; i < countUsers; i++)
			if (listOfUsers[i].name.equalsIgnoreCase(name) && listOfUsers[i].getKind() == 1) {
				System.out.println(listOfUsers[i].toString() + "\n");
				check = true;
			}
		if (!check)
			System.out.println("Find not Found!");
	}

	public void findByKind(int Kind) {
		boolean check = false;
		for (int i = 0; i < countUsers; i++)
			if (listOfUsers[i].kind == Kind) {
				System.out.println(listOfUsers[i].toString() + "\n");
				check = true;
			}
		if (!check)
			System.out.println("Find not Found!");
	}
}
