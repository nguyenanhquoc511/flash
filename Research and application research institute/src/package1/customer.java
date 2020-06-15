package package1;

import java.util.*;

public class customer extends person {
	private String nameCompany;
	private double valueDeal;

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public double getValueDeal() {
		return valueDeal;
	}

	public void setValueDeal(double valueDeal) {
		this.valueDeal = valueDeal;
	}

	public customer() {
		super();
		this.nameCompany = "";
		this.valueDeal = 0;
	}

	public customer(String name, String address, String nameCompany, double valueDeal) {
		super(name, address);
		this.nameCompany = nameCompany;
		this.valueDeal = valueDeal;
	}

	public void input() {
		super.input();
		System.out.print("Input Name Company: ");
		this.nameCompany = objSc.nextLine();
		System.out.print("Input Value Deal: ");
		this.valueDeal = objSc.nextDouble();
	}

	public String evaluate() {
		if (valueDeal >= 10000)
			return "Good";
		else if (valueDeal >= 5000)
			return "Average";
		else
			return "Bad";
	}

	public String toString() {
		return "Customer" + super.toString() + "\nValue of Deal: " + String.valueOf(this.valueDeal);
	}
}
