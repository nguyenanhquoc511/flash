package quoc17;

public class car extends vehicle{
	public int sizeOfEngine, numberOfDoors;
	
	public car() {
		super();
		this.sizeOfEngine = 0;
		this.numberOfDoors = 0;
	}
	
	public car(String color, int speed, int sizeOfEngine, int numberOfDoors) {
		super(color, speed);
		this.sizeOfEngine = sizeOfEngine;
		this.numberOfDoors = numberOfDoors;
	}
	
	public void go() {
		System.out.println(
				"the " + this.color + " car with " + this.numberOfDoors + " and "+this.sizeOfEngine+" go with " + this.speed + " km/h");
	}
	
}
