package Users;

import java.util.*;


public class Customer extends Users {

	Scanner objSc = new Scanner(System.in);

	private double money;

	public Customer() {
		super();
		this.money = 0;
		
	}

	public Customer(long id, String name, String address, String password, String kind, int verificationCode, String phone, double money) {
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

	public String toString() {
		return super.toString() + String.valueOf(money);
	}

	

}
