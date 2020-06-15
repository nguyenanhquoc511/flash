package quoc12;

import java.util.*;

public class moneyDeal extends deal {

	Scanner objSc = new Scanner(System.in);

	private float exRate;
	private int kindMoney;

	public float getExRate() {
		return exRate;
	}

	public void setExRate(float exRate) {
		this.exRate = exRate;
	}

	public int getKindMoney() {
		return kindMoney;
	}

	public boolean setKindMoney(int kindMoney) {
		if (kindMoney < 1 || kindMoney > 3) {
			System.out.println("Choose not available, Try again! ");
			return false;
		} else
			this.kindMoney = kindMoney;
		return true;
	}

	protected moneyDeal() {
		super();
		this.exRate = 0;
		this.kindMoney = 0;
	}

	protected moneyDeal(int id, int amount, String day, double unitPrice, double price, float exRate, int kindMoney) {
		super(id, amount, day, unitPrice, price);
		this.exRate = exRate;
		this.kindMoney = kindMoney;
	}

	protected double calPrice(int kindMoney) {
		if (kindMoney == 2 || kindMoney == 3)
			return super.price = super.unitPrice * super.amount * this.exRate;
		else
			return super.price = super.unitPrice * super.amount;
	}

	public String kindM(int kind) {
		if (kind == 1)
			return "VND";
		else if (kind == 2)
			return "USD";
		else
			return "Euro";
	}

	public void input() {
		int tmp = 0;

		super.input();

		do {
			System.out.print("Input Kind of Money (1.VND / 2.USD / 3.Euro): ");
			tmp = objSc.nextInt();
		} while (!setKindMoney(tmp));

		if (this.kindMoney == 2 || this.kindMoney == 3) {
			System.out.print("Input Exchange Rate: ");
			this.exRate = objSc.nextFloat();
		}
	}

	public String toString() {
		return "\nMoney Deal: " + super.toString() + "\nKind of Money: " + kindM(this.kindMoney) + "\nExchange Rate: "
				+ String.valueOf(this.exRate) + "\nPrice: " + String.valueOf(this.price);
	}

}
