package package1;

public class student extends person {
	private float pointSub1, pointSub2;

	public float getPointSub1() {
		return pointSub1;
	}

	public void setPointSub1(float pointSub1) {
		this.pointSub1 = pointSub1;
	}

	public float getPointSub2() {
		return pointSub2;
	}

	public void setPointSub2(float pointSub2) {
		this.pointSub2 = pointSub2;
	}

	public student() {
		super();
		this.pointSub1 = 0;
		this.pointSub2 = 0;
	}

	public student(String name, String address, float pointSub1, float pointSub2) {
		super(name, address);
		this.pointSub1 = pointSub1;
		this.pointSub2 = pointSub2;
	}

	public void input() {
		super.input();
		System.out.print("Input Point Of Subject 1: ");
		this.pointSub1 = objSc.nextFloat();
		System.out.print("Input Point Of Subject 2: ");
		this.pointSub2 = objSc.nextFloat();
	}

	public float calGPA() {
		return (this.pointSub1 + this.pointSub2) / 2;
	}

	public String evaluate() {
		if (calGPA() >= 8)
			return "Good";
		else if (calGPA() >= 5)
			return "Average";
		else
			return "Bad";
	}

	public String toString() {
		return "Student" + super.toString() + "\nPoint GPA: " + String.valueOf(calGPA());
	}
}
