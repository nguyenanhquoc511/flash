package Users;

import File.FileProcess;
import Function.Function;

public class listUsers {

	public boolean addUsers(String[] arrInfo, int number, Users u) throws Exception {
		Function F = new Function();
		FileProcess file = new FileProcess();
		try {
			file.writeFile(arrInfo, number, "./USERSFILE.INP");
			file.writeFile(u.toString(), "./USERSFILE.INP");
			file.readFile(arrInfo, "./USERSFILE.INP");
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void showList(String[] arrInfo, int number) {
		Function F = new Function();
		for (int i = 0; i < number; i++) {
			System.out.println("\nInfomation User " + (i + 1) + ": ");
			F.showInfo(arrInfo[i]);
		}
	}

	public boolean checkId(String[] arrInfo, int number, long id, String kind) {
		for (int i = 0; i < number; i++) {
			String[] tmp = arrInfo[i].split("~~");
			if (tmp[0].equals(String.valueOf(id)) && tmp[6].equals(kind))
				return true;
		}
		System.out.println("ID not Found !");
		return false;
	}

	public void findByIdCus(String[] arrInfo, int number, long id) {
		Function F = new Function();
		boolean check = false;
		for (int i = 0; i < number; i++) {
			String[] tmp = arrInfo[i].split("~~");
			if (tmp[0].equals(String.valueOf(id)) && tmp[6].equals("Customer")) {
				F.showInfo(arrInfo[i]);
				check = true;
			}
		}
		if (!check)
			System.out.println("Find not Found!");
	}

	public int findById(String[] arrInfo, int number, long id) {
		for (int i = 0; i < number; i++) {
			String[] tmp = arrInfo[i].split("~~");
			if (tmp[0].equals(String.valueOf(id)))
				return i;
		}
		return -1;
	}

	public void findByNameCus(String[] arrInfo, int number, String name) {
		Function F = new Function();
		boolean check = false;
		for (int i = 0; i < number; i++) {
			String[] tmp = arrInfo[i].split("~~");
			if (tmp[1].equalsIgnoreCase(name) && tmp[6].equals("Customer")) {
				F.showInfo(arrInfo[i]);
				check = true;
			}
		}
		if (!check)
			System.out.println("Find not Found!");
	}

	public void findByKind(String[] arrInfo, int number, String Kind) {
		Function F = new Function();
		boolean check = false;
		for (int i = 0; i < number; i++) {
			String[] tmp = arrInfo[i].split("~~");
			if (tmp[6].equals(Kind)) {
				F.showInfo(arrInfo[i]);
				check = true;
			}
		}
		if (!check)
			System.out.println("Find not Found!");
	}
}
