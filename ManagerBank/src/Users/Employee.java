package Users;

import java.io.*;
import java.util.*;

import Function.*;

public class Employee extends Users {
	Function F = new Function();
	Scanner objSc = new Scanner(System.in);

	private double salary;

	public Employee() {
		super();
		this.salary = 0;
	}

	public Employee(long id, String name, String address, String password, int kind, int verificationCode, String phone, double salary) {
		super(id, name, address, password, kind, verificationCode, phone);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public boolean setSalary(double salary) {
		if (salary < 0) {
			System.out.println("Value not available, Try again!!");
			return false;
		}
		this.salary = salary;
		return true;
	}

	public void input(listUsers LU) throws IOException {
		double salary;
		super.input(LU);
		do {
			System.out.print("Input Salary: ");
			salary = objSc.nextDouble();
		} while (!setSalary(salary));
	}

	public String toString() {
		return "Employee" + super.toString() + "\nSlary: " + String.valueOf(salary);
	}

	public boolean transferMoney(Customer transfer, Customer receive, double money, int verificationCode) {

		if (verificationCode != transfer.getVerificationCode()) {
			System.out.println("Verification Code not match, Try again !");
			return false;
		}

		if (!transfer.setMoney(transfer.getMoney() - money - money * 5 / 100)) {
			System.out.println("Not enough money, Try again !");
			return false;
		}

		receive.setMoney(receive.getMoney() + money);
		System.out.println("Transfer Successful !");
		transfer.setVerificationCode(0);
		return true;

	}

	public boolean getOutMoney(Customer cus, double money, int verificationCode) {

		if (verificationCode != cus.getVerificationCode()) {
			System.out.println("Verification Code not match, Try again !");
			return false;
		}

		if (!cus.setMoney(cus.getMoney() - money - money * 5 / 100)) {
			System.out.println("Not enough money, Try again !");
			return false;
		}

		System.out.println("Get Out Money Successful !");
		cus.setVerificationCode(0);
		return true;

	}

	public boolean putOnMoney(Customer cus, double money, int verificationCode) {
		if (verificationCode != cus.getVerificationCode()) {
			System.out.println("Verification Code not match, Try again !");
			return false;
		}

		cus.setMoney(cus.getMoney() + money);
		System.out.println("Put On Money Successful !");
		cus.setVerificationCode(0);
		return true;
	}
}
