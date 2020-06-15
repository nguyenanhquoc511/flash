package quoc16;

public class regularEmployee extends employee {

	public float salaryGrading, benefitGrading;

	public regularEmployee() {
		super();
		this.benefitGrading = 0;
		this.salaryGrading = 0;
	}

	public regularEmployee(String id, String name, int kind, float benefitGrading, float salaryGrading) {
		super(id, name, salaryGrading, kind);
		this.benefitGrading = benefitGrading;
		this.salaryGrading = salaryGrading;
	}

	public float calculateSalary() {
		return this.salary = 1000000 * (1 + salaryGrading + benefitGrading);
	}

	public void input() {
		super.input();
		System.out.print("Input Salary Grading: ");
		this.salaryGrading = objSc.nextFloat();
		System.out.print("Input Benefit Grading: ");
		this.benefitGrading = objSc.nextFloat();
	}

}
