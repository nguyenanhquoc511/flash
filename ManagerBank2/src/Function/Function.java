package Function;

import java.io.*;
import java.util.*;
import File.FileProcess;
import Users.*;

public class Function {

	public boolean signIn(String[] arrInfo, int number, long id, String password) {
		Scanner objSc = new Scanner(System.in);
		for (int i = 0; i < number; i++) {

			String[] splitInfo = arrInfo[i].split("~~");
			// id~~name~~address~~phone~~password~~verification~~kind~~(money/salary)
			if (splitInfo[0].equals(String.valueOf(id)) && splitInfo[4].equals(password)) {
				System.out.println("Sign In Successful !! Hello, " + splitInfo[1]);
				return true;
			}
		}
		System.out.println("Sign In Failed!! ");
		return false;
	}

	public boolean signUp(String[] arrInfo, int number, Customer cus) throws IOException {
		Scanner objSc = new Scanner(System.in);
		long id;
		String name, address, password1, password2, phone;
		double money;

		do {
			id = (int) Math.floor(((Math.random() * 899999) + 100000));
		} while (checkIdUser(arrInfo, number, id) || !cus.setId(id));

		do {
			System.out.print("Input Name: ");
			name = objSc.nextLine();
		} while (!cus.setName(name));

		do {
			System.out.print("Input Address: ");
			address = objSc.nextLine();
		} while (!cus.setAddress(address));

		do {
			System.out.print("Input Money: ");
			money = objSc.nextDouble();
		} while (!cus.setMoney(money));

		do {
			System.out.print("Input Number Phone: ");
			objSc.nextLine();
			phone = objSc.nextLine();
		} while (!cus.setPhone(phone));

		do {
			System.out.print("Input Password: ");
			password1 = objSc.nextLine();
			System.out.print("Confirm Password: ");
			password2 = objSc.nextLine();
		} while (!checkPassword(password1, password2) || !cus.setPassword(password1));

		System.out.println("Sign Up Successful !");
		return true;
	}

	// id~~name~~address~~phone~~password~~verification~~kind~~(money/salary)
	public void showInfo(String str) {
		String[] tmp = str.split("~~");
		System.out.println(
				tmp[6] + "\nID: " + tmp[0] + "\nName: " + tmp[1] + "\nAddress: " + tmp[2] + "\nPhone: " + tmp[3]);
		if (tmp[6].equals("Customer"))
			System.out.println("Money: " + tmp[7]);
		else
			System.out.println("Salary: " + tmp[7]);

	}

	// id~~kind~~date~~time~~idcustomer~~money~~idreceive~~note
	public void showDeal(String str) {
		String[] tmp = str.split("~~");
		System.out.println("\nID: " + tmp[0] + "\nKind Of Deal: " + tmp[1] + "\nDate: " + tmp[2] + "\nTime: " + tmp[3]
				+ "\nID Customer: " + tmp[4] + "\nMoney: " + tmp[5] + "\nID Receive: " + tmp[6] + "\nNote: " + tmp[7]);
	}

	public boolean signUp(String[] arrInfo, int number, Employee emp) throws IOException {
		Scanner objSc = new Scanner(System.in);
		long id;
		double salary;

		String name, address, password1, password2, phone;
		do {
			id = (int) Math.floor(((Math.random() * 899999) + 100000));
		} while (checkIdUser(arrInfo, number, id) || !emp.setId(id));

		do {
			System.out.print("Input Name: ");
			name = objSc.nextLine();
		} while (!emp.setName(name));

		do {
			System.out.print("Input Address: ");
			address = objSc.nextLine();
		} while (!emp.setAddress(address));

		do {
			System.out.print("Input Salary: ");
			salary = objSc.nextDouble();
		} while (!emp.setSalary(salary));

		do {
			System.out.print("Input Number Phone: ");
			objSc.nextLine();
			phone = objSc.nextLine();
		} while (!emp.setPhone(phone));

		do {
			System.out.print("Input Password: ");
			password1 = objSc.nextLine();
			System.out.print("Confirm Password: ");
			password2 = objSc.nextLine();
		} while (!checkPassword(password1, password2) || !emp.setPassword(password1));

		System.out.println("\nSign Up Successful !");
		return true;
	}

