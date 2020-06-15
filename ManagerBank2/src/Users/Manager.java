
package Users;
import java.util.*;
import Deals.*;


public class Manager extends Users {
	listDeals D = new listDeals();
	Scanner objSc = new Scanner(System.in);

	private double salary;

	public Manager() {
		super();
		this.salary = 0;
	}

	public Manager(long id, String name, String address, String password, String kind, int verificationCode, String phone, double salary) {
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

	public String toString() {
		return super.toString() + String.valueOf(salary);
	}

	public void statistical() {
		System.out.println("Coming Soon!!");
	}

}

