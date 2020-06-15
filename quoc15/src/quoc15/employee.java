package quoc15;

import java.util.*;

public class employee {
	Scanner objSc = new Scanner(System.in);
	protected String name;
	protected long salary;

	public employee() {
		this.name = "";
		this.salary = 0;
	}

	public employee(String name) {
		this.name = name;
	}

	protected String employeeKind() {
		return "";
	}

	public void calSalary() {

	}

	public void showInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Kind of Employee: " + employeeKind());
		System.out.println("Salary: " + this.salary);
	}
}
