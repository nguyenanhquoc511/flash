package manager;

import java.util.*;

public class crockeryItems extends items {

	Scanner objSc = new Scanner(System.in);
	function F = new function();
	private String manufacturer, inventoryDate;

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getInventoryDate() {
		return inventoryDate;
	}

	public boolean setInventoryDate(String inventoryDate) {
		if (inventoryDate.isEmpty()) {
			System.out.println("Can not empty, try again!!");
			return false;
		}
		if (!F.checkDate(inventoryDate)) return false;
		this.inventoryDate = inventoryDate;
		return true;
	}

	public crockeryItems() {
		super();
		this.inventoryDate = null;
		this.manufacturer = null;
	}

	public crockeryItems(String id, String name, int amountLeft, double unitPrice, String manufacturer,
			String inventoryDate) {
		super(id, name, amountLeft, unitPrice);
		this.manufacturer = manufacturer;
		this.inventoryDate = inventoryDate;
	}

	public void input() {
		String tmp;
		super.input();
		System.out.print("Input Manufacturer: ");
		this.manufacturer = objSc.nextLine();
		do {
			System.out.print("Input Inventory Date: ");
			tmp = objSc.nextLine();
		} while (!setInventoryDate(tmp));
	}

	public String toString() {
		return "Crokery Items" + super.toString() + "\nManufacturer: " + this.manufacturer + "\nInventory Date: "
				+ this.inventoryDate;
	}

	public double calPriceVAT() {
		return super.getUnitPrice() * 10 / 100;
	}

	public String evaluate() {
		return "Coming soon...";
	}
}