	public boolean deleteUser(String[] arrInfo, int number, String user, int verificationCode) throws Exception {
		FileProcess file = new FileProcess();
	
		listUsers LU = new listUsers();
		String[] splitTmp = user.split("~~");

		if (!splitTmp[5].equals(String.valueOf(verificationCode))) {
			System.out.println("Verification Code not Match !!");
			return false;
		}

		for (int i = LU.findById(arrInfo, number, Long.parseLong(splitTmp[0])); i < number - 1; i++)
			arrInfo[i] = arrInfo[i + 1];

		splitTmp[5] = "0";

		file.writeFile(arrInfo, number - 1, "./USERSFILE.INP");
		file.readFile(arrInfo, "./USERSFILE.INP");

		System.out.println("Delete Users Successful !");
		return true;
	}

	public boolean deleteUser(String[] arrInfo, int number, String user) throws Exception {
		FileProcess file = new FileProcess();
		listUsers LU = new listUsers();
		String[] splitTmp = user.split("~~");
		for (int i = LU.findById(arrInfo, number, Long.parseLong(splitTmp[0])); i < number - 1; i++)
			arrInfo[i] = arrInfo[i + 1];

		splitTmp[5] = "0";

		file.writeFile(arrInfo, number - 1, "./USERSFILE.INP");
		file.readFile(arrInfo, "./USERSFILE.INP");

		System.out.println("Delete Users Successful !");
		return true;
	}

	public boolean changePassword(String[] arrInfo, int number, String user, String newPass, int verificationCode)
			throws Exception {
		FileProcess file = new FileProcess();
		listUsers LU = new listUsers();
		String[] tmp = user.split("~~");

		if (!tmp[5].equals(String.valueOf(verificationCode))) {
			System.out.println("Verification Code not Match !!\nChange Password Failed");
			return false;
		}
		if (newPass.length() < 4) {
			System.out.println("\nPassword must longer 4 character, Try again!!\n");
			return false;
		}

		tmp[4] = newPass;
		tmp[5] = "0";

		arrInfo[LU.findById(arrInfo, number, Long.parseLong(tmp[0]))] = changeArrStringToString(tmp);

		file.writeFile(arrInfo, number, "./USERSFILE.INP");
		file.readFile(arrInfo, "./USERSFILE.INP");

		System.out.println("\nChange Password Successful !");
		return true;
	}

	public boolean checkIdUser(String[] arrInfo, int number, long id) {
		for (int i = 0; i < number; i++) {
			String[] splitInfo = arrInfo[i].split("~~");
			// id~~name~~address~~phone~~password~~verification~~kind~~(money/salary)
			if (splitInfo[0].equals(String.valueOf(id)))
				return true;
		}
		return false;
	}

	public boolean checkIdDeal(String[] arrDeal, int number, long id) {
		for (int i = 0; i < number; i++) {
			String[] splitDeal = arrDeal[i].split("~~");

			if (splitDeal[0].equals(String.valueOf(id)))
				return true;
		}
		return false;
	}

	public boolean checkPassword(String password1, String password2) {
		if (!password1.equals(password2)) {
			System.out.println("\nPassword not match, Try again!!\n");
			return false;
		}

		if (password1.length() < 4) {
			System.out.println("\nPassword must longer 4 character, Try again!!\n");
			return false;
		}

		System.out.println("\nConfirm Password Successful !!");
		return true;
	}

	public boolean checkPasswordUser(String user, String password) {
		String[] splitTmp = user.split("~~");
		if (!splitTmp[4].equals(password)) {
			System.out.println("\nPassword not match, Try again!!\n");
			return false;
		}
		return true;
	}

	public String dateToString() {
		Calendar c = Calendar.getInstance();
		return String.valueOf(c.get(Calendar.DATE)) + "/" + String.valueOf(c.get(Calendar.MONTH) + 1) + "/"
				+ String.valueOf(c.get(Calendar.YEAR));
	}

