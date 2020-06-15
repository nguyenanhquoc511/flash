package quoc14;

import java.util.*;

public class employee {
	Scanner objSc = new Scanner(System.in);

	public int id;
	public String name;
	public double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public employee() {
		this.id = 0;
		this.name = "";
		this.salary = 0;
	}

	public employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public void input() {
		System.out.print("Input Id: ");
		this.id = objSc.nextInt();
		objSc.nextLine();
		System.out.print("Input Name: ");
		this.name = objSc.nextLine();
	}

	public double calSalary() {
		return 0;
	}

	public void output() {
		System.out.println();
		System.out.println("Id: " + getId());
		System.out.println("Name: " + getName());
		System.out.println("Salary: " + getSalary());
	}
}
