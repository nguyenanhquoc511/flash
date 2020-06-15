package quoc9;

import java.util.*;

public class car extends vehicle {
	public String manufacturer;
	public double priceWithVAT, priceWithoutVAT;

	public car() {
		super();
		this.manufacturer = "";
		this.priceWithVAT = 0;
		this.priceWithoutVAT = 0;
	}

	public car(String numberSign, String color, String source, String manufacturer, double priceWithVAT,
			double priceWithoutVAT) {
		super(numberSign, color, source);
		this.manufacturer = manufacturer;
		this.priceWithVAT = priceWithVAT;
		this.priceWithoutVAT = priceWithoutVAT;
	}

	public void input() {
		Scanner objSc = new Scanner(System.in);
		super.input();
		System.out.print("Input manufacturer: ");
		this.manufacturer = objSc.nextLine();
		System.out.print("Input Price With VAT: ");
		this.priceWithVAT = objSc.nextDouble();
		System.out.print("Input Price Without VAT: ");
		this.priceWithoutVAT = objSc.nextDouble();
	}

	public void output() {
		super.output();
		System.out.println("Manufacturer: " + manufacturer + "\t\tPrice With VAT: " + priceWithVAT
				+ "\t\tPrice Without VAT: " + priceWithoutVAT);
	}

	public float cash() {
		if (priceWithoutVAT <= 2000)
			priceWithVAT = priceWithoutVAT + priceWithoutVAT * 10 / 100;
		else
			priceWithVAT = priceWithoutVAT + priceWithoutVAT * 15 / 100;
		return (float) priceWithVAT;
	}
}