	public String timeToString() {
		Calendar c = Calendar.getInstance();
		return String.valueOf(c.get(Calendar.HOUR_OF_DAY)) + "H : " + String.valueOf(c.get(Calendar.MINUTE)) + "M : "
				+ String.valueOf(c.get(Calendar.SECOND) + "S");
	}

	public boolean transferMoney(String[] arrInfo, int number, String transfer, String receive, double money,
			int verificationCode) throws Exception {
		FileProcess file = new FileProcess();
		listUsers LU = new listUsers();
		String[] splitTmp = transfer.split("~~");
		String[] splitTmp1 = receive.split("~~");

		if (!splitTmp[5].equals(String.valueOf(verificationCode))) {
			System.out.println("Verification Code not Match !!");
			return false;
		}

		if (Double.parseDouble(splitTmp[7]) < (money + money * 5 / 100)) {
			System.out.println("Not Enough Money, Try again !!");
			return false;
		}
		splitTmp1[7] = String.valueOf(Double.parseDouble(splitTmp1[7]) + money);
		splitTmp[7] = String.valueOf(Double.parseDouble(splitTmp[7]) - money - money * 5 / 100);
		splitTmp[5] = "0";

		arrInfo[LU.findById(arrInfo, number, Long.parseLong(splitTmp[0]))] = changeArrStringToString(splitTmp);
		arrInfo[LU.findById(arrInfo, number, Long.parseLong(splitTmp1[0]))] = changeArrStringToString(splitTmp1);

		file.writeFile(arrInfo, number, "./USERSFILE.INP");
		file.readFile(arrInfo, "./USERSFILE.INP");

		System.out.println("Transfer Successful !");

		return true;

	}

	public boolean getOutMoney(String[] arrInfo, int number, String customer, double money, int verificationCode)
			throws Exception {
		FileProcess file = new FileProcess();
		listUsers LU = new listUsers();
		String[] splitTmp = customer.split("~~");

		if (!splitTmp[5].equals(String.valueOf(verificationCode))) {
			System.out.println("Verification Code not Match !!");
			return false;
		}

		if (Double.parseDouble(splitTmp[7]) < (money + money * 5 / 100)) {
			System.out.println("Not Enough Money, Try again !!");
			return false;
		}

		splitTmp[7] = String.valueOf(Double.parseDouble(splitTmp[7]) - money - money * 5 / 100);
		splitTmp[5] = "0";

		arrInfo[LU.findById(arrInfo, number, Long.parseLong(splitTmp[0]))] = changeArrStringToString(splitTmp);

		file.writeFile(arrInfo, number, "./USERSFILE.INP");

		file.readFile(arrInfo, "./USERSFILE.INP");

		System.out.println("Get Out Money Successful !");

		return true;

	}

	public boolean putOnMoney(String[] arrInfo, int number, String customer, double money, int verificationCode)
			throws Exception {
		FileProcess file = new FileProcess();
		listUsers LU = new listUsers();
		String[] splitTmp = customer.split("~~");

		if (!splitTmp[5].equals(String.valueOf(verificationCode))) {
			System.out.println("Verification Code not Match !!");
			return false;
		}

		splitTmp[7] = String.valueOf(Double.parseDouble(splitTmp[7]) + money);
		splitTmp[5] = "0";

		arrInfo[LU.findById(arrInfo, number, Long.parseLong(splitTmp[0]))] = changeArrStringToString(splitTmp);

		file.writeFile(arrInfo, number, "./USERSFILE.INP");
		file.readFile(arrInfo, "./USERSFILE.INP");

		System.out.println("Put On Money Successful !");

		return true;
	}

	public String changeArrStringToString(String[] arrStr) {
		String info = "";
		for (int i = 0; i < arrStr.length; i++) {
			info = info.concat(arrStr[i]);
			if (i == 7) {
				break;
			} else
				info = info.concat("~~");
		}

		return info;
	}
}
