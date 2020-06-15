package manager;

import java.util.*;

public class foodItems extends items {
	Scanner objSc = new Scanner(System.in);
	function F = new function();
	private String dateOfManufacture, expiryDate, manufacturer;

	public String getDateOfManufacture() {
		return dateOfManufacture;
	}

	public boolean setDateOfManufacture(String dateOfManufacture) {
		if (dateOfManufacture.isEmpty()) {
			System.out.println("Can not empty, try again!!");
			return false;
		}
		if (!F.checkDate(dateOfManufacture)) return false;
		this.dateOfManufacture = dateOfManufacture;
		return true;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public boolean setExpiryDate(String expiryDate) {
		if (expiryDate.isEmpty()) {
			System.out.println("Can not empty, try again!!");
			return false;
		}
		if (!F.checkDate(expiryDate)) return false;
		this.expiryDate = expiryDate;
		return true;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public boolean setManufacturer(String manufacturer) {
		if (manufacturer.isEmpty()) {
			System.out.println("Can not empty, try again!!");

			return false;
		}
		this.manufacturer = manufacturer;
		return true;
	}

	public foodItems() {
		super();
		this.dateOfManufacture = null;
		this.expiryDate = null;
		this.manufacturer = null;
	}

	public foodItems(String id, String name, int amountLeft, double unitPrice, String dateOfManufacture,
			String expiryDate, String manufacturer) {
		super(id, name, amountLeft, unitPrice);
		this.dateOfManufacture = dateOfManufacture;
		this.expiryDate = expiryDate;
		this.manufacturer = manufacturer;
	}

	public void input() {
		String tmp;

		super.input();

		do {
			System.out.print("Input Date Of Manufacture: ");
			tmp = objSc.nextLine();
			
		} while (!setDateOfManufacture(tmp));

		do {
			System.out.print("Input Expiry Date: ");
			tmp = objSc.nextLine();
		} while (!setExpiryDate(tmp));

		do {
			System.out.print("Input Manufacturer: ");
			tmp = objSc.nextLine();
		} while (!setManufacturer(tmp));
	}

	public String toString() {
		return "Food Items" + super.toString() + "\nDate Of Manufacture: " + this.dateOfManufacture + "\nExpiry Date: "
				+ this.expiryDate + "\nManufacturer: " + this.manufacturer;
	}

	public String evaluate() {
		return "Coming soon..";
	}

	public double calPriceVAT() {
		return this.getUnitPrice() * 5 / 100;
	}

	
}
