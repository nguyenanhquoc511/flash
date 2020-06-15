
package Users;

import java.io.*;
import java.util.*;
import Deals.*;
import Function.*;

public class Manager extends Users {
	listDeals D = new listDeals();
	Scanner objSc = new Scanner(System.in);

	private double salary;

	public Manager() {
		super();
		this.salary = 0;
	}

	public Manager(long id, String name, String address, String password, int kind, int verificationCode, String phone, double salary) {
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
		return "Manager" + super.toString() + "\nSlary: " + String.valueOf(salary);
	}

	public void statistical() {
		System.out.println("Coming Soon!!");
	}

}

