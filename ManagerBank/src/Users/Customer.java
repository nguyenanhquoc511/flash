package Users;

import java.io.*;
import java.util.*;
import Function.*;

public class Customer extends Users {
	Function F = new Function();
	Scanner objSc = new Scanner(System.in);

	private double money;

	public Customer() {
		super();
		this.money = 0;
		
	}

	public Customer(long id, String name, String address, String password, int kind, int verificationCode, String phone, double money) {
		super(id, name, address, password, kind, verificationCode, phone);
		this.money = money;
	}

	public double getMoney() {
		return money;
	}

	public boolean setMoney(double money) {
		if (money < 0) {
			System.out.println("Value not available, Try again!!");
			return false;
		}
		this.money = money;
		return true;
	}

	public void input(listUsers LU) throws IOException {
		double money;
		super.input(LU);
		do {
			System.out.print("Input Money: ");
			money = objSc.nextDouble();
		} while (!setMoney(money));
	}

	public String toString() {
		return "Customer" + super.toString() + "\nMoney: " + String.valueOf(money);
	}

	public boolean transferMoney(Customer receive, double money) {

		if (!this.setMoney(this.getMoney() - money - money * 5 / 100)) {
			System.out.println("Not enough money, Try again !");
			return false;
		}
		receive.setMoney(receive.getMoney() + money);
		System.out.println("Transfer Successful !");
		return true;

	}

	public boolean getOutMoney(double money) {
		if (!this.setMoney(this.getMoney() - money - money * 5 / 100)) {
			System.out.println("Not enough money, Try again !");
			return false;
		}

		System.out.println("Get Out Money Successful !");
		return true;

	}

	public boolean putOnMoney(double money) {
		this.setMoney(this.getMoney() + money);
		System.out.println("Put On Money Successful !");
		return true;
	}

}
