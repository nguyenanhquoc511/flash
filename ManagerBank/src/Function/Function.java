package Function;

import java.io.IOException;
import java.util.*;
import Deals.*;
import Users.*;

public class Function {

	
	Random generator = new Random(9999);
	Scanner objSc = new Scanner(System.in);

	public boolean signIn(listUsers LU, long id, String password) {

		for (int i = 0; i < LU.countUsers; i++)
			if (LU.listOfUsers[i].getId() == id && LU.listOfUsers[i].getPassword().equals(password)) {
				System.out.println("Sign In Successful !! Hello, " + LU.listOfUsers[i].getName());
				return true;
			}
		System.out.println("Sign In Failed!! ");
		return false;
	}

	public boolean signUp(listUsers LU, Customer cus) throws IOException {
		long id;
		String name, address, password1, password2, phone;
		double money;

		do {
			id = (int) Math.floor(((Math.random() * 899999) + 100000));
		} while (!checkId(LU, id) || !cus.setId(id));

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
			objSc.nextLine();
			System.out.print("Input Password: ");
			password1 = objSc.nextLine();
			System.out.print("Confirm Password: ");
			password2 = objSc.nextLine();
		} while (!checkPassword(password1, password2) || !cus.setPassword(password1));

		System.out.println("Sign Up Successful !");
		return true;
	}

	public boolean signUp(listUsers LU, Employee emp) throws IOException {
		long id;
		double salary;
		
		String name, address, password1, password2, phone;
		do {
			id = (int) Math.floor(((Math.random() * 899999) + 100000));
		} while (!checkId(LU, id) || !emp.setId(id));

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
			objSc.nextLine();
			System.out.print("Input Password: ");
			password1 = objSc.nextLine();
			System.out.print("Confirm Password: ");
			password2 = objSc.nextLine();
		} while (!checkPassword(password1, password2) || !emp.setPassword(password1));

		System.out.println("\nSign Up Successful !");
		return true;
	}
	
	public boolean deleteUser(listUsers LU, long id, int verificationCode) {
		Users tmp = LU.listOfUsers[LU.findById(id)];
		
		if(tmp.getVerificationCode() != verificationCode) {
			System.out.println("Verification Code not Match !!");
			return false;
		}
		
		for(int i = LU.findById(id); i < LU.countUsers - 1; i++)
			LU.listOfUsers[i] = LU.listOfUsers[i+1];
		
		LU.countUsers --;
		
		System.out.println("Delete Users Successful !");
		return true;
	}
	
	public boolean deleteUser(listUsers LU, long id) {
		
		for(int i = LU.findById(id); i < LU.countUsers - 1; i++)
			LU.listOfUsers[i] = LU.listOfUsers[i+1];
		
		LU.countUsers --;
		
		System.out.println("Delete Users Successful !");
		return true;
	}
	
	public boolean changePassword(Users user, String newPass, int verificationCode) {
		
		if(user.getVerificationCode() != verificationCode) {
			System.out.println("Verification Code not Match !!\nChange Password Failed");
			return false;
		}
		
		if(!user.setPassword(newPass)) {
			System.out.println("\nChange Password Failed");
			return false;
		}
		
		System.out.println("\nChange Password Successful !");
		return true;
	}

	public boolean checkId(listUsers LU, long id) {
		for (int i = 0; i <= LU.countUsers; i++) {
			if (LU.listOfUsers[i].getId() == id)
				return false;
		}
		return true;
	}

	public boolean checkId(listDeals LD, long id) {
		for (int i = 0; i <= LD.countDeals; i++) {
			if (LD.listOfDeals[i].getIdDeal() == id)
				return false;
		}
		return true;
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
	
	public boolean checkPassword(Users user, String password) {
		if (!user.getPassword().equals(password)) {
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

}
