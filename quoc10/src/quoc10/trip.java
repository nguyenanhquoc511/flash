package quoc10;

import java.util.*;

public class trip {

	protected String idTrip, nameDriver, idCar;
	protected double revenue;

	Scanner objSc = new Scanner(System.in);

	protected String getIdTrip() {
		return idTrip;
	}

	protected void setIdTrip(String idTrip) {
		this.idTrip = idTrip;
	}

	protected String getNameDriver() {
		return nameDriver;
	}

	protected void setNameDriver(String nameDriver) {
		this.nameDriver = nameDriver;
	}

	protected String getIdCar() {
		return idCar;
	}

	protected void setIdCar(String idCar) {
		this.idCar = idCar;
	}

	protected double getRevenue() {
		return revenue;
	}

	protected void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	protected trip() {
		this.idCar = "";
		this.idTrip = "";
		this.nameDriver = "";
		this.revenue = 0;
	}

	protected trip(String idTrip, String nameDriver, String idCar, double revenue) {
		this.idCar = idCar;
		this.idTrip = idTrip;
		this.nameDriver = nameDriver;
		this.revenue = revenue;
	}

	protected void input() {
		System.out.print("Input ID trip: ");
		this.idTrip = objSc.nextLine();
		System.out.print("Input Name Driver: ");
		this.nameDriver = objSc.nextLine();
		System.out.print("Input ID Car: ");
		this.idCar = objSc.nextLine();
		System.out.print("Input Revenue: ");
		this.revenue = objSc.nextDouble();
	}

	public String toString() {
		return "ID Trip: " + getIdTrip() + "\t\tName Driver: " + getNameDriver() + "\t\tID Car: " + getIdCar()
				+ "\t\tRevenue: " + String.valueOf(getRevenue());
	}
}
