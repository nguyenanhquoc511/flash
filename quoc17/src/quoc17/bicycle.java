package quoc17;

public class bicycle extends vehicle {
	public int numberOfWheel;

	public bicycle() {
		super();
		this.numberOfWheel = 0;
	}
	
	public bicycle(String color, int speed, int numberOfWheel) {
		super(color, speed);
		this.numberOfWheel = numberOfWheel;
	}
	
	public void go() {
		System.out.println(
				"the " + this.color + " bicycle with " + this.numberOfWheel + " go with " + this.speed + " km/h");
	}

}
