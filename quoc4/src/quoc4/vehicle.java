
package quoc4;

import java.util.*;

public class vehicle {
	String color, source, numberSign, manufacturer;
	double priceWithVAT, priceWithoutVAT;

	vehicle() {
		this.color = "";
		this.manufacturer = "";
		this.numberSign = "";
		this.priceWithoutVAT = 0;
		this.priceWithVAT = 0;
		this.source = "";
	}

	vehicle(String numberSign, String color, String source, String manufacturer, double priceWithVAT,
			double priceWithoutVAT) {
		this.color = color;
		this.manufacturer = manufacturer;
		this.numberSign = numberSign;
		this.source = source;
		this.priceWithoutVAT = priceWithoutVAT;
		this.priceWithVAT = priceWithVAT;
	}

	void output() {
		System.out.println("Number Sign: " + this.numberSign);
		System.out.println("Color: " + this.color);
		System.out.println("Source: " + this.source);
		System.out.println("manufacturer: " + this.manufacturer);
		System.out.println("Price With VAT: " + this.priceWithVAT);
		System.out.println("Price Without VAT: " + this.priceWithoutVAT);
	}

	void input() {
		Scanner objSc = new Scanner(System.in);
		System.out.print("Number Sign: ");
		this.numberSign = objSc.nextLine();
		System.out.print("Color: ");
		this.color = objSc.nextLine();
		System.out.print("Source: ");
		this.source = objSc.nextLine();
		System.out.print("manufacturer: ");
		this.manufacturer = objSc.nextLine();
		System.out.print("Price With VAT: ");
		this.priceWithVAT = objSc.nextDouble();
		System.out.print("Price Without VAT: ");
		this.priceWithoutVAT = objSc.nextDouble();
	}

	void cash() {
		if (this.priceWithoutVAT <= 2000)
			priceWithVAT = priceWithoutVAT + priceWithoutVAT * 10 / 100;
		else
			priceWithVAT = priceWithoutVAT + priceWithoutVAT * 15 / 100;
	}
}
