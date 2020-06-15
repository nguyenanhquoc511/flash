package quoc9;

import java.util.*;

public class vehicle {
	public String numberSign, color, source;

	vehicle() {
		this.color = "";
		this.numberSign = "";
		this.source = "";
	}

	vehicle(String numberSign, String color, String source) {
		this.numberSign = numberSign;
		this.color = color;
		this.source = source;
	}

	float cash() {
		return 0;
	}

	void input() {
		Scanner objSc = new Scanner(System.in);
		System.out.print("Input Number Sign: ");
		this.numberSign = objSc.nextLine();
		System.out.print("Input Color: ");
		this.color = objSc.nextLine();
		System.out.print("Input Source: ");
		this.source = objSc.nextLine();
	}

	void output() {
		System.out
				.println("Number Sign: " + this.numberSign + "\t\tColor: " + this.color + "\t\tSource: " + this.source);
	}
}
