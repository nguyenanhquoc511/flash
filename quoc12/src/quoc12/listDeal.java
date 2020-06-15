package quoc12;

import java.util.*;

public class listDeal {
	Scanner objSc = new Scanner(System.in);
	deal[] dl = new deal[100];
	public int countDeal, countMD = 0;
	public double sumMD = 0, sumAGD = 0, sumAMD = 0;

	public void initList() {
		countDeal = 0;
		for (int i = 0; i < 100; i++)
			dl[i] = new deal();
	}

	public void addDeal(int choose) {
		if (countDeal > 100)
			System.out.println("Not enough empty!! ");
		else {
			if (choose == 1) {
				goldDeal GD = new goldDeal();
				GD.input();
				GD.calPrice();
				sumAGD += GD.amount;
				dl[countDeal] = GD;
			} else {
				moneyDeal MD = new moneyDeal();
				MD.input();
				sumMD += MD.calPrice(MD.getKindMoney());
				countMD++;
				sumAMD += MD.amount;
				dl[countDeal] = MD;
			}
			countDeal++;
		}
	}

	public void showInfo() {
		System.out.println();
		for (int i = 0; i < countDeal; i++) {
			System.out.println("Information Deal " + (i + 1) + ": ");
			System.out.println(dl[i].toString());
			System.out.println();
		}
		System.out.println();
		System.out.println("Amount Of Gold Deal: " + sumAGD);
		System.out.println();
		System.out.println("Amount Of Money Deal: " + sumAMD);
		System.out.println();
		System.out.println("Average Pice Of Money Deal: " + sumMD / countMD);
	}

	public void find() {
		boolean check = false;
		for (int i = 0; i < countDeal; i++)
			if (dl[i].unitPrice > 1000) {
				check = true;
				System.out.println(dl[i].toString());
			}
		if (!check)
			System.out.println("Can not found!");
	}
}
