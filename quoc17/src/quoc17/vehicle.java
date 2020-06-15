package quoc17;

public abstract class vehicle {
	public String color;
	public int speed;

	public vehicle() {
		this.color = "";
		this.speed = 0;
	}
	
	public vehicle(String color, int speed) {
		this.color = color;
		this.speed = speed;
	}
	
	public abstract void go();

	public void changeColor(String color) {
		this.color = color;
	}

}
