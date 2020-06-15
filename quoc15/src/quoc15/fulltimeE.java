package quoc15;

public class fulltimeE extends employee {
	private int kindPosition, dayOT;

	public fulltimeE(String name, int dayOT, int kindPostion) {
		super(name);
		this.dayOT = dayOT;
		this.kindPosition = kindPostion;
	}

	public String employeeKind() {
		if (kindPosition == 1)
			return "Employee full time" + (dayOT > 0 ? " (Over Time)" : "");
		else
			return "Boss full time" + (dayOT > 0 ? " (Over Time)" : "");
	}

	public void calSalary() {
		if (kindPosition == 1)
			super.salary = 10000 + dayOT * 800;
		else
			super.salary = 20000 + dayOT * 800;
	}

}
