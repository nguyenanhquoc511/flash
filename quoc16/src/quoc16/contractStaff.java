package quoc16;

import java.util.*;

public class contractStaff extends employee {

	Scanner objSc = new Scanner(System.in);

	public float wage, excessHoursGrading, workday;

	public contractStaff() {
		super();
		this.wage = 0;
		this.excessHoursGrading = 0;
		this.workday = 0;
	}

	public contractStaff(String id, String name, float salary, int kind, float wage, float workday,
			float excessHoursGrading) {
		super(id, name, salary, kind);
		this.wage = wage;
		this.excessHoursGrading = excessHoursGrading;
		this.workday = workday;
	}

	public float calculateSalary() {
		return this.salary = wage * workday * (1 + excessHoursGrading);
	}

	public void input() {
		super.input();
		System.out.print("Input wage: ");
		this.wage = objSc.nextFloat();
		System.out.print("Input work day: ");
		this.workday = objSc.nextFloat();
		System.out.print("Input ExcessHours Grading: ");
		this.excessHoursGrading = objSc.nextFloat();
	}
}
