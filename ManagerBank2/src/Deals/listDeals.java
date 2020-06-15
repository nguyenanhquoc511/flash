package Deals;

import File.FileProcess;
import Function.Function;

public class listDeals {

	public boolean addDeal(String[] arrDeal, int number, Deal d) throws Exception {
		Function F = new Function();
		FileProcess file = new FileProcess();
		try {
		//	file.writeFile(arrDeal, number, "./DEALSFILE.INP");
			file.writeFile(d.toString(), "./DEALSFILE.INP");
			file.readFile(arrDeal, "./DEALSFILE.INP");
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void showDeal(String[] arrDeal, int number) {
		Function F = new Function();
		for (int i = 0; i < number; i++) {
			System.out.println("\nInfomation Deal " + (i + 1) + ": ");
			F.showInfo(arrDeal[i]);
		}
	}

	// id~~kind~~date~~time~~idcustomer~~money~~idreceive~~note
	public void findByIdCus(String[] arrDeal, int number, long id) {
		Function F = new Function();
		boolean check = false;
	//	System.out.println(number);
		for (int i = 0; i < number; i++) {
			String[] tmp = arrDeal[i].split("~~");
			if (tmp[4].equals(String.valueOf(id)) || tmp[6].equals(String.valueOf(id))) {
				F.showDeal(arrDeal[i]);
				check = true;
			}
		}
		if (!check)
			System.out.println("Find not Found!");
	}

	public void findByIdDeals(String[] arrDeal, int number, long id) {
		Function F = new Function();
		boolean check = false;
		for (int i = 0; i < number; i++) {
			String[] tmp = arrDeal[i].split("~~");
			if (tmp[0].equals(String.valueOf(id))) {
				F.showDeal(arrDeal[i]);
				check = true;
			}
		}
		if (!check)
			System.out.println("Find not Found!");
	}

	public void findByDate(String[] arrDeal, int number, String date) {
		Function F = new Function();
		boolean check = false;
		for (int i = 0; i < number; i++) {
			String[] tmp = arrDeal[i].split("~~");
			if (tmp[2].equals(date)) {
				F.showDeal(arrDeal[i]);
				check = true;
			}
		}
		if (!check)
			System.out.println("Find not Found!");
	}

	public void findByLowMoney(String[] arrDeal, int number, double money) {
		Function F = new Function();
		boolean check = false;
		for (int i = 0; i < number; i++) {
			String[] tmp = arrDeal[i].split("~~");
			if (Double.parseDouble(tmp[5]) <= money) {
				F.showDeal(arrDeal[i]);
				check = true;
			}
		}
		if (!check)
			System.out.println("Find not Found!");
	}

	public void findByHighMoney(String[] arrDeal, int number, double money) {
		Function F = new Function();
		boolean check = false;
		for (int i = 0; i < number; i++) {
			String[] tmp = arrDeal[i].split("~~");
			if (Double.parseDouble(tmp[5]) >= money) {
				F.showDeal(arrDeal[i]);
				check = true;
			}
		}
		if (!check)
			System.out.println("Find not Found!");
	}

}
