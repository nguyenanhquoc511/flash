package quoc2;

import java.util.*;

public class account {
	long id;
	String name;
	double money;
	double rate = 0.05, pay = 1100;
	String password;

	account() {
		this.id = 0;
		this.name = "";
		this.money = 0;
		this.password = "";
	}

	account(long id, String name, double money, String password) {
		this.id = id;
		this.name = name;
		this.money = money;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	// nop tien
	double putOnMoney(double money) {
		return this.money += money;
	}

	void putOnMoney(double money, int x) {
		this.money += money;
	}

	// rut tien
	double plugOutMoney(double money) {
		return this.money -= (money + 1100);
	}

	void plugOutMoney(double money, int x) {
		this.money -= (money + 1100);
	}

	// dao han
	void toFallDue() {
		this.money = this.money + this.money * this.rate;
	}

	// chuyen tien
	void transfer(account k, double money) {
		this.money -= (money + pay + money * rate);
		k.money += money;
	}

	// khoi tao account

	account[] listOfAcc = new account[20];
	listAccount list = new listAccount();

	void input() {
		Scanner objSc = new Scanner(System.in);
		String tmp1, tmp2;
		System.out.println("Sign up");
		// khoi tao Id
		System.out.print("Input ID account: ");
		this.id = objSc.nextLong();
		objSc.nextLine();
		System.out.print("Input name of account: ");
		this.name = objSc.nextLine();
		System.out.print("Input money of account: ");
		this.money = objSc.nextDouble();
		objSc.nextLine();
		// khoi tao password;
		do {
			System.out.print("Input Password: ");
			tmp1 = objSc.nextLine();
			System.out.print("Input Password Again: ");
			tmp2 = objSc.nextLine();
			if (tmp1.equals(tmp2) == false)
				System.out.println("Password not correct, please try again! ");
			else {
				System.out.println("Sign up Success !!");
				this.password = tmp1;
			}
		} while (!tmp1.equals(tmp2));
	}

	void toPrint() {
		System.out.println("ID: " + getId() + "\t\tName: " + getName() + "\t\tMoney: " + getMoney() + " USD");
	}

}
