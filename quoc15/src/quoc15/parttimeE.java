package quoc15;

public class parttimeE extends employee {
	private int hours;

	public parttimeE(String name, int hours) {
		super(name);
		this.hours = hours;
	}

	public String employeeKind() {
		return "Employee part time";
	}

	public void calSalary() {
		super.salary = this.hours * 100;
	}
}
