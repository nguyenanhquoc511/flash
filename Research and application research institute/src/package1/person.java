package package1;

import java.util.*;

public class person {
	Scanner objSc = new Scanner(System.in);
	protected String name, address;

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getAddress() {
		return address;
	}

	protected void setAddress(String address) {
		this.address = address;
	}

	public person() {
		this.name = "";
		this.address = "";
	}

	public person(String name, String address) {
		this.address = address;
		this.name = name;
	}

	public void input() {
		System.out.print("Input Name: ");
		this.name = objSc.nextLine();
		System.out.print("Input Address: ");
		this.address = objSc.nextLine();
	}

	public String toString() {
		return "\nName: " + this.name + "\nAddress: " + this.address;
	}
}
