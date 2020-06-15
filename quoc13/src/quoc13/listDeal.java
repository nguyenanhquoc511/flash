package quoc13;

import java.util.*;

public class listDeal {
	Scanner objSc = new Scanner(System.in);
	deal[] dl = new deal[100];
	int countDL, countLD = 0, countHD = 0;
	double sumLD = 0;

	public void initList() {
		countDL = 0;
		for (int i = 0; i < countDL; i++)
			dl[countDL] = new deal();
	}

	public void addDeal(int choose) {
		if (countDL > 100)
			System.out.println("Not enough empty!!");
		else {
			if (choose == 1) {
				System.out.println("Add a land deal");
				landDeal LD = new landDeal();
				LD.input();
				sumLD += LD.calPrice(LD.getKindLand());
				countLD++;
				dl[countDL] = LD;
			} else {
				System.out.println("Add a house deal");
				houseDeal HD = new houseDeal();
				HD.input();
				HD.calPrice(HD.getKindHouse());
				countHD++;
				dl[countDL] = HD;
			}
			countDL++;
		}
	}

	public void showInfo() {
		for (int i = 0; i < countDL; i++) {
			System.out.println();
			System.out.println(dl[i].toString());
		}
		System.out.println();
		System.out.println("Count land deal: " + countLD);
		System.out.println("Count house deal: " + countHD);
	}

	public void averageLD() {
		System.out.println("Average land deal: " + sumLD / countHD);
	}

	public void findDealByMY(String monthYear) {
		boolean check = false;
		for (int i = 0; i < countDL; i++)
			if (dl[i].getDay().contains(monthYear)) {
				check = true;
				System.out.println(dl[i].toString());
			}
		if (!check)
			System.out.println("Can not Found!");
	}

}
