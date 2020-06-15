package quoc16;

import java.util.*;

public abstract class employee {

	Scanner objSc = new Scanner(System.in);

	public String name, id;
	public float salary;
	public int kind;

	public employee() {
		this.id = "";
		this.name = "";
		this.kind = 0;
		this.salary = 0;
	}

	public employee(String id, String name, float salary, int kind) {
		this.id = id;
		this.name = name;
		this.kind = kind;
		this.salary = salary;
	}

	public abstract float calculateSalary();

	public void input() {
		System.out.print("Input ID: ");
		objSc.nextLine();
		System.out.print("Input Name: ");
		this.name = objSc.nextLine();
	}

	public void output() {
		System.out.println("ID: " + this.id);
		System.out.println("Name: " + this.name);
		System.out.println("Salary: " + this.salary);
	}
}
