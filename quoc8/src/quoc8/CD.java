package quoc8;

public class CD {

	private int id, number;
	private String name, singer;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public boolean setNumber(int number) {
		if (number <= 0) {
			System.out.println("Value not available, try again! ");
			return false;
		}
		this.number = number;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public double getPrice() {
		return price;
	}

	public boolean setPrice(double price) {
		if (price <= 0) {
			System.out.println("Value not available, try again! ");
			return false;
		}
		this.price = price;
		return true;
	}

	CD() {
		id = 0;
		name = "";
		number = 0;
		singer = "";
		price = 0;
	}

	CD(int id, String name, String singer, int number, double price) {
		this.id = id;
		this.name = name;
		this.singer = singer;
		this.number = number;
		this.price = price;
	}

	public String toString() {
		return ("Id: " + String.valueOf(getId()) + "\t\tName: " + getName() + "\t\tSinger: " + getSinger()
				+ "\t\tNumber: " + String.valueOf(getNumber()) + "\t\tPrice: " + String.valueOf(getPrice()));
	}
}
