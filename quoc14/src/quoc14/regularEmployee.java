package quoc14;

import java.util.*;

public class regularEmployee extends employee {
	Scanner objSc = new Scanner(System.in);
	public float salaryGrading, benefitGrading;

	public float getSalaryGrading() {
		return salaryGrading;
	}

	public void setSalaryGrading(float salaryGrading) {
		this.salaryGrading = salaryGrading;
	}

	public float getBenefitGrading() {
		return benefitGrading;
	}

	public void setBenefitGrading(float benefitGrading) {
		this.benefitGrading = benefitGrading;
	}

	public regularEmployee() {
		super();
		this.salaryGrading = 0;
		this.benefitGrading = 0;
	}

	public regularEmployee(int id, String name, double salary, float salaryGrading, float benefitGrading) {
		super(id, name, salary);
		this.salaryGrading = salaryGrading;
		this.benefitGrading = benefitGrading;
	}

	public void input() {
		super.input();
		System.out.print("Input Salary Grading: ");
		this.salaryGrading = objSc.nextFloat();
		System.out.print("Input Benefit Grading: ");
		this.benefitGrading = objSc.nextFloat();
	}

	public double calSalary() {
		return super.salary = 100 * (1.0 + getSalaryGrading() + getBenefitGrading());
	}

	public void output() {
		super.output();
		System.out.println("Salary Grading: " + getSalaryGrading());
		System.out.println("Benefit Grading: " + getBenefitGrading());
	}

}
