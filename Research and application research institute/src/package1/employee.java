package package1;

import java.util.*;

public class employee extends person {

	Scanner objSc = new Scanner(System.in);

	private float salaryGrading;

	public float getSalaryGrading() {
		return salaryGrading;
	}

	public void setSalaryGrading(float salaryGrading) {
		this.salaryGrading = salaryGrading;
	}

	public employee() {
		super();
		this.salaryGrading = 0;
	}

	public employee(String name, String address, float salaryGrading) {
		super(name, address);
		this.salaryGrading = salaryGrading;
	}

	public void input() {
		super.input();
		System.out.print("Salary Grading: ");
		this.salaryGrading = objSc.nextFloat();
	}

	public double calSalary() {
		return 100 * this.salaryGrading;
	}

	public String evaluate() {
		return "Good";
	}

	public String toString() {
		return "Employee" + super.toString() + "\nSalary: " + String.valueOf(calSalary());
	}
}
